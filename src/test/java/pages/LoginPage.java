package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class LoginPage extends BasePage {
    public static final By EMAIL_INPUT = By.name("login_name");
    public static final By PASSWORD = By.id("login_password");
    public static final By LOGIN_BUTTON = By.xpath("//button[contains(text(), 'Login')]");
    public static final By ERROR_MESSAGE = By.xpath("//label[@class='error']");
    public static final By ERROR_MESSAGE_INVALID_PASSWORD = By.xpath("//field-footer__error]");


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Checking if the Login page is open")
    public boolean isPageOpen() {
        return isExist(LOGIN_BUTTON);
    }

    @Step("Open 'Login' page")
    public LoginPage open() {
        log.debug("Start open method on LoginPage");
        driver.get(BASE_URL);
        log.debug("Completing the open method on the LoginPage");
        return this;
    }

    public LoginPage errorMessage(String user, String password) {
        log.info("Error");
        login(user, password);
        return this;
    }

    @Step("Get error message")
    public static String getErrorMessage() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }

    @Step("Get error message for invalid data")
    public static String getErrorMessageWithInvalidPassword() {
        return driver.findElement(ERROR_MESSAGE_INVALID_PASSWORD).getText();
    }

    @Step("Starting the login method on the LoginPage")
    public HomePage login(String email, String password) {
        log.debug("Starting the login method on the LoginPage");
        driver.findElement(EMAIL_INPUT).sendKeys(email);
        driver.findElement(PASSWORD).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        log.debug("Completing the login method on the LoginPage");
        return new HomePage(driver);
    }

}