/**
 * AbstractAlcoholGrocery extends the AbstractGrocery class and keeps track of alcohol items for a
 * supermarket inventory system.
 *
 * @version 2019-03-25
 */
public abstract class AbstractAlcoholGrocery extends AbstractGrocery {

  /**
   * The minimum age to purchase alcoholic beverages.
   */
  public static final int ALCOHOL_MIN_AGE = 21;

  /**
   * Creates a new AbstractGrocery object given the products manufacturer name, product name, price,
   * minimum age for purchase, and weight.
   *
   * @param manufacturer the manufacturer name
   * @param productName the product name
   * @param price the price of the product
   * @param weight the weight of the product
   */
  public AbstractAlcoholGrocery(String manufacturer, String productName, double price,
      Double weight) {
    super(manufacturer, productName, price, ALCOHOL_MIN_AGE, weight);
  }
}
