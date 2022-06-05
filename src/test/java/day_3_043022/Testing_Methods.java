package day_3_043022;

import Resueable_method_library.Resuable_Methods;

public class Testing_Methods {
    public static void main(String[] args) {
        //call the add two number method and execute it
        Resuable_Methods.addTwoNumbers(20,30);
        //call the return method and store it in a variable to perform something else
        int finalresult = Resuable_Methods.subtractTwoNumbers(50,10);
        int newresult = finalresult + 10;
        System.out.println("new result is " + newresult);
    }//end of main method
}//end of java class
