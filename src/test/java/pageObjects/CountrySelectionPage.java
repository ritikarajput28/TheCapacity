package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.*;

public class CountrySelectionPage {

    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    public CountrySelectionPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.actions = new Actions(driver);
    }

    // 🔹 Country autocomplete input
    private By countryInput = By.id("checkboxes-tags-demo-country");

    // 🔹 All dropdown options (MUI standard)
    private By countryOptions = By.xpath("//li[@role='option']");

    public void selectRandomCountries(int count) {

        // Click input to open dropdown
        WebElement input = wait.until(ExpectedConditions.elementToBeClickable(countryInput));
        input.click();

        // Wait until options appear
        List<WebElement> options =
                wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(countryOptions));

        if (options.size() < count) {
            throw new RuntimeException("Not enough country options available");
        }

        // Shuffle list to randomize
        Collections.shuffle(options);

        // Select random countries
        for (int i = 0; i < count; i++) {
            WebElement option = options.get(i);

            // Scroll to option (MUI safety)
            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].scrollIntoView({block:'center'});", option);

            // JS click (most reliable for MUI)
            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].click();", option);

            // Small delay for UI animation
            try { Thread.sleep(300); } catch (InterruptedException ignored) {}
        }
    }
}
