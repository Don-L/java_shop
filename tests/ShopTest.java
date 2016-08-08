import app.*;

import static org.junit.Assert.*;
import org.junit.*;

public class ShopTest {

  Shop snoutsRus;

  @Before
  public void before(){
    snoutsRus= new Shop("Snouts R Us", 10000);
  }

  @Test
  public void hasName(){
    assertEquals("Snouts R Us", snoutsRus.getName());
  }

  @Test
  public void hasBalance(){
    assertEquals(10000, snoutsRus.getBalance());
  }



  // tests commented out as the following methods are now private: addFunds(), subtractFunds(), setSalesTotal(), getSalesTotal(), setRefundsTotal(), getRefundsTotal(). all tests passed.
  // @Test
  // public void canAddToBalance(){
  //   snoutsRus.addFunds(10);
  //   assertEquals(10010, snoutsRus.getBalance());
  // }

  // @Test
  // public void canSubtractFromBalance(){
  //   snoutsRus.subtractFunds(6000);
  //   assertEquals(4000, snoutsRus.getBalance());
  // }

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

  // @Test
  // public void canReportBalanceOfSales(){
  //   snoutsRus.setSalesTotal(30);
  //   snoutsRus.setRefundsTotal(10);
  //   assertEquals(20, snoutsRus.getBalanceOfSales());
  // }

}
