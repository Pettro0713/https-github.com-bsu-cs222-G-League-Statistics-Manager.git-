package edu.bsu.cs222.model;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class SportsRadarUrl {

    private final String playerID;

    public SportsRadarUrl(String playerID) {
        this.playerID = playerID;
    }

    public InputStream makeConnection() throws IOException {
        URL url = new URL("api.sportradar.us");
        URLConnection connection = url.openConnection();
        connection.setRequestProperty("GET", "/nbdl/trial/v7/en/players/"+ playerID +"/profile.json?api_key=f5gxhwerah7sn3sguu5ae5ea");
        if(connection.getContent() == null) {
            return InputStream.nullInputStream();
        }
        else{return connection.getInputStream();}
    }


}