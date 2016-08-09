package app;

import behaviours.*;


public abstract class Card implements Payable{

  private String name;
  private int balance;
  private int limit;

  public Card(String name, int limit, int balance){
    this.name = name;
    this.limit = limit;
    this.balance = balance;
  }

  public String getName(){
    return this.name;
  }

  public void setName(String name){
    this.name = name;
  }

  public int getBalance(){
    return this.balance;
  }

  public void setBalance(int newBalance){
    this.balance = newBalance;
  }

  public int getLimit(){
    return this.limit;
  }

  public int getAvailable(){
    return this.limit + this.balance;
  }

  public void transferFunds(int amount){
    int avail = this.getAvailable();
    if (amount > avail) {
      throw new IllegalArgumentException("Insufficient funds - wait til Giro day");
    } else {
      this.balance -= amount;
    }
  }

  public boolean purchasePermitted(int price){
    int avail = this.getAvailable();
    if (price > avail){
      return false;
    } else {
      return true;
    }
  }

}
