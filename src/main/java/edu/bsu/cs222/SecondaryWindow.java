package edu.bsu.cs222;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SecondaryWindow extends MainWindow {
    Stage secondaryWindow;

    private final TextArea outputPoints = new TextArea();
    private final TextArea outputRebounds = new TextArea();
    private final TextArea outputBlocks = new TextArea();
    private final TextArea outputSteals = new TextArea();
    private final TextArea outputAssists = new TextArea();
    private final TextArea outputHeight = new TextArea();
    private final TextArea outputWeight = new TextArea();

    public SecondaryWindow() {
        secondaryWindow = new Stage();
        secondaryWindow.setTitle("|Player Stats Window|");

        outputPoints.setEditable(false);
        outputRebounds.setEditable(false);
        outputBlocks.setEditable(false);
        outputSteals.setEditable(false);
        outputAssists.setEditable(false);
        outputHeight.setEditable(false);
        outputWeight.setEditable(false);

        ScrollPane Pane = createSecondaryWindow();

        addSecondaryUIControls(Pane);

        Scene secondaryScene = new Scene(Pane, 800, 500);

        secondaryWindow.setScene(secondaryScene);

    }

    public void showSecondaryWindow() {
        secondaryWindow.show();
    }


    private ScrollPane createSecondaryWindow() {
        //TODO create scene layout
        // create Pane
        ScrollPane scrollPane = new ScrollPane();
        VBox root = new VBox();
        root.setSpacing(20);
        root.setPrefSize(800, 500);
        root.setAlignment(Pos.CENTER_LEFT);
        root.getChildren().addAll(
                new Label("Points Per Game:"),
                outputPoints,
                new Label("Rebounds Per Game: "),
                outputRebounds,
                new Label("Blocks Per Game: "),
                outputBlocks,
                new Label("Steals Per Game: "),
                outputSteals,
                new Label("Assists Per Game: "),
                outputAssists,
                new Label("Player Height: "),
                outputHeight,
                new Label("Player Weight: "),
                outputWeight
        );
        scrollPane.setContent(root);
        return scrollPane;
    }

    private void addSecondaryUIControls(ScrollPane Pane) {
        //TODO UI functionalities Here

    }
/*
        public void search(String userInput){
            //TODO implement model work here that takes this string, obtains data for the player and hands off data as a string to the appropriate outputField.

            String pointsString; // = model work to get string of ppg player stat

            String reboundsString; // = model work to get string of rebounds per game player stat

            String blocksString; // = model work to get string of blocks per game player stat

            String stealsString; // = model work to get string of steals per game player stat

            String assistsString; // = model work to get string of assists per game player stat

            String heightString; // = model work to get string of player height stat

            String weightString; // = model work to get string of player weight stat

            outputPoints.setText(pointsString);
            outputRebounds.setText(reboundsString);
            outputBlocks.setText(blocksString);
            outputSteals.setText(stealsString);
            outputAssists.setText(assistsString);
            outputHeight.setText(heightString);
            outputWeight.setText(weightString);
        }

 */
}
