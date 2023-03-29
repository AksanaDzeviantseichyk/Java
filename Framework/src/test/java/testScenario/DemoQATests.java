package testScenario;

import DemoQAPages.*;
import browser.BrowserUtils;
import com.github.javafaker.Faker;
import org.jetbrains.annotations.NotNull;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.Alert;
import utils.TablesData;
import utils.User;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DemoQATests extends BaseTest {
    @DataProvider(name = "Alerts")
    public Object[][] createAlertsData() {
        return new Object[][]
                {
                        {new Faker().lorem().word()}
                };
    }

    @DataProvider(name = "Tables")
    public Iterator<Object[]> createTablesData() {
        List<User> listUser = (new TablesData("src/main/resources/TablesData.json")).getListUser();
        List<Object[]> arrayObject = new ArrayList<>();
        for (User user : listUser) {
            Object[] object = new Object[1];
            object[0] = user;
            arrayObject.add(object);
        }
        Iterator<Object[]> iterator = arrayObject.iterator();
        return iterator;
    }

    @DataProvider(name = "IFrame")
    public Object[][] createIFrameData() {
        return new Object[][]
                {
                        {"Parent frame", "Child Iframe"}
                };
    }

    @Test(testName = "Alerts", dataProvider = "Alerts")
    public void Alerts(String text) {
        HomePage homePage = new HomePage();
        Assert.assertTrue(homePage.isFormOpen(), "Main page is not open");
        homePage.clickAlertsFramesWindows();
        AlertsFrameWindowsPage alertsFrameWindowsPage = new AlertsFrameWindowsPage();
        alertsFrameWindowsPage.leftSidePannel.clickAlerts();
        AlertsForm alertsForm = new AlertsForm();
        Assert.assertTrue(alertsForm.isFormOpen(), "AlertsForm page is not open");
        alertsForm.clickAlertButton();
        Alert alert = new Alert();
        Assert.assertEquals(alert.getTextAlert(), "You clicked a button",
                "Alert 'You clicked a button' is not open");
        alert.clickAcceptAlert();
        Assert.assertFalse(alert.isAlertOpen(), "Alert is not closed");
        alertsForm.clickConfirmButton();
        Assert.assertEquals(alert.getTextAlert(), "Do you confirm action?",
                "Alert 'Do you confirm action?' is not open");
        alert.clickAcceptAlert();
        Assert.assertFalse(alert.isAlertOpen(), "Alert is not closed");
        Assert.assertEquals(alertsForm.getConfirmResult(), "You selected Ok", "Text has appeared on the page ");
        alertsForm.clickPromtButton();
        alert.sendKeysAlert(text);
        Assert.assertEquals(alert.getTextAlert(), "Please enter your name",
                "Please enter your name' is not open");
        alert.clickAcceptAlert();
        Assert.assertFalse(alert.isAlertOpen(), "Alert is not closed");
        Assert.assertEquals(alertsForm.getPromptResult(), "You entered " + text, "Text has appeared on the page ");

    }

    @Test(testName = "IFrame", dataProvider = "IFrame")
    public void IFrame(String expectedParentFrameText, String expectedChildFrameText) {
        HomePage homePage = new HomePage();
        Assert.assertTrue(homePage.isFormOpen(), "Main page is not open");
        homePage.clickAlertsFramesWindows();
        AlertsFrameWindowsPage alertsFrameWindowsPage = new AlertsFrameWindowsPage();
        alertsFrameWindowsPage.leftSidePannel.clickNestedFrames();
        NestedFramesForm nestedFramesForm = new NestedFramesForm();
        Assert.assertTrue(nestedFramesForm.isFormOpen(), "Nested Frames form is not open");
        Assert.assertEquals(nestedFramesForm.getMessageParentFrame(), expectedParentFrameText, "Parent Frame message is not equals");
        Assert.assertEquals(nestedFramesForm.getMessageChildFrame(), expectedChildFrameText, "Child IFrame message is not equals");
        alertsFrameWindowsPage.leftSidePannel.clickFrames();
        FramesForm framesForm = new FramesForm();
        Assert.assertTrue(framesForm.isFormOpen(), "Frames Form is not open");
        Assert.assertEquals(framesForm.getMessageUpperFrame(), framesForm.getMessageLowerFrame(), "Text is equals");

    }

    @Test(testName = "Tables", dataProvider = "Tables")
    public void Tables(@NotNull User user) {
        HomePage homePage = new HomePage();
        Assert.assertTrue(homePage.isFormOpen(), "Main page is not open");
        homePage.clickElements();
        ElementsForm elementsForm = new ElementsForm();
        elementsForm.leftSidePannel.clickWebTables();
        WebTablesForm webTablesForm = new WebTablesForm();
        Assert.assertTrue(webTablesForm.isFormOpen(), "Web Tables Form is not open");
        int sizeTableBeforeAdd = webTablesForm.getSizeTable();
        webTablesForm.clickAdd();
        RegistrationForm registrationForm = new RegistrationForm();
        Assert.assertTrue(registrationForm.isFormOpen(), "Registration Form is not open");
        registrationForm.typeFirstName(user.getFirstName());
        registrationForm.typeLastName(user.getLastName());
        registrationForm.typeUserEmail(user.getEmail());
        registrationForm.typeAge(user.getAge());
        registrationForm.typeSalary(user.getSalary());
        registrationForm.typeDepartment(user.getDepartment());
        webTablesForm=registrationForm.clickSubmit();
        Assert.assertTrue(registrationForm.isFormClose(), "Registration Form is not closed");
        int sizeTableAfterAdd = webTablesForm.getSizeTable();
        Assert.assertEquals(sizeTableBeforeAdd + 1, sizeTableAfterAdd, "User is not added");
        Assert.assertTrue(webTablesForm.isRowAdd(user), "User is not added");
        webTablesForm.clickLastDelete();
        int sizeTableAfterDeleted = webTablesForm.getSizeTable();
        Assert.assertEquals(sizeTableAfterAdd - 1, sizeTableAfterDeleted, "User is not deleted");
    }

    @Test(testName = "Handles")
    public void Handles() {
        HomePage homePage = new HomePage();
        Assert.assertTrue(homePage.isFormOpen(), "Main page is not open");
        homePage.clickAlertsFramesWindows();
        AlertsFrameWindowsPage alertsFrameWindowsPage = new AlertsFrameWindowsPage();
        alertsFrameWindowsPage.leftSidePannel.clickBrowserWindows();
        BrowserWindowsForm browserWindowsForm = new BrowserWindowsForm();
        Assert.assertTrue(browserWindowsForm.isFormOpen(), "Browser Windows form is not open");
        BrowserUtils browserUtils = new BrowserUtils();
        String home = browserUtils.getWindowHandle();
        browserWindowsForm.clickNewTab();
        browserUtils.switchToNewTab(home);
        NewTabPage newTabPage = new NewTabPage();
        Assert.assertTrue(newTabPage.isFormOpen(), "NewTab page is not open");
        browserUtils.closeCurrentTab(home);
        Assert.assertTrue(browserWindowsForm.isFormOpen(), "Browser Windows form is not open");
        browserWindowsForm.leftSidePannelForm.clickElements();
        browserWindowsForm.leftSidePannelForm.clickLinks();
        LinksForm linksForm = new LinksForm();
        Assert.assertTrue(linksForm.isFormOpen(), "Links form is not open");
        String previous = browserUtils.getWindowHandle();
        linksForm.clickHomeLink();
        browserUtils.switchToNewTab(previous);
        Assert.assertTrue(homePage.isFormOpen(), "Main page is not open");
        String newHomePageTab = browserUtils.getWindowHandle();
        browserUtils.switchToNewTab(newHomePageTab);
        Assert.assertTrue(linksForm.isFormOpen(), "Links form is not open");

    }

}
