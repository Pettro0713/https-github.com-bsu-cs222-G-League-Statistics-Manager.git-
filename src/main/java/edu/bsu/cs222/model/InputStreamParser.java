package edu.bsu.cs222.model;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.lang.constant.Constable;
import java.util.LinkedHashMap;

public class InputStreamParser {

    private final InputStream dataStream;

    public InputStreamParser(InputStream inputStream) {
        this.dataStream = inputStream;
    }

    public Object parseForStats(String statistic) throws IOException {
        return JsonPath.read(dataStream, statistic);
    }
}