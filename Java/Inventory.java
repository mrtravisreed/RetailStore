import java.util.ArrayList;

/**
 * Inventory class implements the IInventory interface and is used to keep track of a supermarket's
 * inventory of products.
 *
 * @version 2019-03-25
 */
public class Inventory implements IInventory{

  protected ArrayList<GroceryStockItem> groceryStock;

  protected ArrayList<HouseholdStockItem> householdStock;

  /**
   * Creates a new Inventory with given lists for grocery item stock and household item stock.
   *
   * @param groceryStock the grocery item stock list
   * @param householdStock the household item stock list
   */
  public Inventory(ArrayList<GroceryStockItem> groceryStock,
      ArrayList<HouseholdStockItem> householdStock) {
    this.groceryStock = groceryStock;
    this.householdStock = householdStock;
  }

  /**
   * Creates a new empty Inventory.
   */
  public Inventory() {
    this(new ArrayList<>(), new ArrayList<>());
  }

  /**
   * Returns a new empty Inventory.
   *
   * @return a new empty Inventory.
   */
  public static Inventory emptyInventory() {
    return new Inventory();
  }

  /**
   * Adds a new IStockItem to the IInventory.
   *
   * @param stockItem the new IStockItem
   * @throws IllegalStockItemException if the stockItem is not a legal type
   */
  @Override
  public void addStockItem(IStockItem stockItem)
      throws IllegalStockItemException, AddingExistingStockItemException {
    if (stockItem instanceof GroceryStockItem) {
      if (this.groceryStock.contains(stockItem)) {
        throw new AddingExistingStockItemException();
      }
      this.groceryStock.add((GroceryStockItem) stockItem);
    } else if (stockItem instanceof HouseholdStockItem) {
      if (this.householdStock.contains(stockItem)) {
        throw new AddingExistingStockItemException();
      }
      this.householdStock.add((HouseholdStockItem) stockItem);
    } else {
      throw new IllegalStockItemException();
    }
  }

  /**
   * Calculates and returns the total retail value of all items in the inventory.
   *
   * @return the total retail value
   */
  @Override
  public double getTotalValue() {
    return getSumOfValues(groceryStock) + getSumOfValues(householdStock);
  }

  /**
   * Helper method to get the sum of values of all stock items in a list.
   *
   * @return the total value of all stock items in a list.
   */
  protected <T extends AbstractStockItem> double getSumOfValues(ArrayList<T> stockItems) {
    double sum = 0;
    for (AbstractStockItem stockItem : stockItems) {
      sum += stockItem.getValue();
    }
    return sum;
  }
}
