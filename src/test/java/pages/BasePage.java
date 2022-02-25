package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.Profile;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

@Log4j2
public abstract class BasePage {
    public static final String BASE_URL = "https://log.finalsurge.com/login.cshtml?Assoc=&page_redirect=";

    protected static WebDriver driver;
    static WebDriverWait wait;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
    }

    public abstract boolean isPageOpen();

    protected boolean isExist(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (NoSuchElementException ex) {
            System.out.println(">>> !!! " + ex.getMessage());
            return false;
        }
    }

    @Step("Validate input")
    public void validateInput(String label, String expected) {
        String locator = "//div[contains(@id, 'EditProfile')]//*[contains(text(),'%s')]/ancestor::p";
        log.info("Validating input with label: " + label);
        Assert.assertEquals(
                driver.findElement(By.xpath(String.format(locator, label))).getText(),
                expected,
                "Input text is not correct");

    }
}