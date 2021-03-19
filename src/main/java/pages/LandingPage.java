package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage extends PageBase {
    public LandingPage(WebDriver driver){super(driver);}

    /*
     *  Detecting Elements from the UI in Landing Page
     */

    @FindBy(xpath = "//a[@class='login']")
    public WebElement buttonSignIn;

     public void clickOnSignIn()
     {
         clickButton(buttonSignIn);
     }
}
