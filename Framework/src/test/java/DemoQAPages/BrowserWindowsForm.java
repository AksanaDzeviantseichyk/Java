package DemoQAPages;

import baseElement.Button;
import baseForm.BaseForm;
import org.openqa.selenium.By;

public class BrowserWindowsForm extends BaseForm {
    private final Button newTab = new Button(By.id("tabButton"), "NewTabButton");
    public final LeftSidePannelForm leftSidePannelForm = new LeftSidePannelForm();

    public BrowserWindowsForm() {
        super(By.xpath("//div[@class='main-header' and //div[contains(.,'Browser')]]"), "BrowserWindowsForm");
    }

    public void clickNewTab() {
        newTab.click();

    }
}
