package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


@Log4j2
public class PrintPage extends BasePage {

    private static final By PRINT_DETAILS = By.xpath("//div[@class='w-box']");

    public PrintPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpen() {
        return isExist(PRINT_DETAILS);

    }

    public PrintPage open() {
        driver.get(BASE_URL + "/PrintWorkouts.cshtml");
        return this;
    }
}
