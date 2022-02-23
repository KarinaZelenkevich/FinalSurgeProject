package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class HomePage extends BasePage {
    public static final By DASHBOARD_BUTTON = By.xpath("//*[@class='icsw16-home']");
    private static final By LOGOUT_LINK = By.xpath("//a[text()='Logout']");
    private static final By LOGOUT_MESSAGE = By.cssSelector("[class^='alert']");
    private static final By PRINT_WORKOUTS_LINK = By.xpath("//nav//li//i[@class='icsw16-printer']/..");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage open() {
        driver.get(BASE_URL + "/Default.cshtml");
        return this;
    }

    @Override
    public boolean isPageOpen() {
        return isExist(DASHBOARD_BUTTON);
    }

    @Step("Clicking 'Logout' link")
    public void clickLogoutButton() {
        log.info("clicking 'Logout' link");
        driver.findElement(LOGOUT_LINK).click();
    }

    @Step("Getting message about successfully logged out of the system")
    public static String getLogoutMessage() {
        log.info("getting message about successfully logged out of the system");
        return driver.findElement(LOGOUT_MESSAGE).getText();
    }

    @Step("Clicking 'Print Workouts' link")
    public void clickPrintWorkouts() {
        log.info("clicking 'Print Workouts' link");
        driver.findElement(PRINT_WORKOUTS_LINK).click();
    }

}

