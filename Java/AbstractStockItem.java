/**
 * AbstractStockItem implements IStockItem interface and is used to keep track of the stock of an
 * IProduct.
 *
 * @version 2019-03-25
 */
public abstract class AbstractStockItem implements IStockItem {

  /**
   * The product to keep stock of.
   */
  protected IProduct product;

  /**
   * The current quantity available of the product.
   */
  protected int quantity;

  /**
   * Creates a new stock item with a given IProduct and starting quantity.
   *
   * @param product the IProduct to keep track of
   * @param quantity the starting quantity
   */
  public AbstractStockItem(AbstractProduct product, int quantity) {
    this.product = product;
    this.quantity = quantity;
  }

  /**
   * Checks if there is enough stock to make a purchase of a given size.
   *
   * @param purchaseAmount the amount to purchase
   * @return true if there is sufficient quantity to purchase, false if not
   */
  @Override
  public boolean isEnough(int purchaseAmount) {
    return purchaseAmount <= this.quantity;
  }

  /**
   * Performs a purchase of a given amount, updating the quantity available.
   *
   * @param purchaseAmount the amount to purchase
   * @throws NotEnoughProductException if there is not sufficient quantity to purchase
   */
  @Override
  public void purchase(int purchaseAmount) throws NotEnoughProductException {
    if (!isEnough(purchaseAmount)) {
      throw new NotEnoughProductException("Less than " + purchaseAmount + " quantity available.");
    }
    this.quantity -= purchaseAmount;
  }

  /**
   * Helper method to get the value for this stock item.
   *
   * @return the value of this stock item
   */
  protected double getValue() {
    return this.quantity * this.product.getPrice();
  }
}
