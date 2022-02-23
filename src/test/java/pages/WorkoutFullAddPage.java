package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class WorkoutFullAddPage extends BasePage {

    public static final By FULL_ADD_BUTTON = By.id("FullAddBtn");
    public static final By BREADCRUMB = By.xpath("//ul[@id=  'breadcrumbs']//a[contains(text(),'Add Workout')]");
    public static final By WORKOUT_DATE = By.id("WorkoutDate");
    public static final By SAVE_FULL_ADD_WORKOUT = By.id("saveButton");
    public static final By CLICK_ON_SPORT_TITLE = By.xpath("//div[@class='accordion']/div/div/a[contains(text(),'Run')]");
    public static final By CLICK_ON_SPORT_TYPE = By.xpath("//div//ul//li//a[text()='Long Run']");

    public WorkoutFullAddPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpen() {
        return false;
    }

    @Step("Check that workout full add page is opened")
    public boolean isPageOpened() {
        log.info("Check that Add workout page is opened");
        wait.until(ExpectedConditions.visibilityOfElementLocated(BREADCRUMB));
        return isExist(BREADCRUMB);
    }

    @Step("Open workout full add page")
    public WorkoutFullAddPage open() {
        driver.findElement(FULL_ADD_BUTTON).click();
        return new WorkoutFullAddPage(driver);
    }

    @Step("Sports selection in the menu on the left")
    public WorkoutPage clickOnSportType() {
        driver.findElement(CLICK_ON_SPORT_TITLE).click();
        driver.findElement(CLICK_ON_SPORT_TYPE).click();
        return new WorkoutPage(driver);
    }


    @Step("Save workout full add form")
    public void saveFullAddForm() {
        log.info("Click on save button" + SAVE_FULL_ADD_WORKOUT);
        driver.findElement(SAVE_FULL_ADD_WORKOUT).click();
    }

}