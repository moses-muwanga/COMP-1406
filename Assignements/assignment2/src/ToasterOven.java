//Moses Muwanga
//COMP 1406 A2

public class ToasterOven extends Product {

    private int wattage;
    private String color;
    private String brand;
    private int width;
    private boolean convection;

    public ToasterOven(double price, int stockQuantity, int soldQuantity, int wattage, String color, String brand,
                       int width, boolean convection){

        super(price, soldQuantity);
        this.wattage = wattage;
        this.color = color;
        this.brand = brand;
        this.width = width;
        this.convection = convection;
    }

    public String toString(){

        if (convection){
            return width + " inch " + brand + " Toaster with convection (" + color + ", " + wattage + " watts) " + price + " " +
                    "dollars each, " + stockQuantity + " in stock, " + soldQuantity + " sold)";
        } else{
            return width + " inch " + brand + " Toaster (" + color + ", " + wattage + " watts) " + price + " " +
                    "dollars each, " + stockQuantity + " in stock, " + soldQuantity + " sold)";
        }
    }
}
