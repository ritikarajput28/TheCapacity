package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.security.SecureRandom;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
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

    @FindBy(xpath = "//div[@data-fieldtype='answerField']//div[@contenteditable='true']")
    WebElement answerTextBox;

    @FindBy(xpath = "//div[@contenteditable='true']//p[@data-placeholder='Answer']")
    WebElement answerTextBox2;

    @FindBy(xpath = "//div[@contenteditable='true']//p[@data-placeholder='Answer']")
    WebElement answerTextBox3;

    @FindBy(xpath = "//div[@contenteditable='true']//p[@data-placeholder='Answer']")
    WebElement answerTextBox4;

    @FindBy(xpath = "//div[@contenteditable='true']//p[@data-placeholder='Answer']")
    WebElement answerTextBox5;

    @FindBy(xpath = "//div[@contenteditable='true']//p[@data-placeholder='Answer']")
    WebElement answerTextBox6;

    @FindBy(xpath = "//div[@contenteditable='true']//p[@data-placeholder='Answer']")
    WebElement answerTextBox7;

    @FindBy(xpath = "//div[@contenteditable='true']//p[@data-placeholder='Answer']")
    WebElement answerTextBox8;

    @FindBy(xpath = "//div[@contenteditable='true']//p[@data-placeholder='Answer']")
    WebElement answerTextBox9;

    @FindBy(xpath = "//div[@contenteditable='true']//p[@data-placeholder='Answer']")
    WebElement answerTextBox10;


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

    public void AnswerOptionFourth(String name) {
        answerTextBox4.sendKeys(name);
    }

    public void AnswerOptionFifth(String name) {
        answerTextBox5.sendKeys(name);
    }

    public void AnswerOptionSixth(String name) {
        answerTextBox6.sendKeys(name);
    }

    public void AnswerOptionSeventh(String name) {
        answerTextBox7.sendKeys(name);
    }

    public void AnswerOptionEight(String name) {
        answerTextBox8.sendKeys(name);
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


    public String getInstructionText() {
        return instructionTxtDescription.getAttribute("innerText").trim();
    }

    public String getDescriptionText() {
        return descriptionTxtDescription.getAttribute("innerText").trim();
    }

    public String getQuestionText() {
        WebElement question = driver.findElement(openEndFieldLocator);
        return question.getAttribute("innerText").trim();
    }


    //==========================================ANSWERS ORDERS===============================================================================================


    @FindBy(xpath = "//h6[contains(text(),'Answer Order')]/following::button[@type='button'][descendant::*[@data-testid='KeyboardArrowDownIcon']]")
    private WebElement answerOrderArrowBtn;

    public void expandAnswerOrderSection() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // 1. Handle Iframe if necessary (Uncomment if the element is in a frame)
        // driver.switchTo().frame("frame_id_or_name");

        try {
            // 2. Wait for the element to be present in the DOM
            wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//h6[contains(text(),'Answer Order')]/following::button[descendant::*[@data-testid='KeyboardArrowDownIcon']]")
            ));

            // 3. Scroll to center to ensure it's not blocked by sticky headers
            js.executeScript("arguments[0].scrollIntoView({block:'center'});", answerOrderArrowBtn);

            // 4. Brief pause for stability before the click
            Thread.sleep(500);

            // 5. JavaScript click to bypass transparent MUI overlays
            js.executeScript("arguments[0].click();", answerOrderArrowBtn);

            System.out.println("Answer Order dropdown expanded.");

            // 6. Optional: Switch back to main content if you switched to a frame
            // driver.switchTo().defaultContent();

        } catch (Exception e) {
            throw new RuntimeException("Could not expand Answer Order: " + e.getMessage());
        }
    }

    // Randomize radio button


    @FindBy(xpath = "//span[text()='Randomize']/preceding-sibling::span//input[@type='radio']")
    private WebElement radioRandomize;

    public void clickRandomizeOption() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        try {
            // 1. Wait for presence first (DOM exists)
            wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//span[text()='Randomize']/preceding-sibling::span//input[@type='radio']")));

            // 2. Wait for visibility (Animation finished)
            wait.until(ExpectedConditions.visibilityOf(radioRandomize));

            // 3. Final JS Click
            js.executeScript("arguments[0].click();", radioRandomize);
            System.out.println("Randomize option selected successfully.");

        } catch (TimeoutException e) {
            // Fallback: If visibility fails, try clicking the label 'Randomize' directly
            WebElement label = driver.findElement(By.xpath("//span[text()='Randomize']"));
            js.executeScript("arguments[0].click();", label);
        }
    }


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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait until radio is visible (accordion expanded)
        wait.until(ExpectedConditions.visibilityOf(radioRandomize));

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block:'center'});", radioRandomize);

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", radioRandomize);
    }

    public void selectRotationalOption() {
        jsClick(radioRotational);
    }

    public void selectAlphabeticalOption() {
        jsClick(radioAlphabetical);
    }


