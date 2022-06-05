package Homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class Automation_AI_4_2nd_try {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        options.addArguments("start-maximized");
        WebDriver driver = new ChromeDriver(options);

        ArrayList<String> zipcodes = new ArrayList<>();
        zipcodes.add("11208");
        zipcodes.add("11218");
        zipcodes.add("11224");
        for (int i = 0; i < zipcodes.size(); i++) {
            //navigate to weightwatchers.com
            driver.navigate().to("https://weightwatchers.com");
            //put some wait time
            Thread.sleep(2000);

            //click on Attend
            try {
                driver.findElement(By.xpath("//*[@data-e2e-name='attend']")).click();
                Thread.sleep(2000);

            } catch (Exception e) {
                System.out.println("Unable to find the Attend button " + e);
            }

            //click on Unlimited Workshops
            try {
                driver.findElement(By.xpath("//*[@data-e2e-name='unlimited_workshops']")).click();
            } catch (Exception e) {
                System.out.println("Unable to find the Unlimited Workshops " + e);
            }
            Thread.sleep(2000);

            //click on studio
            try {
                driver.findElement(By.xpath("//*[@class='studioIcon-2TdMR']")).click();
            } catch (Exception e) {
                System.out.println("Unable to find the Unlimited Workshops " + e);
            }

            //type in zipcodes in studio search bar
            try {
                WebElement studio = driver.findElement(By.xpath("//*[@id='location-search']"));
                studio.clear();
                studio.click();
                studio.sendKeys(zipcodes.get(i));
                //studio.submit();
                driver.findElement(By.xpath("//*[@class='rightArrow-daPRP']")).click();
                Thread.sleep(2000);

            } catch (Exception e) {
                System.out.println("Unable to find and click on search bar " + e);

            }

            //click on the location
            try {
                WebElement locations = driver.findElements(By.xpath("//*[@class='linkUnderline-1_h4g']")).get(i);
                //print the addresses
                if (zipcodes.get(i) == zipcodes.get(0)) {
                    locations.click();
                    Thread.sleep(1000);
                    String address = driver.findElement(By.xpath("//*[@class='address-2PZwW']")).getText();

                    System.out.println("The studio closest to the zipcode " + zipcodes.get(i) + " is " + address);
                    Thread.sleep(1000);
                    try {
                        //scroll to schedule section
                        JavascriptExecutor jse = (JavascriptExecutor) (driver);
                        WebElement scrolltoschedule = driver.findElement(By.xpath("//*[@id='studioWorkshopSchedule']"));
                        jse.executeScript("arguments[0].scrollIntoView(true);", scrolltoschedule);
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        System.out.println("Unable to scroll to the schedule " + e);
                    }
                    try {
                        //get text from the schedule
                        String Schedules = driver.findElement(By.xpath("//*[@id= 'studioWorkshopSchedule']")).getText();
                        System.out.println("Please see below the table of schedule:" + Schedules);
                    } catch (Exception e) {
                        System.out.println(" Unable to get text from schedule " + e);
                    }//end of catch on getting schedule
                }//end of if
                if (zipcodes.get(i) == zipcodes.get(1)) ;
                {
                    locations.click();
                    Thread.sleep(2000);
                    String address2 = driver.findElement(By.xpath("//*[@class='address-2PZwW']")).getText();
                    System.out.println(" The studio closest to the zipcode " + zipcodes.get(i) + " is " + address2);
                    Thread.sleep(2000);
                    try {
                        //scroll to view schedule
                        JavascriptExecutor jse = (JavascriptExecutor) (driver);
                        WebElement scrollschedule = driver.findElement(By.xpath("//*[@id='studioWorkshopSchedule']"));
                        jse.executeScript("arguments[0].scrollIntoView(true);", scrollschedule);
                        Thread.sleep(2000);
                    } catch (Exception e) {
                        System.out.println("Unable to scroll to the element of schedules " + e);
                    }
                    try {
                        //get text from the schedule
                        String schedule = driver.findElement(By.xpath("//*[@id= 'studioWorkshopSchedule']")).getText();
                        System.out.println("Please see below the table of schedule:" + schedule);
                    } catch (Exception e) {
                        System.out.println(" Unable to get text from the schedule " + e);
                    }//end of if condition
                }// end of second if condition
                if (zipcodes.get(i) == zipcodes.get(2)) {
                    locations.click();
                    Thread.sleep(2000);
                    String address3 = driver.findElement(By.xpath("//*[@class='address-2PZwW']")).getText();
                    System.out.println(" The studio closest to the zipcode " + zipcodes.get(i) + " is " + address3);
                    Thread.sleep(2000);
                    try { //scroll to element
                        JavascriptExecutor jse = (JavascriptExecutor) (driver);
                        WebElement scrollschedule = driver.findElement(By.xpath("//*[@id='studioWorkshopSchedule']"));
                        jse.executeScript("arguments[0].scrollIntoView(true);", scrollschedule );
                        Thread.sleep(2000);
                    } catch (Exception e) {
                        System.out.println("Unable to scroll to the schedule " + e);
                    }
                    try {//get text from table
                        String schedule = driver.findElement(By.xpath("//*[@id= 'studioWorkshopSchedule']")).getText();
                        System.out.println("Please see below the table of schedule:" + schedule);
                    } catch (Exception e) {
                        System.out.println(" Unable to get text from the schedule " + e);
                    }//ending catch
                }//end of third if condition
            }//end of last catch
            catch (Exception e) {
            }//end of catch
        }//end of loop
        }//end of main
}//end of class
