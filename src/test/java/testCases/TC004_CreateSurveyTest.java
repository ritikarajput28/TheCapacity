package testCases;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.*;

import java.io.IOException;

public class TC004_CreateSurveyTest extends BaseClass {

    @Test
    public void CreateSurvey() throws IOException {

        logger.info("***** TC004_CreateSurveyTest started *****");

        LoginPage lp = new LoginPage(driver);
        logger.info("Entering email");
        lp.enterEmail(p.getProperty("email"));

        logger.info("Entering password");
        lp.enterPassword(p.getProperty("password"));

        logger.info("Clicking Sign In button");
        lp.clickSignIn();

        Dashboard dashboard = new Dashboard(driver);
        logger.info("Navigating to Survey Listing page");
        dashboard.clickSurveyMenu();
        dashboard.clickSurveyListing();

        SurveyListingPage sl = new SurveyListingPage(driver);
        logger.info("Clicking New Survey button");
        sl.clickNewSurvey();

        LanguageSelectionDropdown ls = new LanguageSelectionDropdown(driver);
        logger.info("Selecting random languages");
        ls.selectRandomLanguages(5);

        logger.info("Closing language dropdown using ESC key");
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ESCAPE).perform();

        CountrySelectionPage cp = new CountrySelectionPage(driver);
        logger.info("Selecting random countries");
        cp.selectRandomCountries(5);

        CreateSurveyPage cs = new CreateSurveyPage(driver);
        logger.info("Entering survey details");
        cs.setProjectName(randomstring());
        cs.setProjectCode(randomAlphaNumeric());
        cs.setBrowserTitle(randomAlphaNumeric());
        String surveyName = randomAlphaNumeric();
        cs.setSurveyName(surveyName);

        logger.info("Selecting survey type");
        cs.selectSurveyType();

        logger.info("Clicking Create Survey button");
        cs.clickCreateSurvey();

        logger.info("Verifying success message with survey name");

        if (cs.isSurveyCreatedSuccessfully(surveyName)) {
            logger.info("Survey created successfully with name: " + surveyName);
            Assert.assertTrue(true);
        } else {
            logger.error("Survey creation failed for name: " + surveyName);
            captureScreen("CreateSurvey_Failed");
            Assert.fail("Success message not displayed for survey name: " + surveyName);
        }

        logger.info("***** TC004_CreateSurveyTest completed successfully *****");
    }
}

