package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
        else{
            throw new RuntimeException(element + " is not present on the page");
        }
        return flag;
    }

    public void clickOnElement(WebElement element){
        if(element.isEnabled()) {
            element.click();
        }else {
            throw new RuntimeException(element + " is not present on the page");
        }
    }

    public void waitForElementToBePresent(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(element));
    }




}
