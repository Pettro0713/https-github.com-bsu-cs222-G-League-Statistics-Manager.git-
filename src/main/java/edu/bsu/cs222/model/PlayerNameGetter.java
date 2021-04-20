package edu.bsu.cs222.model;
import java.io.File;
import java.util.Scanner;

public class PlayerNameGetter {

    public String getplayerName(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Player Name: ");
        String playerName = scanner.nextLine();
        if (playerName.equals(" ")) {
            System.err.println("Player name required");
            System.exit(1);
        }
        return playerName;

    }

}