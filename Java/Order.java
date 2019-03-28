import java.util.ArrayList;

/**
 * An order keeps track of the final order as it is being processed by a SuperMarket ordering
 * system. Keeps track of items purchased as well as items removed due to age restrictions or lack
 * of stock.
 *
 * @version 2019-03-26
 */
public class Order {

  /**
   * List of in stock products to process.
   */
  protected ArrayList<AbstractProduct> inStock;

  /**
   * List of products that were out of stock and could not be substituted.
   */
  protected ArrayList<AbstractProduct> outOfStock;

  /**
   * Creates a new order with a given a list of in stock and out of stock items.
   *
   * @param inStock the list of in stock items
   * @param outOfStock the list of out of stock items
   */
  public Order(ArrayList<AbstractProduct> inStock, ArrayList<AbstractProduct> outOfStock) {
    this.inStock = inStock;
    this.outOfStock = outOfStock;
  }

  /**
   * Creates a new order with an empty final shopping cart and empty list of out of stock items.
   */
  public Order() {
    this(new ArrayList<>(), new ArrayList<>());
  }
}
