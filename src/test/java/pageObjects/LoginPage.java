package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    public LoginPage (WebDriver driver)
    {
        super(driver);
    }

    @FindBy(xpath = "//input[@placeholder='Enter your email address']")
    WebElement emailTxt;

    @FindBy(xpath = "//input[@placeholder='Enter password']")
    WebElement passwordTxt;

    @FindBy(xpath = "//button[normalize-space()='Sign in']")
    WebElement signInBtn;

    public void enterEmail(String email) {
        emailTxt.sendKeys(email);
    }

    public void enterPassword(String pwd) {
        passwordTxt.sendKeys(pwd);
    }

    public void clickSignIn() {
        signInBtn.click();
    }

}
