package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountRegistrationThridPage extends BasePage
{
    public AccountRegistrationThridPage (WebDriver driver)
    {
        super(driver);
    }

    // -------- CUSTOMER BRANDING DROPDOWN --------

    @FindBy(xpath = "//label[normalize-space()='Customer Branding']/following::div[@role='combobox'][1]")
    WebElement customerBrandingDropdown;

    // -------- INPUT FIELDS --------

    @FindBy(xpath = "//label[normalize-space()='Helpdesk Email ID']/following::input[1]")
    WebElement helpdeskEmailInput;

    @FindBy(xpath = "//label[normalize-space()='Terms & Conditions Link']/following::input[@type='url'][1]")
    WebElement termsConditionsInput;

    @FindBy(xpath = "//label[normalize-space()='Privacy Link']/following::input[@type='url'][1]")
    WebElement privacyLinkInput;

    // -------- BUTTONS --------


    @FindBy(xpath = "//button[.//p[normalize-space()='Submit']]")
    WebElement submitButton;

    // -------- ACTION METHODS --------

    public void clickCustomerBrandingDropdown() {
        customerBrandingDropdown.click();
    }

    public void selectCustomerBrandingOption(String option) {
        customerBrandingDropdown.click();
        driver.findElement(
                org.openqa.selenium.By.xpath("//li[normalize-space()='" + option + "']")
        ).click();
    }

    public void enterHelpdeskEmail(String email) {
        helpdeskEmailInput.clear();
        helpdeskEmailInput.sendKeys(email);
    }

    public void enterTermsAndConditionsLink(String url) {
        termsConditionsInput.clear();
        termsConditionsInput.sendKeys(url);
    }

    public void enterPrivacyLink(String url) {
        privacyLinkInput.clear();
        privacyLinkInput.sendKeys(url);
    }

    public void clickSubmit() {
        submitButton.click();
    }
}

