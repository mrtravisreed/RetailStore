/**
 * IllegalStockItemException is an exception to be thrown when an illegal stock item is added to
 * an Inventory.
 *
 * @version 2019-03-25
 */
public class IllegalStockItemException extends Exception {

  /**
   * Constructs a IllegalStockItemException with the given message.
   */
  public IllegalStockItemException() {
    super("The given stock item is not a legal type.");
  }
}
