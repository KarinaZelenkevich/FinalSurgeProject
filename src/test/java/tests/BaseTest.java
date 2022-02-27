package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.*;
import tests.base.TestListener;

import java.util.concurrent.TimeUnit;


@Listeners(TestListener.class)
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
    ProfilePage profilePage;
    ProfileModalPage profileModalPage;
    WorkoutPage workoutPage;
    PrintPage printPage;
    PrintWorkout printWorkout;
    WorkoutFullAddPage workoutFullAddPage;
    WorkoutDetailsPage workoutDetailsPage;
    CaloricNeedsModalPage caloricNeedsModalPage;
    PaceCalculatorModalPage paceCalculatorModalPage;
    WorkoutReportsModalPage workoutReportsModalPage;
    String email, password;

    @Parameters({"browser"})
    @BeforeMethod(alwaysRun = true)
    public void setUp(@Optional("chrome") String browser, ITestContext testContext) {
        if (browser.equals(("chrome"))) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            options.addArguments("--disable-notifications");
            driver = new ChromeDriver(options);
        } else if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--start-maximized");
            options.addArguments("--disable-notifications");
            driver = new FirefoxDriver();
        }
        testContext.setAttribute("driver", driver);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
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
        profilePage = new ProfilePage(driver);
        profileModalPage = new ProfileModalPage(driver);
        workoutPage = new WorkoutPage(driver);
        printPage = new PrintPage(driver);
        printWorkout = new PrintWorkout(driver);
        workoutFullAddPage = new WorkoutFullAddPage(driver);
        workoutDetailsPage = new WorkoutDetailsPage(driver);
        caloricNeedsModalPage = new CaloricNeedsModalPage(driver);
        paceCalculatorModalPage = new PaceCalculatorModalPage(driver);
        workoutReportsModalPage = new WorkoutReportsModalPage(driver);

        email = System.getenv().getOrDefault("FINAL_SURGE_EMAIL", utils.PropertyReader.getProperty("finalsurge.email"));
        password = System.getenv().getOrDefault("FINAL_SURGE_PASSWORD", utils.PropertyReader.getProperty("finalsurge.password"));

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}

