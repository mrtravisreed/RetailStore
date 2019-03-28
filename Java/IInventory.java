/**
 * IInventory interface defines the methods required for an IInventory, for use in a supermarket
 * inventory system.
 *
 * @version 2019-03-25
 */
public interface IInventory {
  /**
   * Adds a new IStockItem to the IInventory.
   *
   * @param stockItem the new IStockItem
   * @throws IllegalStockItemException if the stock item is not a legal type
   */
  void addStockItem(IStockItem stockItem) throws IllegalStockItemException;

  /**
   * Calculates and returns the total retail value of all items in the inventory.
   *
   * @return the total retail value
   */
  double getTotalValue();
}
