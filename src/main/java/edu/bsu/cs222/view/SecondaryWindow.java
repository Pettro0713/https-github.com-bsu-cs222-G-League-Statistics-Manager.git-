package edu.bsu.cs222.view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SecondaryWindow{
    Stage secondaryWindow;

    private final TextArea outputPoints = new ReadOnlyTextArea();
    private final TextArea outputRebounds = new ReadOnlyTextArea();
    private final TextArea outputBlocks = new ReadOnlyTextArea();
    private final TextArea outputSteals = new ReadOnlyTextArea();
    private final TextArea outputAssists = new ReadOnlyTextArea();
    private final TextArea outputHeight = new ReadOnlyTextArea();
    private final TextArea outputWeight = new ReadOnlyTextArea();

    public SecondaryWindow(SearchProcessor processor) {
        secondaryWindow = new Stage();
        secondaryWindow.setTitle("|Player Stats Window|");

        outputPoints.setText(String.valueOf(processor.PPG));
        outputRebounds.setText(String.valueOf(processor.RPG));
        outputBlocks.setText(String.valueOf(processor.BPG));
        outputSteals.setText(String.valueOf(processor.SPG));
        outputAssists.setText(String.valueOf(processor.APG));
        outputHeight.setText(processor.height +" in");
        outputWeight.setText(processor.weight +" lbs");

        ScrollPane Pane = createSecondaryWindow();
        Scene secondaryScene = new Scene(Pane, 800, 500);
        secondaryWindow.setScene(secondaryScene);
    }

    public void showSecondaryWindow() {
        secondaryWindow.show();
    }


    private ScrollPane createSecondaryWindow() {
        ScrollPane scrollPane = new ScrollPane();
        VBox root = new VBox();
        root.setSpacing(20);
        root.setPrefSize(800, 500);
        root.setAlignment(Pos.CENTER_LEFT);
        root.getChildren().addAll(
                new Label("Points Per Game: "),
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
}
