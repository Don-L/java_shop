package app;

public class Shop {

  private final String name;
  private int balance;

  public Shop(String name, int balance){
    this.name = name;
    this.balance = balance;
  }

  public String getName(){
    return this.name;
  }
  // following tests commented out as methods being tested are now private
  // public int getBalance(){
  //   return this.balance;
  // }
  //
  // public void addFunds(int fundsIn){
  //   this.balance += fundsIn;
  // }

}
