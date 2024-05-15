package KatalonProject;

import common.Utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage implements Home{

    WebDriver driver;
    Utilities util = new Utilities();


    @Override
    public void initialize(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyHomePageHeader(){
        if(util.verifyElementPresent(driver,headerCuraHealthCareText)){
            System.out.println("Header is correct");
        }
        else{
            System.out.println("Header is not correct");
        }
    }

}
