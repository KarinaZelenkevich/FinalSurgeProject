package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @Test
    public void loginWithValidData() {
        boolean isHomePageOpened = loginPage
                .open()
                .login("blablablablablabla@maillinator.com", "KarinaKarina12")
                .open()
                .isPageOpen();

        assertTrue(isHomePageOpened, "Страница HomePage не открылась");

    }

}