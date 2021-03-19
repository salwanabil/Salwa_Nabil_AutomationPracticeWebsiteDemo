package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {
    public static WebDriver driver;

    public Select select;
    public Actions action;
    public static String currentWindowID = null;
    public static JavascriptExecutor jse;

    // create constructor
    public PageBase(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }

    // Wait for Element to be visiable.
    public static boolean waitUntilElementVisiable(WebElement element)
    {
        try{
            WebDriverWait wait = new WebDriverWait(driver, 20);
            wait.until(ExpectedConditions.visibilityOf(element));
            // element found, return true
            return true;
        }catch (Exception ex){
            // element not found, return false
            return false;
        }
    }

    // Wait for Element to be clickable.
    public static boolean waitUntilElementBeClickable(WebElement element)
    {
        try{
            WebDriverWait wait = new WebDriverWait(driver, 20);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            // element not clickable, return true
            return true;
        }catch (Exception ex){
            // element not clickable, return false
            return false;
        }
    }

    public static void mouseHover(WebDriver driver,WebElement element)
    {
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
    }

    // Method to Click Buttons
    protected static void clickButton(WebElement button) {
        button.click();
    }

    // Method to send Keys
    protected static void setText(WebElement textElement, String value) {
        waitUntilElementVisiable(textElement);
        textElement.clear();
        textElement.sendKeys(value);
    }

    // Method to Press Enter
    public void KeyPressEnter(WebElement webElement) {
        webElement.sendKeys(Keys.ENTER);
    }

    // Method to scroll down
    public void scrollToBottom(){
        jse.executeScript("scrollBy(0,1500)");
    }

    // Method to handle windows
    public void WindowHandling(WebDriver driver){
        currentWindowID = driver.getWindowHandle();
        for (String windowID : driver.getWindowHandles()){
            driver.switchTo().window(windowID);
        }
    }

    // Method to select from Drop down
    public void statusDropDownList(WebDriver driver, WebElement selectWebElement,String selectItem){
        Select dropdwn = new Select(selectWebElement);
        dropdwn.selectByVisibleText(selectItem);
    }

    public void selectDropDownListByValue(WebDriver driver, WebElement selectWebElement,String selectItem){
        Select dropdwn = new Select(selectWebElement);
        dropdwn.selectByValue(selectItem);
    }

    public void jsClickElementInterchangable(WebDriver driver, WebElement element){
        if (element.isEnabled()){
            JavascriptExecutor executor = (JavascriptExecutor)driver;
            executor.executeScript("arguments[0].click();",element);
        }

    }
}
