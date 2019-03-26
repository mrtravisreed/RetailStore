import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

public class BeerTest {

  private String manufacturer = "Elysian";
  private String name = "Space Dust";
  private double price = 6.99;
  private double weight = 24.0;
  private Beer beer;

  @Before
  public void setUp() throws Exception {
    beer = new Beer(manufacturer, name, price, weight);
  }

  @Test
  public void getMinAge() {
    assertEquals(21, beer.getMinAge());
  }
}