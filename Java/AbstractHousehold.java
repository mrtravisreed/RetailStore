/**
 * AbstractHousehold extends the AbstractProduct class and keeps track of household items for a
 * supermarket inventory system.
 *
 * @version 2019-03-25
 */
public abstract class AbstractHousehold extends AbstractProduct {

  /**
   * Number of individual units in a package.
   */
  protected int units;

  /**
   * Creates a new AbstractHousehold object given the manufacturer name, product name, price,
   * minimum age, and number of units per package.
   *
   * @param manufacturer the name of the manufacturer
   * @param productName the name of the product
   * @param price the price of the product
   * @param minAge the minimum age for purchase
   * @param units the number of units in a package
   */
  public AbstractHousehold(String manufacturer, String productName, double price, int minAge,
      int units) {
    super(manufacturer, productName, price, minAge);
    this.units = units;
  }

  /**
   * Creates a new non age-restricted AbstractHousehold object given the manufacturer name, product
   * name, price, and number of units per package.
   *
   * @param manufacturer the name of the manufacturer
   * @param productName the name of the product
   * @param price the price of the product
   * @param units the number of units in a package
   */
  public AbstractHousehold(String manufacturer, String productName, double price, int units) {
    super(manufacturer, productName, price);
    this.units = units;
  }

  /**
   * Return the number of units per package.
   *
   * @return the number of units per package
   */
  public int getUnits() {
    return this.units;
  }

  /**
   * Sets the number of units per package.
   *
   * @param units the new number of units per package
   */
  public void setUnits(int units) {
    this.units = units;
  }
}
