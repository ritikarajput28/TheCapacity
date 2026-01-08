package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.security.SecureRandom;
import java.time.Duration;

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

    @FindBy(xpath = "//div[@data-fieldtype='answerField']//div[@contenteditable='true']")
    WebElement answerTextBox;

    @FindBy(xpath = "//div[@contenteditable='true']//p[@data-placeholder='Answer']")
    WebElement answerTextBox2;

    @FindBy(xpath = "//div[@contenteditable='true']//p[@data-placeholder='Answer']")
    WebElement answerTextBox3;


    // ===================== INSTRUCTION & DESCRIPTION =====================


    @FindBy(xpath = "//p[normalize-space()='Instructions']//button")
    WebElement instructionsArrowBtn;

    @FindBy(xpath = "//div[@data-fieldtype='instructionsField']//div[@contenteditable='true']")
    WebElement instructionTxtDescription;


    @FindBy(xpath = "//p[normalize-space()='Description']//button")
    WebElement descriptionArrowBtn;

    @FindBy(xpath = "//div[@data-fieldtype='descriptionField']//div[@contenteditable='true']")
    WebElement descriptionTxtDescription;


    // ===================== VALIDATION =====================

    @FindBy(xpath = "//p[normalize-space()='Validation Message']//button")
    WebElement validationMessageArrowBtn;

    @FindBy(xpath = "//div[@data-fieldtype='validationMessageField']//div[@contenteditable='true']")
    WebElement validationMessageField;

    // ===================== PROGRAM INSTRUCTION =====================

    @FindBy(xpath = "//p[normalize-space()=\"Programmer's Instruction\"]//button")
    WebElement programmersInstructionArrowBtn;

    @FindBy(xpath = "//div[@data-fieldtype='programmersInstructionsField']//div[@contenteditable='true']")
    WebElement programmersInstructionsField;


    // ===================== PREVIEW =====================

    @FindBy(xpath = "//*[local-name()='svg' and contains(@class,'bi-phone-flip')]/ancestor::button")
    WebElement phoneFlipBtn;


    // ===================== SAVE =====================

    @FindBy(xpath = "//button[normalize-space()='Save']")
    WebElement saveButton;

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
    public void fillOpenEndField(String questionText) {
        WebElement openEndField = driver.findElement(openEndFieldLocator);

        Actions actions = new Actions(driver);
        actions.moveToElement(openEndField)
                .click()
                .sendKeys(questionText)
                .build()
                .perform();
    }

    public void AnswerOptionOne(String name) {
        answerTextBox.sendKeys(name);
    }

    public void AnswerOptionTwo(String name) {
        answerTextBox2.sendKeys(name);
    }

    public void AnswerOptionThird(String name) {
        answerTextBox3.sendKeys(name);
    }

    public void clickInstructionsArrow() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(instructionsArrowBtn)).click();
    }

    public void clearAndEnterInstructions(String text) {
        Actions actions = new Actions(driver);
        actions.moveToElement(instructionTxtDescription)
                .click()
                .keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .sendKeys(Keys.DELETE)
                .sendKeys(text)
                .perform();
    }

    public void clickDescriptionArrow() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(descriptionArrowBtn)).click();
    }

    public void clearAndEnterDescription(String text) {
        Actions actions = new Actions(driver);
        actions.moveToElement(descriptionTxtDescription)
                .click()
                .keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .sendKeys(Keys.DELETE)
                .sendKeys(text)
                .perform();
    }

    public void clickValidationMessageArrow() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(validationMessageArrowBtn)).click();
    }

    public void clearAndEnterValidation(String text) {
        Actions actions = new Actions(driver);
        actions.moveToElement(validationMessageField)
                .click()
                .keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .sendKeys(Keys.DELETE)
                .sendKeys(text)
                .perform();
    }

    public void clickProgrammersInstructionArrow() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(programmersInstructionArrowBtn)).click();
    }


    public void clearAndEnterProgramInstruction(String text) {
        Actions actions = new Actions(driver);
        actions.moveToElement(programmersInstructionsField)
                .click()
                .keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .sendKeys(Keys.DELETE)
                .sendKeys(text)
                .perform();
    }


    public void clickSaveButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[normalize-space()='Save']")));
        if (saveButton.isEnabled()) {
            wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();
            System.out.println("Save button clicked successfully.");
        } else {
            Assert.fail("Save button is disabled! Test cannot proceed.");
        }

    }

    public boolean isQuestionSavedSuccessfully() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.xpath("//*[contains(text(),'Question Saved')]")
                    )
            );

            return true;

        } catch (TimeoutException e) {
            return false;
        }
    }

    public void clickPhoneFlip() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//*[local-name()='svg' and contains(@class,'bi-phone-flip')]")
        ));

        wait.until(ExpectedConditions.elementToBeClickable(phoneFlipBtn));

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", phoneFlipBtn);
    }


    //==========================================ANSWERS ORDERS===============================================================================================


    @FindBy(xpath = "//span[normalize-space()='Instruction']/ancestor::div[contains(@class,'MuiAccordion')]//svg")
    WebElement ArrowIcon;


    public void clickArrowIcon() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(ArrowIcon));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", ArrowIcon);
    }


    // Randomize radio button
    @FindBy(xpath = "//input[@type='radio' and @value='1']")
    private WebElement radioRandomize;

    // Rotational radio button
    @FindBy(xpath = "//input[@type='radio' and @value='2']")
    private WebElement radioRotational;

    // Alphabetical radio button
    @FindBy(xpath = "//input[@type='radio' and @value='3']")
    private WebElement radioAlphabetical;


    private void jsClick(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public void selectRandomizeOption() {
        jsClick(radioRandomize);
    }

    public void selectRotationalOption() {
        jsClick(radioRotational);
    }

    public void selectAlphabeticalOption() {
        jsClick(radioAlphabetical);
    }
}



