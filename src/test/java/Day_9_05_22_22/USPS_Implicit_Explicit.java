package Day_9_05_22_22;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class USPS_Implicit_Explicit {
    public static void main(String[] args) {

        //setup your chromedriver with webdriver manager
        WebDriverManager.chromedriver().setup();
        //set chrome options arguments
        ChromeOptions options = new ChromeOptions();
        //set the condition to incognito mode
        options.addArguments("incognito");
        //set the condition to maximize/fullscreen your driver
        options.addArguments("start-maximized");
        //for mac use full screen
        //options.addArguments("start-fullscreen");
        //define the "WebDriver"  I am going to use
        WebDriver driver = new ChromeDriver(options);

        //set your implicit wait
        //driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        //Navigate to usps

        driver.navigate().to("https://www.usps.com");

        //call mouse actions
        Actions actions = new Actions(driver);

        //declare and define explicit wait
        WebDriverWait wait = new WebDriverWait(driver,8);

        //hover to quick tools
        WebElement quicktools = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Quick Tools']")));
        actions.moveToElement(quicktools).perform();

        //click on track a package
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Track a Package']"))).click();

        //click and then type on track a package field
        WebElement packageField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='tracking-input']")));
        packageField.click();
        packageField.sendKeys("11254664595666");


    }//end of main
}//end of class
