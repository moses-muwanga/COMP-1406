//Moses Muwanga
//COMP 1406 A1

import java.util.ArrayList;

public class ElectronicStore {

    String StoreName;
    ArrayList desktopStock = new ArrayList();
    ArrayList laptopStock = new ArrayList();
    ArrayList fridgeStock = new ArrayList();

    public ElectronicStore(String Name){
        //Creates arraylists with the stores stock

        StoreName = Name;

        Desktop d1 = new Desktop(3.5, 8, 500, false);
        Desktop d2 = new Desktop(3.0, 16, 250, true);
        Desktop d3 = new Desktop(4.3, 32, 500, true);

        desktopStock.add(d1);
        desktopStock.add(d2);
        desktopStock.add(d3);

        Laptop l1 = new Laptop(3.1, 32, 500, true, 15);
        Laptop l2 = new Laptop(2.5, 8, 250, false, 13);
        Laptop l3 = new Laptop(3.0, 16, 250, true, 15);

        laptopStock.add(l1);
        laptopStock.add(l2);
        laptopStock.add(l3);

        Fridge f1 = new Fridge(16.5, true, "Black");
        Fridge f2 = new Fridge(12.0, false, "White");
        Fridge f3 = new Fridge(23.0, true, "Stainless Steel");

        fridgeStock.add(f1);
        fridgeStock.add(f2);
        fridgeStock.add(f3);
    }

    public void printStock(){
        //Prints out the stores current stock.

        for (int i = 0; i < desktopStock.size(); i++){
            System.out.println(desktopStock.get(i).toString());
        }
        for (int i = 0; i < laptopStock.size(); i++) {
            System.out.println(laptopStock.get(i).toString());
        }
        for (int i = 0; i < fridgeStock.size(); i++) {
            System.out.println(fridgeStock.get(i).toString());
        }
    }

    String searchedItem;

    public boolean searchStock(String item) {
        //Searches the stores stock and returns true or false

        searchedItem = item.toLowerCase();

        for (int i = 0; i < desktopStock.size(); i++) {
            if (desktopStock.get(i).toString().toLowerCase().contains(searchedItem)) {
                return true;
            }
        }
        for (int i = 0; i < laptopStock.size(); i++) {
            if (laptopStock.get(i).toString().toLowerCase().contains(searchedItem)) {
                return true;
            }
        }
        for (int i = 0; i < fridgeStock.size(); i++) {
            if (fridgeStock.get(i).toString().toLowerCase().contains(searchedItem)) {
                return true;
            }

        }
        return false;

    }

}
