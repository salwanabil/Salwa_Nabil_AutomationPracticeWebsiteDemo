package pages.AccountsModule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageBase;

public class CreateAccountPage extends PageBase {
    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }
    /*
        GUI Elements of Create account page
     */

    public String getLableAUTHENTICATION() {
         return lableAUTHENTICATION.getText();
    }

    @FindBy(xpath = "//*[@id=\"noSlide\"]/h1")
    private WebElement lableAUTHENTICATION;

    @FindBy(id = "customer_firstname")
    private WebElement textCusFirstName;

    @FindBy(id = "customer_lastname")
    private WebElement textCusLastName;

    @FindBy(id = "email")
    private WebElement textCusEmail;

    @FindBy(id = "passwd")
    private WebElement textCusPassword;

    @FindBy(id = "days")
    private WebElement selectDayOfBirth;

    @FindBy(id = "months")
    private WebElement selectMonthOfBirth;

    @FindBy(id = "years")
    private WebElement selectYearOfBirth;
    /*
        Elements of shipment address
    */

    @FindBy(id = "firstname")
    private WebElement textFirstName;

    @FindBy(id = "lastname")
    private WebElement textLastName;

    @FindBy(id = "address1")
    private WebElement textAddress;

    @FindBy(id = "city")
    private WebElement textCity;

    @FindBy(id = "id_state")
    private WebElement selectState;

    @FindBy(id = "postcode")
    private WebElement textZipPostalCode;

    @FindBy(id = "id_country")
    private WebElement selectCountry;

    @FindBy(id = "phone_mobile")
    private WebElement textMobilePhone;

    @FindBy(id = "alias")
    private WebElement textAddressAlias;

    @FindBy(id = "submitAccount")
    private WebElement buttonRegister;

    public void createNewAccountWithEmail(String strCusFirstName, String strCusLastName, String strCusEmail,
                                 String strCusPassword,String strDayOfBirth,String strMonthOfBirth,
                                 String strYearOfBirth, String strFirstName, String strLastName,
                                 String strAddress, String strCity,String strState, String strZipCode,
                                 String strMobilePhone, String strAddressAlias){
        setText(textCusFirstName,strCusFirstName);
        setText(textCusLastName,strCusLastName);
        setText(textCusEmail,strCusEmail);
        setText(textCusPassword,strCusPassword);
        statusDropDownList(driver,selectDayOfBirth,strDayOfBirth);
        statusDropDownList(driver,selectMonthOfBirth, strMonthOfBirth);
        statusDropDownList(driver,selectYearOfBirth,strYearOfBirth);
        setText(textFirstName,strFirstName);
        setText(textLastName,strLastName);
        setText(textAddress,strAddress);
        setText(textCity,strCity);
        setText(textCity,strCity);
        statusDropDownList(driver,selectState,strState);
        setText(textZipPostalCode,strZipCode);
        statusDropDownList(driver,selectCountry,"United States");
        setText(textMobilePhone,strMobilePhone);
        setText(textAddressAlias,strAddressAlias);
        clickButton(buttonRegister);
    }

    public void createNewAccountWithOutEmail(String strCusFirstName, String strCusLastName,
                                          String strCusPassword,String strDayOfBirth,String strMonthOfBirth,
                                          String strYearOfBirth, String strFirstName, String strLastName,
                                          String strAddress, String strCity,String strState, String strZipCode,
                                          String strMobilePhone, String strAddressAlias){
        setText(textCusFirstName,strCusFirstName);
        setText(textCusLastName,strCusLastName);
        setText(textCusPassword,strCusPassword);
        selectDropDownListByValue(driver,selectDayOfBirth,strDayOfBirth);
        selectDropDownListByValue(driver,selectMonthOfBirth, strMonthOfBirth);
        selectDropDownListByValue(driver,selectYearOfBirth,strYearOfBirth);
        setText(textFirstName,strFirstName);
        setText(textLastName,strLastName);
        setText(textAddress,strAddress);
        setText(textCity,strCity);
        statusDropDownList(driver,selectState,strState);
        setText(textZipPostalCode,strZipCode);
        selectDropDownListByValue(driver,selectCountry,"21");
        setText(textMobilePhone,strMobilePhone);
        setText(textAddressAlias,strAddressAlias);
        clickButton(buttonRegister);
    }

    public void createNewAccount1(String strCusFirstName, String strCusLastName,String strCusPassword,
                                  String strDayOfBirth,String strMonthOfBirth,String strYearOfBirth,
                                             String strAddress, String strCity,String strState, String strZipCode,
                                             String strMobilePhone, String strAddressAlias){
        setText(textCusFirstName,strCusFirstName);
        setText(textCusLastName,strCusLastName);
        setText(textCusPassword,strCusPassword);
        selectDropDownListByValue(driver,selectDayOfBirth,strDayOfBirth);
        selectDropDownListByValue(driver,selectMonthOfBirth, strMonthOfBirth);
        selectDropDownListByValue(driver,selectYearOfBirth,strYearOfBirth);

        setText(textAddress,strAddress);
        setText(textCity,strCity);
        setText(textCity,strCity);
        statusDropDownList(driver,selectState,strState);
        setText(textZipPostalCode,strZipCode);
        setText(textMobilePhone,strMobilePhone);
        setText(textAddressAlias,strAddressAlias);
        clickButton(buttonRegister);
    }
}
