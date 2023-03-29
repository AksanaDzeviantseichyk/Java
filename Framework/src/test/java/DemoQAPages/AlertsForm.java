package DemoQAPages;

import baseElement.BaseElement;
import baseElement.Button;
import baseElement.Label;
import baseForm.BaseForm;
import org.openqa.selenium.By;

public class AlertsForm extends BaseForm {

    private final Button alertButton = new Button(By.id("alertButton"), "AlertButton");
    private final Button confirmButton = new Button(By.id("confirmButton"), "ConfirmButton");
    private final Button promtButton = new Button(By.id("promtButton"), "PromptButton");
    private final Label confirmResult = new Label(By.id("confirmResult"), "ConfirmResult");
    private final Label promptResult = new Label(By.id("promptResult"), "PromptResult");

    public AlertsForm() {
        super(By.xpath("//div[@class='main-header' and //div[contains(.,'Alerts')]]"), "AlertsForm");

    }

    public void clickAlertButton() {
        alertButton.click();
    }

    public void clickConfirmButton() {
        confirmButton.click();
    }

    public void clickPromtButton() {
        promtButton.click();
    }

    public String getConfirmResult() {
        return confirmResult.getText();
    }

    public String getPromptResult() {
        return promptResult.getText();
    }

}
