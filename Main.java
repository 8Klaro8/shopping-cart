import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

        manageItems();

        // System.out.println(store);
    }

    // Loads items from "products.txt"
    public static void loadItems() throws FileNotFoundException {
        FileInputStream fileInStream = new FileInputStream("products.txt");
        Scanner fileScanner = new Scanner(fileInStream);

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
    }

    public static void manageItems() {
        Scanner userChoiceScanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nChoose:\na.) add\nb.) remove\nc.) checkout");
            String userChoice = userChoiceScanner.nextLine();
            switch (userChoice) {
                case "a":
                    System.out.println("\nPlease type a 'Row' and 'Column' number!\n");
                    System.out.println("First number:\n");
                    int chosenRow = checkIfNumber(userChoiceScanner);
                    if (chosenRow == -2 || chosenRow == -1) {
                        break;
                    }
                    System.out.println("Second number:\n");
                    int chosenCol = checkIfNumber(userChoiceScanner);
                    if (chosenCol == -2 || chosenCol == -1) {
                        break;
                    }

                    Item chosenItem = store.getItem(chosenRow, chosenCol);
                    cart.addItem(chosenItem);
                    break;

                    // String testInput = userChoiceScanner.nextLine();
                    // for (int i = 0; i < testInput.length(); i++) {
                    // boolean flag = Character.isAlphabetic(testInput.charAt(i));
                    // if (flag) {
                    // System.out.println("Please type number only.");
                    // break;
                    // } else {
                    // int chosenRow = Integer.parseInt(testInput);
                    // String testInput_2 = userChoiceScanner.nextLine();
                    // for (int j = 0; j < testInput_2.length(); j++) {
                    // boolean flag_2 = Character.isAlphabetic(testInput_2.charAt(j));
                    // if (flag_2) {
                    // System.out.println("Please type number only.");
                    // break;
                    // } else {
                    // int chosenCol = Integer.parseInt(testInput_2);
                    // userChoiceScanner.nextLine();

                    // Item chosenItem = store.getItem(chosenRow, chosenCol);
                    // cart.addItem(chosenItem);
                    // break;
                    // }
                    // }

                    // }
                    // }

                case "b":
                    System.out.println("Please type an item name, to remove.");
                    String itemName = userChoiceScanner.nextLine();
                    cart.removeItem(itemName);
                    System.out.println("\nYour items in the cart:\n--------------------");
                    cart.printAllItemName();
                    break;

                default:
                    break;
            }
        }
    }

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
                int chosenRow = Integer.parseInt(testInput);
                return chosenRow;
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
