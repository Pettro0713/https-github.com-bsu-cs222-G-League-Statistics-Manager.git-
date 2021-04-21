package edu.bsu.cs222;

import edu.bsu.cs222.model.InputStreamParser;
import edu.bsu.cs222.model.SportsRadarUrl;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;

public class InputStreamParserTest {

    SportsRadarUrl connection = new SportsRadarUrl("25556881-5c14-453e-b02d-bfb28073fb8d");
    InputStreamParser parser = new InputStreamParser(connection.makeConnection());

    public InputStreamParserTest() throws IOException {
    }

    @Test
    public void parsingTest() throws IOException {
        Assertions.assertEquals("Jaylen Hoard",parser.parseForStats());
    }
}
