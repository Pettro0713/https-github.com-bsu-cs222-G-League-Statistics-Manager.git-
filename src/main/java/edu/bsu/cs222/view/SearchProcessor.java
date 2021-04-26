package edu.bsu.cs222.view;

import edu.bsu.cs222.model.InputStreamParser;
import edu.bsu.cs222.model.PlayerIDGetter;
import edu.bsu.cs222.model.SportsRadarUrl;
import java.io.IOException;
import java.util.Scanner;

public class SearchProcessor {

    public String position;
    public String PPG;
    public String RPG;
    public String BPG;
    public String APG;
    public String SPG;
    public String height;
    public String weight;

    //Console Application
    public static void main(String[] args) {
        SearchProcessor processor = new SearchProcessor();
        System.out.println("Enter Player Name");
        Scanner console = new Scanner(System.in);
        String input = console.nextLine();
        processor.searchPlayerNames(input);
    }

    public boolean searchPlayerNames(String playerName) {
        try {
            PlayerIDGetter idGetter = new PlayerIDGetter(playerName);
            String ID = idGetter.getID();
            SportsRadarUrl urlConnection = new SportsRadarUrl(ID);
            InputStreamParser parser =  new InputStreamParser(urlConnection.makeConnection());
            PPG = (String) parser.parseForStats("$.seasons[0].teams[0].average.points");
            System.out.println(PPG);
            return true;
        }
        catch(IOException e){
            System.out.println("Player not found!");
            return false;
        }
    }
}

