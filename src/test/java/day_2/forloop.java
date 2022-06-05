package day_2;

import java.util.ArrayList;

public class forloop {
    public static void main(String[] args) {
        //create an Arraylist for cities and loop/iterating through all the values using for loop
        ArrayList<String> cities = new ArrayList<>();
        cities.add("brooklyn");
        cities.add("Queens");
        cities.add("Bronx");
        cities.add("Staten Island");
        cities.add("Long Island");
        for (int i =0; i < cities.size(); i++) {
            System.out.println("i is now " + i);
            System.out.println("my city is " + cities.get(i));
        } // end of "for loop"
    }// end of main
} //end of java
