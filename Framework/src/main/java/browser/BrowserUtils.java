package browser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;
import java.util.Set;

import static browser.Driver.getInstanceOfDriver;
import static utils.ConfigDataManager.CONFIG_DATA;

public class BrowserUtils {
    private static Logger logger = LoggerFactory.getLogger("org.example.browser");

    public void openUrl() {
        logger.info("Open main page");
        getInstanceOfDriver().getDriver().get(CONFIG_DATA.get("url"));
    }

    public String getWindowHandle() {
        return getInstanceOfDriver().getDriver().getWindowHandle();
    }

    public Set<String> getWindowHandles() {
        return getInstanceOfDriver().getDriver().getWindowHandles();
    }

    public void switchToNewTab(String home) {
        logger.info("Switch to a new tab");
        Set<String> set = getWindowHandles();
        Iterator<String> itr = set.iterator();
        while (itr.hasNext()) {
            String child = itr.next();
            if (!home.equals(child)) {
                getInstanceOfDriver().getDriver().switchTo().window(child);
            }
        }
    }

    public void closeCurrentTab(String home) {
        logger.info("Close current tab");
        getInstanceOfDriver().getDriver().switchTo().window(getWindowHandle()).close();
        getInstanceOfDriver().getDriver().switchTo().window(home);
    }
}
