import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CheeseTest {

  private String manufacturer = "Beecher";
  private String name = "Flagship";
  private double price = 5.99;
  private int minAge = 0;
  private double weight = 8.0;
  private Cheese cheese;
  private Cheese implicitCheese;

  @Before
  public void setUp() throws Exception {
    cheese = new Cheese(manufacturer, name, price, minAge, weight);
    implicitCheese = new Cheese(manufacturer, name, price, weight);
  }

  @Test
  public void getWeight() {
    assertEquals(weight, cheese.getWeight(), 0.01);
  }

  @Test
  public void setWeight() {
    double newWeight = 12.0;
    cheese.setWeight(newWeight);
    assertEquals(newWeight, cheese.getWeight(), 0.01);
  }

  @Test
  public void getManufacturer() {
    assertEquals(manufacturer, cheese.getManufacturer());
  }

  @Test
  public void getProductName() {
    assertEquals(name, cheese.getProductName());
  }

  @Test
  public void getPrice() {
    assertEquals(price, cheese.getPrice(), 0.01);
  }

  @Test
  public void getMinAge() {
    assertEquals(minAge, cheese.getMinAge());
    assertEquals(minAge, implicitCheese.getMinAge());
  }

  @Test
  public void setManufacturer() {
    String newManufacturer = "Tillamook";
    cheese.setManufacturer(newManufacturer);
    assertEquals(newManufacturer, cheese.getManufacturer());
  }

  @Test
  public void setProductName() {
    String newName = "Cheddar";
    cheese.setProductName(newName);
    assertEquals(newName, cheese.getProductName());
  }

  @Test
  public void setPrice() {
    double newPrice = 8.99;
    cheese.setPrice(newPrice);
    assertEquals(newPrice, cheese.getPrice(), 0.01);
  }

  @Test
  public void setMinAge() {
    int newMinAge = 13;
    cheese.setMinAge(newMinAge);
    assertEquals(newMinAge, cheese.getMinAge());
  }
}