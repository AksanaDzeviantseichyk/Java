package DemoQAPages;

import baseElement.Link;
import baseForm.BaseForm;
import org.openqa.selenium.By;

public class LinksForm extends BaseForm {
    private final Link homeLink = new Link(By.id("simpleLink"), "homeLink");

    public LinksForm() {
        super(By.xpath("//div[@class='main-header' and //div[contains(.,'Links')]]"), "LinksForm");
    }

    public void clickHomeLink() {
        homeLink.click();
    }
}
