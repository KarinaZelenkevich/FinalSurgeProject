package pages;

import elements.Input;
import elements.RadioButton;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.WorkoutCalculator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import tests.WorkoutCalculatorTest;

@Log4j2
public class TinmanPage extends BasePage {

    public static final By MODAL_TITLE = By.id("//*[@class='w-box-header']//h4[contains(text()," +
            " 'Running Calculator by Tom Schwartz')]");
    public static final By SAVE_BUTTON = By.id("saveButtonSettings");

    public TinmanPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpen() {
        return isExist(MODAL_TITLE);
    }

    @Step("Filling in the form calculator Tinman workout")
    public WorkoutCalculatorDetailsPage createTinmanCalculator(WorkoutCalculator workoutCalculator) {
        log.info("Filling in the form calculator Tinman workout");
        new Input(driver, "TimeHH").writeWorkout(workoutCalculator.getHoursTinman());
        new Input(driver, "TimeMM").writeWorkout(workoutCalculator.getMinutesTinman());
        new Input(driver, "TimeSS").writeWorkout(workoutCalculator.getSecondsTinman());
        new RadioButton(driver, " Female").selectRadioButton(workoutCalculator.getGender());
        save();
        return new WorkoutCalculatorDetailsPage(driver);
    }

    public void save() {
        driver.findElement(SAVE_BUTTON).click();
    }
}
