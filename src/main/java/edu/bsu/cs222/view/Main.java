package edu.bsu.cs222.view;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class Main extends Application {

    private final SearchProcessor processor = new SearchProcessor();
    private final GridPane gridPane = new GridPane();
    private final TextField nameField = new TextField();
    private final Button searchButton = new Button("Search");
    private final Image icon = new Image("https://1000logos.net/wp-content/uploads/2018/09/Nba-Gatorade-League-logo.jpg");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("|G-League Manager|");
        primaryStage.getIcons().add(icon);
        createMainWindow();
        addUIControls();
        Scene mainScene = new Scene(gridPane, 800, 500);
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }

    private void createMainWindow()  {
        setGridPaneSize();
        addColumnConstraints();
        addHeader();
        addNameLabel();
    }

    private void setGridPaneSize(){
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding(new Insets(40, 40, 40, 40));
        gridPane.setHgap(10);
        gridPane.setVgap(10);
    }

    private void addColumnConstraints(){
        ColumnConstraints columnOneConstraints = new ColumnConstraints(100, 100, Double.MAX_VALUE);
        columnOneConstraints.setHalignment(HPos.RIGHT);
        ColumnConstraints columnTwoConstrains = new ColumnConstraints(200,200, Double.MAX_VALUE);
        columnTwoConstrains.setHgrow(Priority.ALWAYS);
        gridPane.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains);
    }

    private void addUIControls() {
        addNameField();
        addSearchButton();
        searchButton.setOnAction(new EventHandler<>() {
            @Override
            public void handle(javafx.event.ActionEvent actionEvent) {
                if (nameField.getText().isEmpty()) {
                    nameFieldIsEmpty(gridPane.getScene().getWindow());
                } else {
                    try {
                        if (processor.searchPlayerName(nameField.getText())) {
                            StatisticsWindow statisticsWindow = new StatisticsWindow(processor);
                            statisticsWindow.showSecondaryWindow();

                        } else {
                            playerNotFound(gridPane.getScene().getWindow());
                        }
                    } catch (IOException e) {
                        networkConnectionFailure(gridPane.getScene().getWindow());
                    }
                }
            }

            private void networkConnectionFailure(Window owner){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Network Failure");
                alert.setHeaderText(null);
                alert.setContentText("Could not connect to the internet. Please check connection and try again.");
                alert.initOwner(owner);
                alert.show();
            }

            private void nameFieldIsEmpty(Window owner) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Form Error!");
                alert.setHeaderText(null);
                alert.setContentText("Please enter player name");
                alert.initOwner(owner);
                alert.show();
            }

            private void playerNotFound(Window owner) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Player Not Found");
                alert.setHeaderText(null);
                alert.setContentText("The player entered does not exist.\nPlease enter another player name.");
                alert.initOwner(owner);
                alert.show();
            }
        });
    }

    private void addSearchButton(){
        searchButton.setPrefHeight(40);
        searchButton.setDefaultButton(true);
        searchButton.setPrefWidth(100);
        gridPane.add(searchButton, 0, 4, 2, 1);
        GridPane.setHalignment(searchButton, HPos.CENTER);
        GridPane.setMargin(searchButton, new Insets(20, 0,20,0));
    }

    private void addNameField(){
        nameField.setPrefHeight(40);
        gridPane.add(nameField, 1,1);
    }

    private void addNameLabel() {
        Label nameLabel = new Label("Player Full Name : ");
        gridPane.add(nameLabel, 0,1);
    }

    private void addHeader() {
        Label headerLabel = new Label("G-league Manager");
        headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        gridPane.add(headerLabel, 0,0,2,1);
        GridPane.setHalignment(headerLabel, HPos.CENTER);
        GridPane.setMargin(headerLabel, new Insets(20, 0,20,0));
    }


}