package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AdminDashboard extends BasePage {

    public AdminDashboard (WebDriver driver)
    {
        super(driver);
    }

    @FindBy(xpath = "//span[normalize-space()='Customer']")
    WebElement customer;

    @FindBy(xpath = "//span[normalize-space()='Manage Customers']")
    WebElement manage_customers;

    @FindBy(xpath = "//div[contains(@class,'MuiAvatar-root')]")
    WebElement profileAvatar;

    @FindBy(xpath = "//li[@role='menuitem' and normalize-space()='Logout']")
    WebElement logout;

    @FindBy(xpath = "//img[@alt='Capacity Logo']")
    WebElement capacityLogo;


    public void clickCustomer()
    {
        customer.click();
    }

    public void clickManageCustomers()
    {
        manage_customers.click();
    }

    public void clickProfileAvatar()
    {
        profileAvatar.click();
    }

    public void AccountLogout()
    {
        logout.click();
    }

    public boolean DisplayedLogo() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(capacityLogo));
        return capacityLogo.isDisplayed();
    }

}
