package edu.bsu.cs222;

import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

 public class SecondaryWindow extends MainWindow {

        Stage secondaryWindow;

        public SecondaryWindow() {
            secondaryWindow = new Stage();
            secondaryWindow.setTitle("New Window");

            GridPane gridPane = createSecondaryWindow();

            addSecondaryUIControls(gridPane);

            Scene secondaryScene = new Scene(gridPane, 800, 500);

            secondaryWindow.setScene(secondaryScene);

        }

        public void showSecondaryWindow(){
            secondaryWindow.show();
        }


        private GridPane createSecondaryWindow(){
            //TODO create scene layout

            // create gridPane

            GridPane gridPane = new GridPane();

            return gridPane;
        }

        private void addSecondaryUIControls(GridPane gridPane){
            //TODO UI functionalities Here

        }

}
