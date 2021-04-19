package edu.bsu.cs222;

import java.util.ArrayList;
import java.util.Scanner;

public class FakeSportRadarProcessor {
    ArrayList<String> playerNamesList = new ArrayList<>();
    String position = "Point Guard";
    String PPG = "28.4";
    String RPG = "4.5";
    String BPG = "2.4";
    String APG = "9.6";
    String SPG = "2.4";
    String height = "6'3";
    String weight = "215 Pounds";

    //Console Application
    public static void main(String[] args) {
        FakeSportRadarProcessor processor = new FakeSportRadarProcessor();
        System.out.println("Enter Player Name");
        Scanner console = new Scanner(System.in);
        String input = console.nextLine();
        processor.searchPlayerNames(input);
    }

    public void addNamesToList() {
        playerNamesList.add("Jaylen Hoard");
        playerNamesList.add("Omer Yurtseven");
        playerNamesList.add("Zavier Simpson");
        playerNamesList.add("Melvin Frazier");
        playerNamesList.add("Phil Booth");
    }

    public boolean searchPlayerNames(String playerName) {
        addNamesToList();
        if(playerNamesList.contains(playerName)) {
            printStats(playerName);
            return true;
        }
        else{
            System.out.println("Player not found!");
            return false;
        }
    }

    public void printStats(String playerName){
        System.out.println("Player: " + playerName + " has been found");
        System.out.println("============Player Statistics============\n " +
                "\nPosition:\n " + position + "\n"
                + "Points Per Game:\n " + PPG + "\n"
                + "Rebounds Per Game:\n " + RPG + "\n"
                + "Assists Per Game:\n " + APG + "\n"
                + "Steals Per Game:\n " + SPG + "\n"
        );
    }
}

