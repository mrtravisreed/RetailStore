/**
 * NotEnoughProductException is an exception to be thrown when there is not enough quantity of a
 * product to make a purchase.
 *
 * @version 2019-03-25
 */
public class NotEnoughProductException extends Exception {

  /**
   * Constructs a NotEnoughProductException with the given message.
   *
   * @param message the message to show when exception is thrown
   */
  public NotEnoughProductException(String message) {
    super(message);
  }
}
