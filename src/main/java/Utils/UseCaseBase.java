package Utils;

import Pages.BasePage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;

public class UseCaseBase {
    public static WebDriver driver;
    public static BasePage page;

    @BeforeAll
    public static void setUpMain() {
        page = new BasePage();
        driver = SharedDriver.getWebDriver(SharedDriver.Browser.CHROME);
        page.setWebDriver(driver);
    }

    @AfterAll
    public static void tearDownMain() {
        SharedDriver.closeWebDriver();
        driver = null;
    }

}
