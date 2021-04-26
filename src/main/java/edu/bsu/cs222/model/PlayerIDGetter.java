package edu.bsu.cs222.model;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;
import java.io.File;
import java.io.IOException;

public class PlayerIDGetter {

    private final String name;
    File file = new File("C:\\Users\\nates\\IdeaProjects\\G-League-Statistics-Manager\\src\\main\\resources\\newPlayerID.json");

    public PlayerIDGetter(String name){
        this.name = "['"+name+"']";
    }

    public String getID() throws IOException {
        JSONArray id = JsonPath.read(file,"$.."+name+".id");
        return id.toJSONString();
    }
}