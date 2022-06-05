package day_2;

import java.util.ArrayList;

public class ArrayListExample {
    public static void main(String[] args) {
//create an Arraylist for countries
        ArrayList<String> countries = new ArrayList<>();
        countries.add("USA"); //index 0
        countries.add("bangladesh"); //index 1
        countries.add("India"); //index 2
        countries.add("Canada"); //index 3
        countries.add("Pakistan"); //index 4
        System.out.println("my last country is " + countries.get(4) + " And my third country is " + countries.get(2));
        //index 5 will throw index out of bound exception since there is no value stores at index 5
    }//end of main method
}//end of java class
