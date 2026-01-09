package testCases;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.URL;
import java.util.*;

import org.apache.poi.ss.formula.atp.Switch;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import pageObjects.PreviewPage;
import pageObjects.SurveyProgrammingPage;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;

public class BaseClass {

    public static WebDriver driver;
    public Logger logger;
    public Properties p;

    @BeforeClass
    @Parameters({"os", "browser"})
    void setup(String os, String br) throws IOException {


        FileReader file = new FileReader("./src//main//resources//config.properties");
        p = new Properties();
        p.load(file);

        logger = LogManager.getLogger(this.getClass());

        if (p.getProperty("execution_env").equalsIgnoreCase("remote")) {
            DesiredCapabilities capabilities = new DesiredCapabilities();

            if (os.equalsIgnoreCase("windows")) {
                capabilities.setPlatform(Platform.WIN10);
            } else if (os.equalsIgnoreCase("linux")) {
                capabilities.setPlatform(Platform.LINUX);
            } else if (os.equalsIgnoreCase("mac")) {
                capabilities.setPlatform(Platform.MAC);
            } else {
                System.out.println("No matching OS");
                return;
            }

            switch (br.toLowerCase()) {
                case "chrome":
                    capabilities.setBrowserName("chrome");
                    break;
                case "edge":
                    capabilities.setBrowserName("MicrosoftEdge");
                    break;
                case "firefox":
                    capabilities.setBrowserName("firefox");
                    break;
                default:
                    System.out.println("No matching browser");
                    return;
            }
            driver = new RemoteWebDriver(new URL("http://192.168.31.71:4444/wd/hub"), capabilities);

        }
        if (p.getProperty("execution_env").equalsIgnoreCase("local")) {
            switch (br.toLowerCase()) {
                case "chrome":
                    driver = new ChromeDriver();
                    break;
                case "edge":
                    driver = new EdgeDriver();
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                default:
                    System.out.println(" Invalid browser name...");
                    return;
            }

        }
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get(p.getProperty("Url"));
        driver.manage().window().maximize();
    }

    /*@AfterClass
    void tearDown() {
        driver.quit();
    }*/

    public String randomstring() {
        String generatedstring = RandomStringUtils.randomAlphabetic(5);
        return generatedstring;
    }


    public String randomStringWithSpaces() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        int wordCount = random.nextInt(6) + 5; // 5–10 words

        for (int i = 0; i < wordCount; i++) {
            int wordLength = random.nextInt(6) + 3; // 3–8 chars per word
            sb.append(RandomStringUtils.randomAlphabetic(wordLength).toLowerCase());

            if (i < wordCount - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public String randomStringParagraph(int totalLength) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        while (sb.length() < totalLength) {
            int wordLength = random.nextInt(5) + 2;
            sb.append(RandomStringUtils.randomAlphabetic(wordLength));

            if (sb.length() < totalLength) {
                sb.append(" ");
            }
        }
        return sb.substring(0, totalLength);
    }

    public String randomSentence() {
        String sentence = RandomStringUtils.randomAlphabetic(1).toUpperCase()
                + RandomStringUtils.randomAlphabetic(5).toLowerCase()
                + " "
                + RandomStringUtils.randomAlphabetic(4).toLowerCase()
                + " "
                + RandomStringUtils.randomAlphabetic(8).toLowerCase()
                + ".";

        return sentence;
    }

    public String randomSentence50Words() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        int wordCount = 50; // exact 50 words

        for (int i = 0; i < wordCount; i++) {
            int wordLength = random.nextInt(6) + 3; // 3–8 characters per word
            String word = RandomStringUtils.randomAlphabetic(wordLength).toLowerCase();

            // Capitalize first word
            if (i == 0) {
                word = Character.toUpperCase(word.charAt(0)) + word.substring(1);
            }

            sb.append(word);

            if (i < wordCount - 1) {
                sb.append(" ");
            }
        }

        sb.append("."); // end with full stop
        return sb.toString();
    }

    public String randomNumber() {
        String generatednumber = RandomStringUtils.randomNumeric(10);
        return generatednumber;
    }

    public String randomAlphaNumeric() {
        String generatedstring = RandomStringUtils.randomAlphabetic(3);
        String generatednumber = RandomStringUtils.randomNumeric(5);
        return (generatedstring + "@" + generatednumber);
    }

    public String captureScreen(String tname) throws IOException {

        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss")
                .format(new Date());   // java.util.Date

        TakesScreenshot ts = (TakesScreenshot) driver;
        File sourceFile = ts.getScreenshotAs(OutputType.FILE);

        String targetFilePath = System.getProperty("user.dir")
                + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

        File targetFile = new File(targetFilePath);

        FileUtils.copyFile(sourceFile, targetFile);

        return targetFilePath;
    }

    List<String> normalizeAnswerList(List<String> answers) {
        List<String> normalized = new ArrayList<>();
        for (String ans : answers) {
            normalized.add(ans.trim());
        }
        return normalized;
    }

    protected boolean isRotationalAcrossMultipleLoads(
            SurveyProgrammingPage sp,
            PreviewPage ps,
            List<String> expectedAnswers,
            int attempts
    ) {

        List<String> original = new ArrayList<>(expectedAnswers);

        for (int i = 0; i < attempts; i++) {

            List<String> actual = ps.getPreviewAnswers();

            // Same answers?
            if (actual.containsAll(original) && original.containsAll(actual)) {

                // Order is different?
                if (!actual.equals(original)) {
                    return true; // rotation detected
                }
            }

            // Refresh preview for next "respondent"
            driver.navigate().refresh();
        }

        return false; // no rotation seen
    }


}