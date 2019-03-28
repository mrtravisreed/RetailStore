import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

public class InventoryTest {
  private ArrayList<GroceryStockItem> groceryStock;
  private ArrayList<HouseholdStockItem> householdStock;
  private Salmon salmon;
  private Beer beer;
  private GroceryStockItem salmonStock;
  private GroceryStockItem beerStock;
  private PaperTowels paperTowels;
  private Shampoo shampoo;
  private HouseholdStockItem paperTowelStock;
  private HouseholdStockItem shampooStock;
  Inventory emptyInventory;
  Inventory inventory = new Inventory();

  @Before
  public void setUp() throws Exception {
    salmon = new Salmon("Salmon Manufacturer", "Fresh Salmon",
        4.99d, 0, 16);
    beer = new Beer("Beer Manufacturer", "Corona", 3.99d,
        12);
    paperTowels = new PaperTowels("Dunder Miffilin", "Michael's Paper",
        2.99d, 8);
    shampoo = new Shampoo("Shampoo Manufacturer", "Shapoop", 8.50d,
        2);
    salmonStock = new GroceryStockItem(salmon, 5);
    beerStock = new GroceryStockItem(beer, 6);
    paperTowelStock = new HouseholdStockItem(paperTowels, 7);
    shampooStock = new HouseholdStockItem(shampoo, 8);
    inventory.addStockItem(salmonStock);
    inventory.addStockItem(beerStock);
    inventory.addStockItem(paperTowelStock);
    inventory.addStockItem(shampooStock);
  }

  @Test
  public void emptyInventoryTest() {
    emptyInventory = Inventory.emptyInventory();
    assertArrayEquals(groceryStock, emptyInventory.groceryStock);
    assertArray2Equals(householdStock, emptyInventory.householdStock);
  }

  private void assertArrayEquals(ArrayList<GroceryStockItem> groceryStock,
      ArrayList<GroceryStockItem> groceryStock1) {
  }

  private void assertArray2Equals(ArrayList<HouseholdStockItem> householdStock,
      ArrayList<HouseholdStockItem> householdStock1) {
  }


  @Test
  public void addStockItemTest() throws IllegalStockItemException {
    emptyInventory = Inventory.emptyInventory();
    emptyInventory.addStockItem(salmonStock);
    emptyInventory.addStockItem(paperTowelStock);
    assertEquals(salmonStock, emptyInventory.groceryStock.get(0));
    assertEquals(paperTowelStock, emptyInventory.householdStock.get(0));
  }



  @Test //(expected = IllegalStockItemException.class)
  public void addingIllegalStockItemTest() {
    // Needs a stock item class here that is neither grocery nor household, e.g. future type
  }

  @Test
  public void getTotalValueTest() {
    assertEquals(137.82d, inventory.getTotalValue(), 0.001);
  }

  @Test
  public void getSumOfValuesTest() {
    assertEquals(48.89d, inventory.sumOfValues(inventory.groceryStock), 0.001);
    assertEquals(88.93d, inventory.sumOfValues(inventory.householdStock), 0.001);
  }

  @Test
  public void quantifyOfTest() throws IllegalStockItemException {
    assertEquals(6, inventory.quantityOf(beer));
    assertEquals(8, inventory.quantityOf(shampoo));
    inventory.addStockItem(beerStock);
    assertEquals(12, inventory.quantityOf(beer));
  }
}