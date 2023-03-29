package browser;

import org.openqa.selenium.WebDriver;

public class Driver {

    private static Driver instanceOfDriver = null;
    private static WebDriver driver;

    private Driver() {

        driver = new BrowserFactory().createInstance();

    }

    public static Driver getInstanceOfDriver() {
        if (instanceOfDriver == null) {
            instanceOfDriver = new Driver();
        }

        return instanceOfDriver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void quit() {
        driver.quit();
        driver = null;
        instanceOfDriver = null;
    }

}
