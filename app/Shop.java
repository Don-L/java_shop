package app;

public class Shop {

  private final String name;
  private int balance;
  private int salesTotal;
  private int refundsTotal;

  public Shop(String name, int balance){
    this.name = name;
    this.balance = balance;
    this.salesTotal = 0;
    this.refundsTotal = 0;
  }

  public String getName(){
    return this.name;
  }

  public int getBalance(){
    return this.balance;
  }

  private void addFunds(int fundsIn){
    this.balance += fundsIn;
  }

  private void subtractFunds(int fundsOut){
    this.balance -= fundsOut;
  }

  private void setSalesTotal(int fundsIn){
    this.salesTotal += fundsIn;
  }

  private int getSalesTotal(){
    return this.salesTotal;
  }

  private void setRefundsTotal(int fundsOut){
    this.refundsTotal += fundsOut;
  }

  private int getRefundsTotal(){
    return this.refundsTotal;
  }

  private int getBalanceOfSales(){
    return this.salesTotal - this.refundsTotal;
  }

}
