package com.company;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        ArrayList<Worker> myWorkers = new ArrayList<>();
        String fileName = "dane.txt";
        try {
            Stream<String> myStream = Files.lines(Paths.get(fileName), StandardCharsets.UTF_8);
            Consumer<String> consumer = s -> myWorkers.add(new Worker(s));
            myStream.forEach(consumer);
        } catch (IOException e) {
            e.printStackTrace();
        }

        int max1 =Integer.MIN_VALUE;
        int max2 =Integer.MIN_VALUE;
        int min1 =Integer.MAX_VALUE;
        int min2 =Integer.MAX_VALUE;

        for(Worker current : myWorkers) {
            //find 2 highest paid workers
            if(current.country.equals("PL")) {
                if (current.salary > max1) {
                    max2 = max1;
                    max1 = current.salary;
                } else if (current.salary > max2) {
                    max2 = current.salary;
                }
            }
            //find 2 lowest paid workers
            if(current.country.equals("PL")) {
                if (current.salary < min1) {
                    min2 = min1;
                    min1 = current.salary;
                } else if (current.salary < min2) {
                    min2 = current.salary;
                }
            }
        }
        System.out.println("Suma 2 najwięcej zarabiających Polaków: " + Integer.sum(max1,max2));
        System.out.println("Suma 2 najmniej zarabiających Polaków: " + Integer.sum(min1,min2));



        List<String> countries = new ArrayList<>();
        for(Worker current : myWorkers) {
            countries.add(current.country);
        }
        List<String> unique = new ArrayList<>();
        for (String s : countries) {
            if(!(unique.contains(s))){
                unique.add(s);
            }
        }

        for (String s: unique) {
            System.out.println(s + " - " + Collections.frequency(countries, s));
        }

    }
}
