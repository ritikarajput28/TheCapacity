package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.AdminDashboard;
import pageObjects.LoginPage;
import pageObjects.ManageCustomer;

public class loginfo extends BaseClass {

    @Test
    public void verify_account_registration() {

        try {
            logger.info("===== Starting Account Registration Test =====");

            LoginPage lp = new LoginPage(driver);
            logger.info("Entering email");
            lp.enterEmail("akshay.singh@irbureau.com");

            logger.info("Entering password");
            lp.enterPassword("irb1234");

            logger.info("Clicking Sign In");
            lp.clickSignIn();

            AdminDashboard ad = new AdminDashboard(driver);
            logger.info("Navigating to Manage Customers");
            ad.clickCustomer();
            ad.clickManageCustomers();

            ManageCustomer mc = new ManageCustomer(driver);
            logger.info("Clicking Add New Customer");
            mc.clickNewCustomer();

            AccountRegistrationPage ac1 = new AccountRegistrationPage(driver);

            logger.info("Entering Account Name");
            ac1.enterAccountName(randomstring());

            logger.info("Entering Customer Name");
            ac1.enterCustomerName(randomstring());

            logger.info("Entering Email");
            ac1.enterEmail(randomstring() + "@gmail.com");

            logger.info("Entering Phone Number");
            ac1.enterPhone(randomNumber());

            logger.info("Selecting Financial Year");
            ac1.selectFinancialYear("Jan - Dec");

            Assert.assertEquals(
                    ac1.getSelectedFinancialYear(),
                    "Jan - Dec",
                    "Financial Year selection failed"
            );
            logger.info("Financial Year selected successfully");

            Assert.assertTrue(ac1.isNextButtonEnabled(), "Next button is not enabled");
            logger.info("Next button is enabled");

            logger.info("Clicking Next button");
            ac1.clickNext();

            logger.info("===== Account Registration Test Completed Successfully =====");
        }
        catch (Exception e) {
            logger.error("Test Failed...");
            logger.debug("Debug Failed...");
            Assert.fail();
        }
    }
}
