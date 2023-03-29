package DemoQAPages;

import baseElement.Button;
import baseElement.RowTable;
import baseForm.BaseForm;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import utils.User;

public class WebTablesForm extends BaseForm {
    private final Button add = new Button(By.id("addNewRecordButton"), "AddButon");
    private final Button deleteButtons = new Button(By.xpath("//span[@title='Delete']"), "Table");
    private final Button lastDeleteButton = new Button(By.xpath("//span[@id='delete-record-" + getSizeTable() + "']"), "lastDeleteButton");
    private final RowTable lastRowTable = new RowTable(By.xpath("//div[@class='rt-tr-group'][" + getSizeTable() + "]"), "Rowstable");

    public WebTablesForm() {
        super(By.xpath("//div[@class='main-header' and //div[contains(.,'Tables')]]"), "WebTablesForm");
    }

    public void clickAdd() {
        add.click();
    }

    public boolean isRowAdd(@NotNull User user) {
        String attribute = lastRowTable.getAttribute("innerText");
        String[] splitted = attribute.split("\\n");
        if (splitted[0].equals(user.getFirstName()) && Integer.parseInt(splitted[2]) == user.getAge()) {
            return true;
        }
        return false;
    }

    public void clickLastDelete() {
        lastDeleteButton.click();
    }

    public int getSizeTable() {
        return deleteButtons.getNumberOfElements();
    }
}
