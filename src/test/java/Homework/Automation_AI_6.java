package Homework;

import Resueable_method_library.Reusable_Actions;
import ReusableClasses.Reusable_Actions_Loggers;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Automation_AI_6 {

    //declare the local driver outside so that it can be reusable with other annotation methods
    WebDriver driver;
    ExtentReports reports;
    ExtentTest logger;

    //before suite will set the driver you are using
    @BeforeSuite
    public void setChromeDriver(){
        driver = Reusable_Actions.setDriver();
        //define the path to the report
        reports = new ExtentReports("src/main/java/HTML_Report/Automation.html",true);
    }//end of before suite annotation

        @Test(priority = 1)
        //TC-1 verify that you see the insurance category on homepage
        //navigate to the website
        public void navigatetowebsite() throws InterruptedException {
            logger = reports.startTest("verifyInsuranceTab");
            driver.navigate().to("https://www.northwesternmutual.com");
            //click on insurance category
            Reusable_Actions_Loggers.clickAction(driver,"//*[@id='nmx-nav-link-primary-insurance']", logger, "Click on insurance");
            //hover on Insurance category to see the submenu
            Reusable_Actions_Loggers.mouseHover(driver,"//*[@id='nmx-nav-link-primary-insurance']", logger,"Verify the dropdown list");
            reports.endTest(logger);
        }//end of test


    @Test(dependsOnMethods = "navigatetowebsite")
    //TC-2 verify that there is lists of each individual insurance services are and clickable and working under insurance category
    public void clickableSublist(){
        Reusable_Actions.clickAction(driver,"//*[@id='nmx-nav-link-primary-sub-life-insurance']","click on sublist Insurance");
        //hover on Insurance category to see the submenu
        Reusable_Actions.mouseHover(driver,"//*[@id='nmx-nav-link-primary-insurance']","Verify the whole life insurance from list");
        //click on whole life insurance
        Reusable_Actions.clickByIndexAction(driver,"//*[@href='/life-insurance/whole-life-insurance/']",0,"click on whole life insurance");
        reports.endTest(logger);
    }//end of test

    @AfterSuite
    public void quitsession() {
        driver.quit();
     reports.flush();
    }// end aftersuite
}// end of class
