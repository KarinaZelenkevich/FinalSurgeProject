package tests;

import io.qameta.allure.Description;
import models.Reports;
import models.ReportsFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.AllureUtils;

import static org.testng.AssertJUnit.assertTrue;

public class WorkoutReportsTest extends BaseTest {

    @Test(description = "Reporting on workouts of the selected type for the selected period")
    @Description(value = "Reporting on workouts of the selected type for the selected period")
    public void reportWorkoutTest() {
        loginPage
                .open()
                .login(email, password);
        homePage
                .clickReportsAndStatistics();
        assertTrue(workoutReportsModalPage.isPageOpen());
        Reports reportView = ReportsFactory.getReportInform();
        workoutReportsModalPage.fillForm(reportView)
                .clickViewReportButton();
        Assert.assertTrue(workoutReportsModalPage.getActivityFromTable(),"WorkoutName was not displayed");
        AllureUtils.takeScreenshot(driver);
    }
}
