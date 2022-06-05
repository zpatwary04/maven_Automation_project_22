package Resueable_method_library;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class Reusable_Actions {

    //set a static timeout variable so that it can cover all explicit for all methods

    static int timeout = 20;

    //resuable function for webdriver as a return method
    public static WebDriver setDriver() {
        //setup your chromedriver with webdrivermanager
        WebDriverManager.chromedriver().setup();
        //set chrome options arguments
        ChromeOptions options = new ChromeOptions();
        //set the condition to incognito mode
        options.addArguments("incognito");
        //set the condition to maximize/fullscreen your driver
        options.addArguments("start-maximized");
        //for mac use full screen
        //options.addArguments("start-fullscreen");
        //define the webdriver I am going to use
        WebDriver driver = new ChromeDriver(options);
        return driver;
    }//end of setDriver method

    //create a mouse hover method
    public static void mouseHover(WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        Actions actions = new Actions(driver);
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            actions.moveToElement(element).perform();
        } catch (Exception e) {
            System.out.println("Unable to hover on element " + elementName + " " + e);
        }
    }//end of mouseHover

    //create a click method
    public static void clickAction(WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            element.click();
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + " " + e);
        }
    }//end of clickAction

 /*   public static void clickActions(WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath))).get(0);
            element.click();
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + " " + e);
        }
    }//end of clickAction */


    //create a sendkeys method
    public static void sendKeysAction(WebDriver driver, String xpath, String userValue, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            element.sendKeys(userValue);
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + " " + e);
        }
    }//end of sendkeys method


    //create a getText method
    public static String getTextAction(WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        String result = null;
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            result = element.getText();
            System.out.println("The message is " + result);
        } catch (Exception e) {
            System.out.println("Unable to capture text on element " + elementName + " " + e);
        }
        return result;
    }//end of getTextAction method

    //create a click by index method
    public static void clickByIndexAction(WebDriver driver, String xpath, int indexNumber, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath))).get(indexNumber);
            element.click();
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + " " + e);
        }
    }//end of clickByIndexAction

   /* // create a selectByText method
    public static void selectByTextAction(WebDriver driver, String xpath, String visibleText, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            Select elementDropdown = new Select(element);
            //element.click();
           elementDropdown.selectByVisibleText(visibleText);
        } catch (Exception e) {
            System.out.println("Unable to select on element " + elementName + " " + e);
        }
    }//end of select by text  method

    //create a switch tabs by index method

  /*  public static void switchToTabByIndex (WebDriver driver, int uservalue){
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(uservalue));
    }//end of switchToTabsByIndex method*/

    public static void switchToTabByIndex(WebDriver driver, String tab, int indexNumber) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {  //store new tabs in an array list, we use getWindowHandles method to get list of tabs
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            //switch to new tab, it should be at index 1
            driver.switchTo().window(tabs.get(indexNumber));
        } catch (Exception e) {
            System.out.print("Unable to switch tabs " + e);
        }//end of try catch
    }//end of switchToTabByIndex


    public static void verifyTitle(WebDriver driver, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        driver.getTitle();
        if (driver.getTitle().contains(elementName)) {
            System.out.println("My title matches");
        } else {
            System.out.println("Title does not match. Actual title contains " + elementName);
        }//end of else
    }//end of verifyTitle

    // create a selectByText method
    public static void selectByTextAction(WebDriver driver, String xpath, String visibleText, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            Select elementDropdown = new Select(element);
            //element.click();
            elementDropdown.selectByVisibleText(visibleText);
        } catch (Exception e) {
            System.out.println("Unable to select on element " + elementName + " " + e);
        }
    }//end of select by text  method


    //create a submit method
    public static void submitAction(WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            element.submit();
        } catch (Exception e) {
            System.out.println("Unable to submit on element " + elementName + " " + e);
        }
    }//end of submit



   /* //create a Verify Title/ printing header method

    public static void verifyTitle(WebDriver driver, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,10);
        driver.getTitle();
        if (driver.getTitle().contains(elementName)) {
            System.out.println("My title matches");
        } else {
            System.out.println("Title does not match. Actual title contains " + elementName);

        }//end of else
    }//end of verifyTitle*/




   /* public static void scrollAction(WebDriver driver, String scrollvalue) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {

            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript(scrollvalue);


        } catch (Exception e) {
            System.out.println("Unable to select on element " + " " + e);
        }//end of catch
    }// end of scroll by pixel*/
  /*  public static void
    scrollAction(WebDriver driver,String scrollValue ){
       // WebDriverWait wait = new WebDriverWait(driver,10);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript(scrollValue);
    }//end of scrollAction

    public static void scrolltoview(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView();", element);
    }//end of scroll to view */


}//end of class
