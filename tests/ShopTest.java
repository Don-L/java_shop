import app.*;

import static org.junit.Assert.*;
import org.junit.*;
import java.util.HashMap;

public class ShopTest {

  Shop snoutsRus;
  Shop snoutsWorld;
  Shop internationalSnouts;
  Item prizeSnouts;
  HashMap<Item, Integer> list;
  Inventory invent;

  @Before
  public void before(){
    snoutsRus= new Shop("Snouts R Us");
    snoutsWorld = new Shop("Snouts World", 100, 100);
    prizeSnouts = new Item("Prize Snouts", 699);
    list = new HashMap<Item, Integer>();
    list.put(prizeSnouts, 3);
    invent = new Inventory(list);
    internationalSnouts = new Shop("International Snouts", invent);
  }

  @Test
  public void hasName(){
    assertEquals("Snouts R Us", snoutsRus.getName());
  }

  @Test
  public void canAddToSalesTotal(){
    snoutsWorld.takeFunds(500);
    assertEquals(600, snoutsWorld.getSalesTotal());
  }

  @Test
  public void canAddToRefundsTotal(){
    snoutsWorld.makeRefund(200);
    assertEquals(300, snoutsWorld.getRefundsTotal());
  }

  @Test
  public void canReportBalanceOfSales(){
    assertEquals(0, snoutsWorld.getBalanceOfSales());
  }

  @Test
  public void canGetInventory(){
    Inventory returnedInvent = internationalSnouts.getInventory();
    HashMap<Item, Integer> returnedList = returnedInvent.getList();
    int quantity = (int) returnedList.get(prizeSnouts);
    assertEquals(3, quantity);
  }

  @Test
  public void canGetQuantityOfItemInStock(){
    assertEquals(3, internationalSnouts.getQuantity(prizeSnouts));
  }

  @Test
  public void canAddItemsToStock(){
    snoutsRus.addToInventory(prizeSnouts, 7);
    Inventory returnedInvent = snoutsRus.getInventory();
    HashMap<Item, Integer> returnedList = returnedInvent.getList();
    int quantity = (int) returnedList.get(prizeSnouts);
    assertEquals(7, quantity);
  }

  @Test
  public void canTakeItemsFromStock(){
    internationalSnouts.takeFromInventory(prizeSnouts, 1);
    Inventory returnedInvent = internationalSnouts.getInventory();
    HashMap<Item, Integer> returnedList = returnedInvent.getList();
    int quantity = (int) returnedList.get(prizeSnouts);
    assertEquals(2, quantity);
  }

}
