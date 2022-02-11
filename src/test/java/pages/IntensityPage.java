package pages;

import elements.Input;
import elements.RadioButton;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.WorkoutCalculator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

@Log4j2
public class IntensityPage extends BasePage {

    public static final By MODAL_TITLE = By.id("//*[@class='w-box-header']//h4[contains(text(), " + "'Running Workout Intensity Calculator')]");
    public static final By SAVE_BUTTON = By.id("saveButtonSettings");

    public IntensityPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpen() {
        return isExist(MODAL_TITLE);
    }

    @Step("Filling in the form calculator Intensity workout")
    public WorkoutCalculatorDetailsPage createIntensityCalculator(WorkoutCalculator workoutCalculator) {
        log.info("Filling in the form calculator Intensity workout");
        new Input(driver, "TimeHH").writeWorkout(workoutCalculator.getHoursIntensity());
        new Input(driver, "TimeMM").writeWorkout(workoutCalculator.getMinutesIntensity());
        new Input(driver, "TimeSS").writeWorkout(workoutCalculator.getSecondsIntensity());
        new RadioButton(driver, " 10Km").selectRadioButton(workoutCalculator.getSelectEvent());
        save();
        return new WorkoutCalculatorDetailsPage(driver);
    }

    public void save() {
        driver.findElement(SAVE_BUTTON).click();
    }


    @Step("Checking intensity paces was opened")
    public void checkingCalculationWasOpened() {
        Assert.assertTrue(WorkoutCalculatorDetailsPage.checkCalculationsIsOpened(), "Calculations did not open");
    }

}
