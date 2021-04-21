package edu.bsu.cs222.model;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class InputStreamParser {

    private final InputStream dataStreamCopy;

    //Copy dataStream into dataStreamCopy to avoid making more than one request from
    // the sportsRadar API.
    public InputStreamParser(InputStream dataStream) throws IOException {
        this.dataStreamCopy = JsonPath.read(dataStream, "$[*]");
    }

    public String parseForStats() throws IOException {
        String name = JsonPath.read(dataStreamCopy, "$..Name[*]");
        return name;
    }
}