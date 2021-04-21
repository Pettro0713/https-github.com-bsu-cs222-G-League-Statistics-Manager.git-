package edu.bsu.cs222;

import edu.bsu.cs222.model.PlayerNameGetter;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class PlayerNameGetterTest {

    @Test
    public void getPlayerIDTest(){
        PlayerNameGetter nameGetter = new PlayerNameGetter();
        Assertions.assertEquals("hi",nameGetter.getPlayerName());
    }
}