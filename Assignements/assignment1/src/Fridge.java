//Moses Muwanga
//COMP 1406 A1

public class Fridge {
    //Stores the fridges

    double FridgeSize;
    boolean HasFreezer;
    String FridgeColour;

    public Fridge(double Size, boolean Freezer, String Colour){
        FridgeSize = Size;
        HasFreezer = Freezer;
        FridgeColour = Colour;
    }
    public String toString(){
        //Returns fridge with given values

        if (HasFreezer == true){
            return FridgeSize + " cubic foot fridge with Freezer (" + FridgeColour + ")";
        } else {
            return FridgeSize + " cubic foot fridge (" + FridgeColour + ")";
        }
    }
}
