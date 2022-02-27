package pages;

import elements.DropDown;
import elements.Input;
import elements.RadioButton;
import elements.TextArea;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.WorkoutFullAdd;
import models.WorkoutQuickAdd;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;


@Log4j2
public class WorkoutPage extends BasePage {
    public static final By QUICK_ADD_BUTTON = By.id("QuickAddToggle");
    public static final By QUICK_ADD_FORM = By.id("QuickAdd");
    public static final By SAVE_QUICK_ADD_WORKOUT = By.id("saveButton");
    public static final By POPUP_SAVE_BUTTON = By.xpath("//div[@class = 'modal-footer']//a[contains(text(), 'OK')]");
    public static final By WORKOUT_DATE = By.id("WorkoutDate");
    public static final By ALERT = By.cssSelector(".alert");
    String quickDelete = "//div[contains(text(),'%s')]/ancestor::div[contains(@class , 'dropdown')]/ul//li/a[contains(@class, 'quick-delete')]";
    String calendarTitleLocator = "//div[contains(text(),'%s')]";

    public WorkoutPage(WebDriver driver) {
        super(driver);
    }


    @Step("Open workout quick add page")
    public WorkoutPage openWorkoutQuickAdd() {
        driver.findElement(QUICK_ADD_BUTTON).click();
        return new WorkoutPage(driver);
    }


    @Step("Add workout through the quick add")
    public WorkoutPage workOutQuickAdd(WorkoutQuickAdd workout) {
        log.info("Adding new workout");
        driver.findElement(WORKOUT_DATE).clear();
        new Input(driver, "WorkoutDate").write(workout.getDate());
        new Input(driver, "WorkoutTime").write(workout.getTime());
        new DropDown(driver, "ActivityType").selectDropdown(workout.getActivityType());
        new Input(driver, "Name").write(workout.getWorkoutName());
        new TextArea(driver, "Desc").write(workout.getDescription());
        new Input(driver, "Distance").write(workout.getDistance());
        new Input(driver, "Duration").write(workout.getDuration());
        new DropDown(driver, "HowFeel").selectDropdown(workout.getHowIFelt());
        new DropDown(driver, "PerEffort").selectDropdown(workout.getPerceivedEffort());
//        new RadioButton(driver, "SaveLibrary").selectRadioButton(workout.isSavedToLibrary());
        return new WorkoutPage(driver);
    }

    @Step("Save workout quick add form")
    public void saveQuickAddForm() {
        log.info("Click on save button" + SAVE_QUICK_ADD_WORKOUT);
        driver.findElement(SAVE_QUICK_ADD_WORKOUT).click();
    }

    @Step("Take alert message after workout is added")
    public String getAlert() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ALERT));
        return driver.findElement(ALERT).getText();
    }

    @Step("Check that workout with {workoutTitle} was added to the calendar")
    public boolean checkWorkoutWasAddedToCalendar(String workoutTitle) {
        log.info("Check workout with name " + workoutTitle + " was added");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(calendarTitleLocator, workoutTitle))));
        return driver.findElement(By.xpath(String.format(calendarTitleLocator, workoutTitle))).isDisplayed();
    }

    @Override
    public boolean isPageOpen() {
        log.info("Check that workout quick add form page is opened");
        wait.until(ExpectedConditions.visibilityOfElementLocated(QUICK_ADD_FORM));
        return isExist(QUICK_ADD_FORM);
    }

    @Step("Fill in base fields for any Activity type")
    public WorkoutFullAddPage fullAdd(WorkoutFullAdd workoutFullAdd) {
        driver.findElement(WORKOUT_DATE).clear();
        new Input(driver, "WorkoutDate").write(workoutFullAdd.getDate());
        new Input(driver, "Name").write(workoutFullAdd.getWorkoutName());
        new TextArea(driver, "Desc").writeFullAdd(workoutFullAdd.getDescription());
        String feeling = workoutFullAdd.getHowIFelt();
        new Input(driver, "Distance").write(workoutFullAdd.getDistance());
        new Input(driver, "Duration").write(workoutFullAdd.getDuration());
        new Input(driver, "Pace").write(workoutFullAdd.getPace());
        new Input(driver, "Duration").write(workoutFullAdd.getDuration());
        new Input(driver, "MinHR").write(workoutFullAdd.getMinHR());
        new Input(driver, "AvgHR").write(workoutFullAdd.getAvgHR());
        new Input(driver, "MaxHR").write(workoutFullAdd.getMaxHR());
        new Input(driver, "kCal").write(workoutFullAdd.getCaloriesBurned());
        new RadioButton(driver, selectHowIFelt(feeling)).selectRadioButtonInFullAdd(selectHowIFelt(feeling));
        new DropDown(driver, "PerEffort").selectDropdown(workoutFullAdd.getPerceivedEffort());
        return new WorkoutFullAddPage(driver);
    }

    public String selectHowIFelt(String howFeel) {
        switch (howFeel) {
            case "Great":
                howFeel = "Great";
                break;
            case "Good":
                howFeel = "Good";
                break;
            case "Normal":
                howFeel = "Normal";
                break;
            case "Poor":
                howFeel = "Poor";
                break;
            case "Terrible":
                howFeel = "Terrible";
                break;
        }
        return howFeel;
    }
}
