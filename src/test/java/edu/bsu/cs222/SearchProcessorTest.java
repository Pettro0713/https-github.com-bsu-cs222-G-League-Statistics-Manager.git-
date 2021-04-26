package edu.bsu.cs222;

import edu.bsu.cs222.view.SearchProcessor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class SearchProcessorTest {
    SearchProcessor processor = new SearchProcessor();

    @Test
    public void testIsPlayerFound_true() throws IOException {
        boolean result = processor.searchPlayerName("Jaylen Hoard");
        Assertions.assertTrue(result);
    }

    @Test
    public void testIsPlayerFound_false() throws IOException {
        boolean result = processor.searchPlayerName("John Smith");
        Assertions.assertFalse(result);
    }
}


