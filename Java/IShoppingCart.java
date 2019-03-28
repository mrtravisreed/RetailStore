/**
 * IShoppingCart interface defines the methods required for normal functionality of
 * a customer's shopping cart.
 *
 * @version 2019-03-26
 */
public interface IShoppingCart {

  /**
   * Returns the total cost of all items in the cart to be calculated.
   * @return the total cost of all items in the cart as double
   */
  double getTotalCost();

}
