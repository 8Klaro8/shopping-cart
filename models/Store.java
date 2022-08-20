package models;

import java.lang.reflect.Array;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.plaf.synth.SynthPasswordFieldUI;

public class Store {
    private Item[][] items;

    // Constr.
    public Store() {
        this.items = new Item[7][3];
    }

    // Get
    public Item getItem(int row, int col) {
        if (this.items[row][col] == null) {
            throw new NullPointerException("\n\nItem is null at:\n\tCol: " + col + "\n\tRow: " + row + "\n");
        }
        return new Item(this.items[row][col]);
    }

    // Set
    public void setItem(Item item, int row, int col) {
        this.items[row][col] = new Item(item);
    }

    // toString
    public String toString() {
        String temp = "";
        temp += "\n    ************************************************************************";

        for (int i = 0; i < items.length; i++) {
            temp += "\n\n";

            switch (i) {
                case 0:
                    temp += "\tDRINKS: ";
                    break;
                case 1:
                    temp += "\tCEREAL: ";
                    break;
                case 2:
                    temp += "\tDAIRY: ";
                    break;
                case 3:
                    temp += "\tDELI: ";
                    break;
                case 4:
                    temp += "\tGREENS: ";
                    break;
                case 5:
                    temp += "\tCLOTHING: ";
                    break;
                case 6:
                    temp += "\tELECTRONICS: ";
                    break;

                default:
                    break;
            }
            for (int j = 0; j < items[i].length; j++) {

                temp += items[i][j].toString();

            }
        }

        // --------------------Solution I.-----------------
        // for (int i = 0; i < items.length; i++) {
        // temp += "\n\n";
        // switch (i) {
        // case 0:
        // temp += "\tDRINKS: " + Arrays.toString(items[i]);
        // break;
        // case 1:
        // temp += "\tCEREAL: " + Arrays.toString(items[i]);
        // break;
        // case 2:
        // temp += "\tDAIRY: " + Arrays.toString(items[i]);
        // break;
        // case 3:
        // temp += "\tDELI: " + Arrays.toString(items[i]);
        // break;
        // case 4:
        // temp += "\tGREENS: " + Arrays.toString(items[i]);
        // break;
        // case 5:
        // temp += "\tCLOTHING: " + Arrays.toString(items[i]);
        // break;
        // case 6:
        // temp += "\tELECTRONICS: " + Arrays.toString(items[i]);
        // break;

        // default:
        // break;
        // }
        // }

        temp += "\n\n    ************************************************************************\n";
        return temp;
    }

    public void printStoreLength() {
        System.out.println(items.length);
    }

}
