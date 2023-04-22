//Moses Muwanga
//COMP 1406 A2

public class Fridge extends Product {

    private int wattage;
    private String color;
    private String brand;
    private double cubicFeet;
    private boolean hasFreezer;

    public Fridge(double price, int stockQuantity, int soldQuantity, int wattage, String color, String brand,
                  double cubicFeet, boolean hasFreezer){

        super(price, soldQuantity);
        this.wattage = wattage;
        this.color = color;
        this.brand = brand;
        this.cubicFeet = cubicFeet;
        this.hasFreezer = hasFreezer;
    }

    public String toString(){

        if (hasFreezer){
            return cubicFeet + " cu. ft. " + brand + " Fridge with Freezer (" + color + "," + wattage + " watts) (" + price +
                    " dollars each, " + soldQuantity + " in stock, " + soldQuantity + "sold)";
        } else{
            return cubicFeet + " cu. ft. " + brand + " Fridge (" + color + "," + wattage + " watts) (" + price +
                    " dollars each, " + soldQuantity + " in stock, " + soldQuantity + "sold)";
        }

    }

}
