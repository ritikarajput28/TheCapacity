package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

public class BasePage {

    // WebDriver driver;
    WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void waitForElementToBeClickable(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public String generateRandomTextWithSpaces(int maxLength) {
        String characters = "abcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        StringBuilder text = new StringBuilder();

        while (text.length() < maxLength) {
            int wordLength = random.nextInt(6) + 3; // word length 3–8

            for (int i = 0; i < wordLength && text.length() < maxLength; i++) {
                text.append(characters.charAt(random.nextInt(characters.length())));
            }

            if (text.length() < maxLength) {
                text.append(" ");
            }
        }
        return text.toString().trim();

    }
}
