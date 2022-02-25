package tests;

import io.qameta.allure.Description;
import models.PrintWorkouts;
import models.PrintWorkoutsFactory;
import org.testng.Assert;
import org.testng.annotations.Test;



public class PrintTest extends BaseTest {


    @Test(description = "Opening print page with workouts for the selected time period")
    @Description(value = "Opening print page with workouts for the selected time period")
    public void printWorkoutsTest() {
        loginPage
                .open()
                .login(email, password);
        homePage
                .clickPrintWorkouts();
        PrintWorkouts periodForPrint = PrintWorkoutsFactory.getPeriod();
        printWorkout
                .fillForm(periodForPrint);
        Assert.assertTrue(printPage.isPageOpen(), "Print page wasn't opened");
    }
}
