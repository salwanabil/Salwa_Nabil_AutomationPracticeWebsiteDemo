package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends PageBase{
    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    /*
     *  Detecting Elements from the UI in Dashboard Page
     *  Elements for Upper menu on the right
    */
    @FindBy(xpath = "//div[@id=\"center_column\"]/h1")
    private WebElement lblTopTitle;

    @FindBy(xpath = "//a[@title= 'Log me out']")
    private WebElement buttonSignOut;

    @FindBy(xpath = "//li/a[@title= 'Dresses']")
    private WebElement buttonDresses;

    public WebElement getButtonDresses() {
        return buttonDresses;
    }

    @FindBy(xpath = "//a[@title= 'Summer Dresses']")
    private WebElement buttonSummerDresses;

    /*
     *  Elements form side menu on the left
     */
    @FindBy(partialLinkText = "Summer Dresses")
    private WebElement buttonSummerDressesSideM;

    /*
    Elements under CATALOG
     */
    @FindBy(id = "layered_category_11")
    private WebElement chkBoxSummerDresses;
    /*
    Elements under Size
     */
    @FindBy(name = "layered_id_attribute_group_3")
    private WebElement chkBoxLargeSize;
    /*
    Elements under Color
     */
    @FindBy(css = "input[id='#layered_id_attribute_group_13'][style='background: #F39C11']")
    private WebElement chkBoxOrangeColor;

    @FindBy(xpath = "//a[@title= 'Add to cart']")
    private WebElement buttonAddToCart;

    @FindBy(xpath = "//a[@title = 'Proceed to checkout']")
    private WebElement buttonProceedToCheckout;

    @FindBy(xpath = "//a/img[@class='replace-2x img-responsive' or @title ='Printed Dress']")
    private WebElement buttonShopItemImage;

    @FindBy(xpath = "//a[@title= 'View my shopping cart']")
    private WebElement buttonShopCart;

    /*
        Page interaction Methods
     */
    // Get top page navigation title
    public String getLblTopTitle() {
        return lblTopTitle.getText();
    }
    //Sign Out
    public void clickOnSignOut()
    {
        clickButton(buttonSignOut);
    }

    //as it should click on dresses from the top navigation bar
   /*
    public void clickOnDressesTopNav()
    {
        jsClickElementInterchangable(driver,buttonDresses);

        if (waitUntilElementBeClickable(buttonDresses)){
            clickButton(buttonDresses);
        }
    }*/

    // Click on (Summer Dresses) from top breadcrumb
    public void clickOnSummerDressesFTopNav()
    {
        if (waitUntilElementBeClickable(buttonSummerDresses)){
            clickButton(buttonSummerDresses);
        }
    }

    // Click on (Summer Dresses) from side menu
    public void clickOnSummerDressesFSideMenu()
    {
        if (waitUntilElementBeClickable(buttonSummerDressesSideM)){
            clickButton(buttonSummerDressesSideM);
        }
    }

    // Check (Summer Dresses) checkBox from  side menu
    public void checkSummerDresses()
    {
        if (waitUntilElementBeClickable(chkBoxSummerDresses)){
            clickButton(chkBoxSummerDresses);
        }
    }

    // Check (Large Size) checkBox from  side menu under sizes
    public void checkLargeSize()
    {
        if (waitUntilElementBeClickable(chkBoxLargeSize)){
            clickButton(chkBoxLargeSize);
        }
    }

    // Check (Large Size) checkBox from  side menu under sizes
    public void checkOrangeColor()
    {
        if (waitUntilElementBeClickable(chkBoxOrangeColor)){
            clickButton(chkBoxOrangeColor);
        }

    }
    //Click on Add To Cart
    public void clickOnAddToCart(){
        clickButton(buttonAddToCart);
    }
    //Click on Proceed To Checkout
    public void clickOnProceedToCheckout(){
        clickButton(buttonProceedToCheckout);
    }

    //Click on Shop Item Image
    public void clickOnShopItemImage(){
        clickButton(buttonShopItemImage);
    }

    public void clickOnShopCart(){clickButton(buttonShopCart);}

    public void searchDressessShoppingItem(){

        clickOnSummerDressesFSideMenu();
        checkSummerDresses();
        checkLargeSize();
        checkOrangeColor();
        clickOnShopItemImage();
        clickOnAddToCart();
        clickOnProceedToCheckout();
    }
}
