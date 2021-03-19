import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import utils.PropertiesReader;

import java.util.concurrent.TimeUnit;

public class TestBase {
    public static WebDriver driver;
    String baseURL = PropertiesReader.getProperty("liveAutomationPractice.properties",
            "liveAutomationPractice_base_url");

    @BeforeClass
    @Parameters({"browser"})
    public void startDriver(@Optional("chrome") String browserName){

        if (browserName.equalsIgnoreCase("Chrome")) {

            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +
                    "/drivers/chromedriver.exe");
            driver = new ChromeDriver();

        }else if (browserName.equalsIgnoreCase("firefox")) {

            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") +
                    "/drivers/geckodriver.exe");
            driver = new FirefoxDriver();

        }else if (browserName.equalsIgnoreCase("ie")) {

            System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") +
                    "/drivers/IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        }

        driver.manage().window().maximize();
        driver.get(baseURL);
        try {
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        }catch (Exception e){
            System.out.println("Error while loading the page waited <60 second and the page didn't completely loaded");
        }
        //WebDriverWait wait = new WebDriverWait(driver, 10);

    }

    @AfterClass
    public void exitDriver(){
        driver.quit();
    }
}
