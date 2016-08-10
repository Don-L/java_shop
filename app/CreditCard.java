package app;

public class CreditCard extends Card{

  private String name;
  private int limit;
  private int balance;

  public CreditCard(String name, int limit, int balance){
    super(name, limit, balance);
  }

  public void topUp(int amount){
    if (amount < 1){
      throw new IllegalArgumentException("Top up amount must be a positive integer");
    } else {
      int currentBalance = this.getBalance();
      int newBalance = currentBalance + amount;
      if (newBalance > 0){
        throw new IllegalArgumentException("You cannot have a positive balance on a credit card");
      } else {
        this.setBalance(newBalance);
      }
    }
  }

// how to get this to work?
//   public boolean topUpPermitted(int amount){
//     int currentBalance = this.getBalance();
//     int newBalance = currentBalance + amount;
//     if (newBalance > 0){
//       return false;
//     } else{
//       return true;
//     }
//   }

}
