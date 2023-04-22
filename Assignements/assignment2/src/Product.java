//Moses Muwanga
//COMP 1406 A2

public class Product {

    protected double price;
    protected int stockQuantity;
    protected int soldQuantity;

    public Product(double price, int soldQuantity){

        this.price = price;
        this.soldQuantity = soldQuantity;
    }

    double sellUnits(int amount){

        if(amount <= 0){
            return 0.0;
        }

        if(stockQuantity >= amount){
            stockQuantity -= amount;
            soldQuantity += amount;
            return (price * amount);
        } else {
            return 0.0;
        }
    }

}
