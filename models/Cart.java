package models;

import java.util.ArrayList;

public class Cart {
    ArrayList<Item> items = new ArrayList<>();

    // Constr.
    public Cart() {
        this.items = new ArrayList<Item>();
    }

    // Get
    public Item getItem(int index) {
        try {
            for (int i = 0; i < items.size(); i++) {
                if (index == i) {
                    return items.get(index);
                }
            }
            // If user try to access and element that doesn't exists (when it would return
            // null because there is no name)
        } catch (NullPointerException e) {
            System.out.println(e);
        }
        return null;
    }

    // Set
    public void setItem(int index, Item item) {
        // Check if user typed bigger index number than the actual size of the array is
        int sizeOfItems = items.size();
        if (index >= sizeOfItems) {
            throw new IndexOutOfBoundsException("There is no item that you could set at index: " + index);
        }
        // Copy item that was passed in
        items.set(index, new Item(item));
        System.out.println("Item: " + item.getName() + " set at index: " + index);
    }

    // add item
    public void addItem(Item item) {
        Item copyOfItem = new Item(item);
        if (!items.contains(item)) {
            this.items.add(item);
            System.out.println("Item added....");
        } else {
            System.out.println("Can't add item: '" + item.getName() + "' because it has been already added.");
        }
    }

    // remove item
    public void removeItem(String name) {

        boolean removedItem = false;
        for (int i = 0; i < items.size(); i++) {
            if (name.equalsIgnoreCase(items.get(i).getName())) {
                items.remove(i);
                System.out.println("The item: " + name + " has been removed.");
                removedItem = true;
            }
            else{
                continue;
            }

        if (removedItem == false) {
            System.out.println("There is no item with the name: " + name);
        }


        }
    }

    // Print all items
    public void printAllItems() {
        System.out.println("\nItems in your cart:\n-----------------------");
        for (int i = 0; i < items.size(); i++) {
            System.out.println(items.get(i));
        }
        System.out.println();
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
