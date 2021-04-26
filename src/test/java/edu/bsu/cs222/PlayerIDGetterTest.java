package edu.bsu.cs222;

import edu.bsu.cs222.model.PlayerIDGetter;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;

public class PlayerIDGetterTest {

    @Test
    public void testPlayerID() throws IOException {
        PlayerIDGetter idGetter = new PlayerIDGetter("Jaylen Hoard");
        String ID = idGetter.getID();
        Assertions.assertEquals("[\"25556881-5c14-453e-b02d-bfb28073fb8d\"]",ID);
    }
}
