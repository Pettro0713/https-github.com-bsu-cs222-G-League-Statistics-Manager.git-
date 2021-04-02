package edu.bsu.cs222;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
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
        private final TextArea outputHeight = new TextArea();
        private final TextArea outputWeight = new TextArea();

        public SecondaryWindow() {
            secondaryWindow = new Stage();
            secondaryWindow.setTitle("Stats Window");

            outputPoints.setEditable(false);
            outputRebounds.setEditable(false);
            outputBlocks.setEditable(false);
            outputSteals.setEditable(false);
            outputHeight.setEditable(false);
            outputWeight.setEditable(false);

            Pane Pane = createSecondaryWindow();

            addSecondaryUIControls(Pane);

            Scene secondaryScene = new Scene(Pane, 800, 500);

            secondaryWindow.setScene(secondaryScene);

        }

        public void showSecondaryWindow(){
            secondaryWindow.show();
        }


        private Pane createSecondaryWindow(){
            //TODO create scene layout
            // create Pane
            VBox root = new VBox();
            root.setSpacing(10);
            root.setPrefSize(100,100);
            root.setAlignment(Pos.TOP_LEFT);
            root.getChildren().addAll(
                    new Label("Points Per Game:"),
                    outputPoints,
                    new Label("Rebounds Per Game"),
                    outputRebounds,
                    new Label("Blocks Per Game"),
                    outputBlocks,
                    new Label("Steals Per Game"),
                    outputSteals,
                    new Label("Player Height"),
                    outputHeight,
                    new Label("Player Weight"),
                    outputWeight
                    );
            return root;
        }

        private void addSecondaryUIControls(Pane Pane){
            //TODO UI functionalities Here

        }

}
