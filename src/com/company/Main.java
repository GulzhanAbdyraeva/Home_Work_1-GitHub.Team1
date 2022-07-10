package com.company;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static final GsonBuilder GSON_BUILDER = new GsonBuilder();
    private static final Gson GSON = GSON_BUILDER.setPrettyPrinting().create();
    public static final Path PATH1 = Paths.get("./json.json");
    public static void main(String[] args) {
        Driver driver = new Driver();
        Truck[] trucks = {
         new Truck(1,"Renault Magnum",driver,State.BASE),
         new Truck(2,"Volvo",driver,State.BASE),
         new  Truck(3,"DAF XT",driver,State.BASE),
        };
        String json = GSON.toJson(trucks);
        System.out.println(json);
        Truck.write(json);

    }

}