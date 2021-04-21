package edu.bsu.cs222;

import edu.bsu.cs222.view.FakeSportRadarProcessor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FakeSportRadarProcessorHi {
    FakeSportRadarProcessor processor = new FakeSportRadarProcessor();

    @Test
    public void testIsPlayerFound_true(){
        boolean result = processor.searchPlayerNames("Jaylen Hoard");
        Assertions.assertTrue(result);
    }

    @Test
    public void testIsPlayerFound_false(){
        boolean result = processor.searchPlayerNames("John Smith");
        Assertions.assertFalse(result);
    }


    }


