package tests;

import lombok.extern.log4j.Log4j2;
import models.WorkoutAddFactory;
import models.WorkoutQuickAdd;
import org.testng.Assert;
import org.testng.annotations.Test;



@Log4j2
public class CalendarTest extends BaseTest {


    @Test(description = "Quick add workout test")
    public void CalendarQuickAddWorkoutTest() throws InterruptedException {
        log.info("Test start ContactTest");
        loginPage.open();
        loginPage.login(email, password);
        calendarPage
                .open();
        Assert.assertTrue(calendarPage.isPageOpen(), "Calendar page wasn't opened");
    }


    @Test(description = "Test that workout could be moved to the other date with drag-and-drop")
    public void workoutShouldBeDragAndDropped() {
        loginPage
                .open()
                .login(email, password);
        calendarPage
                .open();
        WorkoutQuickAdd workout = WorkoutAddFactory.get();
        workoutPage
                .openWorkoutQuickAdd()
                .workOutQuickAdd(workout)
                .saveQuickAddForm();
        calendarPage.reschedulingAWorkoutToANewDate(workout.getWorkoutName());
        Assert.assertTrue(workoutPage.checkWorkoutWasAddedToCalendar(
                workout.getWorkoutName()), "Workout was not added to the calendar");
    }
}