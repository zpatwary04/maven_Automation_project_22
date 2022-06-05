package Homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class Automation_AI_4 {
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
        //navigate to mortgage calculator site

        ArrayList<String> zipcodes = new ArrayList<>();
        zipcodes.add("11208");
        zipcodes.add("11218");
        zipcodes.add("11224");
        for (int i = 0; i < zipcodes.size(); i++) {
            //navigate to weightwatchers.com
            driver.navigate().to("https://www.weightwatchers.com");
            Thread.sleep(3000);

            //handle execption for "Attend". click on attend

         try {
             driver.findElement(By.xpath("//*[@data-e2e-name='attend']")).click();
             Thread.sleep(2000);
         } catch (Exception e) {
             System.out.println("unable to find attend button" + e);
         }
         // Handle exception and  click on unlimited workshop
            try {
                driver.findElement(By.xpath("//*[@data-e2e-name='unlimited_workshops']")).click();
            } catch ( Exception e) {
                System.out.println(" unable to find the unlimited workshops" + e);
            }
            //find the studio icon and click on it
            try {
                driver.findElement(By.xpath("//*[@class='studioIcon-2TdMR']")).click();
            } catch (Exception e)  {
                System.out.println("unable to find studio" + e);
            }
            try {
                //find the search location
                WebElement enterlocation = driver.findElement(By.xpath("//*[@id='location-search']"));
                enterlocation.click();
                enterlocation.clear();
                enterlocation.sendKeys(zipcodes.get(i));
                // enterlocation.submit();
                Thread.sleep(2000);
                // click on the arrow
                driver.findElement(By.xpath("//*[@class='rightArrow-daPRP']")).click();
            } catch (Exception e) {
                System.out.println("unable to find and search location" + e);
            }
            //click on the first link
            try {
               // WebElement locations = driver.findElements(By.xpath("//*[@class='container-3SE46']")).get(i);

                if (zipcodes.get(i) == zipcodes.get(1)) {
                    driver.findElements(By.xpath("//*[@class='linkUnderline-1_h4g']")).get(0).click();;
                    //String add1 = driver.findElement(By.xpath("//*[@class='address-2PZwW']")).getText();
                  //  System.out.println("My address for the studio closest to the zipcode " + zipcodes.get(i) + " is " + add1);

                    Thread.sleep(2000);
                }

                } catch(Exception e){
                    System.out.println(" unable to find the link" + e);
                }
                //storing webelement variable for all the locations
                //WebElement locations = driver.findElement(By.xpath("//*[@class='linkUnderline-1_h4g']"));

       }//end of loop
    }//end of main
}// end of class
