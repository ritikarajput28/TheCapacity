package testCases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import pageObjects.Dashboard;
import pageObjects.LoginPage;
import pageObjects.SurveyListingPage;
import pageObjects.SurveyProgrammingPage;

import java.io.IOException;

public class TC005_SingleSelectQuestionType extends BaseClass {

    @Test
    public void SingleSelectVerification() throws IOException {

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
        logger.info("Clicking survey code button");
        sl.clickSurveyCode();
        logger.info("Survey code button clicked successfully");
        sl.clickSurveyProgramming();
        logger.info("Survey Programming option selected successfully");

        SurveyProgrammingPage sp = new SurveyProgrammingPage(driver);

        logger.info("Clicking on Add New Question button");
        sp.clickAddNewQuestionSimple();

        logger.info("Filling Open End question field");
        sp.fillOpenEndField();

        logger.info("Scrolling to Add Answer button");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", sp.getBtnAddAnswer());

        logger.info("Clicking Add Answer button");
        sp.btnAddAnswer();


    }
}