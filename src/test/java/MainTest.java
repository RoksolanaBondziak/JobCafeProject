import Pages.*;
import Utils.UseCaseBase;

import org.junit.jupiter.api.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest extends UseCaseBase {
    private static MainPage mainPage;
    public static final Logger logger = LogManager.getLogger(BasePage.class);

    @BeforeAll
    public static void classSetUp() {
        mainPage = new MainPage();
    }

    @BeforeEach
    public void beforeEachTest() {
        mainPage.navigateToMainPage();
    }

    public void beforeParametrizedTest() {
        mainPage.clickOnJobsPage();
        LoginPage loginPage = new LoginPage();
        if (loginPage.checkLoginPageLogo()) {
            loginPage.enterCredentials("Tom12345", "Tom54321");
        }
    }

    @Test
    public void visibilityOfMainPage() {
        MainPage mainPage1 = new MainPage();
        boolean isLogoVisible = mainPage1.findMainPageLogo();
        assertTrue(isLogoVisible);
        boolean isImageVisible = mainPage1.findMainPageImage();
        assertTrue(isImageVisible);
    }

    @Test
    public void visibilityOfJobsPage() {
        mainPage.clickOnJobsPage();
        JobsPage jobsPage = new JobsPage();
        boolean isJobsLogoVisible = jobsPage.checkJobPageLogo();
        assertTrue(isJobsLogoVisible);
    }

    @Test
    public void visibilityOfAboutUsPage() {
        mainPage.clickOnAboutUsPage();
        AboutUsPage aboutUsPage = new AboutUsPage();
        boolean isAboutUsPageLoaded = aboutUsPage.checkAboutPageLogo();
        assertTrue(isAboutUsPageLoaded);
    }

    @Test
    public void loginTest() {
        mainPage.clickOnJobsPage();
        LoginPage loginPage = new LoginPage();
        loginPage.enterCredentials("Tom12345", "Tom54321");
        JobsPage jobsPage = new JobsPage();
        boolean isJobPageLoaded = jobsPage.checkJobPageLogo();
        assertTrue(isJobPageLoaded);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Toronto", "Tel Aviv", "Chicago", "New York"})
    public void locationFieldTest(String cityName) {
        mainPage.clickOnJobsPage();
        LoginPage loginPage = new LoginPage();
        if (loginPage.checkLoginPageLogo()) {
            loginPage.enterCredentials("Tom12345", "Tom54321");
        }
        JobsPage jobsPage = new JobsPage();
        jobsPage.enterCredentialsInLocationField(cityName);
        boolean isListVisible = jobsPage.checkIfListIsLoaded();
        assertFalse(isListVisible);
        jobsPage.clearLocationField();
    }

    @ParameterizedTest
    @ValueSource(strings = {"QA", "Developer", "Project Manager"})
    public void positionFieldTest(String positionName) {
        beforeParametrizedTest();
        JobsPage jobsPage = new JobsPage();
        jobsPage.enterCredentialsInPositionField(positionName);
        boolean isListVisible = jobsPage.checkIfListIsLoaded();
        assertFalse(isListVisible);
        jobsPage.clearPositionField();
    }

    @ParameterizedTest
    @ValueSource(strings = {"Apple", "Facebook", "Google"})
    public void companyFieldTest(String companyName) {
        beforeParametrizedTest();
        JobsPage jobsPage = new JobsPage();
        jobsPage.enterCredentialsInCompanyField(companyName);
        boolean isListVisible = jobsPage.checkIfListIsLoaded();
        assertFalse(isListVisible);
        jobsPage.clearCompanyField();
    }

    @Test
    public void combinedSearchTest() {
        beforeParametrizedTest();
        JobsPage jobsPage = new JobsPage();
        jobsPage.combinedSearch("USA", "Manager", "Google");
        boolean isListVisible = jobsPage.checkIfListIsLoaded();
        assertFalse(isListVisible);
    }

    @Test
    public void negativeSearchTest() {
        beforeParametrizedTest();
        JobsPage jobsPage = new JobsPage();
        jobsPage.sendTextToPositionField("abracadabra");
        jobsPage.clickOnSearchButton();
        String errorMessage = jobsPage.verifyErrorMessage().getText();
        assertEquals("No results found!", errorMessage);
        String errorMessageSecondLine = jobsPage.verifyErrorMessageSecondLine().getText();
        assertEquals("Please try different search criteria", errorMessageSecondLine);
    }

    @Test
    public void combinedSearchAllEditBoxesTest() {
        beforeParametrizedTest();
        JobsPage jobsPage = new JobsPage();
        jobsPage.combinedSearchAllEditBoxes("USA", "QA", "Google", "Tester");
        jobsPage.clickOnResetButton();
        String emptyFieldPosition = jobsPage.verifyPositionFieldIsEmpty();
        assertEquals("", emptyFieldPosition);
        String emptyFieldLocation = jobsPage.verifyFieldLocationIsEmpty();
        assertEquals("", emptyFieldLocation);
        String emptyFieldCompany = jobsPage.verifyCompanyFieldIsEmpty();
        assertEquals("", emptyFieldCompany);
        String emptyFieldDescription = jobsPage.verifyDescriptionFieldIsEmpty();
        assertEquals("", emptyFieldDescription);
    }

    @Test
    public void logsTest() {
        logger.info("Logger test");
        LogEntries entries = driver.manage().logs().get(LogType.BROWSER);
        List<LogEntry> logs = entries.getAll();
        for (LogEntry e : logs) {
            System.out.println("Message : " + e.getMessage());
            System.out.println("Message : " + e.getLevel());
        }
        Assertions.assertEquals(0, logs.size());


    }
}