package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class WorkoutCalculatorListPage extends BasePage {

    public static final By TITLE = By.id("dpMonth");
    public static final By CALCULATOR_BUTTON = By.xpath("//*[@class='icsw16-stop-watch']");
    private final static By IFRAME_BUTTON = By.id("IntensityCalciFrame");
    public static final By HANSONS_BUTTON = By.xpath("//a[contains(text(), 'Hansons')]");
    public static final By MCMILLAN_BUTTON = By.xpath("//a[contains(text(), 'McMillan')]");
    public static final By TINMAN_BUTTON = By.xpath("//a[contains(text(), 'Tinman')]");
    public static final By PALLADINO_BUTTON = By.xpath("//a[contains(text(), 'Palladino')]");

    public WorkoutCalculatorListPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpen() {
        return isExist(TITLE);
    }


    @Step("Open account page")
    public static WorkoutCalculatorListPage open() {
        log.info("Open Calendar Page {}", BASE_URL);
        driver.get(BASE_URL + "/Calendar.cshtml");
        return new WorkoutCalculatorListPage(driver);
    }

    @Step("Click workout calculator on calendar page")
    public IntensityPage clickWorkoutCalculator() {
        log.info("Click {} in order to open calculator page", CALCULATOR_BUTTON);
        wait.until(ExpectedConditions.visibilityOfElementLocated(CALCULATOR_BUTTON)).click();
        driver.switchTo().frame(driver.findElement(IFRAME_BUTTON));
        return new IntensityPage(driver);
    }

    @Step("Click workout calculator and then the Hansons button")
    public HansonsPage clickWorkoutCalculatorAndHansonsButton() {
        log.info("Click {} in order to open calculator page", CALCULATOR_BUTTON);
        wait.until(ExpectedConditions.visibilityOfElementLocated(CALCULATOR_BUTTON)).click();
        driver.switchTo().frame(driver.findElement(IFRAME_BUTTON));
        wait.until(ExpectedConditions.visibilityOfElementLocated(HANSONS_BUTTON)).click();
        return new HansonsPage(driver);
    }

    @Step("Click workout calculator and then the McMillan button")
    public McMillanPage clickWorkoutCalculatorAndMcMillanButton() {
        log.info("Click {} in order to open calculator page", CALCULATOR_BUTTON);
        wait.until(ExpectedConditions.visibilityOfElementLocated(CALCULATOR_BUTTON)).click();
        driver.switchTo().frame(driver.findElement(IFRAME_BUTTON));
        log.info("Click {} in order to open the McMillan workout on the calculator page", MCMILLAN_BUTTON);
        wait.until(ExpectedConditions.visibilityOfElementLocated(MCMILLAN_BUTTON)).click();
        ;
        return new McMillanPage(driver);
    }

    @Step("Click workout calculator and then the Tinman button")
    public TinmanPage clickWorkoutCalculatorAndTinmanButton() {
        log.info("Click {} in order to open calculator page", CALCULATOR_BUTTON);
        wait.until(ExpectedConditions.visibilityOfElementLocated(CALCULATOR_BUTTON)).click();
        driver.switchTo().frame(driver.findElement(IFRAME_BUTTON));
        log.info("Click {} in order to open the Tinman workout on the calculator page", TINMAN_BUTTON);
        wait.until(ExpectedConditions.visibilityOfElementLocated(TINMAN_BUTTON)).click();
        return new TinmanPage(driver);
    }

    @Step("Click workout calculator and then the Palladino button")
    public PalladinoPage clickWorkoutCalculatorAndPalladinoButton() {
        log.info("Click {} in order to open calculator page", CALCULATOR_BUTTON);
        wait.until(ExpectedConditions.visibilityOfElementLocated(CALCULATOR_BUTTON)).click();
        driver.switchTo().frame(driver.findElement(IFRAME_BUTTON));
        log.info("Click {} in order to open the Palladino workout on the calculator page", PALLADINO_BUTTON);
        wait.until(ExpectedConditions.visibilityOfElementLocated(PALLADINO_BUTTON)).click();
        return new PalladinoPage(driver);
    }
}