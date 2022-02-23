package pages;

import elements.DropDown;
import elements.Input;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.WorkoutCalculator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class HansonsPage extends BasePage {

    public static final By MODAL_TITLE = By.id("//*[@class='w-box-header']//h4[contains(text()," +
            " 'Hansons Marathon Method Pace Calculator')]");
    public static final By SAVE_BUTTON = By.id("saveButtonSettings");

    public HansonsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpen() {
        return isExist(MODAL_TITLE);
    }


    @Step("Filling in the form calculator Hansons workout")
    public WorkoutCalculatorDetailsPage createHansonsCalculator(WorkoutCalculator workoutCalculator) {
        log.info("Filling in the form calculator Hansons workout");
        new DropDown(driver, "RaceDist").selectDropdown(workoutCalculator.getRaceDist());
        new Input(driver, "Distance").write(workoutCalculator.getDistanceHansons());
        new Input(driver, "TimeHH").write(workoutCalculator.getHoursHansons());
        new Input(driver, "TimeMM").write(workoutCalculator.getMinutesHansons());
        new Input(driver, "TimeSS").write(workoutCalculator.getSecondsHansons());
        new Input(driver, "Temp").write(workoutCalculator.getTemperature());
        new DropDown(driver, "TempType").selectDropdown(workoutCalculator.getTempType());
        new Input(driver, "Humid").write(workoutCalculator.getHumidity());
        new Input(driver, "Wind").write(workoutCalculator.getWindSpeed());
        new DropDown(driver, "SpeedType").selectDropdown(workoutCalculator.getSpeedType());
        save();
        return new WorkoutCalculatorDetailsPage(driver);
    }

    public void save() {
        driver.findElement(SAVE_BUTTON).click();
    }
}
