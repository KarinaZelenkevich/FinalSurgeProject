package tests;

import models.Profile;
import models.ProfileFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.AllureUtils;


public class ProfileTest extends BaseTest {

    @Test(description = "Open edit profile page")
    public void editProfilePageShouldBeOpened() {
        loginPage
                .open()
                .login("blablablablablabla@maillinator.com", "KarinaKarina12");
        profilePage.openProfilePage();

        Assert.assertTrue(profilePage.isPageOpen(), "Profile page wasn't opened");
        AllureUtils.takeScreenshot(driver);
    }

    @Test(description = "Fill in User profile form")
    public void fillInProfileForm() {
        loginPage
                .open()
                .login(email, password);
        profilePage
                .openProfilePage()
                .openEditProfileForm();
        Profile profile = ProfileFactory.getFillingProfileForm();
        profileModalPage
                .editProfile(profile)
                .saveProfileChanges()
                .validateInput(profile);
        AllureUtils.takeScreenshot(driver);
    }

    @Test(description = "Add user photo to the profile")
    public void profilePhotoShouldBeAddedAndDeleted() throws InterruptedException {
        loginPage
                .open()
                .login(email, password);
        profilePage
                .openProfilePage()
                .openEditProfileForm();
        profileModalPage
                .uploadPhoto("src/test/resources/c1f15e1s-1920.jpg")
                .savePhoto()
                .saveProfileChanges()
                .openEditProfileForm()
                .deletePhoto()
                .saveProfileChanges();
        AllureUtils.takeScreenshot(driver);
    }
}
