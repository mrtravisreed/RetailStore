import java.util.ArrayList;

/**
 * Supermarket class manages a supermarket's inventory and ordering fulfillment.
 *
 * @version 2019-03-26
 */
public class SuperMarket {

  /**
   * The supermarket's inventory.
   */
  protected Inventory inventory;

  /**
   * Creates a new SuperMarket with a given inventory.
   *
   * @param inventory the supermarket's starting inventory
   */
  public SuperMarket(Inventory inventory) {
    this.inventory = inventory;
  }

  /**
   * Creates a new SuperMarket with an empty inventory.
   */
  public SuperMarket() {
    this(Inventory.emptyInventory());
  }

  /**
   * Fulfill an order with given customer.
   *
   * @param customer the customer to fulfill the order for
   * @return a receipt after processing an order successfully
   * @throws IllegalStockItemException if a stock item in the cart does not exist
   */
  public Receipt fulfillOrder(Customer customer) throws IllegalStockItemException {
    Order order = new Order();
    processItems(customer.shoppingCart.groceryStock, order);
    processItems(customer.shoppingCart.householdStock, order);
    Receipt receipt = processOrder(order, customer);
    return receipt;
  }

  /**
   * Helper method to process items one by one, either adding them to the order if they are in
   * stock, or looking for a substitution if they are out of stock.
   *
   * @param shoppingList the list of stock items to check for
   * @param order the order to add items to
   * @param <T> the type of StockItem
   */
  private <T extends AbstractStockItem> void processItems(ArrayList<T> shoppingList, Order order) {
    for (AbstractStockItem stockItem : shoppingList) {
      for (int i = 0; i < stockItem.quantity; i++) {
        if (inventory.quantityOf(stockItem.product) > 0) {
          addProductToOrder(stockItem.product, order);
        } else {
          substitute(stockItem.product, order);
        }
      }
    }
  }

  /**
   * Helper method to reduce the quantity of a stock item in the inventory after it is added to
   * a customer's final order. Should only be called if the stock of the product is > 0.
   *
   * @param product the product to reduce quantity
   * @param order the order to add the product to
   * @return true if the product was added successfully, false if not
   */
  private boolean addProductToOrder(AbstractProduct product, Order order) {
    order.inStock.add(product);
    if (product instanceof AbstractGrocery) {
      for (GroceryStockItem groceryStockItem : this.inventory.groceryStock) {
        if (groceryStockItem.product.equals(product)) {
          groceryStockItem.quantity--;
          return true;
        }
      }
    } else if (product instanceof AbstractHousehold) {
      for (HouseholdStockItem householdStockItem : this.inventory.householdStock) {
        if (householdStockItem.product.equals(product)) {
          householdStockItem.quantity--;
          return true;
        }
      }
    }
    return false;
  }

  /**
   * Helper method to substitute out-of-stock item in the customer's cart with an equivalent item.
   *
   * @param product the product to be substituted
   * @param order the order to substitute the product to
   */
  protected void substitute(AbstractProduct product, Order order) {
    if (product instanceof AbstractGrocery) {
      for (GroceryStockItem groceryStockItem : this.inventory.groceryStock) {
        if (isSubstitutable(product, groceryStockItem.product)) {
          addProductToOrder(groceryStockItem.product, order);
          return;
        }
      }
    } else if (product instanceof AbstractHousehold) {
      for (HouseholdStockItem householdStockItem : this.inventory.householdStock) {
        if (isSubstitutable(product, householdStockItem.product)) {
          addProductToOrder(householdStockItem.product, order);
          return;
        }
      }
    }
    order.outOfStock.add(product); // if no substitution is found
  }

  /**
   * Helper method to check if a product can be substituted by another product given five criteria.
   * a. Two products must be same type of product
   * b. Substituted item must be in stock
   * c. Substituted item must be same or cheaper price
   * d. Substituted grocery item's weight must be same or greater
   * e. Substituted household item's number of unit must be same or greater
   * @param product the product to be substituted
   * @param substituteProduct the substituted product
   * @return true if no criteria violation (substitutable), false otherwise
   */
  protected boolean isSubstitutable(AbstractProduct product, AbstractProduct substituteProduct) {
    if (product.getClass() != substituteProduct.getClass()) {
      return false;
    }
    if (inventory.quantityOf(substituteProduct) <= 0) {
      return false;
    }
    if (substituteProduct.getPrice() > product.getPrice()) {
      return false;
    }
    if (product instanceof AbstractGrocery && substituteProduct instanceof AbstractGrocery
        && ((AbstractGrocery) product).getWeight()
        < ((AbstractGrocery) substituteProduct).getWeight()) {
      return false;
    }
    if (product instanceof AbstractHousehold && substituteProduct instanceof AbstractHousehold
        && ((AbstractHousehold) product).getUnits()
        < ((AbstractHousehold) substituteProduct).getUnits()) {
      return false;
    }
    return true; // If there is no violation
  }

  /**
   * A method to process and order and generate a receipt given an order given an order,
   * a customer, and current inventory.
   * @param order An order that needs to be fulfilled
   * @param customer customer who places the order
   * @return a receipt
   */
  public Receipt processOrder(Order order, Customer customer) {
    Receipt receipt = new Receipt(order.outOfStock);
    for (AbstractProduct product : order.inStock) {
      if (product.getMinAge() > customer.age) {
        if (product instanceof AbstractHousehold) {
          inventory.householdStock.add(new HouseholdStockItem((AbstractHousehold) product,1));
          receipt.ageRestricted.add(product);
        } else if (product instanceof AbstractGrocery) {
          inventory.groceryStock.add(new GroceryStockItem((AbstractGrocery) product, 1));
          receipt.ageRestricted.add(product);
        }
      } else {
        receipt.received.add(product);
        receipt.totalPrice += product.price;
      }
    }
    return receipt;
  }
}
