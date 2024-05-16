import common.configFileReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class loginTestBase extends commonTestBase{

    WebDriver driver;
    common.configFileReader configFileReader;
    String propsPath = "src/test/resources/application.properties";

    @Test
    public void Login() throws MalformedURLException {
        configFileReader = new configFileReader(propsPath);
        System.out.println("Hello 3");
        driver = createDriver("chrome");
        driver.get(configFileReader.readProperty("ApplicationURL"));
        System.out.println("loggedIn");
    }
}
