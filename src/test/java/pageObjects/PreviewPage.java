package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class PreviewPage extends BasePage {

    WebDriver driver;

    public PreviewPage (WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    // ================= QUESTION =================

    // Example text: "Q105. dheiwhdowo"
    @FindBy(xpath = "//h6[contains(@class,'rich-html')]")
    private WebElement questionText;

    // ================= INSTRUCTION =================

    // First paragraph after question block

    @FindBy(xpath = "(//p[contains(@class,'rich-html')])[1]")
    private WebElement instructionText;



    // ================= DESCRIPTION =================

    // Second paragraph after instruction

    @FindBy(xpath = "(//p[contains(@class,'rich-html')])[2]")
    private WebElement descriptionText;



    // ================= ANSWER OPTIONS =================

    @FindBy(xpath = "//label[contains(@class,'MuiFormControlLabel-root')]//span[contains(@class,'rich-html')]")
    private List<WebElement> answerOptions;




    // ================= METHODS =================
    public String getPreviewQuestionText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(questionText));
        return questionText.getText().trim();
    }

    public String getPreviewInstructionText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(instructionText));
        return instructionText.getText().trim();
    }

    public String getPreviewDescriptionText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(descriptionText));
        return descriptionText.getText().trim();
    }


    public List<String> getPreviewAnswers() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        By answersLocator = By.xpath(
                "//label[contains(@class,'MuiFormControlLabel-root')]//span[contains(@class,'rich-html')]"
        );

        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(answersLocator, 0));

        List<WebElement> options = driver.findElements(answersLocator);

        List<String> answers = new ArrayList<>();
        for (WebElement option : options) {
            answers.add(option.getText().replaceAll("\\s+", " ").trim());
        }

        return answers;
    }

}



