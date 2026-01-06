package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AdminDashboard;
import pageObjects.Dashboard;
import pageObjects.LoginPage;
import utilities.DataProviders;

import java.util.logging.Logger;

public class TC002_LoginTest extends BaseClass {

    @Test
    public void verify_login() {
        
        //login page
        logger.info("===Starting Testing of Login Page===");

            LoginPage lp = new LoginPage(driver);

            logger.info("===Entering email===");
            lp.enterEmail(p.getProperty("email"));

            logger.info("===Entering password===");
            lp.enterPassword(p.getProperty("password"));

            lp.clickSignIn();
            //dashboard page
            Dashboard dashboard = new Dashboard(driver);
            boolean targetPage = dashboard.DisplayedLogo();
            Assert.assertTrue(targetPage, "Login failed: Dashboard logo not displayed");

        /*} catch (Exception e) {
            Assert.fail("Login test failed due to exception: " + e.getMessage(), e);
        }*/
            logger.info("===Sign in successfully===");

    }
}
