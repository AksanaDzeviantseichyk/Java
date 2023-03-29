package baseElement;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TextBox extends BaseElement {
    private static Logger logger = LoggerFactory.getLogger("org.example.baseElement");

    public TextBox(By locator, String name) {
        super(locator, name);
    }

    public void type(String text) {
        logger.info("Type {} in the {} field", text, super.getElementName());
        getElement().sendKeys(text);
    }

    public void clear() {
        logger.info("Clear the {} field", super.getElementName());
        getElement().clear();
    }
}
