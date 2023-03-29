package DemoQAPages;

import baseElement.Button;
import baseForm.BaseForm;
import org.openqa.selenium.By;

public class HomePage extends BaseForm {

    private final Button AlertsFramesWindows = new Button(By.xpath("//div[contains(h5,'Alerts')]"), "AlertsFramesWindows");
    private final Button Elements = new Button(By.xpath("//div[contains(h5,'Elements')]"), "Elements");

    public HomePage() {
        super(By.className("home-banner"), "mainPage");
    }

    public void clickAlertsFramesWindows() {
        AlertsFramesWindows.click();
    }

    public void clickElements() {
        Elements.click();
    }
}
