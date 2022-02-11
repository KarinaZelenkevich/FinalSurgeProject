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
        new TextArea(driver, "Workout Description").write(calendar.getWorkoutDescription());
        new Input(driver, "PDistance").writeWorkout(calendar.getPlannedDistance());
        new DropDown(driver, "DistType").selectDropdown(calendar.getDistType());
        new Input(driver, "PDuration").writeWorkout(calendar.getPlannedDuration());
        new Input(driver, "Distance").writeWorkout(calendar.getDistance());
        new DropDown(driver, "DistType").selectDropdown(calendar.getDistType());
        new Input(driver, "Duration").writeWorkout(calendar.getDuration());
        driver.findElement(WORKOUT_PACE).clear();
        new Input(driver, "Pace").writeWorkout(calendar.getPace());
        new DropDown(driver, "PaceType").selectDropdown(calendar.getPaceType());
        new DropDown(driver, "HowFeel").selectDropdown(calendar.getHowIFelt());
        new DropDown(driver, "PerEffort").selectDropdown(calendar.getPerceivedEffort());
        new Input(driver, "Post Workout Notes/Results").writeWorkout(calendar.getPostWorkoutNotesResults());
        new Input(driver, "OverallPlace").writeWorkout(calendar.getOverallPlace());
        new Input(driver, "AgeGroupPlace").writeWorkout(calendar.getAgeGroupPlace());
        return new CalendarDetailsPage(driver);

    }

    public CalendarDetailsPage clickAddWorkoutButton() {
        driver.findElement(ADD_WORKOUT_BUTTON).click();
        return new CalendarDetailsPage(driver);
    }


}
