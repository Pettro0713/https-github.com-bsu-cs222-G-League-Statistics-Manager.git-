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
        JSONArray ID = JsonPath.read(file,"$.."+name+".id");
        if (ID.isEmpty()){return null;}
        StringBuilder build = new StringBuilder(ID.toJSONString());
        build.delete(38,40);
        build.delete(0,2);
        return build.toString();
    }
}