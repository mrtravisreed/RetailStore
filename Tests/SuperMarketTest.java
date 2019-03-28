import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SuperMarketTest {
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
  private Inventory inventory = new Inventory();
  private SuperMarket superMarket = new SuperMarket();
  private Customer customer;
  private Receipt receipt = new Receipt(new ArrayList<AbstractProduct>());

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
    customer = new Customer("Caspar", 16);
    customer.addItemToCart(beer, inventory);
    customer.addItemToCart(shampoo, inventory, 2);
    receipt.ageRestricted.add(beer);
    receipt.received.add(shampoo);
    receipt.received.add(shampoo);
    receipt.totalPrice = shampoo.price + shampoo.price;
  }

    @Test
    public void fulfillOrder() throws IllegalStockItemException {
      superMarket = new SuperMarket(inventory);
      assertTrue(inventory.quantityOf(shampoo) > 0);
      assertTrue(superMarket.inventory.quantityOf(shampoo) > 0);
      Receipt fulfilledOrder = superMarket.fulfillOrder(customer);
      assertEquals(receipt.totalPrice, fulfilledOrder.totalPrice, 0.01);
    }

    @Test
    public void substitute() throws IllegalStockItemException {
      superMarket = new SuperMarket(inventory);
      Beer liteBeer = new Beer("bud", "lite", 2.99, 12);
      Shampoo shampoo1 = new Shampoo("Shampoo Manufacturer1", "Shapoop1", 8.50d,
          2);
      superMarket.inventory.addStockItem(new GroceryStockItem(liteBeer, 1));
      superMarket.inventory.addStockItem(new HouseholdStockItem(shampoo1, 1));
      Order order = new Order();
      superMarket.substitute(liteBeer, order);
      superMarket.substitute(shampoo1, order);
      assertEquals(liteBeer, order.inStock.get(0));
      assertEquals(shampoo, order.inStock.get(1));
    }

    @Test
    public void processOrder() {

      Beer draft = new Beer("coors", "draft", 10.00, 8);
      assertFalse(superMarket.isSubstitutable(beer, draft));
      PaperTowels paperTest = new PaperTowels("Brawney","Select A Size",8.99,2);
      assertEquals("Brawney", paperTest.manufacturer);
      assertEquals("Select A Size", paperTest.productName);
    }

    @Test
    public void isSubstitutable() {
      Beer liteBeer = new Beer("bud", "lite", 12.99, 12);
      superMarket = new SuperMarket(inventory);
      assertFalse(superMarket.isSubstitutable(shampoo, beer));
      assertTrue(superMarket.isSubstitutable(beer, beer));
      assertFalse(superMarket.isSubstitutable(beer, liteBeer));
      assertTrue((superMarket.isSubstitutable(liteBeer, beer)));
    }
}
