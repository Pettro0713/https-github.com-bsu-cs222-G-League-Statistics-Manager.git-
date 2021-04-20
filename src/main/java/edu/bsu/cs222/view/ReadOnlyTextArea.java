package edu.bsu.cs222.view;

import javafx.scene.control.TextArea;

public class ReadOnlyTextArea extends TextArea {

    public ReadOnlyTextArea(){
        setEditable(false);
    }
}
