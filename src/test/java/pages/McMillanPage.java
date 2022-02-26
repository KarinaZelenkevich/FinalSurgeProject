package pages;

import elements.DropDown;
import elements.Input;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.WorkoutCalculator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import tests.WorkoutCalculatorTest;

@Log4j2
public class McMillanPage extends BasePage {

    public static final By MODAL_TITLE = By.id("//*[@class='w-box-header']//h4[contains(text()," +
            " 'McMillan Running Calculator')]");
    public static final By SAVE_BUTTON = By.id("saveButtonSettings");

    public McMillanPage(WebDriver driver) {
        super(driver);
    }


    @Step("Filling in the form calculator McMillan workout")
    public WorkoutCalculatorDetailsPage createMcMillanCalculator(WorkoutCalculator workoutCalculator) {
        log.info("Filling in the form calculator McMillan workout");
        new DropDown(driver, "distance").selectDropdown(workoutCalculator.getDistanceMillan());
        new Input(driver, "TimeHH").write(workoutCalculator.getHoursMillan());
        new Input(driver, "TimeMM").write(workoutCalculator.getMinutesMillan());
        new Input(driver, "TimeSS").write(workoutCalculator.getSecondsMillan());
        save();
        return new WorkoutCalculatorDetailsPage(driver);
    }


    public void save() {
        driver.findElement(SAVE_BUTTON).click();
    }

    @Override
    public boolean isPageOpen() {
        return isExist(MODAL_TITLE);
    }
}
