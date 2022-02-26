package pages;

import elements.DropDown;
import elements.Input;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.Reports;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class WorkoutReportsModalPage extends BasePage {

    private static final By VIEW_REPORT_BUTTON = By.id("saveButton");
    private static final By STARTING_DATE = By.id("WorkoutDate");
    private static final By ENDING_DATE = By.id("WorkoutDateEnd");
    private static final By ACTIVITY_COLUMN_OF_TABLE = By.xpath("//span[text()='Calvin Zieme - You want a toe? I can get you...']");

    public WorkoutReportsModalPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpen() {
        return isExist(VIEW_REPORT_BUTTON);
    }

    @Step("Filling 'Report Filters' form")
    public WorkoutReportsModalPage fillForm(Reports report) {
        new Input(driver, "WorkoutDate").clear(STARTING_DATE);
        new Input(driver, "WorkoutDate").write(report.getStartDate());
        new Input(driver, "WorkoutDateEnd").clear(ENDING_DATE);
        new Input(driver, "WorkoutDateEnd").write(report.getEndDate());
        new DropDown(driver, "ActivityType").selectDropdown(report.getActivityType());
        return this;
    }

    @Step("Clicking 'View Report' button")
    public void clickViewReportButton() {
        log.info("clicking 'View Report' button");
        driver.findElement(VIEW_REPORT_BUTTON);
    }

    @Step("Getting data from the actions column in the results table")
    public boolean getActivityFromTable() {
        log.info("getting data from the actions column in the results table");
        return driver.findElement(ACTIVITY_COLUMN_OF_TABLE).isDisplayed();
    }


    @Step("Open 'WorkourReports' page")
    public BasePage open() {
        driver.get(BASE_URL + "/WorkoutReport.cshtml");
        return this;
    }
}
