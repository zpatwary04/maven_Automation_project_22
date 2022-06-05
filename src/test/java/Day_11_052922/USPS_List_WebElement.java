package Day_11_052922;

import Resueable_method_library.Reusable_Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.List;

public class USPS_List_WebElement {

    //declare the local driver outside so it can reusable with other annotation methods
    WebDriver driver;

    //before suite will set the driver you are using
    @BeforeSuite
    public void setChromeDriver(){
        driver = Reusable_Actions.setDriver();

    }//end of before suite annotation

    @Test()
    public void USPS_Table_Count() throws InterruptedException {

        //navigate to USPS.com
        driver.navigate().to("https://www.USPS.com");
        //declare explicit wait for the tabs
        WebDriverWait wait = new WebDriverWait(driver, 10);
        //store the navigation tabs as a list to get the count
        List<WebElement> tabsCount = driver.findElements(By.xpath("//li[contains(@class, 'menuheader')]"));
        System.out.print("Tab count is " + tabsCount.size());

        for (int i = 0; i < tabsCount.size(); i++) {
            driver.navigate().to("https://www.USPS.com");
            tabsCount = driver.findElements(By.xpath("//li[contains(@class, 'menuheader')]"));
            //click on each tab
            tabsCount.get(i).click();
            Thread.sleep(3000);

        }//end of for loop


    }//end of test 1


    @AfterSuite
    public void quitSession(){
        driver.quit();
    }//end of AfterSuite

}// end of class
