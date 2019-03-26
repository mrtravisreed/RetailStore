/**
 * PaperTowels class keeps track of a PaperTowels object for use in a supermarket inventory system.
 *
 * @version 2019-03-25
 */
public class PaperTowels extends AbstractHousehold {


  /**
   * Creates a new non age-restricted PaperTowels object given the manufacturer name, product
   * name, price, and number of units per package.
   *
   * @param manufacturer the name of the manufacturer
   * @param productName the name of the product
   * @param price the price of the product
   * @param units the number of units in a package
   */
  public PaperTowels(String manufacturer, String productName, double price, Integer units) {
    super(manufacturer, productName, price, units);
  }
}
