/**
 * Salmon class keeps track of a salmon grocery object for a supermarket inventory system.
 *
 * @version 2019-03-25
 */
public class Salmon extends AbstractGrocery {


  /**
   * Creates a new Salmon object given the products manufacturer name, product name, price,
   * minimum age for purchase, and weight.
   *
   * @param manufacturer the manufacturer name
   * @param productName the product name
   * @param price the price of the product
   * @param minAge the minimum age for purchase
   * @param weight the weight of the product
   */
  public Salmon(String manufacturer, String productName, double price, int minAge, double weight) {
    super(manufacturer, productName, price, minAge, weight);
  }

  /**
   * Creates a new non age-restricted Salmon object given the products manufacturer name,
   * product name, price, and weight.
   *
   * @param manufacturer the manufacturer name
   * @param productName the product name
   * @param price the price of the product
   * @param weight the weight of the product
   */
  public Salmon(String manufacturer, String productName, double price, double weight) {
    this(manufacturer, productName, price, DEFAULT_MIN_AGE, weight);
  }
}
