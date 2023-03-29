package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static browser.Driver.getInstanceOfDriver;

public class Frame {
    private static Logger logger = LoggerFactory.getLogger("org.example.utils");

    public void switchToFrame(String path) {
        logger.info("Switch to frame");
        WebElement frame = getInstanceOfDriver().getDriver().findElement(By.xpath(path));
        getInstanceOfDriver().getDriver().switchTo().frame(frame);
    }

    public void switchToChildFrame(String path) {
        logger.info("Switch to nested frame");
        WebElement frame = getInstanceOfDriver().getDriver().findElement(By.xpath(path));
        getInstanceOfDriver().getDriver().switchTo().frame(frame).switchTo().frame(0);
    }

    public void switchToDefaultContent() {
        getInstanceOfDriver().getDriver().switchTo().defaultContent();
    }

}
