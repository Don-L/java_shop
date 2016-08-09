import app.*;

import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

public class CustomerTest {

  Customer customer;
  CreditCard creditCard;
  DebitCard debitCard;
  ArrayList<Card> paymentMethods;

  @Before
  public void before(){
    creditCard = new CreditCard("Snout Enabler Creditline", 1000, -100);
    debitCard = new DebitCard("Snout Bank Of America inc", 1000, 100);
    paymentMethods = new ArrayList<Card>();
    paymentMethods.add(creditCard);
    paymentMethods.add(debitCard);
    customer = new Customer("Jimmy McSnoutsnout", paymentMethods);
  }

  @Test
  public void hasName(){
    assertEquals("Jimmy McSnoutsnout", customer.getName());
  }

  @Test
  public void hasCreditCard(){
    ArrayList<Card> paymentMethods = customer.getPaymentMethods();
    assertEquals(true, paymentMethods.contains(creditCard));
  }

  @Test
  public void hasDebitCard(){
    ArrayList<Card> paymentMethods = customer.getPaymentMethods();
    assertEquals(true, paymentMethods.contains(debitCard));
  }

}
