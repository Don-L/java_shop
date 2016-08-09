import app.*;

import static org.junit.Assert.*;
import org.junit.*;
import java.util.HashMap;

public class ShopTest {

  Shop snoutsRus;
  Shop snoutsWorld;
  Item prizeSnouts;

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
  public void canAddNewItemToInventory(){
    snoutsRus.addToInventory(prizeSnouts, 2);
    HashMap<Item, Integer> inventory = snoutsRus.getInventory();
    assertEquals(true, inventory.containsKey(prizeSnouts));
  }

  @Test
  public void canIncreaseStockLevelOfExistingItem(){
    snoutsRus.addToInventory(prizeSnouts, 2);
    snoutsRus.addToInventory(prizeSnouts, 2);
    HashMap<Item, Integer> inventory = snoutsRus.getInventory();
    int newStock = (int) inventory.get(prizeSnouts);
    assertEquals(4, newStock);
  }

  @Test
  public void removesItemTypeFromInventoryIfLastOneRemoved(){
    snoutsRus.addToInventory(prizeSnouts, 5);
    snoutsRus.removeFromInventory(prizeSnouts, 5);
    HashMap<Item, Integer> inventory = snoutsRus.getInventory();
    assertEquals(false, inventory.containsKey(prizeSnouts));
  }

  @Test
  public void reducesNumberInStockWhenItemRemoved(){
    snoutsRus.addToInventory(prizeSnouts, 5);
    snoutsRus.removeFromInventory(prizeSnouts, 2);
    HashMap<Item, Integer> inventory = snoutsRus.getInventory();
    int newStock = (int) inventory.get(prizeSnouts);
    assertEquals(3, newStock);
  }

  @Test(expected = IllegalArgumentException.class)
  public void cantSellMoreItemsThanAreHeldInStock(){
    snoutsRus.addToInventory(prizeSnouts, 5);
    snoutsRus.removeFromInventory(prizeSnouts, 6);
  }



  // tests commented out as the following methods are now private: addFunds(), subtractFunds(), setSalesTotal(), getSalesTotal(), setRefundsTotal(), getRefundsTotal(). all tests passed.
  // @Test
  // public void canAddToBalance(){
  //   snoutsRus.addFunds(10);
  //   assertEquals(10010, snoutsRus.getBalance());
  // }
  //
  // @Test
  // public void canSubtractFromBalance(){
  //   snoutsRus.subtractFunds(6000);
  //   assertEquals(4000, snoutsRus.getBalance());
  // }
  //
  // @Test
  // public void canGetAndSetSalesTotal(){
  //   snoutsRus.setSalesTotal(5);
  //   assertEquals(5, snoutsRus.getSalesTotal());
  // }
  //
  // @Test
  // public void canGetAndSetRefundsTotal(){
  //   snoutsRus.setRefundsTotal(10);
  //   assertEquals(10, snoutsRus.getRefundsTotal());
  // }
  //
  // @Test
  // public void canReportBalanceOfSales(){
  //   snoutsRus.setSalesTotal(30);
  //   snoutsRus.setRefundsTotal(10);
  //   assertEquals(20, snoutsRus.getBalanceOfSales());
  // }

}
