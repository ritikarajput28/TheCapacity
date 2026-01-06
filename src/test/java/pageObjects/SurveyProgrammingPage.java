package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.security.SecureRandom;
import java.time.Duration;
import java.util.List;

public class SurveyProgrammingPage extends BasePage {

    public SurveyProgrammingPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @FindBy(xpath = "//button[normalize-space()='+ Add new question']")
    WebElement btnAddNewQuestion;


    // ===================== ANSWERS =====================

    @FindBy(xpath = "//button[normalize-space()='Add Answers']")
    WebElement btnAddAnswer;

    @FindBy(xpath = "//input[@placeholder='Enter answer option']")
    List<WebElement> txtAnswers;
    
    

    // ===================== INSTRUCTION & DESCRIPTION =====================

    @FindBy(xpath = "//textarea[@placeholder='Enter instruction']")
    WebElement txtInstruction;

    @FindBy(xpath = "//textarea[@placeholder='Enter description']")
    WebElement txtDescription;

    // ===================== VALIDATION =====================

    @FindBy(xpath = "//input[@placeholder='Enter validation message']")
    WebElement txtValidationMessage;

    // ===================== PROGRAM INSPECTION =====================

    @FindBy(xpath = "//span[text()='Program Inspection']/preceding::input[@type='checkbox'][1]")
    WebElement chkProgramInspection;

    // ===================== PROVIDE =====================

    @FindBy(xpath = "//button[@aria-label='Preview']//*[name()='svg']")
    WebElement Preview;

    // ===================== SAVE =====================

    @FindBy(xpath = "//button[normalize-space()='Save']")
    WebElement btnSave;

    // ======================================================
    // ===================== ACTION METHODS =================
    // ======================================================

    public void clickAddNewQuestionSimple() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(btnAddNewQuestion)).click();

    }

    public void btnAddAnswer() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(btnAddAnswer)).click();

    }

    public WebElement getBtnAddAnswer() {
        return btnAddAnswer;
    }


    private By openEndFieldLocator = By.xpath("//p[@data-placeholder='Question']");

    // Generate random alphanumeric string of given length
    private String generateRandomText(int length) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(chars.charAt(random.nextInt(chars.length())));
        }
        return sb.toString();
    }

    // Fill the open-end field
    public void fillOpenEndField() {
        WebElement openEndField = driver.findElement(openEndFieldLocator); // Locate element at runtime
        String randomText = generateRandomText(50); // up to 50 chars

        // Use Actions to click and type
        Actions actions=new Actions(driver);
        actions.moveToElement(openEndField)
                .click()
                .sendKeys(randomText)
                .build()
                .perform();
    }
}



