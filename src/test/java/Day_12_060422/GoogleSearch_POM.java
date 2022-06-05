package Day_12_060422;

import Pageobjects.BaseClass;
import ReusableClasses.Reusable_Annotations_Class;
import org.testng.annotations.Test;

public class GoogleSearch_POM extends Reusable_Annotations_Class {

    @Test
    public void SearchForAKeywordOnGoogleHome(){
        driver.navigate().to("https://www.google.com");
        BaseClass.googleHomePage().searchUserValue("BMW");
        BaseClass.googleHomePage().submitOnGoogleSearch();
    }

    @Test(dependsOnMethods = "SearchForAKeywordOnGoogleHome")
    public void CaptureSearchNumberFromGoogle(){
        BaseClass.googleSearchResultPage().CaptureSearchNumberAndPrintIt();
    }


}// end of class

