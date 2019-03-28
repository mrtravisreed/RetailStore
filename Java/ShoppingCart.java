import java.util.ArrayList;

/**
 * ShoppingCart class keeps track of items of a customer's shopping cart.
 *
 * @version 2019-03-26
 */
public class ShoppingCart extends Inventory {

  /**
   * Create a new ShoppingCart with given grocery stock list and household stock list.
   *
   * @param groceryStock the grocery item stock list
   * @param householdStock the household item stock list
   */
  public ShoppingCart(ArrayList<GroceryStockItem> groceryStock,
      ArrayList<HouseholdStockItem> householdStock) {
    super(groceryStock, householdStock);
  }

  /**
   * Creates a new empty ShoppingCart.
   */
  public ShoppingCart() {
    super();
  }
}