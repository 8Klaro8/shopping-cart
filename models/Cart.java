package models;

import java.security.MessageDigest;
import java.util.ArrayList;

public class Cart {
    ArrayList<Item> items;

    // conts.
    public Cart() {
        this.items = new ArrayList<Item>();
    }

    // Get
    public Item getItem(int index) {
        return new Item(items.get(index));
    }

    // Set
    public void setItem(int index, Item item) {
        this.items.set(index, new Item(item));
    }

    // Add Method I.------------>
    // public boolean addItem(Item item){

    // for (int i = 0; i < items.size(); i++) {
    // if (items.get(i).getName().equalsIgnoreCase(item.getName())) {
    // System.out.println("The item: " + item.getName() + " has been added
    // already.");
    // return false;
    // }
    // }
    // this.items.add(new Item(item));
    // return true;
    // }

    // Add Method II.------------>
    public void addItem(Item item) {

        boolean alreadyContains = false;

        // Adds the very first item individualy
        if (items.size() < 1) {
            items.add(item);
            System.out.println("Item added: " + item.getName());
            return;
        }

        // Checks if 'items' already contains the passed item and if so then
        // 'alreadyCointains' will be true
        if (!(alreadyContains)) {
            for (int i = 0; i < items.size(); i++) {
                if (!(items.get(i).equals(item))) {
                    alreadyContains = false;
                } else {
                    System.out.println("Item: " + item.getName() + " can't be added because it has been already added.");
                    alreadyContains = true;
                    return;
                }
            }

            // If 'items' doesnt contain passed item, then it will add it.
            if (!(alreadyContains)) {
                items.add(item);
                System.err.println("Item: " + item.getName() + " successfuly added.");
            }
            // } else {
            //     System.out.println("Item: " + item.getName() + " can't be added because it has been already added.");
            // }
        }
    }

    // Remove
    public void removeItem(String name) {
        if (items.size() < 1) {
            System.out.println("\nCan't remove item because there is no any item added yet.");
            return;
        }
        for (int i = 0; i < items.size(); i++) {
            if (name.equalsIgnoreCase(items.get(i).getName())) {
                System.out.println("\nItem: " + items.get(i).getName() + " has been removed.\n");
                items.remove(i);
                break;
            }
            else{
                System.out.println("There is no item with the name: " + name);
            }
            
        }
    }

    // Checkout
    public String checkout() {
        double[] measures = new double[3];

        for (int i = 0; i < items.size(); i++) {
            measures[0] += items.get(i).getPrice();
        }
        measures[1] = measures[0] * 0.13;
        measures[2] = measures[0] + measures[1];

        return "\nsubtotal: " + measures[0] + "\n" +
                "tax: " + measures[1] + "\n" +
                "total: " + measures[2] + "\n";
    }

    // toString method (override)
    public String toString() {
        String temp = "";
        for (int i = 0; i < items.size(); i++) {
            temp += items.get(i).toString();
        }
        return temp;
    }

    public void printAllItemName(){
        for (int i = 0; i < items.size(); i++) {
            System.out.println(items.get(i).getName());
        }
    }
}

/**
 * Name: checkout
 * 
 * @return (String)
 *
 *         Inside the function:
 *         1. Calculates the subtotal (price before tax).
 *         2. Calculates the tax (assume tax is 13%).
 *         3. Calculates total: subtotal + tax
 *         4. Returns a String that resembles a receipt. See below.
 */
