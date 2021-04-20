package edu.bsu.cs222.view;

import edu.bsu.cs222.view.PlayerStatisticsStorage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SecondaryWindow {
    PlayerStatisticsStorage playerStatisticsStorage = new PlayerStatisticsStorage();

    Stage secondaryWindow;
    private final TextArea outputPoints = new ReadOnlyTextArea();
    private final TextArea outputRebounds = new ReadOnlyTextArea();
    private final TextArea outputBlocks = new TextArea();
    private final TextArea outputSteals = new ReadOnlyTextArea();
    private final TextArea outputAssists = new TextArea();
    private final TextArea outputHeight = new TextArea();
    private final TextArea outputWeight = new TextArea();

    //Constructor
    //DRY
    public SecondaryWindow() {
        secondaryWindow = new Stage();
        secondaryWindow.setTitle("|Player Stats Window|");
        //necessary complexity
        outputPoints.setText(playerStatisticsStorage.pointsString);
        outputRebounds.setText(playerStatisticsStorage.reboundsString);
        outputBlocks.setText(playerStatisticsStorage.blocksString);
        outputSteals.setText(playerStatisticsStorage.stealsString);
        outputAssists.setText(playerStatisticsStorage.assistsString);
        outputHeight.setText(playerStatisticsStorage.heightString);
        outputWeight.setText(playerStatisticsStorage.weightString);

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
