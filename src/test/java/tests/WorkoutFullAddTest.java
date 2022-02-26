package tests;

import models.WorkoutAddFactory;
import models.WorkoutFullAdd;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.AllureUtils;

public class WorkoutFullAddTest extends BaseTest {


    @Test(description = "Check that workout full add page was opened")
    public void activitiesPageShouldBeOpened() {
        loginPage
                .open()
                .login(email, password);
        calendarPage
                .open();
        workoutFullAddPage
                .open();
        Assert.assertTrue(workoutFullAddPage.isPageOpened(), "Workout Full Add page was not opened");
    }

    @Test(description = "Add workout with quick add")
    public void workoutShouldBeAddedWithFullAdd() {
        loginPage
                .open()
                .login(email, password);
        calendarPage
                .open();
        WorkoutFullAdd workout = WorkoutAddFactory.getFullAdd();
        workoutFullAddPage
                .open()
                .clickOnSportType()
                .fullAdd(workout)
                .saveFullAddForm();
        Assert.assertTrue(workoutDetailsPage.isPageOpen(), "Workout Full Add page was not opened");

    }
}
