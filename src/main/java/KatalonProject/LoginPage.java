package KatalonProject;

import common.Utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage implements Login{

    WebDriver driver ;
    Utilities utilities = new Utilities();
    AppointmentPage appointmentPage = new AppointmentPage();

    @Override
    public void initialize(WebDriver driver) {
        this.driver = driver;
        utilities.initialize(driver);
        appointmentPage.initialize(driver);
    }

    public boolean verifyLoginPageHeader(){
        boolean flag = false;
        utilities.waitForElementToBePresent(LoginHeader);
        if(utilities.verifyElementPresent(driver,LoginHeader)){
            flag = true;
            System.out.println("Login Page has appeared");
        }else{
            throw new RuntimeException("Login Page has not appeared");
        }
        return flag;
    }

    public void login(String user , String pass){
        if(utilities.verifyElementPresent(driver,username)
                && utilities.verifyElementPresent(driver,password)){
        username.sendKeys(user);
        password.sendKeys(pass);
        utilities.clickOnElement(loginButton);
        utilities.waitForElementToBePresent(appointmentPage.appointmentPageHeader);
        }
    }
}
