package com.company;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Main {
    public static final GsonBuilder GSON_BUILDER = new GsonBuilder();
    private static final Gson GSON = GSON_BUILDER.setPrettyPrinting().create();
    public static final Path PATH1 = Paths.get("./json.json");
    private static final Path WRITE_PATH = Paths.get("json.drivers");
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
        Driver[] drivers ={
                new Driver(1,"Petr"),
                new Driver(2,"Askar"),
                new Driver(3,"Uson"),
        };
        String json2 = GSON.toJson(drivers);
        System.out.println(json2);

    }

    public static void write(String obj){
        Path write = Paths.get(String.valueOf(WRITE_PATH));
        try{
            Files.writeString(write,obj, StandardOpenOption.CREATE,StandardOpenOption.WRITE);
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

}