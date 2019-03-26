import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MedicineTest {

  private String manufacturer = "Bayer";
  private String name = "Aspirin";
  private String ageName = "Claritin";
  private double price = 4.99;
  private double agePrice = 5.99;
  private int units = 50;
  private Medicine aspirin;
  private Medicine claritin;

  @Before
  public void setUp() throws Exception {
    aspirin = new Medicine(manufacturer, name, price, units);
    claritin = new Medicine(manufacturer, ageName, agePrice, 16, units);
  }

  @Test
  public void getUnits() {
    assertEquals(units, aspirin.getUnits());
  }

  @Test
  public void setUnits() {
    int newUnits = 100;
    aspirin.setUnits(newUnits);
    assertEquals(newUnits, aspirin.getUnits());
  }
}