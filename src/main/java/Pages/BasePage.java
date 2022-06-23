package Pages;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    public static final Logger logger  =  LogManager.getLogger(BasePage.class);

    public void setWebDriver(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    protected  WebElement findElementByXpath(String xpath) {
        logger.info("Finding element with xpath: "+ xpath);
        WebElement element;
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        element = driver.findElement(By.xpath(xpath));
        return element;
    }
    public  void clearFieldByXpath(String xpath){
        logger.info("Delete text with xpath: "+ xpath);
        findElementByXpath(xpath).clear();
    }

    protected  void clickElementByXpath(String xpath){
        logger.info("Clicking element with xpath: "+ xpath);
        findElementByXpath(xpath).click();
    }

    protected  void sendTextToElementByXpath(String xpath, String text) {
        logger.info("Sending text to element with xpath: " + xpath);
        findElementByXpath(xpath).sendKeys(text);
    }

    protected  boolean elementExist(String xpath) {
        try{
            logger.info("Check element with xpath exists: "+ xpath);
            driver.findElement(By.xpath(xpath));
            return true;
        }
        catch(Exception err){
            return false;
        }
    }


}
