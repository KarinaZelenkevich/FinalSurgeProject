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


import java.io.File;

@Log4j2
public class ProfileModalPage extends BasePage {

    public static final By PROFILE_MODAL_TITLE = By.xpath("//label[text()='Profile Picture']");

    public ProfileModalPage(WebDriver driver) {
        super(driver);
    }

    @Step("Edit User profile")
    public ProfilePage editProfile(Profile profile) {
        String gender = profile.getGender();
        String weightMeasure = profile.getWeightMeasure();
        log.info("Creating new account");
        log.info("Set gender in profile");
        log.info("Add First Name to profile");
        new Input(driver, "fname").writeInProfileForm(profile.getName());
        log.info("Add Last Name to profile");
        new Input(driver, "lname").writeInProfileForm(profile.getLastName());
//        new RadioButton(driver, "female").selectRadioButtonInProfileForm(profile.getGender());
        log.info("Add Birthday to profile");
//        new DropDown(driver, "BDay").selectDropdownInProfileForm(profile.getBirthday());
        log.info("Add weight to profile");
        new Input(driver, "Weight").writeInProfileForm(profile.getWeight());
        log.info("Choose weight measure in profile");
        String myMeasure = profile.getWeightMeasure();
//        new RadioButton(driver, "kg").selectRadioButtonInProfileForm(weightMeasure(myMeasure));
        new DropDown(driver, "Country").selectDropdownInProfileFormForCountry(profile.getCountry());
        log.info("Add state to profile");
        new DropDown(driver, "Region").selectDropdownInProfileFormForCountry(profile.getState());
        //WebElement firstResult = new WebDriverWait(driver, Duration.ofSeconds(10))
        //        .until(ExpectedConditions.elementToBeClickable(By.xpath("//a/h3")));
        //TODO ожидание
        log.info("Add city to profile");
        new Input(driver, "City").writeInProfileForm(profile.getCity());
        log.info("Add zip code to profile");
        new Input(driver, "Zip").writeInProfileForm(profile.getZip());
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

    public String weightMeasure(String measure) {
        switch (measure) {
            case "Ibs":
                measure = "Ibs";
                break;
            case "kg":
                measure = "kg";
                break;
        }
        return measure;
    }


}