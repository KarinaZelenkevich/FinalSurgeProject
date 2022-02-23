package pages;


import io.qameta.allure.Step;
import jdk.jfr.Description;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDate;


@Getter
@Log4j2
public class CalendarPage extends BasePage {
    private static final By CALENDAR = By.id("CalendarContent");
    private static final By CALENDAR_BUTTON = By.className("icsw16-day-calendar");
    private static final By QUICK_ADD_WORKOUT = By.id("QuickAddToggle");
    private static final By WORKOUT_LIBRARY_BUTTON = By.id("WorkoutLibAdd");
    private static final By WORKOUT_LIBRARY_HEADER = By.xpath("//h4[contains(.,'Workout Library')]/ancestor::div[@class='w-box-header']");
    private static final By LIBRARY = By.xpath("//option[contains(.,'Run')]/ancestor::div[@class='w-box-content']//ul");
    private static final String DATA_PATTERN = "//td[@data-day='%s' and @data-month='%s' and @data-year='%s']";
    public static final String WORKOUTS = "//td//div[@data-date='%s/%s/%s']";
    String nameOfEvent = "//div[contains(text(),'%s')]/ancestor::div[contains(@class , 'dropdown')]/ancestor::td";
    String selectDataDay = "//div[contains(@class , 'dropdown')]/ancestor::td[@data-day = '%s' and @data-month = '%s' and @data-year = '%s']";

    public CalendarPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpen() {
        log.info("Check that Calendar page is opened");
        wait.until(ExpectedConditions.visibilityOfElementLocated(CALENDAR));
        return isExist(CALENDAR);
    }

    @Description("Open calendar page")
    public CalendarPage open() {
        log.info("Open Calendar Page {}", BASE_URL);
        driver.get(BASE_URL + "/Calendar.cshtml#");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        return this;
    }

    @Step("ReschedulingAWorkoutToANewDate {workoutName} in the calendar")
    public void reschedulingAWorkoutToANewDate(String workoutName) {
        int currentDay = LocalDate.now().getDayOfMonth();
        int currentMonth = LocalDate.now().getMonthValue();
        int currentYear = LocalDate.now().getYear();
        String day = String.format("%s", currentDay + 1);
        log.info("Find element");
        WebElement element = driver.findElement(By.xpath(String.format(nameOfEvent, workoutName)));
        log.info("Find target");
        WebElement target = driver.findElement(By.xpath(String.format(selectDataDay, day, currentMonth, currentYear)));
        (new Actions(driver)).dragAndDrop(element, target).perform();
    }


}