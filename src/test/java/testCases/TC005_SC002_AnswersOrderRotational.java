package testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.Dashboard;
import pageObjects.LoginPage;
import pageObjects.PreviewPage;
import pageObjects.SurveyListingPage;
import pageObjects.SurveyProgrammingPage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.testng.asserts.SoftAssert;

public class TC005_SC002_AnswersOrderRotational extends BaseClass {

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

        // Add new question
        sp.clickAddNewQuestionSimple();

        // NEW: Instructions -> Randomize
        sp.expandAnswerOrderSection();
        sp.selectRotationalOption();

        // Question text (kept consistent with your existing pattern)
        /*sp.fillOpenEndField(randomStringWithSpaces());*/
        String expectedQuestion = randomStringWithSpaces();
        sp.fillOpenEndField(expectedQuestion);

        // Add 3 answers and capture the typed order
        List<String> expectedAnswers = new ArrayList<>();

        sp.btnAddAnswer();
        String answer1 = randomstring();
        sp.AnswerOptionOne(answer1);
        expectedAnswers.add(answer1);

        sp.btnAddAnswer();
        String answer2 = randomstring();
        sp.AnswerOptionTwo(answer2);
        expectedAnswers.add(answer2);

        sp.btnAddAnswer();
        String answer3 = randomstring();
        sp.AnswerOptionThird(answer3);
        expectedAnswers.add(answer3);

        logger.info("Expanding Instru   tions section");
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


        sp.clickSaveButton();

        // Open Preview (new window) and switch
        sp.clickPhoneFlip();
        String parentWindow = driver.getWindowHandle();
        for (String window : driver.getWindowHandles()) {
            if (!window.equals(parentWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }


        // Capture answers in preview order
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

        SoftAssert softAssert1 = new SoftAssert();

        logger.info("Validating Question text");
        softAssert.assertTrue(
                actualQuestion.contains(expectedQuestion),
                "Question mismatch! Expected: " + expectedQuestion +
                        " but Found: " + actualQuestion
        );

        /* ---------- Instruction Validation ---------- */
        logger.info("Validating Instruction text");
        softAssert1.assertEquals(
                actualInstruction.trim(),
                expectedInstruction.trim(),
                "Instruction mismatch! Expected: " + expectedInstruction +
                        " but Found: " + actualInstruction
        );

        /* ---------- Description Validation ---------- */
        logger.info("Validating Description text");
        softAssert1.assertEquals(
                actualDescription.trim(),
                expectedDescription.trim(),
                "Description mismatch! Expected: " + expectedDescription +
                        " but Found: " + actualDescription
        );

        /* ---------- Answer Count Validation ---------- */
        logger.info("Validating Answer count");
        softAssert1.assertEquals(
                actualAnswers.size(),
                expectedAnswers.size(),
                "Answer count mismatch! Expected: " + expectedAnswers.size() +
                        " but Found: " + actualAnswers.size()
        );

        /* ---------- Final Assertion ---------- */
        logger.info("Executing final assertion check for Preview validation");
        softAssert1.assertAll();

        List<String> actualAnswers1 = ps.getPreviewAnswers();

        // Validate: same content, different order
        // Validate: same content
        softAssert1.assertTrue(
                actualAnswers.containsAll(expectedAnswers) && expectedAnswers.containsAll(actualAnswers),
                "Fail: Preview answers content does not match expected answers!"
        );

// Validate: rotational order
        softAssert1.assertTrue(
                isRotationalAcrossMultipleLoads(sp, ps, expectedAnswers, 3),
                "Fail: Answers never rotated across preview reloads!"
        );

    }

}















