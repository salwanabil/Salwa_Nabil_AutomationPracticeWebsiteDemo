import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AccountsModule.CreateAccountPage;
import pages.DashboardPage;
import pages.LandingPage;
import pages.AccountsModule.UserAccountsPage;
import utils.FakerGeneration;
import utils.PropertiesReader;

public class UserLoginTest extends TestBase{
    LandingPage         landingPageObj  = null;
    UserAccountsPage    userAccountsObj = null;
    CreateAccountPage   createAccountPageObj = null;
    FakerGeneration     fakerObj = null;
    DashboardPage       dashboardPageObj = null;
    String loginPassword = PropertiesReader.getProperty("liveAutomationPractice.properties",
            "emailPassword") ;

    @BeforeClass
    public void initPageObject(){
        landingPageObj          = new LandingPage(driver);
        userAccountsObj         = new UserAccountsPage(driver);
        createAccountPageObj    = new CreateAccountPage(driver);
        fakerObj                = new FakerGeneration();
        dashboardPageObj        = new DashboardPage(driver);
    }

    /*
    Test Scenarios: user click Sign Up button
     */
    @Test(description = "Successful Sign Up with Valid mail")
    public void signUpWithValidEmail(){

        landingPageObj.clickOnSignIn();
        userAccountsObj.enterEmailAndSignUp(PropertiesReader.getProperty("liveAutomationPractice.properties",
                "signUpEmail"));
        Assert.assertEquals(createAccountPageObj.getLableAUTHENTICATION(), "AUTHENTICATION");
    }

    @Test(description = "prevent Register With Existing Email in the system.")
    public void preventRegisterWithExistingEmail(){
        landingPageObj.clickOnSignIn();
        userAccountsObj.enterEmailAndSignUp(PropertiesReader.getProperty("liveAutomationPractice.properties",
                "signUpEmail"));
        Assert.assertEquals(userAccountsObj.getErrorMessageAlert().getText(),
                "An account using this email address has already been registered. Please enter a valid password or request a new one.");
    }

    /*
    Test Scenarios: for user click Create new account
     */
    @Test(description = "Successful create New User Account",dependsOnMethods = "signUpWithValidEmail")
    public void createNewUserAccount(){
        createAccountPageObj.createNewAccountWithOutEmail(fakerObj.getFakerFirstName(), fakerObj.getFakerLastName(),
                loginPassword,
                fakerObj.getFakerDayOfBirth(),fakerObj.getFakerMonthOfBirth(),fakerObj.getFakerYearOfBirth(),
                fakerObj.getFakerFirstName(), fakerObj.getFakerLastName(),fakerObj.getFakerAddressName(),
                fakerObj.getFakerCity(),"New York",fakerObj.getFakerZipCode(),
                fakerObj.getFakerMobilePhone(),fakerObj.getFakerAddressAlias());
        Assert.assertEquals(createAccountPageObj.getLableAUTHENTICATION(), "My account");
    }

    /*
    Test Scenarios: for user click Sign In with already Registered mail
     */
    @Test(description = "Successful Sign In with already Registered mail" , groups = "Login")
    public void userSignInWithRegisteredEmail(){
        landingPageObj.clickOnSignIn();
        userAccountsObj.signInWithEmailAndPassword(PropertiesReader.getProperty("liveAutomationPractice.properties",
                "signUpEmail"),
                PropertiesReader.getProperty("liveAutomationPractice.properties",
                        "emailPassword"));
        Assert.assertEquals(dashboardPageObj.getLblTopTitle(),"MY ACCOUNT");
    }


}
