package tests;

import jdk.jfr.Description;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utils.AllureUtils;


import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class LoginTest extends BaseTest {

    @Test
    public void loginWithValidData() {
        boolean isHomePageOpened = loginPage
                .open()
                .login(email, password + "kjiilj")
                .open()
                .isPageOpen();
        AllureUtils.takeScreenshot(driver);
        assertTrue(isHomePageOpened, "HomePage wasn't opened");
        AllureUtils.takeScreenshot(driver);

    }

    @Test
    public void checkLogInWithInvalidEmail() {
        loginPage
                .open()
                .login("", password);

        String error = LoginPage.getErrorMessage();
        assertEquals(error,
                "Please enter a valid email address.",
                "Please enter a valid email address.");

    }

    @Test
    public void checkLogInWithInvalidPassword() {
        loginPage
                .open()
                .login(email, "");

        String error = LoginPage.getErrorMessage();
        assertEquals(error,
                "Please enter a password.",
                "Please enter a password.");

    }

    @Description("Logout test")
    @Test
    public void logoutTest() {
        loginPage
                .open()
                .login(email, password);
        homePage
                .open()
                .clickLogoutButton();
        String alert = HomePage.getLogoutMessage();
        assertEquals(alert,
                "You have been successfully logged out of the system.",
                "You have been successfully logged out of the system.");

    }
}