//===========================================Answer Properties==================================================


    @FindBy(xpath = "//span[normalize-space()='Do not randomize']")
    WebElement DoNotRandomize;

    @FindBy(xpath = "//span[normalize-space()='Sub Heading']")
    WebElement SubHeading;

    @FindBy(xpath = "//span[normalize-space()='Hidden']")
    WebElement Hidden;

    @FindBy(xpath = "//span[normalize-space()='None of the above']")
    WebElement NoneOfTheAbove;

    @FindBy(xpath = "//span[normalize-space()='Terminate']")
    WebElement Terminate;


    public void clickDoNotRandomize() {
        DoNotRandomize.click();
    }

    public void clickSubHeading() {
        SubHeading.click();
    }

    public void clickHidden() {
        Hidden.click();
    }

    public void clickNoneOfTheAbove() {
        NoneOfTheAbove.click();
    }

    public void clickTerminate() {
        Terminate.click();
    }



   /* @FindBy(xpath = "(//p[@data-placeholder='Answer'])[1]")
    WebElement answerOne;

    @FindBy(xpath = "(//p[@data-placeholder='Answer'])[2]")
    WebElement answerTwo;

    @FindBy(xpath = "(//p[@data-placeholder='Answer'])[3]")
    WebElement answerThree;

    @FindBy(xpath = "(//p[@data-placeholder='Answer'])[3]")
    WebElement answerForth;

    @FindBy(xpath = "(//p[@data-placeholder='Answer'])[3]")
    WebElement answerFifth;

    @FindBy(xpath = "(//p[@data-placeholder='Answer'])[3]")
    WebElement answerSixth;

    @FindBy(xpath = "(//p[@data-placeholder='Answer'])[3]")
    WebElement answerSeven;

    @FindBy(xpath = "(//p[@data-placeholder='Answer'])[3]")
    WebElement answerEight;

    public void clickAnswerOne() {
        answerOne.click();
    }

    public void clickAnswerTwo() {
        answerTwo.click();
    }

    public void clickAnswerThree() {
        answerThree.click();
    }

    public void clickAnswerFourth() {
        answerForth.click();
    }

    public void clickAnswerFifth() {
        answerFifth.click();
    }

    public void clickAnswerSixth() {
        answerSixth.click();
    }

    public void clickAnswerSeven() {
        answerSeven.click();
    }

    public void clickAnswerEight() {
        answerEight.click();
    }
*/

    public void ClickAnswerOptionOne() {
        answerTextBox.click();
    }

    @FindBy(xpath = "//div[contains(@class,'ProseMirror') and @contenteditable='true']")
    List<WebElement> answerEditors;

    public void clickAnswerByIndex(int index) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElements(answerEditors));

        WebElement editor = answerEditors.get(index - 1);

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView(true);" +
                        "arguments[0].focus();" +
                        "arguments[0].click();",
                editor
        );
    }



}







