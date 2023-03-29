package browser;

import org.openqa.selenium.WebDriver;

import java.time.Duration;

import static utils.ConfigDataManager.CONFIG_DATA;

public class BrowserFactory {
    public WebDriver createInstance() {
        WebDriver driver;
        BrowserList browserType = BrowserList.valueOf(CONFIG_DATA.get("nameBrowser").toUpperCase());

        switch (browserType) {

            case CHROME:
                driver = new ChromeBrowserManager().createDriver();
                break;

            case FIREFOX:
                driver = new FirefoxBrowserManager().createDriver();
                break;

            default:
                throw new BrowserNotSupportedException(CONFIG_DATA.get("nameBrowser").toUpperCase());
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(CONFIG_DATA.get("smallWait"))));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Integer.parseInt(CONFIG_DATA.get("largeWait"))));
        return driver;
    }
}
