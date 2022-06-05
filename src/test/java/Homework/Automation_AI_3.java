package Homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.naming.directory.SearchResult;
import java.util.ArrayList;
import java.util.concurrent.LinkedTransferQueue;

public class Automation_AI_3 {
    public static void main(String[] args) throws InterruptedException {
//set up the chromedriver with web-driver manager
        WebDriverManager.chromedriver().setup();
        //setting up chrome options
        ChromeOptions options = new ChromeOptions();
        // setting up the conditions
        options.addArguments("start-maximized");
        // defining the "web-driver"
        WebDriver driver = new ChromeDriver(options);
        // listing the countries using Array list
       ArrayList<String> countries = new ArrayList<>();
       countries.add(" Bangladesh ");
       countries.add(" Pakistan ");
        countries.add(" India ");
        countries.add(" USA ");
        countries.add(" Greece ");
        for (int i = 0; i <countries.size() ; i++) {
            //go to Bing homepage, Bing.com
            driver.navigate().to("https://www.bing.com");
            Thread.sleep(3000);
            //locate element in search field
            driver.findElement(By.xpath("//*[@name='q']")).sendKeys(countries.get(i));
            //find element for searching
            driver.findElement(By.xpath("//*[@id='search_icon']")).submit();
            Thread.sleep(3000);
//capture the bing search and print it
String searchResult = driver.findElement(By.xpath("//*[@class='ent-dtab-dtxt-ov ent-dtab-tabuxv1']")).getText();

            System.out.println("Result is for the " + countries.get(i) + "is a " + searchResult  );
            //print the search result




        }// end of loop
        //quit the driver
        driver.quit();
    }// end of main
}// end of class
