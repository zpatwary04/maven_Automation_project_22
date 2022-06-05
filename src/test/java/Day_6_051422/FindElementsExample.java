package Day_6_051422;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FindElementsExample {
    public static void main(String[] args) throws InterruptedException {
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

        //navigate to bing home page
        driver.navigate().to("https://www.bing.com");
        Thread.sleep(3000);
        //cling on images using class property with index of 1
        //to ignore white space in the property value we can use "contains" command in xpath
        driver.findElements(By.xpath("//li[contains(@class,'scope')]")).get(0).click();

driver.quit();
    }// end of main
}//end of class
