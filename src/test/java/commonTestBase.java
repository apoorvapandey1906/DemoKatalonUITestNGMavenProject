import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class commonTestBase {

    WebDriver driver ;

      public WebDriver createDriver(String browser) throws MalformedURLException {
          switch (browser) {
             case "chrome":
              driver = setUpChromeDriver();
              break;

              case "firefox":
                  driver = new FirefoxDriver();
                  break;

              case "headless":
                  driver = setUpHeadlessChromeDriver();
              default:
                  throw new IllegalArgumentException(
                          "Supported browser types are - chrome, firefox ,headless .Unsupported browser type: " + browser
                  );
          }

         return driver;
      }

      public WebDriver getDriver(){
          return driver;
      }

      protected void tearDownDrivers(){
          if(driver != null){
              driver.quit();
              driver = null;
          }
         // logger.info(Constants.GeneralLoggingConstants.DRIVERS_CLOSED_LOG_MSG);
      }

      @AfterMethod(alwaysRun = true)
      protected void cleanup() {
          tearDownDrivers();
      }

      public WebDriver setUpChromeDriver() throws MalformedURLException {
         System.setProperty("webdriver.chrome.driver","C:\\Users\\USER\\IdeaProjects\\DemoKatalonUITestNGMavenProject\\src\\test\\resources\\drivers\\chromedriver_V124.exe");
          DesiredCapabilities capabilities = new DesiredCapabilities();
          capabilities.setCapability("browserName", "chrome");
          capabilities.setCapability("browserVersion", "124");
          capabilities.setCapability("screenResolution", "1920*1080");

          ChromeOptions options = new ChromeOptions();
//          options.addArguments("--start-maximized",
//                  "--allow-insecure-localhost",
//                  "--ignore-certificate-errors",
//                  "--headless");

          options.setAcceptInsecureCerts(true);
          capabilities.setCapability(ChromeOptions.CAPABILITY,options);
          driver = new ChromeDriver(options);
          driver.manage().timeouts().setScriptTimeout(15, TimeUnit.SECONDS);
          driver.manage().deleteAllCookies();

          return driver;
      }

    public WebDriver setUpHeadlessChromeDriver(){
      //  System.setProperty("webdriver.chrome.driver",DRIVER_PATH);
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("browserVersion", "latest");
        ChromeOptions options=new ChromeOptions();
        options.addArguments("headless");
        options.setAcceptInsecureCerts(true);
        capabilities.setCapability(ChromeOptions.CAPABILITY,options);
        driver = new ChromeDriver(options);
        driver.manage().timeouts().setScriptTimeout(15, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();

        return driver;
    }
}
