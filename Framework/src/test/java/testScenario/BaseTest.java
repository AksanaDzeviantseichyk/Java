package testScenario;

import browser.BrowserUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static browser.Driver.getInstanceOfDriver;

public abstract class BaseTest {
    private static Logger logger = LoggerFactory.getLogger("org.example.testScenario");

    @BeforeMethod
    public static void setup(Method method) {
        Test test = method.getAnnotation(Test.class);
        if (test == null) {
            return;
        }
        logger.info("Start {} test case", test.testName());
        new BrowserUtils().openUrl();
    }

    @AfterMethod
    public void tearDown(Method method) {
        Test test = method.getAnnotation(Test.class);
        if (test == null) {
            return;
        }
        logger.info("Stop {} test case", test.testName());
        getInstanceOfDriver().quit();
    }


}
