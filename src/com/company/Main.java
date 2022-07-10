package com.company;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static final GsonBuilder GSON_BUILDER = new GsonBuilder();
    private static final Gson GSON = GSON_BUILDER.setPrettyPrinting().create();
    public static final Path PATH1 = Paths.get("./json.json");
    private static final Path WRITE_PATH = Paths.get("json.drivers");
    public static void main(String[] args) {

        Truck[] trucks = {
                new Truck(1, "Renault Magnum", " ", State.BASE),
                new Truck(2, "Volvo", " ", State.BASE),
                new Truck(3, "DAF XT", " ", State.BASE),
        };
        List<Truck> list1 = new ArrayList<>(List.of(trucks));

        String json = GSON.toJson(trucks);
        Truck.write(json);
        viewTruck(list1);

        Driver[] drivers = {
                new Driver(1, "Petr"),
                new Driver(2, "Askar"),
                new Driver(3, "Uson"),
        };
        List<Driver> list2 = new ArrayList<>(List.of(drivers));
        String json2 = GSON.toJson(drivers);
        Driver.write(json2);
        viewDriver(list2);


    }
      public static void viewTruck(List<Truck> list1){
        System.out.println("~~~~~~~~~~~~~~~~~~Trucks~~~~~~~~~~~~~~~~~");
        System.out.println("| id |      Bus      |    Driver   |State |");
        System.out.println("|~~~ |~~~~~~~~~~~~~~~|~~~~~~~~~~~~~|~~~~~~|");
        for(Truck autoPark : list1){
            System.out.printf("|%-3s ",autoPark.getId());
            System.out.printf("|%-15s|", autoPark.getName());
            System.out.printf("%-13s|", autoPark.getDriver() + " ");
            System.out.printf("%-6s|",autoPark.getState());
            System.out.println();
        }
    }
    public static void viewDriver(List<Driver> list2){
        System.out.println("~~~~~~~~~~Drivers~~~~~~~~~~~");
        System.out.println("| Id of driver |  Driver |");
        System.out.println("|~~~~~~~~~~~~~~|~~~~~~~~~|");
        for (Driver driverInfo : list2) {
            System.out.printf("|%-14    s", driverInfo.getId());
            System.out.printf("|%-9s", driverInfo.getName());
            System.out.println();
        }
    }
}