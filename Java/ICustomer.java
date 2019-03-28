/**
 * ICustomer interface defines the methods for an ICustomer.
 *
 * @version 2019-03-26
 */
public interface ICustomer {

  /**
   * Adds one of the given IProduct to the customer's shopping cart.
   *
   * @param product the product to add
   * @param inventory the inventory to shop from
   * @throws IllegalStockItemException if the product is not a legal type
   */
  void addItemToCart(AbstractProduct product, Inventory inventory)
      throws IllegalStockItemException;

  /**
   * Adds a given amount of the given product to the customer's shopping cart.
   *
   * @param product the product to add
   * @param inventory the inventory to shop from
   * @param quantity the quantity of the product to add
   * @throws IllegalStockItemException if the product is not a legal type
   */
  void addItemToCart(AbstractProduct product, Inventory inventory, int quantity)
      throws IllegalStockItemException;
}
