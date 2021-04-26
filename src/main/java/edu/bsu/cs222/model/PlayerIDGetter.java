package edu.bsu.cs222.model;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class PlayerIDGetter {

    private final String name;

    ClassLoader classLoader = this.getClass().getClassLoader();
    File file = new File(Objects.requireNonNull(classLoader.getResource("newPlayerID.json")).getFile());

    public PlayerIDGetter(String name){
        this.name = "['"+name+"']";
    }

    public String getID() throws IOException {
        JSONArray id = JsonPath.read(file,"$.."+name+".id");
        return id.toJSONString();
    }
}