package Pages;

import Consts.Consts;

public class MainPage extends BasePage {
    public static final String LOGO_MAIN_PAGE = "//*[text() = 'Job Cafe']";
    public static final String IMAGE_MAIN_PAGE = "//img[@class = 'img-fluid']";
    public static final String ABOUT_US_BUTTON = "//a[@name = 'About']";
    public static final String JOBS_PAGE_BUTTON = "//a[@name = 'Jobs']";

    public void navigateToMainPage() {
        logger.info("Navigating to main page");
        driver.get(Consts.JOB_CAFE_URL);
    }

    public boolean findMainPageLogo() {
        logger.info("Finding Main page logo");
        return elementExist(LOGO_MAIN_PAGE);
    }

    public boolean findMainPageImage() {
        logger.info("Finding Main page image");
        return elementExist(IMAGE_MAIN_PAGE);
    }

    public AboutUsPage clickOnAboutUsPage() {
        logger.info("Sending text to Username field");
        clickElementByXpath(ABOUT_US_BUTTON);
        return new AboutUsPage();
    }

    public JobsPage clickOnJobsPage() {
        logger.info("Clicking on Job page tab");
        clickElementByXpath(JOBS_PAGE_BUTTON);
        return new JobsPage();
    }
}
