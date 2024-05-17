package KatalonProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public interface Login {

//    private WebDriver driver;

    public WebElement LoginHeader = (WebElement) By.xpath("//h2[text()='Login']");
    public WebElement username = (WebElement) By.id("txt-username");
    public WebElement password = (WebElement) By.id("txt-password");
    public WebElement loginButton = (WebElement) By.id("btn-login");

    public default void initialize(WebDriver driver){
        PageFactory.initElements(driver,this);
//            this.driver = driver;
    }


}
