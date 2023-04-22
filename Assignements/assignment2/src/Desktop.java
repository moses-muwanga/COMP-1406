//Moses Muwanga
//COMP 1406 A2

public class Desktop extends Product {

    private double cpuSpeed;
    private int ram;
    private boolean ssd;
    private int storage;
    private String profile;

    public Desktop(double price, int stockQuantity, int soldQuantity, double cpuSpeed, int ram, boolean ssd, int storage,
                   String profile){

        super(price, soldQuantity);
        this.cpuSpeed = cpuSpeed;
        this.ram = ram;
        this.ssd = ssd;
        this.storage = storage;
        this.profile = profile;
    }

    public String toString(){

        if (ssd){
            return profile + "Desktop PC with " + cpuSpeed + "ghz CPU, " + ram + "GB RAM, " + storage + "GB SSD drive. ("
            + price + " dollars each, " + stockQuantity + "in stock, " + soldQuantity + "sold)";
        } else{
            return profile + "Desktop PC with " + cpuSpeed + "ghz CPU, " + ram + "GB RAM, " + storage + "GB HDD drive. ("
                    + price + " dollars each, " + stockQuantity + "in stock, " + soldQuantity + "sold)";
        }

    }



}