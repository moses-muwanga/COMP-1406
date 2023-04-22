//Moses Muwanga
//COMP 1406 A1

public class Laptop {
    //Stores the laptops

    double LaptopCPU;
    int LaptopRam;
    int LaptopStorage;
    boolean LaptopSSD;
    int LaptopScreen;

    public Laptop(double CPU, int RAM, int Storage, boolean SSD, int Screen){
        LaptopCPU = CPU;
        LaptopRam = RAM;
        LaptopStorage = Storage;
        LaptopSSD = SSD;
        LaptopScreen = Screen;
    }
    public String toString() {
        //Returns laptop with given values

        if (LaptopSSD == true) {
            return LaptopScreen + " Laptop PC with " + LaptopCPU + "ghz CPU, " + LaptopRam + " RAM, "
                    + LaptopStorage + "GB SSD drive.";
        } else {
            return LaptopScreen + " Laptop PC with " + LaptopCPU + "ghz CPU, " + LaptopRam + " RAM, "
                    + LaptopStorage + "GB HDD drive.";
        }
    }
}
