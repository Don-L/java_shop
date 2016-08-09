package app;
import app.*;
import java.util.HashMap;

public class Shop {

  private final String name;
  private int salesTotal;
  private int refundsTotal;
  private HashMap<Item, Integer> inventory;

  public Shop(String name){
    this.name = name;
    this.salesTotal = 0;
    this.refundsTotal = 0;
    this.inventory = new HashMap<Item, Integer>();
  }

  public Shop(String name, HashMap<Item, Integer> inventory){
    this.name = name;
    this.salesTotal = 0;
    this.refundsTotal = 0;
    this.inventory = inventory;
  }

  public Shop(String name, int salesTotal, int refundsTotal){
    this.name = name;
    this.salesTotal = salesTotal;
    this.refundsTotal = refundsTotal;
    this.inventory = new HashMap<Item, Integer>();
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

  public void addToInventory(Item item, Integer quantity){
    if (this.inventory.containsKey(item) == false){
      this.inventory.put(item, quantity);
    } else {
      Integer inStock = this.inventory.get(item);
      Integer newStock = inStock + quantity;
      this.inventory.put(item, newStock);
    }
  }

  public HashMap<Item, Integer> getInventory(){
    return this.inventory;
  }

  public void removeFromInventory(Item item, Integer quantity){
    Integer inStock = this.inventory.get(item);
    if (inStock < quantity) {
      throw new IllegalArgumentException("Request can't be fulfilled - not enough of this item in stock");
    } else {
        if (inStock == quantity){
        this.inventory.remove(item);
      } else {
        Integer newStock = inStock - quantity;
        this.inventory.put(item, newStock);
      }
    }
  }

}
