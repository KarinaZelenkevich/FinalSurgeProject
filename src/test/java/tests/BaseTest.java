package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {

    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    CalendarPage calendarPage;
    CalendarModalPage calendarModalPage;
    CalendarListPage calendarListPage;
    CalendarDetailsPage calendarDetailsPage;
    WorkoutCalculatorDetailsPage workoutCalculatorDetailsPage;
    IntensityPage intensityPage;
    WorkoutCalculatorListPage workoutCalculatorListPage;
    HansonsPage hansonsPage;
    McMillanPage mcMillanPage;
    PalladinoPage palladinoPage;
    TinmanPage tinmanPage;
    DailyVitalsPage dailyVitalsPage;
    ProfilePage profilePage;


    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        calendarPage = new CalendarPage(driver);
        calendarModalPage = new CalendarModalPage(driver);
        calendarListPage = new CalendarListPage(driver);
        calendarDetailsPage = new CalendarDetailsPage(driver);
        workoutCalculatorDetailsPage = new WorkoutCalculatorDetailsPage(driver);
        intensityPage = new IntensityPage(driver);
        workoutCalculatorListPage = new WorkoutCalculatorListPage(driver);
        hansonsPage = new HansonsPage(driver);
        mcMillanPage = new McMillanPage(driver);
        palladinoPage = new PalladinoPage(driver);
        tinmanPage = new TinmanPage(driver);
        dailyVitalsPage = new DailyVitalsPage(driver);
        profilePage = new ProfilePage(driver);


    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }

}
