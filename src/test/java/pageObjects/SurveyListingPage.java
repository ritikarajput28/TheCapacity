package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SurveyListingPage extends BasePage{

    public SurveyListingPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @FindBy(xpath = "//button[starts-with(normalize-space(),'SURV')]")
    WebElement surveyCodeButton;

    public void clickSurveyCode() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(surveyCodeButton)).click();
    }

    @FindBy(xpath = "//span[normalize-space()='Survey Programming']")
    WebElement surveyProgrammingOption;

    public void clickSurveyProgramming() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//span[normalize-space()='Survey Programming']")
                )
        );
        element.click();
    }


    private By loader = By.className("bprogress");
    private By newSurvey =
            By.xpath("//button[normalize-space()='Add New Survey']");

    public void clickNewSurvey() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        // Wait for loader to disappear (if present)
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
        } catch (Exception ignored) {}

        // Wait for button to be visible
        WebElement addBtn = wait.until(
                ExpectedConditions.visibilityOfElementLocated(newSurvey)
        );

        // Scroll into view (MUI safety)
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block:'center'});", addBtn);

        // Click using JS (best for MUI)
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", addBtn);
    }





}


