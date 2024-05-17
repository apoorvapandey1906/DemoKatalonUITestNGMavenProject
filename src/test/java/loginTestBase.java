import KatalonProject.HomePage;
import KatalonProject.LoginPage;
import common.configFileReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class loginTestBase extends commonTestBase{

    WebDriver driver;
    common.configFileReader configFileReader;
    String propsPath = "src/test/resources/application.properties";



    @Test
    public void launchTheCURAApplication() throws MalformedURLException {
        configFileReader = new configFileReader(propsPath);
        System.out.println("Hello 1");
        driver = createDriver("chrome");
        driver.get(configFileReader.readProperty("ApplicationURL"));
        System.out.println("launched");
    }

    @Test(priority = 2)
    public void LoginIntoCURAApplication() throws MalformedURLException {
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        configFileReader = new configFileReader(propsPath);
        driver = createDriver("chrome");
        driver.get(configFileReader.readProperty("ApplicationURL"));
        System.out.println("Hello 2");
        homePage.openLoginMenuToggle();
        homePage.openLoginPage();
        String user = configFileReader.readProperty("username");
        String pass = configFileReader.readProperty("password");
        loginPage.verifyLoginPageHeader();
        loginPage.login(user,pass);
        System.out.println("logged In");

    }
}
