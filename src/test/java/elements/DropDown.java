package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import static java.awt.SystemColor.text;

@Log4j2
public class DropDown {

    private static final String DROPDOWN_BDAY = "//input[@id='%s']";
    private static final String DROPDOWN_IN_PROFILE_FORM_FOR_COUNTRY = "//select[@id='%s']";
    private static final String DROPDOWN_IN_PACE_CALCULATOR = "//select[@id='DistType']/option[text()='%s']";

    WebDriver driver;
    String label;

    public DropDown(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void selectDropdown(String text1) {
        System.out.println(String.format("Writing text '%s' into DropDown with label %s", text, label));
        driver.findElement(By.xpath(String.format(DROPDOWN_IN_PROFILE_FORM_FOR_COUNTRY, label))).sendKeys(text1);
    }
    public void selectDropdownBday(String text2) {
        System.out.println(String.format("Writing text '%s' into DropDown with label %s", text, label));
        driver.findElement(By.xpath(String.format(DROPDOWN_BDAY, label))).sendKeys(text2);
    }
    public void selectDropdownInProfileFormForCountry(String text) {
        System.out.println(String.format("Writing text '%s' into DropDown with label %s", text, label));
        driver.findElement(By.xpath(String.format(DROPDOWN_IN_PROFILE_FORM_FOR_COUNTRY, label))).sendKeys(text);
    }
    public void selectDropdownInPaceCalculator(String text) {
        System.out.println(String.format("Writing text '%s' into DropDown with label %s", text, label));
        driver.findElement(By.xpath(String.format(DROPDOWN_IN_PACE_CALCULATOR, label))).click();
    }
}