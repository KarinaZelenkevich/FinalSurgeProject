package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class CalendarDetailsPage extends BasePage {
    public static final By EVENT_DETAILS_LINK = By.xpath("//ul[@id='breadcrumbs']//a[@href='Calendar.cshtml']");

    public CalendarDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpen() {
        log.debug("Go to the AccountsDetailsPage");
        driver.findElement(EVENT_DETAILS_LINK).click();
        return isExist(EVENT_DETAILS_LINK);
    }
}
