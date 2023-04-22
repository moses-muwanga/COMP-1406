//Moses Muwanga
//COMP 1406 A2

public class Laptop extends Product {

    private double cpuSpeed;
    private int ram;
    private boolean ssd;
    private int storage;
    private double screenSize;

    public Laptop(double price, int stockQuantity, int soldQuantity, double speedQuantity, int ram, boolean ssd,
                  int storage, int screenSize){

        super(price, soldQuantity);
        this.cpuSpeed = cpuSpeed;
        this.ram = ram;
        this.ssd = ssd;
        this.storage = storage;
        this.screenSize = screenSize;
    }

    public String toString(){

        if (ssd){
            return screenSize + " inch Laptop PC with " + cpuSpeed + "ghz CPU, " + ram + "GB RAM, " + storage+ "GB SSD drive." +
                    " (" + price + " dollars each, " + stockQuantity + " in stock, " + soldQuantity + " sold)";
        } else{
            return screenSize + " inch Laptop PC with " + cpuSpeed + "ghz CPU, " + ram + "GB RAM, " + storage+ "GB HDD drive." +
                    " (" + price + " dollars each, " + stockQuantity + " in stock, " + soldQuantity + " sold)";
        }
    }
}
