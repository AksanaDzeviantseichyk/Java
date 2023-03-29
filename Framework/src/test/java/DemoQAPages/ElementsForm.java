package DemoQAPages;

import baseForm.BaseForm;
import org.openqa.selenium.By;

public class ElementsForm extends BaseForm {
    public final LeftSidePannelForm leftSidePannel = new LeftSidePannelForm();

    public ElementsForm() {
        super(By.xpath("//div[@class='main-header' and //div[contains(.,'Elements')]]"), "Elements");
    }
}
