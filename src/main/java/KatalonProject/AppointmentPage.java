package KatalonProject;

import common.Utilities;
import org.openqa.selenium.WebDriver;

class AppointmentPage implements Appointment{

    WebDriver driver;
    Utilities utilities = new Utilities();
    LoginPage loginPage = new LoginPage();

    @Override
    public void initialize(WebDriver driver) {
        this.driver = driver;
        utilities.initialize(driver);
        loginPage.initialize(driver);
    }


}
