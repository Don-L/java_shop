package app;


public class Customer {

  private final String name;
  private PaymentMethodList paymentMethodList;
  private Inventory inventory;

  public Customer(String name, PaymentMethodList paymentMethodList){
    this.name = name;
    this.paymentMethodList = paymentMethodList;
    this.inventory = new Inventory();
  }

  public Customer(String name, PaymentMethodList paymentMethodList, Inventory inventory){
    this.name = name;
    this.paymentMethodList = paymentMethodList;
    this.inventory = inventory;
  }

  public String getName(){
    return this.name;
  }

  public Card selectPaymentMethod(int purchasePrice){
    Card creditCard = this.getCard("Credit Card");
    if (creditCard.purchasePermitted(purchasePrice)){
      return creditCard;
    } else {
      Card debitCard = this.getCard("Debit Card");
      return debitCard;
    }
  }

//make get card methods private?
  public CreditCard getCreditCard(){
    CreditCard creditCard = (CreditCard) this.getCard("Credit Card");
    return creditCard;
  }

  public DebitCard getDebitCard(){
    DebitCard debitCard = (DebitCard) this.getCard("Debit Card");
    return debitCard;
  }

  public Card getCard(String cardType){
    return this.paymentMethodList.getCard(cardType);
  }

  public Inventory getInventory(){
    return this.inventory;
  }

}
