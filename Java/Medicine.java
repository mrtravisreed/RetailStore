/**
 * Medicine class keeps track of a Medicine object for use in a supermarket inventory system.
 *
 * @version 2019-03-25
 */
public class Medicine extends AbstractHousehold {

  /**
   * Creates a new Medicine object given the manufacturer name, product name, price, minimum
   * age, and number of units per package.
   *
   * @param manufacturer the name of the manufacturer
   * @param productName the name of the product
   * @param price the price of the product
   * @param minAge the minimum age for purchase
   * @param units the number of units in a package
   */
  public Medicine(String manufacturer, String productName, double price, int minAge,
      int units) {
    super(manufacturer, productName, price, minAge, units);
  }

  /**
   * Creates a new non age-restricted Medicine object given the manufacturer name, product
   * name, price, and number of units per package.
   *
   * @param manufacturer the name of the manufacturer
   * @param productName the name of the product
   * @param price the price of the product
   * @param units the number of units in a package
   */
  public Medicine(String manufacturer, String productName, double price, int units) {
    super(manufacturer, productName, price, units);
  }
}
