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
//      public static void pattern(List<AutoPark> list1, List<DriverInfo> list2){
//        String choice;
//        int id;
//        while(true){
//            try {
//                System.out.println(ANSI_PURPLE + "Choose one of the TRUCK: " + ANSI_RESET);
//                id = scanner.nextInt();
//                id--;
//                System.out.println(ANSI_YELLOW + "----------------TRUCK-INF-----------------" + ANSI_RESET);
//                System.out.println("N                :" + list1.get(id).getId());
//                System.out.println("BUS              :" + list1.get(id).getName());
//                System.out.println("Driver           :" + list1.get(id).getDriver());
//                System.out.println("State            :" + list1.get(id).getState());
//                System.out.println(ANSI_PURPLE + "Press 1 to change or assign new DRIVER" + ANSI_RESET);
//                System.out.println(ANSI_PURPLE + "Press 2 to start DRIVING" + ANSI_RESET);
//                System.out.println(ANSI_PURPLE + "Press 3 to start REPAIRING" + ANSI_RESET);
//                System.out.println(ANSI_PURPLE + "Press 4 if you wish to stop program" + ANSI_RESET);
//                scanner.nextLine();
//                choice = scanner.nextLine();
//                if(choice.equals("4")){
//                    System.exit(0);
//                }
//                ServiceImpl actions = new ServiceImpl(list1, list2, id);
//                switch (choice) {
//                    case "1" -> actions.changeDriver(list1, list2, id);
//                    case "2" -> actions.startDriving(list1, list2, id);
//                    case "3" -> actions.startRepair(list1, list2, id);
//                }
//                list1 = actions.getList1();
//                list2 = actions.getList2();
//                displayDrivers(list2);
//                displayTrucks(list1);
//            }
//            catch(IndexOutOfBoundsException e){
//                System.out.println(ANSI_RED+"Вы обратились к несуществуещему грузовику!\n"+
//                        "Общее количество грузовиков: "+list1.size());
//            }
//        }
}