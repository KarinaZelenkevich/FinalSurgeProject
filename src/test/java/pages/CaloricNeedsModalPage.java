package pages;

import elements.Input;
import elements.RadioButton;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.CaloricNeeds;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class CaloricNeedsModalPage extends BasePage {
    private final static By OTHER_CALCULATORS_TITLE = By.xpath("//i[@class='icsw16-calculator']");
    private final static By CALCULATE_BUTTON = By.name("btnSubmitSettings");
    private final static By OTHER_CALCULATOR_FRAME = By.id("OtherCalciFrame");
    private final static By PACE_CALCULATOR_BUTTON = By.xpath("//a[contains(text(),'Pace Calculator')]");
    private final static By CALORIC_NEEDS_MODAL_TITLE = By.xpath("//div[@class='w-box-header']/h4[text()='Daily Caloric Needs Calculator']");

    public CaloricNeedsModalPage(WebDriver driver) {
        super(driver);
    }

    @Override
    @Step("PopUp'Caloric needs' is visible")
    public boolean isPageOpen() {
        return isExist(CALORIC_NEEDS_MODAL_TITLE);
    }

    @Step("Open 'Other Calculators' page")
    public static CaloricNeedsModalPage open() {
        log.info("Open 'Other Calculators' page {}");
        driver.findElement(OTHER_CALCULATORS_TITLE).click();
        return new CaloricNeedsModalPage(driver);
    }

    @Step("Filling 'Caloric Needs Calculator' form")
    public CaloricNeedsModalPage fillForm(CaloricNeeds caloricNeeds) {
        driver.switchTo().frame(driver.findElement(OTHER_CALCULATOR_FRAME));
        new RadioButton(driver, "kg").selectRadioButton(caloricNeeds.getWeight());
        new RadioButton(driver, "centimeters").selectRadioButton(caloricNeeds.getHeight());
        new RadioButton(driver, "female").selectRadioButton(caloricNeeds.getGender());
        new RadioButton(driver, "kilometers").selectRadioButton(caloricNeeds.getDistance());
        new Input(driver, "Weight").write(caloricNeeds.getWeight());
        new Input(driver, "HeightInchCent").write(caloricNeeds.getHeight());
        new Input(driver, "Age").write(caloricNeeds.getAge());
        new Input(driver, "RunDist").write(caloricNeeds.getDistance());
        return this;
    }

    @Step("Clicking 'Calculate Caloric Needs' button")
    public void clickCalculateButton() {
        log.info("clicking 'Calculate Caloric Needs' button");
        driver.findElement(CALCULATE_BUTTON).click();
    }

    @Step("Clicking 'Pace Calculator' button")
    public PaceCalculatorModalPage clickPaceCalculatorButton() {
        driver.switchTo().frame(driver.findElement(OTHER_CALCULATOR_FRAME));
        log.info("clicking 'Pace Calculator' button");
        driver.findElement(PACE_CALCULATOR_BUTTON);
        return new PaceCalculatorModalPage(driver);
    }

}