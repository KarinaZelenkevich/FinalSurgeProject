package pages;

import io.qameta.allure.Step;
import jdk.jfr.Description;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

@Log4j2
public class CalendarListPage extends BasePage {
    public static final By QUICK_BUTTON = By.id("QuickAddToggle");
    public static final By ERROR_MESSAGE = By.cssSelector(".alert");
    public static final By CALENDAR_LABEL = By.xpath("//ul[@id='breadcrumbs']//a[@href='Calendar.cshtml']");
    private static final By WORKOUT_LIBRARY_BUTTON = By.id("WorkoutLibAdd");
    private final static String WORKOUT_EVENT = ".fc-event-activity";
    public CalendarListPage(WebDriver driver) {
        super(driver);

    }


    @Description("Open calendar page")
    public CalendarListPage open() {
        log.info("Open Calendar Page {}", BASE_URL);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.get(BASE_URL + "/Calendar.cshtml");
        WebDriverWait wait2 = new WebDriverWait(driver, 10);
        return this;
    }

    public void openWorkoutLibraryPanel() {
        log.info("Click {} in order to open workout library", WORKOUT_LIBRARY_BUTTON);
        driver.findElement(WORKOUT_LIBRARY_BUTTON).click();
    }
    @Override
    public boolean isPageOpen() {
        return isExist(CALENDAR_LABEL);
    }


    @Step("Click quick add workout on calendar page")
    public CalendarModalPage clickQuickAdd() {
        log.info("Click {} in order to open quick add workout", QUICK_BUTTON);
        driver.findElement(QUICK_BUTTON).click();
        return new CalendarModalPage(driver);
    }


    @Step("Get message")
    public static String getMessage() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }

}
