package app;

public class Item {

  private final String name;
  private final int price;

  public Item(String name, int price){
    if (price < 0) {
      throw new IllegalArgumentException("Price must be zero or greater");
    }
    this.name = name;
    this.price = price;
  }

  public String getName(){
    return this.name;
  }

  public int getPrice(){
    return this.price;
  }

}
