package KatalonProject;

import common.Utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage implements Home{

    WebDriver driver;
    Utilities utilities = new Utilities();
    LoginPage loginPage = new LoginPage();

    @Override
    public void initialize(WebDriver driver) {
        this.driver = driver;
        utilities.initialize(driver);
        loginPage.initialize(driver);
    }

    public void verifyHomePageHeader(){
        if(utilities.verifyElementPresent(driver,headerCuraHealthCareText)){
            System.out.println("Header is correct");
        }
        else{
            System.out.println("Header is not correct");
        }
    }

    public void verifyHomePageFields(){
        if(utilities.verifyElementPresent(driver,headerCuraHealthCareText)
                && utilities.verifyElementPresent(driver,headerWeCareAboutYourHealthText)
                && utilities.verifyElementPresent(driver,makeAppointmentButton)){
            System.out.println("Home Page has all the correct fields");
        }else{
            throw new RuntimeException("All the fields are not present");
        }
    }

    public void openLoginMenuToggle(){
        utilities.clickOnElement(menuToggle);
        utilities.waitForElementToBePresent(CURAHealthCareToggleHeader);
    }

    public void openLoginPage(){
        utilities.clickOnElement(LoginLink);
        loginPage.verifyLoginPageHeader();
    }

}
