//Moses Muwanga
//COMP 1406 A2

import java.util.Scanner;

public class ElectronicStore {

    final int MAX_PRODUCTS = 10;
    String name;
    double revenue;
    Product[] products;
    int productNum;

    public ElectronicStore(String name) {
        this.name = name;
        products = new Product[MAX_PRODUCTS];
        productNum = 0;
        revenue = 0;
    }

    String getName() {
        return name;
    }

    boolean addProduct(Product p) {
        if (productNum < MAX_PRODUCTS) {
            products[productNum] = p;
            productNum++;
            return true;
        } else {
            return false;
        }
    }

    //void sellProducts() { }

    void sellProducts ( int item, int amount){
        if (item > 0 && item < productNum) {
            revenue += products[item].sellUnits(amount);
        }
    }

    double getRevenue() {
        return revenue;
    }

    void printStock() {
        for (int i = 0; i < productNum; i++) {
            System.out.println(products[i].toString());
        }
    }
}

