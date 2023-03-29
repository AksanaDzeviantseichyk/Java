package DemoQAPages;

import baseElement.Button;
import baseForm.BaseForm;
import org.openqa.selenium.By;

public class LeftSidePannelForm extends BaseForm {

    private final Button Alerts = new Button(By.xpath("//li[contains(span,'Alerts')]"), "Alerts");
    private final Button NestedFrames = new Button(By.xpath("//li[contains(span,'Nested')]"), "NestedFrames");
    private final Button Frames = new Button(By.xpath("//li[contains(span,'Frames')]"), "Frames");
    private final Button BrowserWindows = new Button(By.xpath("//li[contains(span,'Browser')]"), "BrowserWindows");
    private final Button Elements = new Button(By.xpath("//div[contains(span,'Elements')]"), "Elements");
    private final Button Links = new Button(By.xpath("//li[contains(span,'Links')]"), "Links");
    private final Button WebTables = new Button(By.xpath("//li[contains(span,'Tables')]"), "Tables");

    public LeftSidePannelForm() {
        super(By.className("left-pannel"), "LeftSideMenuForm");
    }

    public void clickAlerts() {
        Alerts.click();
    }

    public void clickNestedFrames() {
        NestedFrames.click();
    }

    public void clickFrames() {
        Frames.click();
    }

    public void clickBrowserWindows() {
        BrowserWindows.click();
    }

    public void clickWebTables() {
        WebTables.click();
    }

    public void clickElements() {
        Elements.click();
    }

    public void clickLinks() {
        Links.click();
    }
}
