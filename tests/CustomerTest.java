import app.*;

import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

public class CustomerTest {

  Customer customer;
  Customer cust;
  CreditCard creditCard;
  DebitCard debitCard;
  PaymentMethodList paymentMethods;
  ArrayList<Card> emptyList;
  HashMap<Item, Integer> list;
  Item prizeSnouts;
  Inventory inventory;

  @Before
  public void before(){
    creditCard = new CreditCard("Snout Enabler Creditline", 1000, -100);
    debitCard = new DebitCard("Snout Bank Of America inc", 1000, 100);
    emptyList = new ArrayList<Card>();
    paymentMethods = new PaymentMethodList(emptyList);
    paymentMethods.addCard(creditCard);
    paymentMethods.addCard(debitCard);
    customer = new Customer("Jimmy McSnoutsnout", paymentMethods);
    list = new HashMap<Item, Integer>();
    prizeSnouts = new Item("Prize Snouts", 699);
    list.put(prizeSnouts, 3);
    Inventory invent = new Inventory(list);
    cust = new Customer("Maggie McSnoutsnout", paymentMethods, invent);
  }

  @Test
  public void hasName(){
    assertEquals("Jimmy McSnoutsnout", customer.getName());
  }

//mark getcard methods as private?
  @Test
  public void canSelectCreditCardWithGetCardMethod(){
    CreditCard creditCard = (CreditCard) customer.getCard("Credit Card");
    String cardName = creditCard.getName();
    assertEquals("Snout Enabler Creditline", cardName);
  }

  @Test
  public void canSelectDebitCardWithGetCardMethod(){
    DebitCard debitCard = (DebitCard) customer.getCard("Debit Card");
    String cardName = debitCard.getName();
    assertEquals("Snout Bank Of America inc", cardName);
  }

  @Test
  public void canSelectCreditCardWithGetCreditCardMethod(){
    CreditCard creditCard = customer.getCreditCard();
    String cardName = creditCard.getName();
    assertEquals("Snout Enabler Creditline", cardName);
  }

  @Test
  public void canSelectDebitCardWithGetDebitCardMethod(){
    DebitCard debitCard = customer.getDebitCard();
    String cardName = debitCard.getName();
    assertEquals("Snout Bank Of America inc", cardName);
  }

  //if enough funds are available on the credit card, it should be used for any purchase

  @Test
  public void selectsCreditCardifPurchasePermitted(){
    Card selectedCard = customer.selectPaymentMethod(800);
    String cardName = selectedCard.getName();
    assertEquals("Snout Enabler Creditline", cardName);
  }

  @Test
  public void selectsDebitCardIfCantUseCreditCard(){
    Card selectedCard = customer.selectPaymentMethod(1000);
    String cardName = selectedCard.getName();
    assertEquals("Snout Bank Of America inc", cardName);
  }

  @Test
  public void selectsDebitCardIfRefundAmountOver2500(){
    Card selectedCard = customer.selectRefundMethod(2600);
    String cardName = selectedCard.getName();
    assertEquals("Snout Bank Of America inc", cardName);
  }

  @Test
  public void canGetInventory(){
    Inventory returnedInvent = cust.getInventory();
    HashMap<Item, Integer> returnedList = returnedInvent.getList();
    int quantity = (int) returnedList.get(prizeSnouts);
    assertEquals(3, quantity);
  }

  @Test
  public void canGetQuantityOfItemInStock(){
    assertEquals(3, cust.getQuantity(prizeSnouts));
  }

  @Test
  public void canAddItemsToStock(){
    cust.addToInventory(prizeSnouts, 7);
    Inventory returnedInvent = cust.getInventory();
    HashMap<Item, Integer> returnedList = returnedInvent.getList();
    int quantity = (int) returnedList.get(prizeSnouts);
    assertEquals(10, quantity);
  }

  @Test
  public void canTakeItemsFromStock(){
    cust.takeFromInventory(prizeSnouts, 1);
    Inventory returnedInvent = cust.getInventory();
    HashMap<Item, Integer> returnedList = returnedInvent.getList();
    int quantity = (int) returnedList.get(prizeSnouts);
    assertEquals(2, quantity);
  }



}
