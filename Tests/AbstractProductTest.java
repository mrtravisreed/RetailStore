import org.junit.Test;


public class AbstractProductTest {

  private String manufacturer = "Bounty";
  private String name = "Quilted";
  private double price = 4.99;
  private int units = 4;
  private PaperTowels paperTowels;

  @Test
  public void constructor() {
    paperTowels = new PaperTowels(manufacturer, name, price, units);
    Salmon salmon = new Salmon("Trident", "King", 10.99, 9.5);
    Shampoo shampoo = new Shampoo("Suave", "Coconut", 4.99, 1);
  }

}
