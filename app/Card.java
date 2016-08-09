package app;

import behaviours.*;


public abstract class Card implements Payable{

  private String name;
  private int balance;
  private int limit;


  public String getName(){
    return this.name;
  }

  public void setName(String name){
    this.name = name;
  }

  public int getBalance(){
    return this.balance;
  }

  public int getLimit(){
    return this.limit;
  }

  public void setLimit(int lim){
    this.limit = lim;
  }

  public int getAvailable(){
    return this.limit + this.balance;
  }

  public void transferFunds(int amount){
    this.balance -= amount;
  }

}
