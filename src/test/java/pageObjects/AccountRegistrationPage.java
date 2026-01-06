package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountRegistrationPage extends BasePage {

    public AccountRegistrationPage (WebDriver driver)
    {
        super(driver);
    }

    @FindBy(xpath = "//input[@placeholder='Enter Account Name']")
    WebElement accountNameInput;

    @FindBy(xpath = "//input[@placeholder='Enter Customer Name']")
    WebElement customerNameInput;

    @FindBy(xpath = "//input[@placeholder='Enter Email ID']")
    WebElement emailInput;

    @FindBy(xpath = "//input[@placeholder='Enter Phone Number']")
    WebElement phoneInput;

    @FindBy(xpath = "//label[normalize-space()='Financial Year']/following-sibling::div//div[@role='combobox']")
    WebElement financialYearDropdown;

    @FindBy(xpath = "//button[normalize-space()='Next']")
    WebElement nextButton;

    public void enterAccountName(String accountName) {
        accountNameInput.clear();
        accountNameInput.sendKeys(accountName);
    }

    public void enterCustomerName(String customerName) {
        customerNameInput.clear();
        customerNameInput.sendKeys(customerName);
    }

    public void enterEmail(String email) {
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    public void enterPhone(String phone) {
        phoneInput.clear();
        phoneInput.sendKeys(phone);
    }

    public void selectFinancialYear(String year) {

        // Open dropdown
        wait.until(ExpectedConditions.elementToBeClickable(financialYearDropdown)).click();

        // Select value from listbox
        WebElement option = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//ul[@role='listbox']//li[normalize-space()='" + year + "']")
                )
        );
        option.click();
    }

    // Get selected Financial Year text
    public String getSelectedFinancialYear() {
        return wait.until(ExpectedConditions.visibilityOf(financialYearDropdown)).getText();
    }

    public boolean isNextButtonEnabled() {
        return nextButton.isEnabled();
    }

    public void clickNext() {
        nextButton.click();
    }

}
