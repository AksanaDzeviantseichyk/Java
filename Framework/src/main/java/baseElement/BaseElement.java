package baseElement;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.Waits;

import java.util.List;

import static browser.Driver.getInstanceOfDriver;

public abstract class BaseElement {
    private static Logger logger = LoggerFactory.getLogger("org.example.baseElement");
    private By uniqueLocator;
    private String elementName;
    private Waits waits;

    public BaseElement(By locator, String name) {
        uniqueLocator = locator;
        elementName = name;
        waits = new Waits();
    }

    protected WebElement getElement() {

        return getInstanceOfDriver().getDriver().findElement(uniqueLocator);
    }

    protected List<WebElement> getElements() {

        return getInstanceOfDriver().getDriver().findElements(uniqueLocator);
    }

    public void click() {
        logger.info("Click on {}", elementName);
        waits.waitForPresenceOfElement(uniqueLocator);
        JavascriptExecutor executor = (JavascriptExecutor) getInstanceOfDriver().getDriver();
        executor.executeScript("arguments[0].click();", getElement());
    }

    public boolean isDisplayed() {
        logger.info("{} is displayed", elementName);
        waits.waitForPresenceOfElement(uniqueLocator);
        return getElements().size() != 0;
    }

    public String getText() {
        logger.info("Get text from {}", elementName);
        return getElement().getText();
    }

    public int getNumberOfElements() {
        logger.info("Get number of elements {}", elementName);
        return getElements().size();
    }

    public String getAttribute(String attribute) {
        logger.info("Get attribute from {}", elementName);
        return getElement().getAttribute(attribute);
    }

    protected String getElementName() {
        return elementName;
    }

}
