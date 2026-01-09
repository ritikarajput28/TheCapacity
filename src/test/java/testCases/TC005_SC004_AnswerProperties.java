package testCases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class TC005_SC004_AnswerProperties extends BaseClass {


    @Test
    public void verifyAnswersAreRandomizedInPreview() throws IOException {
        SoftAssert softAssert = new SoftAssert();

        // Login
        LoginPage lp = new LoginPage(driver);
        lp.enterEmail(p.getProperty("email"));
        lp.enterPassword(p.getProperty("password"));
        lp.clickSignIn();

        // Navigate to Survey Programming
        Dashboard dashboard = new Dashboard(driver);
        dashboard.clickSurveyMenu();
        dashboard.clickSurveyListing();

        SurveyListingPage sl = new SurveyListingPage(driver);
        sl.clickSurveyCode();
        sl.clickSurveyProgramming();

        SurveyProgrammingPage sp = new SurveyProgrammingPage(driver);

        sp.clickAddNewQuestionSimple();
        sp.fillOpenEndField(randomStringWithSpaces());

        logger.info("Scrolling to Add Answer button");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", sp.getBtnAddAnswer());

        sp.btnAddAnswer();
        sp.AnswerOptionOne(randomstring());
        sp.btnAddAnswer();
        sp.AnswerOptionTwo(randomstring());
        sp.btnAddAnswer();
        sp.AnswerOptionThird(randomstring());
        sp.btnAddAnswer();
        sp.AnswerOptionFourth(randomstring());
        sp.btnAddAnswer();
        sp.AnswerOptionFifth(randomstring());
        sp.btnAddAnswer();
        sp.AnswerOptionSixth(randomstring());
        sp.btnAddAnswer();
        sp.AnswerOptionSeventh(randomstring());
        sp.btnAddAnswer();
        sp.AnswerOptionEight(randomstring());
        sp.expandAnswerOrderSection();
        sp.clickRandomizeOption();
        sp.ClickAnswerOptionOne();
        sp.clickDoNotRandomize();
        sp.clickAnswerByIndex(3);
        sp.clickSubHeading();




    }


}

