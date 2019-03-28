import java.util.ArrayList;

/**
 * A receipt class that keeps tracks of total price paid, a list of products that customer received
 * when the order was processed, a list of products that were out of stock, a list of products
 * that were removed due to age restriction.
 *
 * @version 2019-03-27
 */
public class Receipt {
  protected ArrayList<AbstractProduct> received;
  protected ArrayList<AbstractProduct> outOfStock;
  protected ArrayList<AbstractProduct> ageRestricted;
  protected double totalPrice;

  /**
   * Creates a new receipt object with given list of products that were out of stock.
   * @param outOfStock a list of products that were out of stock
   */
  public Receipt(ArrayList<AbstractProduct> outOfStock) {
    this.outOfStock = outOfStock;
    this.received = new ArrayList<>();
    this.ageRestricted = new ArrayList<>();
    this.totalPrice = 0;
  }

}
