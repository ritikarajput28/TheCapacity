package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class CreateSurveyPage extends BasePage {

    public CreateSurveyPage(WebDriver driver) {
        super(driver);
    }

    // ================= BASIC DETAILS =================

    @FindBy(xpath = "//input[@placeholder='Project Name']")
    WebElement txtProjectName;

    @FindBy(xpath = "//input[@placeholder='Select Language']")
    WebElement drpLanguage;

    @FindBy(xpath = "//input[@placeholder='Project Code']")
    WebElement txtProjectCode;

    @FindBy(xpath = "//input[@placeholder='Browser Title']")
    WebElement txtBrowserTitle;

    @FindBy(xpath = "//input[@placeholder='Survey Name']")
    WebElement txtSurveyName;

    @FindBy(xpath = "//div[contains(text(),'Select Survey Type')]")
    WebElement drpSurveyType;

    @FindBy(xpath = "//div[@role='combobox' and contains(text(),'Pending')]")
    WebElement drpSurveyStatus;

    @FindBy(xpath = "//input[@placeholder='Select Country']")
    WebElement drpCountry;

    // ================= BASIC SETTINGS =================

    @FindBy(xpath = "//input[@id='progress-bar-switch']")
    WebElement chkProgressBar;

    @FindBy(xpath = "//input[@id='footer-switch']")
    WebElement chkFooter;

    // ================= SECURITY =================

    @FindBy(xpath = "//h3[text()='Geo IP']/following-sibling::div//span[text()='Yes']")
    WebElement chkGeoIPYes;

    @FindBy(xpath = "//h3[text()='Unique IP']/following-sibling::div//span[text()='Yes']")
    WebElement chkUniqueIPYes;

    @FindBy(xpath = "//h3[text()='Duplicate Id']/following-sibling::div//span[text()='Yes']")
    WebElement chkDuplicateIdYes;

    @FindBy(xpath = "//h3[text()='Re-Entry']/following-sibling::div//span[text()='Yes']")
    WebElement chkReEntryYes;

    @FindBy(xpath = "//h3[text()='Cookie']/following-sibling::div//span[text()='Yes']")
    WebElement chkCookieYes;

    @FindBy(xpath = "//h3[text()='Proxy/VPN']/following-sibling::div//span[text()='Yes']")
    WebElement chkProxyYes;

    // ================= THEME SETTINGS =================

    @FindBy(xpath = "//input[@placeholder='Select Primary Typeface']")
    WebElement drpTypeface;

    @FindBy(xpath = "//input[@placeholder='16']")
    WebElement txtFontSize;

    // ================= ACTION BUTTONS =================

    @FindBy(xpath = "//button[normalize-space()='Clear Values']")
    WebElement btnClearValues;

    @FindBy(xpath = "//button[normalize-space()='Create Survey']")
    WebElement btnCreateSurvey;

    // ================= ACTION METHODS =================

    public void setProjectName(String name) {
        txtProjectName.clear();
        txtProjectName.sendKeys(name);
    }

    public void setProjectCode(String code) {
        txtProjectCode.clear();
        txtProjectCode.sendKeys(code);
    }

    public void setBrowserTitle(String title) {
        txtBrowserTitle.clear();
        txtBrowserTitle.sendKeys(title);
    }

    public void setSurveyName(String surveyName) {
        txtSurveyName.clear();
        txtSurveyName.sendKeys(surveyName);
    }

    public void selectLanguage(String language) {
        drpLanguage.sendKeys(language);
    }

    public void selectCountry(String country) {
        drpCountry.sendKeys(country);
    }

    public void enableProgressBar() {
        if (!chkProgressBar.isSelected()) {
            chkProgressBar.click();
        }
    }

    public void clickClearValues() {
        btnClearValues.click();
    }

    public void clickCreateSurvey() {
        btnCreateSurvey.click();
    }
    /*public void selectQuantitativeSurvey() {
        // Click dropdown
        drpSurveyType.click();

        // Select option
        WebElement option = driver.findElement(
                By.xpath("//li[normalize-space()='Quantitative Survey']")
        );

        option.click();*/

    public void selectSurveyType() {

        // Click the dropdown
        wait.until(ExpectedConditions.elementToBeClickable(drpSurveyType)).click();

        // Get all survey type options
        List<WebElement> options = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(
                        By.xpath("//li[@role='option']")
                )
        );

        // Select random option
        Random rand = new Random();
        WebElement randomOption = options.get(rand.nextInt(options.size()));

        String selectedText = randomOption.getText();
        randomOption.click();

    }
    public boolean isSurveyCreatedSuccessfully(String surveyName) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement successMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'" + surveyName + "') and contains(text(),'added successfully!')]")));
            return successMsg.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

}

