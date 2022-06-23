package Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AboutUsPage extends BasePage {

    public static final Logger logger = LogManager.getLogger(BasePage.class);
    public static final String LOGO_ABOUT_PAGE = "//h2[text() = 'About Us']";

    public boolean checkAboutPageLogo() {
        logger.info("Finding logo of About us page");


        return elementExist(LOGO_ABOUT_PAGE);
    }
}
