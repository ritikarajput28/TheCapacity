package testCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.AdminDashboard;
import pageObjects.LoginPage;
import pageObjects.ManageCustomer;

import java.time.Duration;

public class TC001_AccountRegistrationTest extends BaseClass {

    @Test
    public void verify_account_registration() {
        LoginPage lp = new LoginPage(driver);
        lp.enterEmail("akshay.singh@irbureau.com");
        lp.enterPassword("irb1234");
        lp.clickSignIn();

        AdminDashboard ad = new AdminDashboard(driver);
        ad.clickCustomer();
        ad.clickManageCustomers();

        ManageCustomer mc = new ManageCustomer(driver);
        mc.clickNewCustomer();

        AccountRegistrationPage ac1 = new AccountRegistrationPage(driver);
        ac1.enterAccountName(randomstring());
        ac1.enterCustomerName(randomstring());
        ac1.enterEmail(randomstring()+"@gmail.com");
        ac1.enterPhone(randomNumber());
        ac1.selectFinancialYear("Jan - Dec");
        Assert.assertEquals(ac1.getSelectedFinancialYear(),
                    "Jan - Dec",
                    "Financial Year selection failed"
            );
        Assert.assertTrue(ac1.isNextButtonEnabled(), "Next button is not enabled");
        ac1.clickNext();

    }


}
