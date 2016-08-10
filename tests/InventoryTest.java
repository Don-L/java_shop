import app.*;

import static org.junit.Assert.*;
import org.junit.*;
import java.util.HashMap;

public class InventoryTest {

  Item prizeSnouts;
  Item flavoredSnouts;
  HashMap<Item, Integer> list;
  Inventory invent;

  @Before
  public void before(){
    prizeSnouts = new Item("Prize Snouts", 699);
    flavoredSnouts = new Item("Flavored Snouts", 599);
    list = new HashMap<Item, Integer>();
    list.put(prizeSnouts, 5);
    invent = new Inventory(list);
  }

  @Test
  public void canAddNewItemToInventory(){
    invent.add(flavoredSnouts, 2);
    HashMap<Item, Integer> newList = invent.getList();
    assertEquals(true, newList.containsKey(flavoredSnouts));
  }

  @Test
  public void canIncreaseStockLevelOfExistingItem(){
    invent.add(prizeSnouts, 2);
    HashMap<Item, Integer> newList = invent.getList();
    int newStock = (int) newList.get(prizeSnouts);
    assertEquals(7, newStock);
  }

  @Test
  public void removesItemTypeFromListIfLastOneTaken(){
    invent.take(prizeSnouts, 5);
    HashMap<Item, Integer> newList = invent.getList();
    assertEquals(false, newList.containsKey(prizeSnouts));
  }

  @Test
  public void reducesNumberInStockWhenItemTaken(){
    invent.take(prizeSnouts, 2);
    HashMap<Item, Integer> newList = invent.getList();
    int newStock = (int) newList.get(prizeSnouts);
    assertEquals(3, newStock);
  }

  @Test(expected = IllegalArgumentException.class)
  public void cantTakeMoreItemsThanAreHeldInStock(){
    invent.take(prizeSnouts, 6);
  }

}
