import app.*;

import static org.junit.Assert.*;
import org.junit.*;

public class CreditCardTest {

  Card card;

  @Before
  public void before(){
    card = new CreditCard("Snout Enabler Creditline", 1000, -100);
  }

  @Test
  public void hasName(){
    assertEquals("Snout Enabler Creditline", card.getName());
  }

  @Test
  public void hasLimit(){
    assertEquals(1000, card.getLimit());
  }

  @Test
  public void hasBalance(){
    assertEquals(-100, card.getBalance());
  }

  @Test
  public void returnsAvailable(){
    assertEquals(900, card.getAvailable());
  }

  @Test
  public void canTransferFunds(){
    card.transferFunds(100);
    assertEquals(-200, card.getBalance());
  }

  @Test
  public void canTopUpFunds(){
    card.topUp(50);
    assertEquals(-50, card.getBalance());
  }

  @Test(expected = IllegalArgumentException.class)
  public void topUpAmountShouldBePositiveInteger(){
    card.topUp(-8);
  }

  @Test(expected = IllegalArgumentException.class)
  public void cantPlaceCardBalanceInCredit(){
    card.topUp(101);
  }

  @Test
  public void testImpermissiblePurchase(){
    assertEquals(false, card.purchasePermitted(1001));
  }

  @Test
  public void testPermissiblePurchase(){
    assertEquals(true, card.purchasePermitted(100));
  }

}
