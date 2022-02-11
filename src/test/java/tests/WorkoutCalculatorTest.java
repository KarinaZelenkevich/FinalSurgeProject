package tests;

import lombok.extern.log4j.Log4j2;
import models.WorkoutCalculator;
import models.WorkoutCalculatorFactory;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.WorkoutCalculatorListPage;

@Log4j2
public class WorkoutCalculatorTest extends BaseTest {

    @Test(description = "Calculator Intensity test")
    public void calculatorIntensityTest() {

        WorkoutCalculator workoutCalculator = WorkoutCalculatorFactory.get();

        loginPage
                .open()
                .login("blablablablablabla@maillinator.com", "KarinaKarina12");
        WorkoutCalculatorListPage
                .open()
                .clickWorkoutCalculator()
                .createIntensityCalculator(workoutCalculator);
        boolean message = driver.findElement(By.xpath("//h4[contains(text(), 'Your Workout Paces')]")).isDisplayed();
        Assert.assertTrue(message, "Error filling out the Intensity Workout Form");
    }

    @Test(description = "Calculator Hansons test")
    public void calculatorHansonsTest() {

        WorkoutCalculator workoutCalculator = WorkoutCalculatorFactory.get();

        loginPage
                .open()
                .login("blablablablablabla@maillinator.com", "KarinaKarina12");
        WorkoutCalculatorListPage
                .open()
                .clickWorkoutCalculatorAndHansonsButton()
                .createHansonsCalculator(workoutCalculator);
        boolean message = driver.findElement(By.xpath("//h4[contains(text(), 'Recent Race Information')]")).isDisplayed();
        Assert.assertTrue(message, "Error filling out the Hansons Workout Form");
    }


}
