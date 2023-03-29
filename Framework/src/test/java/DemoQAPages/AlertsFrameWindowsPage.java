package DemoQAPages;

import baseForm.BaseForm;
import org.openqa.selenium.By;

public class AlertsFrameWindowsPage extends BaseForm {
    public final LeftSidePannelForm leftSidePannel;

    public AlertsFrameWindowsPage() {
        super(By.xpath("//div[@class='main-header' and //div[contains(.,'& Windows')]]"), "AlertsFrameWindowsPage");
        leftSidePannel = new LeftSidePannelForm();
    }


}
