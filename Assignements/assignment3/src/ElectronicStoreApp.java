import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.event.*;

public class ElectronicStoreApp extends Application {

    private ElectronicStore model;
    private ElectronicStoreView view;

    int cartIndex = 0;
    String[] addedList = new String[100];

    public void start(Stage primaryStage) {

        model = new ElectronicStore("Watts Up Electronics").createStore();
        view = new ElectronicStoreView(model);

        view.getLabel3().setText("Current Cart: ($" + model.getRevenue() + ")");

        // Plug in the event handlers

        view.getStockList().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                activateAddButton();
            }
        });

        view.getAddToCartButton().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                handleAdd();
                activateResetButton();
            }
        });

        view.getCurrentList().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                activateRemoveButton();
            }
        });

        view.getRemoveFromCartButton().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                handleRemove();
            }
        });

        view.getResetButton().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                primaryStage.close();
            }
        });

        view.getCompleteSaleButton().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                System.out.println("Complete sale button pressed.");
            }
        });


        //Set the title, make non-resizable, set window size, show
        primaryStage.setTitle("Electronic Store Application");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(view,800,400));
        primaryStage.show();
        view.update();

    }

    public static void main(String[] args) {
        launch(args);
    }


//    //Activates the add button when an item is selected and deactivates when nothing is selected
//    //If an item has been selected inside of the Store Stock ListView, the ‘Add to Cart’ button should be enabled.
//    //If no item has been selected, the button should be disabled.
    public void activateAddButton() {
        int index = view.getStockList().getSelectionModel().getSelectedIndex();
        if (index >= 0) {
            view.getAddToCartButton().setDisable(false);
        } else {
            view.getAddToCartButton().setDisable(true);
        }
    }

    public void activateRemoveButton(){
        int index = view.getCurrentList().getSelectionModel().getSelectedIndex();
        if(index >= 0) {
            view.getRemoveFromCartButton().setDisable(false);
        } else {
            view.getRemoveFromCartButton().setDisable(true);
        }
        view.update();
    }

        //Actives the reset button
    public void activateResetButton(){
        view.getResetButton().setDisable(false);
    }


    //Reset store event handler



    //Add to cart event handler
    public void handleAdd(){
        int index = view.getStockList().getSelectionModel().getSelectedIndex();

        view.getSalesField().setText(String.valueOf(model.sale));
        view.getRevenueField().setText(String.valueOf(model.revenue));
        view.getRatioField().setText(String.valueOf(model.revenue/model.sale));

        if (index >=0) {
            addedList[cartIndex] = String.valueOf(model.cartStock[index]);
            cartIndex++;
            model.removeProduct(index);
            view.getCurrentList().setItems(FXCollections.observableArrayList(addedList));
            model.sellProducts(index, 1);

        }
    }

    public void handleRemove(){
        int index = view.getCurrentList().getSelectionModel().getSelectedIndex();

        if (index >=0) {
            addedList[cartIndex] = String.valueOf(model.cartStock[index]);
            cartIndex++;
            model.removeProduct(index);
            view.getCurrentList().setItems(FXCollections.observableArrayList(addedList));
        }

    }


    //Complete sale events handler

}
