/**
 * AddingExistingStockItemException is an exception to be thrown when existing stock item is added to
 * an Inventory.
 *
 * @version 2019-03-26
 */
public class AddingExistingStockItemException extends Exception {
  /**
   * Constructs a AddingExistingStockItemException with the given message.
   */
  public AddingExistingStockItemException() {
    super("The given stock item is already in the inventory.");
  }
}

