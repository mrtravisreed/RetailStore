/**
 * HouseHoldStockItem extends the AbstractStockItem class and keeps track of a StockItem for an
 * AbstractHousehold product.
 *
 * @version 2019-03-25
 */
public class HouseholdStockItem extends AbstractStockItem {

  /**
   * Creates a new stock item with a given IProduct and starting quantity.
   *
   * @param product the IProduct to keep track of
   * @param quantity the starting quantity
   */
  public HouseholdStockItem(AbstractHousehold product, int quantity) {
    super(product, quantity);
  }
}
