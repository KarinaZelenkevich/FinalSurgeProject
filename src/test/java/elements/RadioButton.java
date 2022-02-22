package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RadioButton {

    WebDriver driver;
    String label;
    String RADIO_BUTTON = "//label[contains(.,'%s')]/input";
    String RADIO_BUTTON_IN_PROFILE_FORM = "//div/label[text()='%s']";
    String RADIO_BUTTON_IN_FULL_ADD = "//label//span[text()='%s']/..";

    public RadioButton(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void selectRadioButton(String text) {
        System.out.println(String.format("Writing text '%s' into input with label %s", text, label));
        driver.findElement(By.xpath(String.format(RADIO_BUTTON, label))).click();
    }
    public void selectRadioButtonInProfileForm(String text) {
        System.out.println(String.format("Writing text '%s' into input with label %s", text, label));
        driver.findElement(By.xpath(String.format(RADIO_BUTTON_IN_PROFILE_FORM, label))).click();
    }
    public void selectRadioButtonInFullAdd(String text) {
        System.out.println(String.format("Writing text '%s' into input with label %s", text, label));
        driver.findElement(By.xpath(String.format(RADIO_BUTTON_IN_FULL_ADD, label))).click();
    }
}
