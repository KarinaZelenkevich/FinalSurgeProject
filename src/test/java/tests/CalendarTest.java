package tests;

import io.qameta.allure.Description;
import lombok.extern.log4j.Log4j2;
import models.Calendar;
import models.CalendarFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CalendarListPage;
import pages.CalendarModalPage;

import static org.testng.AssertJUnit.assertEquals;

@Log4j2
public class CalendarTest extends BaseTest {


    @Test(description = "Quick add workout test")
    public void CalendarQuickAddWorkoutTest() throws InterruptedException {
        log.info("Test start ContactTest");
        loginPage.open();
        loginPage.login("blablablablablabla@maillinator.com", "KarinaKarina12");


        boolean isCalendarModalOpen = calendarListPage
                .open()
                .clickQuickAdd()
                .isPageOpen();
        log.info("Checking that ContactModal has opened");

//        Assert.assertTrue(isCalendarModalOpen, "The window of notes of spots events in the calendar did not open");
        log.info("Quick addition of sports events");

        Calendar calendar = CalendarFactory.getSpotsEvent();

        boolean isCalendarDetailsPageOpen = calendarModalPage
                .addSportsEvent(calendar)
                .isPageOpen();

        log.info("New sports event creation completed");

        String error = CalendarListPage.getMessage();
        assertEquals(error, "\n" +
                        "*The workout was successfully saved to your Workout Library.",
                "*Workout has not been added to your workout library");
    }
}