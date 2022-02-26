package pages;

import elements.DropDown;
import elements.Input;
import elements.RadioButton;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.Profile;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


import java.io.File;
import java.util.concurrent.TimeUnit;

@Log4j2
public class ProfileModalPage extends BasePage {
    private static final By FIRST_NAME = By.id("fname");
    private static final By LAST_NAME = By.id("lname");
    private static final By BIRTHDAY = By.id("BDay");
    private static final By WEIGHT = By.id("Weight");
    private static final By CITY_NAME = By.id("City");
    private static final By ZIP = By.id("Zip");
    private static final By REGION = By.id("Region");
    public static final By DROPDOWN_BDAY_CLICK = By.xpath("//input[@id='BDay']");

    public static final By PROFILE_MODAL_TITLE = By.xpath("//label[text()='Profile Picture']");

    public ProfileModalPage(WebDriver driver) {
        super(driver);
    }

    @Step("Edit User profile")
    public ProfilePage editProfile(Profile profile) {
        log.info("Creating new account");
        log.info("Set gender in profile");
        log.info("Add First Name to profile");
        new Input(driver, "fname").clear(FIRST_NAME);
        new Input(driver, "fname").writeInProfileForm(profile.getName());
        log.info("Add Last Name to profile");
        new Input(driver, "lname").clear(LAST_NAME);
        new Input(driver, "lname").writeInProfileForm(profile.getLastName());
        new RadioButton(driver, "female").selectRadioButtonInProfileForm(profile.getGender());
        log.info("Add weight to profile");
        new Input(driver, "Weight").clear(WEIGHT);
        new Input(driver, "Weight").writeInProfileForm(profile.getWeight());
        log.info("Choose weight measure in profile");
        new RadioButton(driver, "optionsRadios4").selectRadioButtonInProfileForm(profile.getWeightMeasure());
        new DropDown(driver, "Country").selectDropdownInProfileFormForCountry(profile.getCountry());
        log.info("Add state to profile");
        new DropDown(driver, "Region").selectDropdownInProfileFormForCountry(profile.getState());
        log.info("Add city to profile");
        new Input(driver, "City").clear(CITY_NAME);
        new Input(driver, "City").writeInProfileForm(profile.getCity());
        log.info("Add zip code to profile");
        new Input(driver, "Zip").clear(ZIP);
        new Input(driver, "Zip").writeInProfileForm(profile.getZip());
        log.info("Add Birthday to profile");
        new Input(driver, "BDay").clear(BIRTHDAY);
        new DropDown(driver, "BDay").selectDropdownBday(profile.getBirthday());
        return new ProfilePage(driver);
    }

    @Override
    public boolean isPageOpen() {
        return isExist(PROFILE_MODAL_TITLE);
    }

    @Step("Add photo to the user profile")
    public ProfilePage uploadPhoto(String path) {
        driver.findElement(By.id("UserThumbnail")).click();
        WebElement uploader = driver.findElement(By.id("uploader"));
        driver.switchTo().frame(uploader);
        File file = new File(path);
        log.info("switched to frame");
        driver.findElement(By.cssSelector("[type = 'file']")).sendKeys(file.getAbsolutePath());
        driver.switchTo().defaultContent();
        return new ProfilePage(driver);
    }


}
