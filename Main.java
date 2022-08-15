import java.util.Scanner;

import models.Cart;
import models.Item;
import models.Store;

public class Main {
    public static void main(String[] args) {
        Item firstItem = new Item("Celery", 0.99);
        Item secondItem = new Item("Spinach", 0.99);
        Item thirdItem = new Item("Coriander", 1.29);

        Scanner scan = new Scanner(System.in);
        Cart cart = new Cart();

        cart.addItem(firstItem);
        cart.addItem(secondItem);
        cart.addItem(thirdItem);
        cart.addItem(firstItem);

        while (true) {
            System.out.println("What would you like to do?\n\ta.) Add item" +
                    "\n\tb.) Remove item" +
                    "\n\tc.) Checkout");

            String userChoice = scan.nextLine();
            switch (userChoice) {
                case "a":
                // ADD ITEM
                System.out.println("Which item do you want to add?");
                String userChoiceAddItem = scan.nextLine();
                
                // TODO: Add item emthod

                    break;
                case "b":
                // REMOVE
                    System.out.println("Type item's name to remove.");
                    String itemToRemove = scan.nextLine();
                    cart.removeItem(itemToRemove);

                    // Print all item
                    cart.printAllItems();

                    break;
                case "c":
                // CHECKOUT

                    break;

                default:
                    break;
            }
        }

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
