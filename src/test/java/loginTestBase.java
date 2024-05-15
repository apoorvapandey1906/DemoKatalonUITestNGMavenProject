import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class loginTestBase extends commonTestBase{

    WebDriver driver;

    @Test
    public void Login() throws MalformedURLException {
        System.out.println("1");
        driver = createDriver("chrome");
        driver.get("https://www.google.com");
        System.out.println("2");
    }
}
