/**
 * Cheese class keeps track of a cheese grocery object for a supermarket inventory system.
 *
 * @version 2019-03-25
 */
public class Cheese extends AbstractGrocery {

  /**
   * Creates a new Cheese object given the products manufacturer name, product name, price,
   * minimum age for purchase, and weight.
   *
   * @param manufacturer the manufacturer name
   * @param productName the product name
   * @param price the price of the product
   * @param minAge the minimum age for purchase
   * @param weight the weight of the product
   */
  public Cheese(String manufacturer, String productName, double price, int minAge,
      double weight) {
    super(manufacturer, productName, price, minAge, weight);
  }

  /**
   * Creates a new non age-restricted Cheese object given the products manufacturer name,
   * product name, price, and weight.
   *
   * @param manufacturer the manufacturer name
   * @param productName the product name
   * @param price the price of the product
   * @param weight the weight of the product
   */
  public Cheese(String manufacturer, String productName, double price, double weight) {
    super(manufacturer, productName, price, weight);
  }
}
