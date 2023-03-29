package utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static browser.Driver.getInstanceOfDriver;

public class Alert {
    private static Logger logger = LoggerFactory.getLogger("org.example.utils");
    private boolean isAlert = false;

    public void clickAcceptAlert() {
        logger.info("Click accept alert");
        isAlert = false;
        getInstanceOfDriver().getDriver().switchTo().alert().accept();
    }

    public void sendKeysAlert(String text) {
        logger.info("Type {} in the alert text field", text);
        getInstanceOfDriver().getDriver().switchTo().alert().sendKeys(text);
    }

    public boolean isAlertOpen() {
        logger.info("Alert opening check");
        return isAlert;
    }

    public String getTextAlert() {
        Waits waits = new Waits();
        waits.waitAlertIsPresent();
        isAlert = true;
        logger.info("Get text from Alert");
        return getInstanceOfDriver().getDriver().switchTo().alert().getText();
    }
}
