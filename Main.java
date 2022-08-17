import java.util.Scanner;

import javax.swing.CellEditor;

import models.Cart;
import models.Item;
import models.Store;

public class Main {
    public static void main(String[] args) {

        Cart cart = new Cart();

        cart.addItem(new Item("Zeller", 4.4));
        cart.addItem(new Item("Spinach", 0.99));
        cart.addItem(new Item("Celery", 0.99));
        cart.addItem(new Item("Celery", 0.99));

        Item celeryItem = new Item("efefe", 1);
        Item copyCeleryItem = celeryItem;

        cart.addItem(celeryItem);
        cart.addItem(celeryItem);
        cart.addItem(copyCeleryItem);

        System.out.println(cart);

        

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
