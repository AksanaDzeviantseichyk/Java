package DemoQAPages;

import baseForm.BaseForm;
import org.openqa.selenium.By;

public class NewTabPage extends BaseForm {
    public NewTabPage() {
        super(By.id("sampleHeading"), "NewTabPage");
    }
}
