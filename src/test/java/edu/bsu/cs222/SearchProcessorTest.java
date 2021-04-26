package edu.bsu.cs222;

import edu.bsu.cs222.view.SearchProcessor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SearchProcessorTest {
    SearchProcessor processor = new SearchProcessor();

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


