/**
 * The AbstractProduct abstract class implements the IProduct interface. It keeps track of
 * product information for grocery store inventory systems.
 *
 * @version 2019-03-25
 */
public abstract class AbstractProduct implements IProduct {

  /**
   * The default minimum age for product purchase.
   */
  public static final int DEFAULT_MIN_AGE = 0;

  /**
   * The name of the manufacturer.
   */
  protected String manufacturer;

  /**
   * The name of the product.
   */
  protected String productName;

  /**
   * The price of the product.
   */
  protected double price;

  /**
   * The minimum customer age for purchase.
   */
  protected int minAge;

  /**
   * Creates a new AbstractProduct given the manufacturer name, product name, price, and minimum
   * age.
   *
   * @param manufacturer the name of the manufacturer
   * @param productName the name of the product
   * @param price the price of the product
   * @param minAge the minimum age for purchase
   */
  public AbstractProduct(String manufacturer, String productName, double price, int minAge) {
    this.manufacturer = manufacturer;
    this.productName = productName;
    this.price = price;
    this.minAge = minAge;
  }

  /**
   * Creates a new AbstractProduct with no age restriction, given the manufacturer name, product
   * name, and price.
   *
   * @param manufacturer the name of the manufacturer
   * @param productName the name of the product
   * @param price the price of the product
   */
  public AbstractProduct(String manufacturer, String productName, double price) {
    this(manufacturer, productName, price, DEFAULT_MIN_AGE);
  }

  /**
   * Returns the manufacturer name.
   *
   * @return the manufacturer name
   */
  public String getManufacturer() {
    return this.manufacturer;
  }

  /**
   * Returns the product name.
   *
   * @return the product name
   */
  public String getProductName() {
    return this.productName;
  }

  /**
   * Return the price.
   *
   * @return the price
   */
  public double getPrice() {
    return this.price;
  }

  /**
   * Return the minimum age for purchase.
   *
   * @return the minimum age
   */
  public int getMinAge() {
    return this.minAge;
  }

  /**
   * Sets the manufacturer name.
   *
   * @param manufacturer the new manufacturer name
   */
  public void setManufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
  }

  /**
   * Sets the product name.
   *
   * @param productName the new product name
   */
  public void setProductName(String productName) {
    this.productName = productName;
  }

  /**
   * Sets the price.
   *
   * @param price the new price
   */
  public void setPrice(double price) {
    this.price = price;
  }

  /**
   * Sets the minimum age for purchase.
   *
   * @param minAge the new minimum age
   */
  public void setMinAge(int minAge) {
    this.minAge = minAge;
  }
}
