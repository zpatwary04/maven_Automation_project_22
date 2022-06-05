package Homework;

import Resueable_method_library.Reusable_Actions;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class Automation_AI_5 {
    public static void main(String[] args) {
        //Creating ArrayList for Firstname, Lastname, Birth month, Birthday, Birth year, Zip codes, and Member ID.

        //First name ArrayList
        ArrayList<String> FirstName = new ArrayList<>();
        FirstName.add("Zahid");
        FirstName.add("Zihad");
        FirstName.add("Shahrukh");

        //Last Name Array List
        ArrayList<String> LastName = new ArrayList<>();
        LastName.add(" Patwary ");
        LastName.add(" Patwary ");
        LastName.add(" khan ");

        // birth month Array list
        ArrayList<String> BirthMonth = new ArrayList<>();
        BirthMonth.add("April");
        BirthMonth.add("May");
        BirthMonth.add("June");

        // Birthday Array list
        ArrayList<String> Birthday = new ArrayList<>();
        Birthday.add("23");
        Birthday.add("15");
        Birthday.add("25");


        //Birth year Array List
        ArrayList<String> BirthYear = new ArrayList<>();
        BirthYear.add("1998");
        BirthYear.add("2004");
        BirthYear.add("1994");


        // Zip Code Array List
        ArrayList<String> Zipcodes = new ArrayList<>();
        Zipcodes.add("11218");
        Zipcodes.add("11208");
        Zipcodes.add("11224");


        // Member ID Array List
        ArrayList<String> MemberID = new ArrayList<>();
        MemberID.add("154645635");
        MemberID.add("123554686");
        MemberID.add("124464568");

        //using the webdriver as reusable setdriver method
        WebDriver driver = Reusable_Actions.setDriver();
        for (int i = 0 ; i < FirstName.size(); i++) {
        try {
            //Navigate to UHC.com
            driver.navigate().to("https://UHC.com");
        }catch (Exception e) {
            System.out.println("Unable to navigate to UHC.com" + e);
        }//end of catch
//verify the homepage says health insurance plan
          //  Reusable_Actions.verifyTitle(driver, "Health insurance plans");
        //click on find a doctor
            Reusable_Actions.clickAction(driver,"//*[@aria-label='Find a doctor']", "Find a Doctor");

            //click on sign in
            Reusable_Actions.clickAction(driver, "//*[@aria-label='Sign in menu']", "Sign in");

            //click on Medicare Plan?
            Reusable_Actions.clickAction(driver,"//*[@aria-label='Medicare plan? Sign in to Medicare member site Opens a new window']","click on medicare");

            //switch tabs by index
            Reusable_Actions.switchToTabByIndex(driver, "tabs",1);

            // click on register now
            Reusable_Actions.clickAction(driver,"//*[@class='uhc-tempo-link uhc-tempo-link--medium registerBtn ng-scope']","click on register");

            //enter first name
            Reusable_Actions.sendKeysAction(driver,"//*[@id='firstName']",FirstName.get(i),"putting first name");

            //enter last name
            Reusable_Actions.sendKeysAction(driver,"//*[@id='lastName']",LastName.get(i), "putting Last name");

            //enter birth month
            Reusable_Actions.selectByTextAction(driver,"//*[@name='dob_month']",BirthMonth.get(i),"putting month");

            // enter birthday
            Reusable_Actions.sendKeysAction(driver,"//*[@id='dob_day']",Birthday.get(i),"");

            //enter birth year
            Reusable_Actions.sendKeysAction(driver,"//*[@id='dob_year']", BirthYear.get(i),"putting birth year");

            //enter zip code
            Reusable_Actions.sendKeysAction(driver,"//*[@id='zipCode']",Zipcodes.get(i),"putting zip codes");

            //enter member ID
            Reusable_Actions.sendKeysAction(driver,"//*[@id='memberId']", MemberID.get(i),"putting member ID");

            //pressing continue
            Reusable_Actions.clickAction(driver,"//*[@id='submitBtn']","pressing/clicking continue");

            //capturing error message
            Reusable_Actions.getTextAction(driver,"//*[@class='SummaryError_ErrorContent__1j0LP']","capture the text");


            //close the tab
            driver.close();

            //switch to first tab
            Reusable_Actions.switchToTabByIndex(driver,"tabs",0);

        }// end of loop

        //quit driver
        driver.quit();
    }// end of main
}//end of class
