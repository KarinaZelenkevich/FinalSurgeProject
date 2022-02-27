package tests.base;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.AllureUtils;


public class TestListener implements ITestListener {
    public void onTestStart(ITestResult result) {
        System.out.printf("Test started: %s, \n%n", result.getName());
    }

    public void onTestSuccess(ITestResult result) {
        System.out.printf("Test Success: %s, \n", result.getName());
    }

    public void onTestFailure(ITestResult result) {
        WebDriver driver = (WebDriver) result.getTestContext().getAttribute("driver");
        System.out.printf("Test failed: %s, \n%n", result.getName());
        AllureUtils.takeScreenshot(driver);
    }
}