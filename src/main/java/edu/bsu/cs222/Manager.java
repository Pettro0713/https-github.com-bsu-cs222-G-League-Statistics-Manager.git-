package edu.bsu.cs222;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

//Hi
public class Manager extends Application {
    //when actual implementation is done replace fakewikiqueryprocessor and it should wok the same.
    //private final WikipediaQueryProcessor queryProcessor = new FakeWikipediaQueryProcessor();

    private final TextField inputField = new TextField();
    //private final QueryResponseView outputArea = new QueryResponseView();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setScene(new Scene(makeGUI()));
        primaryStage.show();
    }

    private Parent makeGUI() {
        HBox inputBox = new HBox(
                new Label("Player Name or Position: "),
                inputField
        );
        Button button = new Button("Query");
        button.setOnAction(event -> {
            //try {
                //WikipediaRevisionQueryResponse response = queryProcessor.getRevisionsFor(inputField.getText());
                //outputArea.show(response);
            //}// catch (IOException e) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("IOException");
                alert.setContentText("An IOException occurred. See stack trace for details.");
                //e.printStackTrace();
                alert.show();
            //}
        });
        //return new VBox(inputBox, button, outputArea);
        return null;
    }
}