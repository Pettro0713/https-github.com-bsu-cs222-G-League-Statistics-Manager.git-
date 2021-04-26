package edu.bsu.cs222.model;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.io.File;
import java.io.IOException;

public class PlayerIDGetter {

    private String name;
    File file = new File("C:\\Users\\nates\\IdeaProjects\\G-League-Statistics-Manager\\src\\main\\resources\\newPlayerID.json");

    public PlayerIDGetter(String name){
        this.name = name;
    }

    public JSONArray getID() throws IOException {
        return JsonPath.read(file,"$.."+name+".id");
    }
}