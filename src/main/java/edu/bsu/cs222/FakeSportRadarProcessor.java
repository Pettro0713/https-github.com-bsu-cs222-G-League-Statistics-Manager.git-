package edu.bsu.cs222;

import java.util.ArrayList;

public class FakeSportRadarProcessor {
    ArrayList<String> playerNames = new ArrayList<>();

    /*
    public static void main(String[] args) {

        FakeSportRadarProcessor processor = new FakeSportRadarProcessor();

        System.out.println("Enter Player Name");
        Scanner console = new Scanner(System.in);

        String input = console.nextLine();
        processor.searchPlayerNames(input);
    }

     */

    public void playerNamesList() {

        playerNames.add("Jaylen Hoard");
        playerNames.add("Omer Yurtseven");
        playerNames.add("Zavier Simpson");
        playerNames.add("Melvin Frazier");
        playerNames.add("Phil Booth");

    }

    public boolean searchPlayerNames(String playerName) {
        boolean searchResult;
        playerNamesList();

        if (playerNames.contains(playerName)) {

            System.out.println("Player: " + playerName + " has been found");
            searchResult = true;
        } else {

            System.out.println("Player not found!!!");
            searchResult = false;
        }

        return searchResult;
    }
}

