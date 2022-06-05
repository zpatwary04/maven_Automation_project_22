package Day_9_05_22_22;

import Resueable_method_library.Reusable_Actions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class USPS_Reusable_Concepts {
    public static void main(String[] args) {
        //setting the local driver to reusable setDriver method
        WebDriver driver = Reusable_Actions.setDriver();

        //Navigate to USPS
        driver.navigate().to("https://usps.com");

        //hovering to the quick tools
        Reusable_Actions.mouseHover(driver, "//*[text()='Quick Tools']", "Quick tools");

        // hovering send tabs
        Reusable_Actions.mouseHover(driver,"//*[@id='mail-ship-width']", "send tab");

        //click on calculate a price
        Reusable_Actions.clickAction(driver,"//*[@class='tool-calc']", "Calculate a Price");

        //print out header text info
        String result = Reusable_Actions.getTextAction(driver,"//*[@class='header-usps row']","Header Info");
        System.out.println("My header info is " + result);


        //enter the zipcode
        Reusable_Actions.sendKeysAction(driver, "//*[@id='Origin']","11218", "Zip Code");



        //
    }//end of main
}//end of class
