package Day_12_060422;

import ReusableClasses.Reusable_Actions_Loggers;
import ReusableClasses.Reusable_Annotations_Class;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

public class Google_Search_with_Reusable_Annotation extends Reusable_Annotations_Class {

    //test case 1: navigate to google and enter a keyword on search field
    @Test(priority = 1)
    public void GoogleSearchForKeyword(){
        logger = reports.startTest("Search for a keyword");
        driver.navigate().to("https://www.google.com");
        //enter a keyword on search field
        Reusable_Actions_Loggers.sendKeysAction(driver,"//*[@name='q']","BMW",logger,"Search Field");
        //submit the go button
        Reusable_Actions_Loggers.submitAction(driver,"//*[@name='btnK']",logger,"Google Search Button");

        //end the logger per test

    }//end of test 1

    /*
    dependsOnMethods is used when  following @Test is dependent on previous @Test method. If the first test fails,
    the dependent test will get skipped
     */
    @Test(dependsOnMethods = "GoogleSearchForKeyword")
    public void GoogleCaptureSearchNumber(){
        logger = reports.startTest("Google Capture the search number");
        //capture search result
        String result = Reusable_Actions_Loggers.getTextAction(driver,"//*[@id='Result-stats']",logger,"Search Result Text");
        //split the result by single space and print out the search number
        String[] arrayResult = result.split(" ");
        System.out.println("Search number is " + arrayResult[1]);
        logger.log(LogStatus.INFO,"Search number is " + arrayResult[1]);


    }//end of test 2


    @AfterSuite
    public void quitSession(){
        driver.quit();
        reports.flush();
    }//end of after suite


}// end of class
