package edu.bsu.cs222;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.Window;

public class MainWindow extends Application {
    Stage mainWindow;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){
        mainWindow = primaryStage;
        mainWindow.setTitle("G-League Manager");

        //Create grid pane
        GridPane gridPane = createMainWindow();
        // add UI functionalities to the grid pane
        addUIControls(gridPane);
        //create mainScene with grid pane
        Scene mainScene = new Scene(gridPane, 800, 500);
        // set mainScene in primary stage
        mainWindow.setScene(mainScene);

        mainWindow.show();
    }




    private GridPane createMainWindow() {
        GridPane gridPane = new GridPane();

        gridPane.setAlignment(Pos.CENTER);

        // Set a padding of 20px on each side
        gridPane.setPadding(new Insets(40, 40, 40, 40));

        // Set the horizontal gap between columns
        gridPane.setHgap(10);

        // Set the vertical gap between rows
        gridPane.setVgap(10);

        // Add Column Constraints
        // columnOneConstraints will be applied to all the nodes placed in column one.
        ColumnConstraints columnOneConstraints = new ColumnConstraints(100, 100, Double.MAX_VALUE);
        columnOneConstraints.setHalignment(HPos.RIGHT);

        // columnTwoConstraints will be applied to all the nodes placed in column two.
        ColumnConstraints columnTwoConstrains = new ColumnConstraints(200,200, Double.MAX_VALUE);
        columnTwoConstrains.setHgrow(Priority.ALWAYS);

        gridPane.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains);

        return gridPane;
    }


    private void addUIControls(GridPane gridPane) {

        SecondaryWindow secondaryWindow = new SecondaryWindow();

        // Add Header
        Label headerLabel = new Label("G-league Manager");
        headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        gridPane.add(headerLabel, 0,0,2,1);
        GridPane.setHalignment(headerLabel, HPos.CENTER);
        GridPane.setMargin(headerLabel, new Insets(20, 0,20,0));

        // Add Name Label
        Label nameLabel = new Label("Full Name : ");
        gridPane.add(nameLabel, 0,1);

        // Add Name Text Field
        TextField nameField = new TextField();
        nameField.setPrefHeight(40);
        gridPane.add(nameField, 1,1);


        // Add Search Button
        Button searchButton = new Button("Search");
        searchButton.setPrefHeight(40);
        searchButton.setDefaultButton(true);
        searchButton.setPrefWidth(100);
        gridPane.add(searchButton, 0, 4, 2, 1);
        GridPane.setHalignment(searchButton, HPos.CENTER);
        GridPane.setMargin(searchButton, new Insets(20, 0,20,0));


        searchButton.setOnAction(new EventHandler<>() {
            @Override
            public void handle(javafx.event.ActionEvent actionEvent) {
                if (nameField.getText().isEmpty()) {
                    showAlert(gridPane.getScene().getWindow());
                } else {
                    secondaryWindow.showSecondaryWindow();
                }

            }

            private void showAlert(Window owner) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Form Error!");
                alert.setHeaderText(null);
                alert.setContentText("Please enter player name");
                alert.initOwner(owner);
                alert.show();
            }

        });

    }


}