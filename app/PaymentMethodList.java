package app;

import java.util.*;

public class PaymentMethodList {

  private ArrayList<Card> paymentMethods;

  public PaymentMethodList(ArrayList<Card> paymentMethods){
    this.paymentMethods = paymentMethods;
  }

  public ArrayList<Card> getPaymentMethods(){
    return this.paymentMethods;
  }

  public void addCard(Card card){
    this.paymentMethods.add(card);
  }

//clean this up!
  public Card getCard(String cardType){
    if (cardType == "Debit Card"){
      if (this.paymentMethods.get(0) instanceof DebitCard){
        return this.paymentMethods.get(0);
      } else {
        return this.paymentMethods.get(1);
      }
    } else {
      if (this.paymentMethods.get(0) instanceof CreditCard){
        return this.paymentMethods.get(0);
      } else {
        return this.paymentMethods.get(1);
      }
    }
  }


}
