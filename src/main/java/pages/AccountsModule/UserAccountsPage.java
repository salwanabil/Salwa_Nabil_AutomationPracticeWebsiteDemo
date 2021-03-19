package pages.AccountsModule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageBase;

public class UserAccountsPage extends PageBase {
    public UserAccountsPage(WebDriver driver) {
        super(driver);
    }
    //Page Elements
    @FindBy(id = "email_create")
    public WebElement textEmailAddress;

    @FindBy(id = "SubmitCreate")
    public WebElement  buttonCreateAnAccount;

    @FindBy(name = "email")
    public WebElement textSignInEmail;

    @FindBy(id = "passwd")
    public WebElement textSignInPassword;

    @FindBy(id = "SubmitLogin")
    public WebElement buttonSignIn;

    @FindBy(xpath = "//div[@id = 'create_account_error']/ol/li")
    private WebElement errorMessageAlert;

    // Methods
    public void enterEmailAndSignUp(String emailAddress){
        setText(textEmailAddress,emailAddress);
        clickButton(buttonCreateAnAccount);
    }

    public void signInWithEmailAndPassword(String signInEmail , String signInPassword){
        setText(textSignInEmail,signInEmail);
        setText(textSignInPassword , signInPassword);
        clickButton(buttonSignIn);
    }

    //getters
    public WebElement getErrorMessageAlert() {
        return errorMessageAlert;
    }

}
