package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Utilities {

    WebDriver driver;

    public void initialize(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public boolean verifyElementPresent(WebDriver driver, WebElement element){
        boolean flag = false;
        if(element.isDisplayed() && element.isEnabled()){
            flag = true;
        }
        return flag;
    }


}
