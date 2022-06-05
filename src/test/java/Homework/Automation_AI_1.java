package Homework;

import java.util.ArrayList;

public class Automation_AI_1 {
    public static void main(String[] args) {
        ArrayList<String> countries = new ArrayList<>();
        countries.add("Bangladesh");
        countries.add("Pakistan");
        countries.add("USA");
        countries.add("Palestine");
        countries.add("Turkey");

        ArrayList<Integer> countryCode = new ArrayList<>();
        countryCode.add(12345);
        countryCode.add(12364);
        countryCode.add(11566);
        countryCode.add(88594);
        countryCode.add(11208);
        for (int i=0; i <countryCode.size(); i++) {
            System.out.println("my country is " + countries.get(i) + " and my country code is " + countryCode.get(i));


        }
    }//end of main
}// end of class


