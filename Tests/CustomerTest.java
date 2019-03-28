import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

public class CustomerTest {
  private Customer customer;
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
  private ShoppingCart emptyCart;
  private ShoppingCart shoppingCart = new ShoppingCart();
  private Inventory inventory = new Inventory();

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
    salmonStock = new GroceryStockItem(salmon, 1);
    beerStock = new GroceryStockItem(beer, 6);
    paperTowelStock = new HouseholdStockItem(paperTowels, 7);
    shampooStock = new HouseholdStockItem(shampoo, 8);
    shoppingCart.addStockItem(salmonStock);
    shoppingCart.addStockItem(beerStock);
    shoppingCart.addStockItem(paperTowelStock);
    shoppingCart.addStockItem(shampooStock);
    inventory.addStockItem(salmonStock);
    inventory.addStockItem(beerStock);
    inventory.addStockItem(paperTowelStock);
    inventory.addStockItem(shampooStock);
    emptyCart = new ShoppingCart();
    customer = new Customer("Caspar", 25);
  }

  @Test
  public void addItemToCart() throws IllegalStockItemException {
    customer.addItemToCart(beer, inventory);
    customer.addItemToCart(beer, inventory, 3);
    customer.addItemToCart(paperTowels, inventory, 3);
    assertEquals(4, customer.shoppingCart.quantityOf(beer), 0.001);
    assertEquals(6, inventory.quantityOf(beer), 0.001);
    assertEquals(3, customer.shoppingCart.quantityOf(paperTowels), 0.001);
  }
}