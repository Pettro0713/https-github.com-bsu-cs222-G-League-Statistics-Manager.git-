package edu.bsu.cs222.model;

import com.jayway.jsonpath.JsonPath;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamParser {

    private final InputStream dataStream;

    public InputStreamParser(InputStream inputStream) {
        this.dataStream = inputStream;
    }

    public Object parseForStats(String statistic) throws IOException {
        return JsonPath.read(dataStream, statistic);
    }
}