package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountRegistrationSecondPage extends BasePage
{
    public AccountRegistrationSecondPage (WebDriver driver)
    {
        super(driver);
    }


    @FindBy(xpath = "//input[@placeholder='Please Enter registered legal name for billing']")
    WebElement companyNameInput;

    @FindBy(xpath = "//input[@placeholder='Enter Company Domain']")
    WebElement companyDomainInput;

    @FindBy(xpath = "//input[@placeholder='Enter Tax Number']")
    WebElement taxNumberInput;

    @FindBy(xpath = "//input[@placeholder='Enter Address']")
    WebElement companyAddressInput;

    @FindBy(xpath = "//input[@placeholder='Enter City']")
    WebElement cityInput;

    @FindBy(xpath = "//input[@placeholder='Enter country']")
    WebElement countryInput;

    @FindBy(xpath = "//input[@placeholder='Enter state']")
    WebElement stateInput;

    @FindBy(xpath = "//input[@placeholder='Enter pincode']")
    WebElement pinCodeInput;

    // -------- BUTTONS --------

    @FindBy(xpath = "//button[.//p[normalize-space()='Next']]")
    WebElement nextButton;

    // -------- ACTION METHODS --------

    public void enterCompanyName(String companyName) {
        companyNameInput.clear();
        companyNameInput.sendKeys(companyName);
    }

    public void enterCompanyDomain(String domain) {
        companyDomainInput.clear();
        companyDomainInput.sendKeys(domain);
    }

    public void enterTaxNumber(String taxNo) {
        taxNumberInput.clear();
        taxNumberInput.sendKeys(taxNo);
    }

    public void enterCompanyAddress(String address) {
        companyAddressInput.clear();
        companyAddressInput.sendKeys(address);
    }

    public void enterCity(String city) {
        cityInput.clear();
        cityInput.sendKeys(city);
    }

    public void enterCountry(String country) {
        countryInput.clear();
        countryInput.sendKeys(country);
    }

    public void enterState(String state) {
        stateInput.clear();
        stateInput.sendKeys(state);
    }

    public void enterPinCode(String pinCode) {
        pinCodeInput.clear();
        pinCodeInput.sendKeys(pinCode);
    }


    public void clickNext() {
        nextButton.click();
    }
}

