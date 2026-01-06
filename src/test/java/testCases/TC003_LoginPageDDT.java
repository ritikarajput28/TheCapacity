package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Dashboard;
import pageObjects.LoginPage;
import utilities.DataProviders;

public class TC003_LoginPageDDT extends BaseClass {
    @Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
    public void verify_login(String email, String pwd, String exp) {

        //login page
        logger.info("===Starting Testing of Login Page===");
            try {
                LoginPage lp = new LoginPage(driver);

                logger.info("===Entering email===");
                lp.enterEmail(email);

                logger.info("===Entering password===");
                lp.enterPassword(pwd);

                lp.clickSignIn();
                //dashboard page
                Dashboard dashboard = new Dashboard(driver);
                boolean targetPage = dashboard.DisplayedLogo();

                if (exp.equalsIgnoreCase("valid")) {
                    if (targetPage == true) {
                        dashboard.clickUserAvatar();
                        dashboard.clickLogout();
                        Assert.assertTrue(true);
                    } else {
                        driver.navigate().refresh();
                        Assert.assertTrue(false);
                    }
                } else {
                    if (targetPage == true)
                    {
                        dashboard.clickUserAvatar();
                        dashboard.clickLogout();
                        Assert.assertTrue(false);
                    } else {
                        driver.navigate().refresh();
                        Assert.assertTrue(true);
                    }
                }
            }
            catch (Exception e)
            {
                Assert.fail();
            }


    }
}
