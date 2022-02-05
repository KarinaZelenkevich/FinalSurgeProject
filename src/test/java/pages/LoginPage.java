package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class LoginPage extends BasePage {
    public static final By EMAIL_INPUT = By.name("login_name");
    public static final By PASSWORD = By.id("login_password");
    public static final By LOGIN_BUTTON = By.xpath("//button[contains(text(), 'Login')]");


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpen() {
        return isExist(LOGIN_BUTTON);
    }

    public LoginPage open() {
        log.debug("Start open method on LoginPage");
        driver.get(BASE_URL);
        log.debug("Completing the open method on the LoginPage");
        return this;
    }

    public HomePage login(String userEmail, String password) {
        log.debug("Starting the login method on the LoginPage");
        driver.findElement(EMAIL_INPUT).sendKeys(userEmail);
        driver.findElement(PASSWORD).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        log.debug("Completing the login method on the LoginPage");
        return new HomePage(driver);
    }

}