package day_8_052122;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class Hotels_action_item {
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

        //navigate to Hotels.com
        driver.navigate().to("https://www.Hotels.com");
        //create an aaray list for selecting the locations

        ArrayList<String> goingto = new ArrayList<>();
        goingto.add("Los Angeles");
        goingto.add("Hawaii");
        goingto.add("Las Vegas");
        for (int i = 0; i < goingto.size(); i++) {
        //create array list for check in dates
        ArrayList<String> checkinDate = new ArrayList<>();
        checkinDate.add("June 4th");
        checkinDate.add("June 5th");
        checkinDate.add("June 6th");
        //location search bar
      //  for (int i = 0; i < goingto.size(); i++) {
            WebElement searchlocations = driver.findElement(By.xpath("//*[@id='location-field-destination-menu']"));
            searchlocations.click();
            //searchlocations.clear();
            searchlocations.sendKeys(goingto.get(i));
            searchlocations.submit();
            
        }// end of loop
    }//end of main
}//end of class
