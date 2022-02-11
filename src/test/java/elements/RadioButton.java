package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RadioButton {

    WebDriver driver;
    String label;
    String RADIO_BUTTON = "//label[contains(.,'%s')]/input";

    public RadioButton(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void selectRadioButton(String text) {
        System.out.println(String.format("Writing text '%s' into input with label %s", text, label));
        driver.findElement(By.xpath(String.format(RADIO_BUTTON, label))).click();
    }

}
