package behaviours;

public interface Payable{
  int getAvailable();
  void transferFunds(int amountOut);
  void topUp(int amountIn);
}
