package baseForm;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.Waits;

public abstract class BaseForm {
    private static Logger logger = LoggerFactory.getLogger("org.example.baseForm");
    private By uniqueFormLocator;
    private String formName;
    private Waits waits;

    public BaseForm(By locator, String name) {
        uniqueFormLocator = locator;
        formName = name;
        waits = new Waits();
    }

    public boolean isFormOpen() {
        logger.info("{} opening check", formName);
        return waits.waitIsPresenceOfElement(uniqueFormLocator);
    }

    public boolean isFormClose() {
        logger.info("{} closing check", formName);
        return waits.waitInvisibilityOfElementLocated(uniqueFormLocator);
    }
}
