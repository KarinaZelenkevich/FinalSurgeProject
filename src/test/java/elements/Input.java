package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class Input {
    String inputLocator = "//div[contains(@class, 'modal-body')]//span[text()='%s']/ancestor::div[contains(@class, 'uiInput')]//input";
    String inputLocatorInProfileForm = "//div/input[@id='%s']";
    String inputLocatorForStartDate = "//input[@id='PrintStartDate']";
    String inputLocatorForEndingDate = "//input[@id='PrintEndDate']";
    WebDriver driver;
    String label;
    String inputLocatorWorkout = "//input[@id='%s']";

    public Input(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void write(String text) {
        System.out.println(String.format("Writing text '%s' into input with label %s", text, label));
        driver.findElement(By.xpath(String.format(inputLocatorWorkout, label))).sendKeys(text);
    }
    public void writeInProfileForm(String text) {
        System.out.println(String.format("Writing text '%s' into input with label %s", text, label));
        driver.findElement(By.xpath(String.format(inputLocatorInProfileForm, label))).sendKeys(text);
    }
    public void writeInPrintFormStartDate(String text) {
        System.out.println(String.format("Writing text '%s' into input with label %s", text, label));
        driver.findElement(By.xpath(String.format(inputLocatorForStartDate, label))).sendKeys(text);
    }
    public void writeInPrintFormEndingDate(String text) {
        System.out.println(String.format("Writing text '%s' into input with label %s", text, label));
        driver.findElement(By.xpath(String.format(inputLocatorForEndingDate, label))).sendKeys(text);
    }
}
