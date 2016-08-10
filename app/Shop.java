package app;
import app.*;
import java.util.HashMap;

public class Shop {

  private final String name;
  private int salesTotal;
  private int refundsTotal;
  private Inventory inventory;

  public Shop(String name){
    this.name = name;
    this.salesTotal = 0;
    this.refundsTotal = 0;
    this.inventory = new Inventory();
  }

  public Shop(String name, Inventory inventory){
    this.name = name;
    this.salesTotal = 0;
    this.refundsTotal = 0;
    this.inventory = inventory;
  }

  public Shop(String name, int salesTotal, int refundsTotal){
    this.name = name;
    this.salesTotal = salesTotal;
    this.refundsTotal = refundsTotal;
    this.inventory = new Inventory();
  }

  public String getName(){
    return this.name;
  }

  public int getSalesTotal(){
    return this.salesTotal;
  }

  public int getRefundsTotal(){
    return this.refundsTotal;
  }

  public void takeFunds(int fundsIn){
    this.salesTotal += fundsIn;
  }

  public void makeRefund(int fundsOut){
    this.refundsTotal += fundsOut;
  }

  public int getBalanceOfSales(){
    return this.salesTotal - this.refundsTotal;
  }

  public Inventory getInventory(){
    return this.inventory;
  }

  public int getQuantity(Item item){
    return this.inventory.getQuantity(item);
  }

  public void addToInventory(Item item, Integer quantity){
    this.inventory.add(item, quantity);
  }

  public void takeFromInventory(Item item, Integer quantity){
    this.inventory.take(item, quantity);
  }

  public void transact(String transactionType, Customer customer, Item item, Integer quantity){
    int itemPrice = item.getPrice();
    int transactionValue = itemPrice * quantity;
    if (transactionType == "sell"){
      Card card = customer.selectPaymentMethod(transactionValue);
      card.transferFunds(transactionValue);
      this.takeFunds(transactionValue);
      this.takeFromInventory(item, quantity);
      customer.addToInventory(item, quantity);
    } else {
      if (transactionType == "refund"){
        Card card = customer.selectRefundMethod(transactionValue);
        this.makeRefund(transactionValue);
        card.topUp(transactionValue);
        customer.takeFromInventory(item, quantity);
        this.addToInventory(item, quantity);
      }
    }
  }

}
