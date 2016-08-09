package app;

import java.util.*;

public class Customer {

  private final String name;
  private ArrayList<Card> paymentMethods;

  public Customer(String name, ArrayList<Card> paymentMethods){
    this.name = name;
    this.paymentMethods = paymentMethods;
  }

  public String getName(){
    return this.name;
  }

  public ArrayList<Card> getPaymentMethods(){
    return this.paymentMethods;
  }

}
