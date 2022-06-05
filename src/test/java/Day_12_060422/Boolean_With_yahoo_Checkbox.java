package Day_12_060422;

import Resueable_method_library.Reusable_Actions;
import ReusableClasses.Reusable_Actions_Loggers;
import ReusableClasses.Reusable_Annotations_Class;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

public class Boolean_With_yahoo_Checkbox extends Reusable_Annotations_Class {
    @Test(priority = 1)
    public void Yahoo_Stay_Signed_In_Checkbox_Verification() throws InterruptedException {

        //navigate to USPS.com
        driver.navigate().to("https://www.yahoo.com");
        //click on sign in
        Reusable_Actions_Loggers.clickAction(driver, "//*[text()= 'Sign in']", logger,"Sign In");
        //declare explicit wait for the tabs
        WebDriverWait wait = new WebDriverWait(driver, 10);
        //verify the sta signed in checkbox is selected or not
        boolean elementState = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@type='checkbox']"))).isSelected();
        System.out.print("is element checked? " + elementState);
        if (elementState == true) {
            logger.log(LogStatus.PASS, "Checkbox is selected as expected");
        }else {logger.log(LogStatus.FAIL, "Checkbox is not selected");
        }//end of else

    }//end of test


    @Test(priority = 2)
    public void NavigateToYahooHome(){
        //navigate to yahoo
        logger.log(LogStatus.INFO,"Navigating to Home page");
        driver.navigate().to("https://www.yahoo.com");

    }//end of test 2


    @AfterSuite
    public void quitSession(){
        driver.quit();
    }//end of AfterSuite


}// end of class
