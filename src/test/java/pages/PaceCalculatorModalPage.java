package pages;

import elements.DropDown;
import elements.Input;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.PaceCalculator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.AllureUtils;


@Log4j2
public class PaceCalculatorModalPage extends BasePage {
    private final static By PACE_CALCULATOR_IS_OPENED = By.xpath("//button[text()='Pace Calculator']");
    private final static By PACE_CALCULATOR_RESULTS = By.xpath("//div[@class='w-box-header']/h4[text()='Pace Calculator']");
    private final static By PACE_CALCULATOR_MODAL_TITLE = By.xpath("//div/a[text()='Pace Calculator']");
    private final static By CALCULATE_PACES_BUTTON = By.id("saveButtonSettings");
    private final static By OTHER_CALCULATORS_TITLE = By.xpath("//i[@class='icsw16-calculator']");

    public PaceCalculatorModalPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpen() {
        return isExist(PACE_CALCULATOR_IS_OPENED );
    }


    @Step("Open 'PaceCalculator' page")
    public static PaceCalculatorModalPage open() {
        log.info("Open 'PaceCalculator' page {}");
        driver.findElement(OTHER_CALCULATORS_TITLE).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(PACE_CALCULATOR_MODAL_TITLE));
        driver.findElement(PACE_CALCULATOR_MODAL_TITLE).click();
        return new PaceCalculatorModalPage(driver);
    }

    @Step("Filling 'Pace Calculator' form")
    public static PaceCalculatorModalPage fillInForm(PaceCalculator paceCalculator) {
        new DropDown(driver, "km").selectDropdownInPaceCalculator(paceCalculator.getDistance());
        new Input(driver, "RunDist").write(paceCalculator.getDistance());
        new Input(driver, "TimeHH").write(paceCalculator.getHours());
        new Input(driver, "TimeMM").write(paceCalculator.getMinutes());
        new Input(driver, "TimeSS").write(paceCalculator.getSeconds());
       return new PaceCalculatorModalPage(driver);
    }

    @Step("Clicking 'Calculate Pace' button")
    public void clickCalculateButton() {
        log.info("clicking 'Calculate Pace' button");
        driver.findElement(CALCULATE_PACES_BUTTON);
    }

    @Step("Table 'Pace Chart' is visible")
    public boolean paceChartTableIsVisible() {
        log.info("Table 'Pace Chart' is visible");
        return driver.findElement(PACE_CALCULATOR_RESULTS).isDisplayed();
    }
}
