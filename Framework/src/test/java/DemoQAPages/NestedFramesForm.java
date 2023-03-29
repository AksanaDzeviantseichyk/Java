package DemoQAPages;

import baseElement.Label;
import baseForm.BaseForm;
import org.openqa.selenium.By;
import utils.Frame;

public class NestedFramesForm extends BaseForm {

    private final Frame frame = new Frame();
    private final String ParentFrameXpath = "//iframe[@id='frame1']";
    private final Label ParentLabel = new Label(By.xpath("//body[text()='Parent frame']"), "Parent Label");
    private final Label ChildLabel = new Label(By.tagName("p"), "Child Label");

    public NestedFramesForm() {
        super(By.xpath("//div[@class='main-header' and //div[contains(.,'Nested')]]"), "NestedFramesForm");

    }

    public String getMessageParentFrame() {
        frame.switchToFrame(ParentFrameXpath);
        String parentFrameText = ParentLabel.getText();
        frame.switchToDefaultContent();
        return parentFrameText;
    }

    public String getMessageChildFrame() {
        frame.switchToChildFrame(ParentFrameXpath);
        String childFrameText = ChildLabel.getText();
        frame.switchToDefaultContent();
        return childFrameText;
    }
}
