package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Dashboard extends BasePage {

    public Dashboard(WebDriver driver) {
        super(driver);
    }

    // Locators
    @FindBy(xpath = "//input[@placeholder='Enter password']")
    WebElement passwordTxt;

    @FindBy(xpath = "//span[text()='Dashboard']")
    WebElement dashboardMenu;

    @FindBy(xpath = "//span[text()='Survey']")
    WebElement surveyMenu;

    @FindBy(xpath = "//span[text()='Support']")
    WebElement supportMenu;

    @FindBy(xpath = "//h5[contains(text(),'50,000')]")
    WebElement activeUsersCard;

    @FindBy(xpath = "//span[normalize-space()='Survey Listing']")
    WebElement surveyClicksCard;

    @FindBy(xpath = "//h5[contains(text(),'18%')]")
    WebElement clickRateCard;

    @FindBy(xpath = "//h5[contains(text(),'300')]")
    WebElement completesCard;

    @FindBy(xpath = "//img[@alt='Capacity Logo']")
    WebElement capacityLogo;

    @FindBy(xpath = "//div[contains(@class,'MuiAvatar-root')]")
    WebElement userAvatar;

    @FindBy(xpath = "//li[normalize-space()='Logout']")
    WebElement logoutBtn;

    // Actions / Methods
    public void enterPassword(String password) {
        passwordTxt.clear();
        passwordTxt.sendKeys(password);
    }

    public void clickDashboardMenu() {
        dashboardMenu.click();
    }

    public void clickSurveyMenu() {
        surveyMenu.click();
    }

    public void clickSupportMenu() {
        supportMenu.click();
    }

    public String getActiveUsers() {
        return activeUsersCard.getText();
    }

    public void clickSurveyListing() {
         surveyClicksCard.click();
    }

    public String getClickRate() {
        return clickRateCard.getText();
    }

    public String getCompletes() {
        return completesCard.getText();
    }

    public void clickUserAvatar() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(userAvatar));
        userAvatar.click();
    }

    public void clickLogout() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(logoutBtn));
        logoutBtn.click();
    }

    public boolean DisplayedLogo() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(capacityLogo));
            return capacityLogo.isDisplayed();
        }
        catch (Exception e)
        {
            return false;
        }
    }
}
