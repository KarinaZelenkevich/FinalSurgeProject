package tests;

import org.testng.Assert;
import org.testng.annotations.Test;


public class ProfileTest extends BaseTest {

    @Test(description = "Open edit profile page")
    public void editProfilePageShouldBeOpened() {
        loginPage
                .open()
                .login("blablablablablabla@maillinator.com", "KarinaKarina12");
        profilePage.openProfilePage();
        Assert.assertTrue(profilePage.isPageOpen(), "Profile page wasn't opened");
    }
}
