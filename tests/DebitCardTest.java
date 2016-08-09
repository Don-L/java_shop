import app.*;

import static org.junit.Assert.*;
import org.junit.*;

public class DebitCardTest {

  Card card;

  @Before
  public void before(){
    card = new DebitCard("Snout Bank Of America inc", 1000, 100);
  }

  @Test
  public void hasName(){
    assertEquals("Snout Bank Of America inc", card.getName());
  }

  @Test
  public void hasLimit(){
    assertEquals(1000, card.getLimit());
  }

  @Test
  public void hasBalance(){
    assertEquals(100, card.getBalance());
  }

  @Test
  public void returnsAvailable(){
    assertEquals(1100, card.getAvailable());
  }

  @Test
  public void canTransferFunds(){
    card.transferFunds(100);
    assertEquals(0, card.getBalance());
  }

  @Test
  public void canTopUpFunds(){
    card.topUp(50);
    assertEquals(150, card.getBalance());
  }

  @Test(expected = IllegalArgumentException.class)
  public void topUpAmountShouldBePositiveInteger(){
    card.topUp(-8);
  }

  @Test
  public void testImpermissiblePurchase(){
    assertEquals(false, card.purchasePermitted(1200));
  }

  @Test
  public void testPermissiblePurchase(){
    assertEquals(true, card.purchasePermitted(100));
  }

}
