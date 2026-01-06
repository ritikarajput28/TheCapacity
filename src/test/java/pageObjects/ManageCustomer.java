package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ManageCustomer extends BasePage {

    public ManageCustomer (WebDriver driver)
    {
        super(driver);
        this.driver = driver;
    }

    private By addNewCustomerBtn =
            By.xpath("//a[contains(@href,'add-customer')]//button");

    // Loader
    private By loader = By.className("bprogress");

    public void clickNewCustomer() {

        // wait till loader disappears
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));

        WebElement addBtn =
                wait.until(ExpectedConditions.elementToBeClickable(addNewCustomerBtn));

        addBtn.click();
    }

}

