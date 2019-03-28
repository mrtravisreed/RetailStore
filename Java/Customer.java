/**
 * Customer class implements the ICustomer interface and keeps track of a customer's name, age,
 * and shopping cart.
 *
 * @version 2019-03-26
 */
public class Customer implements ICustomer {

  /**
   * The default quantity of product to add.
   */
  public static final int DEFAULT_QUANTITY = 1;

  /**
   * The customer's name.
   */
  protected String name;

  /**
   * The customer's age.
   */
  protected int age;

  /**
   * The customers's shopping cart.
   */
  protected ShoppingCart shoppingCart;

  /**
   * Creates a new Customer object with a given name and age, and an empty shopping cart.
   *
   * @param name the customer's name
   * @param age the customer's age
   */
  public Customer(String name, int age) {
    this.name = name;
    this.age = age;
    this.shoppingCart = new ShoppingCart();
  }

  /**
   * Adds one of the given IProduct to the customer's shopping cart.
   *
   * @param product the product to add
   * @param inventory the inventory to shop from
   * @throws IllegalStockItemException if the product is not a legal type
   */
  @Override
  public void addItemToCart(AbstractProduct product, Inventory inventory)
      throws IllegalStockItemException {
    this.addItemToCart(product, inventory, DEFAULT_QUANTITY);
  }

  /**
   * Adds a given amount of the given product to the customer's shopping cart.
   *
   * @param product the product to add
   * @param inventory the inventory to shop from
   * @param quantity the quantity of the product to add
   * @throws IllegalStockItemException if the product is not a legal type
   */
  @Override
  public void addItemToCart(AbstractProduct product, Inventory inventory, int quantity)
      throws IllegalStockItemException {
    AbstractStockItem cartItem = createCartItem(product, quantity);
    if (inventory.quantityOf(product) < quantity) {
      System.out.println("Error: stock of " + product.toString() + " is low.");
    }
    shoppingCart.addStockItem(cartItem);
  }

  /**
   * Helper method to create a stock item given a product and quantity, in order to add it to
   * a shopping cart.
   *
   * @param product the product to add
   * @param quantity the quantity to add
   * @return GroceryStockItem if the product is a grocery product
   * @return HouseholdStockItem if the product is a household product
   * @throws IllegalStockItemException if the product is not a legal type
   */
  private AbstractStockItem createCartItem(AbstractProduct product, int quantity)
      throws IllegalStockItemException {
    if (product instanceof AbstractGrocery) {
      return new GroceryStockItem((AbstractGrocery) product, quantity);
    } else if (product instanceof AbstractHousehold) {
      return new HouseholdStockItem((AbstractHousehold) product, quantity);
    } else {
      throw new IllegalStockItemException();
    }
  }
}
