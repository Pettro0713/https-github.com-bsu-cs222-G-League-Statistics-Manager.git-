package edu.bsu.cs222;

import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

 public class SecondaryWindow extends MainWindow {

        Stage secondaryWindow;

        public SecondaryWindow() {
            secondaryWindow = new Stage();
            secondaryWindow.setTitle("New Window");
        }

        public void showSecondaryWindow(){
            secondaryWindow.show();
        }


        private GridPane createSecondaryWindow(){
            // create gridPane
            return null;
        }

        private void addUIControls(){
            //Add UI elements here
        }

}
