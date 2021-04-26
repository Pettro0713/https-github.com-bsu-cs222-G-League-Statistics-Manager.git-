package edu.bsu.cs222.view;

import edu.bsu.cs222.model.InputStreamParser;
import edu.bsu.cs222.model.PlayerIDGetter;
import edu.bsu.cs222.model.SportsRadarUrl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class SearchProcessor {

    private InputStream firstClone;
    private InputStream secondClone;
    private InputStream thirdClone;
    private InputStream fourthClone;
    private InputStream fifthClone;
    private InputStream sixthClone;
    private InputStream seventhClone;
    public Object PPG;
    public Object RPG;
    public Object BPG;
    public Object APG;
    public Object SPG;
    public Object height;
    public Object weight;

    public boolean searchPlayerName(String playerName) throws IOException {
        PlayerIDGetter idGetter = new PlayerIDGetter(playerName);
        String ID = idGetter.getID();
        if (ID == null){return false;}
        SportsRadarUrl urlConnection = new SportsRadarUrl(ID);
        cloneInputStream(urlConnection.makeConnection());
        getStatistics();
        return true;
    }

    //Clone input stream so multiple pieces of data can be retrieved with a single API query
    private void cloneInputStream(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        inputStream.transferTo(byteArrayOutputStream);
        firstClone = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        secondClone = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        thirdClone = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        fourthClone = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        fifthClone = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        sixthClone = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        seventhClone = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        inputStream.close();
    }

    private void getStatistics() throws IOException {
        InputStreamParser PPGParser =  new InputStreamParser(firstClone);
        InputStreamParser RPGParser =  new InputStreamParser(secondClone);
        InputStreamParser BPGParser =  new InputStreamParser(thirdClone);
        InputStreamParser APGParser =  new InputStreamParser(fourthClone);
        InputStreamParser SPGParser =  new InputStreamParser(fifthClone);
        InputStreamParser heightParser =  new InputStreamParser(sixthClone);
        InputStreamParser weightParser =  new InputStreamParser(seventhClone);
        PPG = PPGParser.parseForStats("$.seasons[0].teams[0].average.points");
        RPG = RPGParser.parseForStats("$.seasons[0].teams[0].average.rebounds");
        BPG =  BPGParser.parseForStats("$.seasons[0].teams[0].average.blocks");
        APG = APGParser.parseForStats("$.seasons[0].teams[0].average.assists");
        SPG = SPGParser.parseForStats("$.seasons[0].teams[0].average.steals");
        height =  heightParser.parseForStats("$.height");
        weight =  weightParser.parseForStats("$.weight");
    }
}

