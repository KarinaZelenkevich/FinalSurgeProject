package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.Profile;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import javax.swing.*;
import java.io.File;
import java.time.Duration;
import java.util.concurrent.TimeUnit;


@Log4j2
public class ProfilePage extends BasePage {
    public static final By BREADCRUMB = By.xpath("//a[contains( text(),'User Profile')]");
    public static final By SETTINGS_BUTTON = By.xpath("//a[contains( text(),'Settings')]");
    public static final By EDIT_PROFILE = By.xpath("//span[contains(text(),'Edit Profile')]");
    public static final By SAVE_EDIT_PROFILE = By.id("saveButtonProfile");
    public static final By DELETE_PHOTO_BUTTON = By.id("del-pic");
    public static final By SUBMIT_DELETE_PHOTO = By.xpath("//div[@class = 'modal-footer']//a[contains(text(),'OK')]");


    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    @Override
    @Step("Check that Profile page is opened")
    public boolean isPageOpen() {
        log.info("Check that Profile page is opened");
        return isExist(BREADCRUMB);
    }


    public ProfilePage openProfilePage() {
        driver.findElement(SETTINGS_BUTTON).click();
        return new ProfilePage(driver);
    }

    public ProfilePage openEditProfileForm() {
        driver.findElement(EDIT_PROFILE).click();
        return new ProfilePage(driver);
    }

    @Step("Save profile's changes")
    public ProfilePage saveProfileChanges() {
        log.info("Click on save edit profile changes");
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,250)");
        driver.findElement(SAVE_EDIT_PROFILE).click();
        return new ProfilePage(driver);
    }

    @Step("Save photo")
    public ProfilePage savePhoto() throws InterruptedException {
        driver.findElement(By.id("NextStep")).click();
        Thread.sleep(7000);
        driver.findElement(By.id("NextStep")).click();
        Thread.sleep(7000);
        return new ProfilePage(driver);
    }

    @Step("Delete photo")
    public ProfilePage deletePhoto() {
        driver.findElement(DELETE_PHOTO_BUTTON).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(SUBMIT_DELETE_PHOTO));
        driver.findElement(SUBMIT_DELETE_PHOTO).click();
        return new ProfilePage(driver);
    }


    @Step("Validate data on profile page")
    public void validateInput(Profile profile) {
        log.info("Validating data on profile page");
        validateInput("Name:", String.format("Name: " + profile.getName() + " " + profile.getLastName()));
        validateInput("Birthday:", String.format("Birthday: " + profile.getBirthday()));
        validateInput("Country:", String.format("Country: " + profile.getCountry()));
        validateInput("City:", String.format("City: " + profile.getCity()));
        validateInput("Zip/Postal Code:", String.format("Zip/Postal Code: " + profile.getZip()));
    }
}
