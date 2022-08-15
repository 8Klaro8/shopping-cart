package models;

import javax.naming.ldap.SortControl;

public class Item {
    private String name;
    private double price;
    

    // Constr.
    public Item(String name, double price){
        if (name.isEmpty() || name.isBlank() || name == null) {
            throw new IllegalArgumentException("Name can't be null, empty or blank.");
        }
        if (price < 0){
            throw new IllegalArgumentException("Price can't be lwoer than 0.");
        }
        this.name = name;
        this.price = price;
    }
    // Copy Constr.
    public Item(Item source){
        this.name = source.name;
        this.price = source.price;
    }
    // toString method
    public String toString(){
        return name + ": $" + price + " ";
    }

    // Get
    public String getName(){
        return this.name;
    }
    public double getPrice(){
        return this.price;
    }

    // Set
    public void setName(String name){
        this.name = name;
    }
    public void setPrice(double price){
        this.price = price;
    }
}
