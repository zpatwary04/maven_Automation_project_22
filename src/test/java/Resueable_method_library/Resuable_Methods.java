package Resueable_method_library;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Resuable_Methods {
    //create a void method to add two numbers
    public static void addTwoNumbers(int num1, int num2){
        System.out.println("The result of two numbers is " + (num1+num2));
    }//end of add two number method


    //create a "return" integer method to subtract two numbers
    public static int subtractTwoNumbers(int a, int b){
        int result = a-b;
        System.out.println("The result of two numbers for subtraction is " + result);

        return result;
    }// end of subtraction method


    //create a submit method
    public static void submitAction(WebDriver driver, String xpath, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,10);
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            element.submit();
        } catch (Exception e) {
            System.out.println("Unable to submit on element " + elementName + " " + e);
        }
    }//end of submit



}// end of java class
