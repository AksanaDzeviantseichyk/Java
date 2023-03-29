package browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import static io.github.bonigarcia.wdm.config.DriverManagerType.CHROME;
import static utils.ConfigDataManager.CONFIG_DATA;

public class ChromeBrowserManager {

    public WebDriver createDriver() {
        DesiredCapabilities capability = new DesiredCapabilities();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments(CONFIG_DATA.get("mode"));
        chromeOptions.addArguments("--remote-allow-origins=*");
        capability.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        WebDriverManager.getInstance(CHROME).setup();

        return new ChromeDriver(chromeOptions);
    }
}

