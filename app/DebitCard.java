package app;

public class DebitCard extends Card{

  private String name;
  private int limit;
  private int balance;

  public DebitCard(String name, int limit, int balance){
    super(name, limit, balance);
  }

  public void topUp(int amount){
    if (amount < 1){
      throw new IllegalArgumentException("Top up amount must be a positive integer");
    } else {
      int currentBalance = this.getBalance();
      int newBalance = currentBalance + amount;
      this.setBalance(newBalance);
    }
  }

}
