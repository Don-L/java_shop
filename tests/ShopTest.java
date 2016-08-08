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
  private void hasBalance(){
    assertEquals(10000, snoutsRus.getBalance());
  }

  @Test
  private void canAddToBalance(){
    snoutsRus.addFunds(10);
    assertEquals(10010, snoutsRus.getBalance());
  }

}
