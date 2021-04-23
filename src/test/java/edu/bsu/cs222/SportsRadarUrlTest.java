package edu.bsu.cs222;

import edu.bsu.cs222.model.SportsRadarUrl;
import org.junit.Test;

import java.io.IOException;

public class SportsRadarUrlTest {

    SportsRadarUrl connection = new SportsRadarUrl("25556881-5c14-453e-b02d-bfb28073fb8d");

    @Test
    public void connectTest() throws IOException {
        connection.makeConnection();
    }
}