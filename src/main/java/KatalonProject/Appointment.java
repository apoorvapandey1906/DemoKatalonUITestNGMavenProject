package KatalonProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public interface Appointment {

    //WebDriver driver;
    public WebElement appointmentPageHeader  = (WebElement) By.xpath("//h2[text()='Make Appointment']");

    public default void initialize(WebDriver driver){
        PageFactory.initElements(driver,this);
//            this.driver = driver;
    }
}
//