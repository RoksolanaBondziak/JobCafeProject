package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class JobsPage extends BasePage {
    public static final String JOB_PAGE_LOGO = "//h2[text() = 'Jobs']";
    public static final String LOCATION_FIELD = "//input[@placeholder='location']";
    public static final String SEARCH_BUTTON = "//button[@class='search-butom'][text() = 'search']";
    public static final String ERROR_MESSAGE_FIRST_LINE = "//span[text()='No results found!']";
    public static final String ERROR_MESSAGE_SECOND_LINE = "//span[text()='Please try different search criteria']";
    public static final String POSITION_FIELD = "//input[@placeholder='position']";
    public static final String COMPANY_FIELD = "//input[@placeholder='company']";
    public static final String DESCRIPTION_FIELD = "//input[@placeholder='description']";
    public static final String RESET_BUTTON = "//button[text() = 'reset']";

    public  boolean checkJobPageLogo() {
        return elementExist(JOB_PAGE_LOGO);
    }

    public void sendTextToLocationField(String text) {
        sendTextToElementByXpath(LOCATION_FIELD, text);
    }

    public  void clickOnSearchButton() {
        logger.info("Finding Main page logo");
        clickElementByXpath(SEARCH_BUTTON);
    }


    public  boolean checkIfListIsLoaded() {
        return elementExist(ERROR_MESSAGE_FIRST_LINE);
    }

    public  void enterCredentialsInLocationField(String text) {
        logger.info("Sending text to location field and clicking on Search button");
        sendTextToLocationField(text);
        clickOnSearchButton();
    }
    public  void clearLocationField() {
        clearFieldByXpath(LOCATION_FIELD);
    }

    public  void sendTextToPositionField(String text) {
        sendTextToElementByXpath(POSITION_FIELD, text);
    }

    public  void enterCredentialsInPositionField(String text) {
        logger.info("Sending text to position field and clicking on Search button");
        sendTextToPositionField(text);
        clickOnSearchButton();
    }
    public  void clearPositionField() {
        clearFieldByXpath(POSITION_FIELD);
    }

    public void sendTextToCompanyField(String text) {
        sendTextToElementByXpath(COMPANY_FIELD, text);
    }

    public  void sendTextToDescriptionField(String text) {
        sendTextToElementByXpath(DESCRIPTION_FIELD, text);
    }

    public void enterCredentialsInCompanyField(String text) {
        logger.info("Sending text to company field and clicking on Search button");
        sendTextToCompanyField(text);
        clickOnSearchButton();
    }
    public  void clearCompanyField() {
        clearFieldByXpath(COMPANY_FIELD);
    }

    public  void combinedSearch(String text1, String text2, String text3) {
        logger.info("Sending text to location, position and company fields");
        sendTextToLocationField(text1);
        sendTextToPositionField(text2);
        sendTextToCompanyField(text3);
    }

    public void combinedSearchAllEditBoxes(String text1, String text2, String text3, String text4) {
        logger.info("Sending text to location, position, company and description fields");
        sendTextToLocationField(text1);
        sendTextToPositionField(text2);
        sendTextToCompanyField(text3);
        sendTextToDescriptionField(text4);
    }

    public  WebElement verifyErrorMessage() {
        logger.info("Finding error message(first line)");
        return findElementByXpath(ERROR_MESSAGE_FIRST_LINE);
    }
    public  WebElement verifyErrorMessageSecondLine() {
        logger.info("Finding error message(first line)");
        return findElementByXpath(ERROR_MESSAGE_SECOND_LINE);
    }

    public  void clickOnResetButton(){
        logger.info("Clicking on Reset button");
        clickElementByXpath(RESET_BUTTON);

    }

    public  String verifyPositionFieldIsEmpty() {
        return findElementByXpath(POSITION_FIELD).getText();
    }

    public  String verifyFieldLocationIsEmpty() {
        return findElementByXpath(LOCATION_FIELD).getText();
    }

    public  String verifyCompanyFieldIsEmpty() {
        return findElementByXpath(COMPANY_FIELD).getText();
    }

    public  String verifyDescriptionFieldIsEmpty() {
        return findElementByXpath(DESCRIPTION_FIELD).getText();
    }
}
