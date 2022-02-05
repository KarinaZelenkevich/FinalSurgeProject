package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    public static final By DASHBOARD_BUTTON = By.xpath("//*[@class='icsw16-home']");

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
}

