package edu.bsu.cs222;

import edu.bsu.cs222.model.InputStreamParser;
import edu.bsu.cs222.model.SportsRadarUrl;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import java.io.IOException;

public class InputStreamParserTest {

    private InputStreamParser parser;

    @Before
    public void setUp() throws IOException {
        SportsRadarUrl connection = new SportsRadarUrl("5a436b8f-bc86-45ae-8309-6802eb9412dd");
        parser = new InputStreamParser(connection.makeConnection());
    }

    @Test
    public void parseTest() throws IOException {
        Object firstName = parser.parseForStats("$[*]");
        Assertions.assertNotNull(firstName);
    }

    @Test
    public void parseForMultipleTest() throws IOException {
        Object ppg = parser.parseForStats("$.seasons[0].teams[0].average.points");
        boolean playerPoints = ppg.equals(6.9);
        Assertions.assertTrue(playerPoints);
    }
}
