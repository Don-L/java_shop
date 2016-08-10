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
    list = new HashMap<Item, Integer>();
    list.put(prizeSnouts, 3);
    invent = new Inventory(list);
    internationalSnouts = new Shop("International Snouts", invent);
    Inventory returnedInvent = internationalSnouts.getInventory();
    HashMap<Item, Integer> returnedList = returnedInvent.getList();
    int quantity = (int) returnedList.get(prizeSnouts);
    assertEquals(3, quantity);
  }

}
