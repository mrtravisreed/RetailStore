/**
 * Beer class keeps track of a Beer object for a supermarket inventory system.
 *
 * @version 2019-03-25
 */
public class Beer extends AbstractAlcoholGrocery {

  /**
   * Creates a new Beer object given the products manufacturer name, product name, price,
   * and weight.
   *
   * @param manufacturer the manufacturer name
   * @param productName the product name
   * @param price the price of the product
   * @param weight the weight of the product
   */
  public Beer(String manufacturer, String productName, double price, double weight) {
    super(manufacturer, productName, price, weight);
  }
}
