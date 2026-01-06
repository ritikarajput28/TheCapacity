package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.*;

public class LanguageSelectionDropdown {

    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    public LanguageSelectionDropdown(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.actions = new Actions(driver);
    }

    // 🔹 Autocomplete input
    private By languageInput = By.id("checkboxes-tags-demo");

    // 🔹 All dropdown options
    private By languageOptions = By.xpath("//li[@role='option']");

    public void selectRandomLanguages(int count) {

        // Click on input
        WebElement input = wait.until(ExpectedConditions.elementToBeClickable(languageInput));
        input.click();

        // Wait until options are visible
        List<WebElement> options =
                wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(languageOptions));

        if (options.size() < count) {
            throw new RuntimeException("Not enough options in dropdown");
        }

        // Shuffle options
        Collections.shuffle(options);

        // Select random values
        for (int i = 0; i < count; i++) {
            WebElement option = options.get(i);

            // Scroll + click (important for MUI)
            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].scrollIntoView(true);", option);

            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].click();", option);

            // Small wait for animation
            try { Thread.sleep(300); } catch (InterruptedException ignored) {}
        }
    }
}

