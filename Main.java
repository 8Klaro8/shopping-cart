import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.CellEditor;

import models.Cart;
import models.Item;
import models.Store;

public class Main {
    static Cart cart = new Cart();
    static Store store = new Store();
    static int lineCounter = 0;

    public static void main(String[] args) throws FileNotFoundException {

        loadItems();
        System.out.println(store.toString());
        manageItems();

        // System.out.println(store);
    }

    // Loads items from "products.txt"
    public static void loadItems() throws FileNotFoundException {
        try {
            FileReader myFile = new FileReader("shopping-cart\\products.txt");
            // FileInputStream fileInStream = new FileInputStream("products.txt");
            Scanner fileScanner = new Scanner(myFile);

            // Loop until all the lines are read int the "products.txt".
            while (fileScanner.hasNextLine()) {
                lineCounter++;

                String line = fileScanner.nextLine();
                // Split each item using the ";" sign.
                String[] arrayItems = line.split(";");

                // Loop thru each line and get names and values separated.
                for (int i = 0; i < 7; i++) {
                    // Loop thru each item in line (category)
                    for (int j = 0; j < 3; j++) {
                        // Split each item name from price.
                        String[] currentItem = arrayItems[j].split("=");
                        // name
                        String productName = currentItem[0];
                        // parsed price = double
                        double productPrice = Double.parseDouble(currentItem[1]);
                        // Creating new item using the product name and price
                        Item item = new Item(productName, productPrice);
                        // Add item to store
                        store.setItem(item, (lineCounter - 1), j);

                    }
                    break;

                }

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static void manageItems(){
        Scanner userChoiceScanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nChoose:\na.) add\nb.) remove\nc.) checkout");
            String userChoice = userChoiceScanner.nextLine();
            switch (userChoice) {
                case "a":
                    System.out.println("\nPlease type a 'Row' and 'Column' number!\n");
                    System.out.println("First number, between 1-7:\n");

                    // Controls the input
                    int chosenRow = checkIfNumber(userChoiceScanner);
                    if (chosenRow == -3 || chosenRow == -2 || chosenRow == -1) {
                        break;
                    }
                    System.out.println("Second number, bewtween 1-3:\n");
                    int chosenCol = checkIfNumber(userChoiceScanner);
                    if (chosenCol == -3 || chosenCol == -2 || chosenCol == -1) {
                        break;
                    }

                    // Creates item
                    Item chosenItem = store.getItem((chosenRow - 1), (chosenCol - 1)); // Decrease user input to "start count" from 1 instead of 0.
                    cart.addItem(chosenItem);
                    break;

                case "b":
                    System.out.println("Please type an item name, to remove.");
                    String itemName = userChoiceScanner.nextLine();
                    cart.removeItem(itemName);
                    System.out.println("\nYour items in the cart:\n--------------------");
                    cart.printAllItemName();
                    break;

                case "c":
                    checkout();
                    break;
                default:
                    break;
            }
        }
    }

    public static void checkout() {
        cart.printAllItemName();
        System.out.println(cart.checkout());
    }

    // Controls the input
    public static int checkIfNumber(Scanner userChoiceScanner) {
        String testInput = userChoiceScanner.nextLine();
        if (testInput.isBlank() || testInput.isEmpty() || testInput == null) {
            System.out.println("Field cannot be empty. Type number instead.");
            return -2;
        }
        for (int i = 0; i < testInput.length(); i++) {
            boolean flag = Character.isAlphabetic(testInput.charAt(i));
            if (flag) {
                System.out.println("Please type number only.");
                return -1;
            } else {
                try {
                    int chosenRow = Integer.parseInt(testInput.trim());
                    if (chosenRow < 0) {
                        System.out.println("Negative number doesn't count ;)");
                        return -3;
                    }
                    return chosenRow;
                } catch (Exception e) {
                    System.out.println("Type one number please.");
                    return -1;
                }

            }
        }
        return 0;
    }

}

/**
 * Name: manageItems
 * Inside the function:
 * • 1. Starts a new instance of Scanner;
 * • 2. Creates an infinite loop:
 * • The user can choose to a) add or b) remove c) checkout.
 * • case a: asks for the aisle and item number. Then, adds item to cart.
 * • case b: asks for the name. Then, removes item from cart.
 * • case c: prints the receipt and closes Scanner.
 * • Prints the updated shopping cart.
 */

/**
 * Name: loadItems
 * 
 * @param fileName (String)
 * @throws FileNotFoundException
 *
 *                               Inside the function:
 *                               1. loads items from <fileName>.txt.
 *                               • while loop runs through every line in
 *                               <fileName>
 *                               • scan.nextLine() picks up the entire line.
 *                               • splits each String using the ";" separator.
 *                               • splits both fields in each String using the
 *                               "=" separator.
 *                               • Parse each price into a Double.
 *                               2. adds all items to the store object's items
 *                               field.
 */
