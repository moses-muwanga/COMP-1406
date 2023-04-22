//Moses Muwanga
//COMP 1406 A1

public class Desktop {
    //Stores the desktops

    double DesktopCPU;
    int DesktopRam;
    int DesktopStorage;
    boolean DesktopSSD;

    public Desktop(double CPU, int RAM, int Storage, boolean SSD){
        DesktopCPU = CPU;
        DesktopRam = RAM;
        DesktopStorage = Storage;
        DesktopSSD = SSD;
    }
    public String toString(){
        //Returns desktop with given values

        if (DesktopSSD == true){
            return "Desktop PC with " + DesktopCPU + "ghz CPU, " + DesktopRam + " RAM, "
                    + DesktopStorage + "GB SSD drive.";
        } else{
            return "Desktop PC with " + DesktopCPU + "ghz CPU, " + DesktopRam + " RAM, "
                    + DesktopStorage + "GB HDD drive.";
        }
    }
}
