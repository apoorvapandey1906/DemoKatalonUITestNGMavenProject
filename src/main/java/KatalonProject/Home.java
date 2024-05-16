package KatalonProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


public interface Home {

  //  public  WebDriver driver ;

    public WebElement menuToggle = (WebElement) By.id("menu-toggle");

    public WebElement loginButton = (WebElement) By.xpath("//a[text()='Login']");

    public WebElement headerCuraHealthCareText = (WebElement) By.xpath("//h1[text()='CURA Healthcare Service']");

    public WebElement headerWeCareAboutYourHealthText = (WebElement) By.xpath("//h3[text()='We Care About Your Health']");

    public WebElement makeAppointmentButton = (WebElement) By.id("btn-make-appointment");

    public default void initialize(WebDriver driver){
        PageFactory.initElements(driver,this);
    //    this.driver = driver;
    }
}
