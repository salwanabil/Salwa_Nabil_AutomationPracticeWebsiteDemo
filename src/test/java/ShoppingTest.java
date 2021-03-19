import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.DashboardPage;
import pages.LandingPage;
import pages.AccountsModule.UserAccountsPage;
import utils.PropertiesReader;

public class ShoppingTest extends TestBase {
    LandingPage         landingPageObj = null;
    DashboardPage       dashboardPageObj = null;
    UserAccountsPage    userAccountsPageObj = null;
    String loginEmail = PropertiesReader.getProperty("liveAutomationPractice.properties","signUpEmail");
    String loginPassword = PropertiesReader.getProperty("liveAutomationPractice.properties",
            "emailPassword") ;

    @BeforeClass
    public void initPageObject(){
        landingPageObj          = new LandingPage(driver);
        dashboardPageObj        = new DashboardPage(driver);
        userAccountsPageObj     = new UserAccountsPage(driver);
    }

    @Test(description = "Shops Summer Dresses Large Size Orange Color")
    public void userShopsSummerDressesLargeSizeOrangeColor(){

        landingPageObj.clickOnSignIn();
        userAccountsPageObj.signInWithEmailAndPassword(loginEmail, loginPassword);
        System.out.println("Hi + : " + loginEmail + " Logged in");

        if (dashboardPageObj.getButtonDresses().isEnabled()){
            JavascriptExecutor executor = (JavascriptExecutor)driver;
            executor.executeScript("arguments[0].click();",dashboardPageObj.getButtonDresses());
        }


        dashboardPageObj.clickOnSummerDressesFSideMenu();
        System.out.println("Hi + : clickOnSummerDressesFSideMenu in");

    }
}
