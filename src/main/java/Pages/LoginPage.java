package Pages;

public class LoginPage extends BasePage {
    public static final String LOGIN_PAGE_LOGO = "//h2[text() = 'Log In']";
    public static final String USER_NAME = "//input[@name = 'username']";
    public static final String PASSWORD = "//input[@name = 'password']";
    public static final String LOG_IN_BUTTON = "//button[text() = 'Log In']";

    public boolean checkLoginPageLogo() {
        logger.info("Finding logo of login page");
        return elementExist(LOGIN_PAGE_LOGO);
    }

    public void enterUsername(String text) {
        sendTextToElementByXpath(USER_NAME, text);
    }

    public void enterPassword(String text) {
        sendTextToElementByXpath(PASSWORD, text);
    }

    public void clickOnLogIn() {
        clickElementByXpath(LOG_IN_BUTTON);
    }

    public void enterCredentials(String username, String password) {
        logger.info("Sending text to Username and Password fields and clicking on LogIn button");
        enterUsername(username);
        enterPassword(password);
        clickOnLogIn();
    }
}
