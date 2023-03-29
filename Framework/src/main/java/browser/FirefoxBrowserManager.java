package browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import static io.github.bonigarcia.wdm.config.DriverManagerType.FIREFOX;
import static utils.ConfigDataManager.CONFIG_DATA;

public class FirefoxBrowserManager {
    public WebDriver createDriver() {
        DesiredCapabilities capability = new DesiredCapabilities();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments(CONFIG_DATA.get("mode"));
        capability.setCapability("moz:firefoxOptions", firefoxOptions);
        WebDriverManager.getInstance(FIREFOX).setup();

        return new FirefoxDriver(firefoxOptions);
    }
}
