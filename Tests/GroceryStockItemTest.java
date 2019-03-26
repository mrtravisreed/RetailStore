import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GroceryStockItemTest {
  private Cheese cheese = new Cheese("Testing Manufacturer",
      "Testing Cheese", 4.99d, 0, 5);
  private int purchaseAmountSmall = 5;
  private int purchaseAmountLarge = 99;
  private GroceryStockItem groceryStockItem;

  @Before
  public void setUp() throws Exception {
    int quantity = 10;
    groceryStockItem = new GroceryStockItem(cheese, quantity);
  }

  @Test
  public void isEnoughTest() {
    assertTrue(groceryStockItem.isEnough(purchaseAmountSmall));
    int purchaseAllAmount = 10;
    assertTrue(groceryStockItem.isEnough(purchaseAllAmount));
    assertFalse(groceryStockItem.isEnough(purchaseAmountLarge));
  }

  @Test
  public void purchaseTest() throws NotEnoughProductException {
    groceryStockItem.purchase(purchaseAmountSmall);
    assertEquals(5, groceryStockItem.quantity);
  }

  @Test (expected = NotEnoughProductException.class)
  public void purchaseTooMuchTest() throws NotEnoughProductException {
    groceryStockItem.purchase(purchaseAmountLarge);
  }

  @Test
  public void getValueTest() {
    assertEquals(49.9d, groceryStockItem.getValue(), 0.001);
  }
}