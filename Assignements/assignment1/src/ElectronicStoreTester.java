//Moses Muwanga
//COMP 1406 A1

import java.util.Scanner;

public class ElectronicStoreTester {

    public static void main(String[] args) {

        //Instantiate ElectronicStore
        ElectronicStore storeName = new ElectronicStore("Best Buy");

        //Display the stores stock by calling printStock()
        System.out.println("The store stock includes:");
        storeName.printStock();

        /*Loop searches through the stores stock, reports whether or not
        the searched item is in the store and exits when the user enters
        "quit"*/
        String searchedItem = "";
        while (true) {
            System.out.print("Enter a term to search for: ");
            searchedItem = new Scanner(System.in).nextLine();

            if (searchedItem.equals("quit")) {
                break;
            }

            if (storeName.searchStock(searchedItem)) {
                System.out.println("A matching item is contained in the store");
            } else {
                System.out.println("No items in the store's stock match that item");
            }
        }
    }
}
