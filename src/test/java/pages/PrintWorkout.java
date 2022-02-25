package pages;

import elements.Input;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.PrintWorkouts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class PrintWorkout extends BasePage {


    private static final By PRINT_WORKOUTS_BUTTON = By.id("saveButtonPrint");
    private static final By PRINT_WORKOUTS_IFRAME = By.id("PrintWorkoutsiFrame");
    private static final By PRINT_WORKOUTS_TITLE = By.xpath("//div//h4[contains(text(), 'Print Workouts')]");


    public PrintWorkout(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpen() {
        return isExist(PRINT_WORKOUTS_TITLE);
    }

    @Step("Clicking 'Print Workouts' button")
    public void clickPrintWorkoutsButton() {
        log.info("clicking 'Print Workouts' button");
        driver.findElement(PRINT_WORKOUTS_BUTTON).click();
    }

    @Step("Filling 'Print Workouts' form")
    public void fillForm(PrintWorkouts printWorkouts) {
        driver.switchTo().frame(driver.findElement(PRINT_WORKOUTS_IFRAME));
        new Input(driver, "Print Starting Date").writeInPrintFormStartDate(printWorkouts.getStartDate());
        new Input(driver, "Print Ending Date").writeInPrintFormEndingDate(printWorkouts.getEndDate());
        clickPrintWorkoutsButton();
    }


}