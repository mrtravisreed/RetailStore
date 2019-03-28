/**
 * GroceryStockItem extends the AbstractStockItem class and keeps track of a StockItem for a
 * AbstractGrocery product.
 *
 * @version 2019-03-25
 */
public class GroceryStockItem extends AbstractStockItem {

  /**
   * Creates a new stock item with a given AbstractGrocery product and starting quantity.
   * @param product the IProduct to keep track of
   * @param quantity the starting quantity
   */
  public GroceryStockItem(AbstractGrocery product, int quantity) {
    super(product, quantity);
  }
}
