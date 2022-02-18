package pages;

import elements.Input;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.WorkoutCalculator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import tests.WorkoutCalculatorTest;

@Log4j2
public class PalladinoPage extends BasePage {

    public static final By MODAL_TITLE = By.id("//*[@class='w-box-header']//h4[contains(text(), " +
            "'Palladino Power Project - Interval Power Target Calculator')]");
    public static final By SAVE_BUTTON = By.id("saveButtonSettings");

    public PalladinoPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpen() {
        return isExist(MODAL_TITLE);
    }


    @Step("Filling in the form calculator Palladino workout")
    public WorkoutCalculatorDetailsPage createPalladinoCalculator(WorkoutCalculator workoutCalculator) {
        log.info("Filling in the form calculator Palladino workout");
        new Input(driver, "CP").writeWorkout(workoutCalculator.getCP());
        new Input(driver, "RWC").writeWorkout(workoutCalculator.getRWC());
        save();
        return new WorkoutCalculatorDetailsPage(driver);
    }

    public void save() {
        driver.findElement(SAVE_BUTTON).click();
    }
}