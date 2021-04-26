package edu.bsu.cs222;

import edu.bsu.cs222.model.PlayerIDGetter;
import net.minidev.json.JSONArray;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;

public class PlayerIDGetterTest {

    @Test
    public void testPlayerID() throws IOException {
        PlayerIDGetter idGetter = new PlayerIDGetter("['Jaylen Hoard']");
        JSONArray ID = idGetter.getID();
        Assertions.assertEquals("25556881-5c14-453e-b02d-bfb28073fb8d",ID);
    }
}
