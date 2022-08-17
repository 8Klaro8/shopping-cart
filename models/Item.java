package models;

import javax.naming.ldap.SortControl;

public class Item {
   private String name;
   private double price;

   // constr.
   public Item(String name, double price){
    if (name == null || name.isBlank() || name.isEmpty()) {
        throw new IllegalArgumentException("Name can't be null or blank.");
    }
    if (price < 0) {
        throw new IllegalArgumentException("Price can't be lower than 0.");
    }
    this.name = name;
    this.price = price;
   }

   // Copy constr.
   public Item(Item source){
    this.name = source.name;
    this.price = source.price;
   }

   // Get
   public String getName() {
       return name;
   }
   public double getPrice() {
       return price;
   }

   // Set
   public void setName(String name) {
    if (name == null || name.isBlank() || name.isEmpty()) {
        throw new IllegalArgumentException("Name can't be null or blank.");
    }
       this.name = name;
   }
   public void setPrice(double price) {
    if (price < 0) {
        throw new IllegalArgumentException("Price can't be lower than 0.");
    }
       this.price = price;
   }

   // toString
   public String toString() {
       return name + ": $" + price + " ";
   }

   // Overriding equals method
   public boolean equals(Object obj){
        if (obj ==  null){
            return false;
        }
        if (!(obj instanceof Item)){
            return false;
        }

        Item item = (Item)obj;
        return item.name.equalsIgnoreCase(this.name) && item.price == this.price;
   }
}
