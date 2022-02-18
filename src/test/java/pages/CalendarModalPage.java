package pages;

import elements.DropDown;
import elements.Input;
import elements.TextArea;
import lombok.extern.log4j.Log4j2;
import models.Calendar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


@Log4j2
public class CalendarModalPage extends BasePage {
    public static final By ADD_WORKOUT_BUTTON = By.id("saveButton");
    public static final By MODAL_TITLE = By.id("WorkoutAddHeader");
    public static final By WORKOUT_DATE = By.id("WorkoutDate");
    public static final By WORKOUT_PACE = By.id("Pace");


    public CalendarModalPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpen() {
        return isExist(MODAL_TITLE);
    }

    public CalendarDetailsPage addSportsEvent(Calendar calendar) {
        log.info("Filling in the form quick add workout");
        driver.findElement(WORKOUT_DATE).clear();
        new Input(driver, "WorkoutDate").writeWorkout(calendar.getWorkoutDate());
        new Input(driver, "WorkoutTime").writeWorkout(calendar.getTimeOfDay());
        new DropDown(driver, "ActivityType").selectDropdown(calendar.getActivityType());
        new Input(driver, "Name").writeWorkout(calendar.getWorkoutName());
        new TextArea(driver, "Desc").write(calendar.getDesc());
        new Input(driver, "Distance").writeWorkout(calendar.getDistance());
        new DropDown(driver, "DistType").selectDropdown(calendar.getDistType());
        new Input(driver, "Duration").writeWorkout(calendar.getDuration());
        new Input(driver, "Pace").writeWorkout(calendar.getDistance());
        new DropDown(driver, "PaceType").selectDropdown(calendar.getPaceType());
        new DropDown(driver, "HowFeel").selectDropdown(calendar.getHowIFelt());
        new DropDown(driver, "PerEffort").selectDropdown(calendar.getPerceivedEffort());
        new TextArea(driver, "PostDesc").write(calendar.getPostDesc());
        return clickAddWorkoutButton();

    }

    public CalendarDetailsPage clickAddWorkoutButton() {
        driver.findElement(ADD_WORKOUT_BUTTON).click();
        return new CalendarDetailsPage(driver);
    }


}
