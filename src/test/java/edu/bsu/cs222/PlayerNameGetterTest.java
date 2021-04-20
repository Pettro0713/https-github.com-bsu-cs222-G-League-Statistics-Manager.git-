package edu.bsu.cs222;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class PlayerNameGetterTest {

    PlayerNameGetter input = new PlayerNameGetter();

    @Test
    public void getPlayerIDTest(){

        Assertions.assertEquals("hi",input.getplayerName());
    }
}