package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

@Log4j2
public class DropDown {

    private static final String DROPDOWN_PATTERN = "//select[@id='%s']";

    WebDriver driver;
    String label;

    public DropDown(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void selectDropdown(String optionText) {
        WebElement dropdown = driver.findElement(By.id(label));
        Select select = new Select(dropdown);
        select.selectByVisibleText(optionText);
    }
}