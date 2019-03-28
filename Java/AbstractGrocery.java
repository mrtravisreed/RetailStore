/**
 * AbstractGrocery extends the AbstractProduct class and keeps track of grocery items for a
 * supermarket inventory system.
 * @version 2019-03-25
 */
public abstract class AbstractGrocery extends AbstractProduct {

  /**
   * The weight of the product in ounces.
   */
  protected double weight;

  /**
   * Creates a new AbstractGrocery object given the products manufacturer name, product name, price,
   * minimum age for purchase, and weight.
   *
   * @param manufacturer the manufacturer name
   * @param productName the product name
   * @param price the price of the product
   * @param minAge the minimum age for purchase
   * @param weight the weight of the product
   */
  public AbstractGrocery(String manufacturer, String productName, double price, int minAge,
      double weight) {
    super(manufacturer, productName, price, minAge);
    this.weight = weight;
  }

  /**
   * Creates a new non age-restricted AbstractGrocery object given the products manufacturer name,
   * product name, price, and weight.
   *
   * @param manufacturer the manufacturer name
   * @param productName the product name
   * @param price the price of the product
   * @param weight the weight of the product
   */
  public AbstractGrocery(String manufacturer, String productName, double price, double weight) {
    super(manufacturer, productName, price);
    this.weight = weight;
  }

  /**
   * Returns the product weight.
   *
   * @return the weight
   */
  public double getWeight() {
    return this.weight;
  }

  /**
   * Sets the product weight.
   *
   * @param weight the new product weight
   */
  public void setWeight(double weight) {
    this.weight = weight;
  }
}
