package utils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static browser.Driver.getInstanceOfDriver;
import static utils.ConfigDataManager.CONFIG_DATA;

public class Waits {
    private WebDriverWait wait;
    private int timeoutInSeconds;

    public Waits() {
        timeoutInSeconds = Integer.parseInt(CONFIG_DATA.get("smallWait"));
        wait = new WebDriverWait(getInstanceOfDriver().getDriver(), Duration.ofSeconds(timeoutInSeconds));
    }

    public WebElement waitForPresenceOfElement(By uniqueFormLocator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(uniqueFormLocator));
    }

    public boolean waitInvisibilityOfElementLocated(By uniqueFormLocator) {
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(uniqueFormLocator));
    }

    public boolean waitIsPresenceOfElement(By uniqueFormLocator) {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(uniqueFormLocator));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Alert waitAlertIsPresent() {
        return wait.until(ExpectedConditions.alertIsPresent());
    }

}
