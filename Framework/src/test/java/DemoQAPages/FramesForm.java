package DemoQAPages;

import baseElement.Label;
import baseForm.BaseForm;
import org.openqa.selenium.By;
import utils.Frame;

public class FramesForm extends BaseForm {
    private final Frame frame = new Frame();
    private final String UpperFrameXpath = "//iframe[@id='frame1']";
    private final String LowerFrameXpath = "//iframe[@id='frame2']";
    private final Label UpperLabel = new Label(By.id("sampleHeading"), "Parent Label");
    private final Label LowerLabel = new Label(By.id("sampleHeading"), "Child Label");

    public FramesForm() {
        super(By.xpath("//div[@class='main-header' and //div[contains(.,'Frames')]]"), "Frames");
    }

    public String getMessageUpperFrame() {
        frame.switchToFrame(UpperFrameXpath);
        String UpperText = UpperLabel.getText();
        frame.switchToDefaultContent();
        return UpperText;
    }

    public String getMessageLowerFrame() {
        frame.switchToFrame(LowerFrameXpath);
        String LowerText = LowerLabel.getText();
        frame.switchToDefaultContent();
        return LowerText;
    }
}
