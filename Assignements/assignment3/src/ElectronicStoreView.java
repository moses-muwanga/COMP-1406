import javafx.collections.FXCollections;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;


public class ElectronicStoreView extends Pane {

    //Model which the view is attached to
    private ElectronicStore model;

    //UI components needed by the controller
    private Button resetButton, addToCartButton, removeFromCartButton, completeSaleButton;
    private Label label1, label2, label3, label4, label5, label6, label7;
    private TextField salesField, revenueField, ratioField;
    private ListView<String> stockList, popularList, currentList;

    //Public methods to get access to window components
    public Button getResetButton() {
        return resetButton;
    }
    public Button getAddToCartButton() {
        return addToCartButton;
    }
    public Button getRemoveFromCartButton() {
        return removeFromCartButton;
    }
    public Button getCompleteSaleButton() {
        return completeSaleButton;
    }
    public Label getLabel1() {
        return label1;
    }
    public Label getLabel2() {
        return label2;
    }
    public Label getLabel3() {
        return label3;
    }
    public Label getLabel4() {
        return label4;
    }
    public Label getLabel5() {
        return label5;
    }
    public Label getLabel6() {
        return label6;
    }
    public Label getLabel7() {
        return label7;
    }
    public TextField getSalesField() {
        return salesField;
    }
    public TextField getRevenueField() {
        return revenueField;
    }
    public TextField getRatioField() {
        return ratioField;
    }
    public ListView<String> getStockList() {
        return stockList;
    }
    public ListView<String> getPopularList() {
        return popularList;
    }
    public ListView<String> getCurrentList() {
        return currentList;
    }

    public ElectronicStoreView(ElectronicStore m){

        //Store the model for access later
        model = m;

        //Create labels
        label1 = new Label("Store Summary:");
        label1.relocate(60, 30);
        label2 = new Label("Store Stock:");
        label2.relocate(300, 30);
        label3 = new Label("Current Cart:");
        label3.relocate(600, 30);
        label4 = new Label("# Sales:");
        label4.relocate(50,60);
        label5 = new Label("Revenue:");
        label5.relocate(40, 90);
        label6 = new Label("$ / Sale: ");
        label6.relocate(50, 120);
        label7 = new Label("Most Popular Items:");
        label7.relocate(50,150);

        //Create TextFields
        salesField = new TextField();
        salesField.relocate(100, 55);
        salesField.setPrefSize(80,15);
        revenueField = new TextField();
        revenueField.relocate(100,85);
        revenueField.setPrefSize(80,15);
        ratioField = new TextField();
        ratioField.relocate(100, 115);
        ratioField.setPrefSize(80,15);

        //Create buttons
        resetButton = new Button("Reset Store");
        resetButton.setDisable(true);
        resetButton.relocate(40, 340);
        resetButton.setPrefSize(120, 40);

        addToCartButton = new Button("Add to Cart");
        addToCartButton.setDisable(true);
        addToCartButton.relocate(275, 340);
        addToCartButton.setPrefSize(120,40);

        removeFromCartButton = new Button("Remove From Cart");
        removeFromCartButton.setDisable(true);
        removeFromCartButton.relocate(520, 340);
        removeFromCartButton.setPrefSize(120, 40);

        completeSaleButton = new Button("Complete Sale");
        completeSaleButton.setDisable(true);
        completeSaleButton.relocate(650, 340);
        completeSaleButton.setPrefSize(120, 40);

        //Create listsViews
        popularList = new ListView<String>();
        popularList.relocate(35,175);
        popularList.setPrefSize(150,150);

        stockList = new ListView();
        stockList.relocate(190,50);
        stockList.setPrefSize(300,275);

        currentList = new ListView<String>();
        currentList.relocate(495,50);
        currentList.setPrefSize(280,275);


        //Add Components to the window
        getChildren().addAll(label1, label2, label3, label4, label5, label6, label7, salesField, revenueField,
                ratioField, addToCartButton, removeFromCartButton, resetButton, completeSaleButton,
                stockList, popularList, currentList);



    }


    // This method is called whenever the model changes, to make
    // sure that the view shows the model's current state
    public void update() {

        //Add all the products to the Stock List View
        String[] productList = new String[model.curProducts()];
        for (int i = 0; i < model.curProducts(); i++) {
            productList[i] = String.valueOf(model.stock[i]);
        }
        stockList.setItems(FXCollections.observableArrayList(productList));

        //Add products to the Most Popular Items List
        String[] popList = new String[3];
        for (int i = 0; i < 3; i++){
            popList[i] = String.valueOf(model.stock[i]);
        }
        popularList.setItems(FXCollections.observableArrayList(popList));


    }

}

