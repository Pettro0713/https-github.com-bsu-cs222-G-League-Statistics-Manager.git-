package edu.bsu.cs222;

import edu.bsu.cs222.model.InputStreamParser;
import edu.bsu.cs222.model.SportsRadarUrl;
import net.minidev.json.JSONArray;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamParserTest {

    private SportsRadarUrl connection;
    private InputStreamParser parser;

    @Before
    public void setUp() throws IOException {
        connection = new SportsRadarUrl("25556881-5c14-453e-b02d-bfb28073fb8d");
        parser = new InputStreamParser(connection.makeConnection());
    }

    @Test
    public void parsingTest() throws IOException {
        JSONArray name = parser.parseForStats();
        boolean yes = name.contains("Jaylen");
        boolean no = name.contains("sus");
        Assertions.assertTrue(yes);
        Assertions.assertFalse(no);
    }
}
