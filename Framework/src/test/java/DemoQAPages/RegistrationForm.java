package DemoQAPages;

import baseElement.Button;
import baseElement.TextBox;
import baseForm.BaseForm;
import org.openqa.selenium.By;

public class RegistrationForm extends BaseForm {
    private final TextBox firstNameBox = new TextBox(By.id("firstName"), "First name");
    private final TextBox lastNameBox = new TextBox(By.id("lastName"), "Last name");
    private final TextBox userEmailBox = new TextBox(By.id("userEmail"), "userEmail");
    private final TextBox ageBox = new TextBox(By.id("age"), "age");
    private final TextBox salaryBox = new TextBox(By.id("salary"), "salary");
    private final TextBox departmentBox = new TextBox(By.id("department"), "department");
    private final Button submitButton = new Button(By.id("submit"), "SubmitButton");


    public RegistrationForm() {
        super(By.id("registration-form-modal"), "RegistrationForm");
    }

    public void typeFirstName(String firstName) {
        firstNameBox.type(firstName);
    }

    public void typeLastName(String lastName) {
        lastNameBox.type(lastName);
    }

    public void typeUserEmail(String userEmail) {
        userEmailBox.type(userEmail);
    }

    public void typeAge(int age) {
        ageBox.type(Integer.toString(age));
    }

    public void typeSalary(int salary) {
        salaryBox.type(Integer.toString(salary));
    }

    public void typeDepartment(String department) {
        departmentBox.type(department);
    }

    public WebTablesForm clickSubmit() {
        submitButton.click();
        return new WebTablesForm();
    }

}
