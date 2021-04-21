package edu.bsu.cs222.model;

import java.util.Scanner;

public class PlayerNameGetter {

    public String getPlayerName() {
        System.out.println("Enter Player Name:");
        Scanner scanner = new Scanner(System.in);
        String playerName = scanner.next();
        if (playerName.equals(" ")) {
            System.err.println("Player name required");
            System.exit(1);
        }
        return playerName;
    }
}