package edu.bsu.cs222.view;

import edu.bsu.cs222.model.InputStreamParser;
import edu.bsu.cs222.model.PlayerIDGetter;
import edu.bsu.cs222.model.SportsRadarUrl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class SearchProcessor {

    public InputStream firstClone;
    public InputStream secondClone;
    public InputStream thirdClone;
    public InputStream fourthClone;
    public InputStream fifthClone;
    public InputStream sixthClone;
    public InputStream seventhClone;
    public Object PPG;
    public Object RPG;
    public Object BPG;
    public Object APG;
    public Object SPG;
    public Object height;
    public Object weight;

    //Console Application
    public static void main(String[] args) throws IOException {
        SearchProcessor processor = new SearchProcessor();
        System.out.println("Enter Player Name");
        Scanner console = new Scanner(System.in);
        String input = console.nextLine();
        PlayerIDGetter idGetter = new PlayerIDGetter(input);
        String ID = idGetter.getID();
        System.out.println(ID);
        SportsRadarUrl urlConnection = new SportsRadarUrl(ID);
        InputStreamParser parser =  new InputStreamParser(urlConnection.makeConnection());
        Object PPG = parser.parseForStats("$.seasons[0].teams[0].average.points");
        System.out.println(PPG);
    }

    public boolean searchPlayerNames(String playerName) {
        try {
            PlayerIDGetter idGetter = new PlayerIDGetter(playerName);
            String ID = idGetter.getID();
            SportsRadarUrl urlConnection = new SportsRadarUrl(ID);
            cloneInputStream(urlConnection.makeConnection());
            getStatistics();
            return true;
        }
        catch(IOException e){
            System.out.println("Player not found!");
            return false;
        }
    }

    public void cloneInputStream(InputStream inputStream) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        inputStream.transferTo(baos);
        firstClone = new ByteArrayInputStream(baos.toByteArray());
        secondClone = new ByteArrayInputStream(baos.toByteArray());
        thirdClone = new ByteArrayInputStream(baos.toByteArray());
        fourthClone = new ByteArrayInputStream(baos.toByteArray());
        fifthClone = new ByteArrayInputStream(baos.toByteArray());
        sixthClone = new ByteArrayInputStream(baos.toByteArray());
        seventhClone = new ByteArrayInputStream(baos.toByteArray());
        inputStream.close();
    }

    public void getStatistics() throws IOException {
        InputStreamParser PPGParser =  new InputStreamParser(firstClone);
        InputStreamParser RPGParser =  new InputStreamParser(secondClone);
        InputStreamParser BPGParser =  new InputStreamParser(thirdClone);
        InputStreamParser APGParser =  new InputStreamParser(fourthClone);
        InputStreamParser SPGParser =  new InputStreamParser(fifthClone);
        InputStreamParser heightParser =  new InputStreamParser(sixthClone);
        InputStreamParser weightParser =  new InputStreamParser(seventhClone);
        PPG = PPGParser.parseForStats("$.seasons[0].teams[0].average");
        RPG = RPGParser.parseForStats("$.seasons[0].teams[0].average.rebounds");
        BPG =  BPGParser.parseForStats("$.seasons[0].teams[0].average.blocks");
        APG = APGParser.parseForStats("$.seasons[0].teams[0].average.assists");
        SPG = SPGParser.parseForStats("$.seasons[0].teams[0].average.steals");
        height =  heightParser.parseForStats("$..height");
        weight =  weightParser.parseForStats("$..weight");
    }
}

