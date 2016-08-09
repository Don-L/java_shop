package app;


public class Customer {

  private final String name;
  private PaymentMethodList paymentMethodList;

  public Customer(String name, PaymentMethodList paymentMethodList){
    this.name = name;
    this.paymentMethodList = paymentMethodList;
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



//make get card methods as private?
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

}
