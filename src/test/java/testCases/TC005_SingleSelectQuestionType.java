package testCases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.testng.asserts.SoftAssert;


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
        /* sp.fillOpenEndField(randomStringWithSpaces());*/
        String expectedQuestion = randomStringWithSpaces();
        sp.fillOpenEndField(expectedQuestion);

        logger.info("Scrolling to Add Answer button");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", sp.getBtnAddAnswer());

        logger.info("Starting test: Add answers and fill all fields");



        List<String> expectedAnswers = new ArrayList<>();

        logger.info("Clicking 'Add Answer' button for first answer");
        sp.btnAddAnswer();
        String answer1 = randomstring();
        sp.AnswerOptionOne(answer1);
        expectedAnswers.add(answer1);

        logger.info("Clicking 'Add Answer' button for second answer");
        sp.btnAddAnswer();
        String answer2 = randomstring();
        sp.AnswerOptionTwo(answer2);
        expectedAnswers.add(answer2);

        logger.info("Clicking 'Add Answer' button for third answer");
        sp.btnAddAnswer();
        String answer3 = randomstring();
        sp.AnswerOptionThird(answer3);
        expectedAnswers.add(answer3);

        logger.info("Expanding Instructions section");
        sp.clickInstructionsArrow();

        logger.info("Clearing and entering Instructions text");
        String expectedDescription = randomSentence50Words();
        sp.clearAndEnterInstructions(expectedDescription);
        /*sp.clearAndEnterInstructions(randomSentence50Words());*/

        logger.info("Collapsing Instructions section");
        sp.clickInstructionsArrow();

        logger.info("Expanding Description section");
        sp.clickDescriptionArrow();

        logger.info("Clearing and entering Description text");
        String expectedInstruction = randomSentence50Words();
        sp.clearAndEnterDescription(expectedInstruction);
        /* sp.clearAndEnterDescription(randomSentence50Words());*/

        logger.info("Collapsing Description section");
        sp.clickDescriptionArrow();

        logger.info("Expanding Validation Message section");
        sp.clickValidationMessageArrow();

        logger.info("Clearing and entering Validation Message text");
        sp.clearAndEnterValidation(randomSentence50Words());

        logger.info("Collapsing Validation Message section");
        sp.clickValidationMessageArrow();

        logger.info("Expanding Programmer's Instruction section");
        sp.clickProgrammersInstructionArrow();

        logger.info("Clearing and entering Programmer's Instruction text");
        sp.clearAndEnterProgramInstruction(randomSentence50Words());

        logger.info("Collapsing Programmer's Instruction section");
        sp.clickProgrammersInstructionArrow();

        logger.info("Clicking Save button");
        sp.clickSaveButton();

        sp.clickPhoneFlip();
        logger.info("Clicked Phone Flip icon to open Preview");

        String parentWindow = driver.getWindowHandle();

        for (String window : driver.getWindowHandles()) {
            if (!window.equals(parentWindow)) {
                driver.switchTo().window(window);
                logger.info("Switched to Preview window");
                break;
            }
        }

        PreviewPage ps = new PreviewPage(driver);

        logger.info("Fetching preview data from Preview Page");

        String actualQuestion = ps.getPreviewQuestionText();
        String actualInstruction = ps.getPreviewInstructionText();
        String actualDescription = ps.getPreviewDescriptionText();
        List<String> actualAnswers = ps.getPreviewAnswers();

        logger.info("Preview Question Text: {}", actualQuestion);
        logger.info("Preview Instruction Text: {}", actualInstruction);
        logger.info("Preview Description Text: {}", actualDescription);
        logger.info("Preview Answers Count: {}", actualAnswers.size());

        SoftAssert softAssert = new SoftAssert();

        /* ---------- Question Validation ---------- */
        logger.info("Validating Question text");
        softAssert.assertTrue(
                actualQuestion.contains(expectedQuestion),
                "Question mismatch! Expected: " + expectedQuestion +
                        " but Found: " + actualQuestion
        );

        /* ---------- Instruction Validation ---------- */
        logger.info("Validating Instruction text");
        softAssert.assertTrue(
                actualInstruction.contains(expectedInstruction),
                "Instruction mismatch! Expected: " + expectedInstruction +
                        " but Found: " + actualInstruction
        );

        /* ---------- Description Validation ---------- */
        logger.info("Validating Description text");
        softAssert.assertTrue(
                actualDescription.contains(expectedDescription),
                "Description mismatch! Expected: " + expectedDescription +
                        " but Found: " + actualDescription
        );

        /* ---------- Answer Count Validation ---------- */
        logger.info("Validating Answer count");
        softAssert.assertEquals(
                actualAnswers.size(),
                expectedAnswers.size(),
                "Answer count mismatch! Expected: " + expectedAnswers.size() +
                        " but Found: " + actualAnswers.size()
        );

        /* ---------- Individual Answer Validation ---------- */
        for (int i = 0; i < expectedAnswers.size(); i++) {
            logger.info("Validating Answer at index {} | Expected: {} | Actual: {}",
                    i, expectedAnswers.get(i), actualAnswers.get(i));

            softAssert.assertTrue(
                    actualAnswers.get(i).contains(expectedAnswers.get(i)),
                    "Answer mismatch at index " + i +
                            " Expected: " + expectedAnswers.get(i) +
                            " but Found: " + actualAnswers.get(i)
            );
        }

        /* ---------- Final Assertion ---------- */
        logger.info("Executing final assertion check for Preview validation");
        softAssert.assertAll();

        logger.info("Preview validation completed successfully");


    }
}




