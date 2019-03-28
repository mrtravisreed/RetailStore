import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

public class ShoppingCartTest {
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
  ShoppingCart emptyCart;
  ShoppingCart shoppingCart = new ShoppingCart();

  @Test
  public void constructor() throws Exception {
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
    emptyCart = new ShoppingCart();
    groceryStock = new ArrayList<>();
    householdStock = new ArrayList<>();
    groceryStock.add(salmonStock);
    groceryStock.add(beerStock);
    householdStock.add(paperTowelStock);
    householdStock.add(shampooStock);
    shoppingCart = new ShoppingCart(groceryStock, householdStock);
  }
}