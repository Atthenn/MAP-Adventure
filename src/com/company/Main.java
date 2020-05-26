package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static Map<Integer, Location> locations = new HashMap<Integer, Location>();

    public static void main(String[] args) {
        // write your code here

        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> tempExit = new HashMap<String, Integer>();

        locations.put(0, new Location(0, "you are at your home", tempExit));

        tempExit = new HashMap<String, Integer>();
        tempExit.put("W", 2);
        tempExit.put("N", 5);
        tempExit.put("E", 3);
        tempExit.put("S", 4);
        locations.put(1, new Location(1, "locaton1",tempExit));

        //    tempExit.put("Q",0);
        tempExit = new HashMap<String, Integer>();
        tempExit.put("N", 5);
        locations.put(2, new Location(2, "locaton2",tempExit));

        //     tempExit.put("Q",0);
        tempExit = new HashMap<String, Integer>();
        tempExit.put("W", 1);
        locations.put(3, new Location(3, "locaton3",tempExit));

        //    tempExit.put("Q",0);
        tempExit = new HashMap<String, Integer>();
        tempExit.put("N", 1);
        tempExit.put("W", 2);
        locations.put(4, new Location(4, "locaton4",tempExit));

        //     tempExit.put("Q",0);
        tempExit = new HashMap<String, Integer>();
        tempExit.put("S", 1);
        tempExit.put("W", 2);
        locations.put(5, new Location(5, "locaton5",tempExit));

        //     tempExit.put("Q",0);

        Map<String, String> vocab = new HashMap<String, String>();
        vocab.put("EAST", "E");
        vocab.put("WEST", "W");
        vocab.put("NORTH", "N");
        vocab.put("SOUTH", "S");
        vocab.put("QUIT", "Q");


        int loc = 1;
        while (true) {
            System.out.println(locations.get(loc).getDescription());
            if (loc == 0) {
                break;
            }
            //get a copy of exits
            Map<String, Integer> exits = locations.get(loc).getExists();
            System.out.print("Available exits are ");
            for (String exit : exits.keySet()) {
                System.out.print(exit + ",");
            }
            System.out.println();


            String direction = scanner.nextLine().toUpperCase();
            if (direction.length() > 1) {
                String[] splits = direction.split(" ");
                for (String split : splits
                ) {
                    if (vocab.containsKey(split)) {
                        direction = vocab.get(split);
                        break;
                    }
                }
//                for (String split : splits) {
//                    switch (split) {
//                        case "EAST":
//                            direction = "E";
//                            break;
//                        case "WEST":
//                            direction = "W";
//                            break;
//                        case "NORTH":
//                            direction = "N";
//                            break;
//                        case "SOUTH":
//                            direction = "S";
//                            break;
//                    }
//                }
            }
            if (exits.containsKey(direction)) {
                loc = exits.get(direction);
            } else {
                System.out.println("you can not go to that direction");
            }
        }

    }
}
