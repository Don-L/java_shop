package app;

import app.*;
import java.util.HashMap;

public class Inventory {

  private HashMap<Item, Integer> list;

  public Inventory(){
    this.list = new HashMap<Item, Integer>();
  }

  public Inventory(HashMap<Item, Integer> list){
    this.list = list;
  }

  public HashMap<Item, Integer> getList(){
    return this.list;
  }

  public void add(Item item, Integer quantity){
    if (this.list.containsKey(item) == false){
      this.list.put(item, quantity);
    } else {
      Integer inStock = this.list.get(item);
      Integer newStock = inStock + quantity;
      this.list.put(item, newStock);
    }
  }

  public void take(Item item, Integer quantity){
    Integer inStock = this.list.get(item);
    if (inStock < quantity) {
      throw new IllegalArgumentException("Request can't be fulfilled - not enough of this item in stock");
    } else {
        if (inStock == quantity){
        this.list.remove(item);
      } else {
        Integer newStock = inStock - quantity;
        this.list.put(item, newStock);
      }
    }
  }



}
