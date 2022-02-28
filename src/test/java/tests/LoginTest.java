package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;



import static org.testng.AssertJUnit.assertEquals;

public class LoginTest extends BaseTest {

    @Description("login with valid data")
    @Test
    public void loginWithValidData() {
        loginPage
                .open()
                .login(email, password)
                .open()
                .isPageOpen();
        Assert.assertTrue(homePage.isPageOpen(), "HomePage wasn't opened");
    }

    @Description("check LogIn with invalid email")
    @Test
    public void checkLogInWithInvalidEmail() {
        loginPage
                .open()
                .login("jk", password);

        String error = LoginPage.getErrorMessage();
        assertEquals(error,
                "Please enter a valid email address.",
                "Please enter a valid email address.");
    }

    @Description("check LogIn with invalid password")
    @Test
    public void checkLogInWithInvalidPassword() {
        loginPage
                .open()
                .login(email, "mbbh");

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