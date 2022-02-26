package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WorkoutCalculatorDetailsPage extends BasePage {

    public static final By PACES_HEADER = By.xpath("//h4[contains(.,'Your Workout Paces')]/ancestor::div[@class='w-box-header']");
    public static final By TIMES_HEADER = By.xpath("//h4[contains(.,'Equivalent Event Performance Times Based on your PR')]/ancestor::div[@class='w-box-header']");
    public static final By SPLITS_HEADER = By.xpath("//h4[contains(.,'VO2 Max Workout Splits')]/ancestor::div[@class='w-box-header']");

    public WorkoutCalculatorDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpen() {
        return false;
    }
    @Step("Check Calculations Is Opened")
    public static boolean checkCalculationsIsOpened() {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(PACES_HEADER));
        wait.until(ExpectedConditions.visibilityOfElementLocated(TIMES_HEADER));
        wait.until(ExpectedConditions.visibilityOfElementLocated(SPLITS_HEADER));
        return true;
    }
}
