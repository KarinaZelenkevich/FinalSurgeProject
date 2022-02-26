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
    protected String baseUrl = utils.PropertyReader.getProperty("FINAL_SURGE_URL", "finalsurge.baseUrl");
    protected String email = utils.PropertyReader.getProperty("FINAL_SURGE_EMAIL", "finalsurge.email");
    protected String password = utils.PropertyReader.getProperty("FINAL_SURGE_PASSWORD", "finalsurge.password");

    @Parameters({"browser"})
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser, ITestContext testContext) {
        if (browser.equals(("chrome"))) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            options.addArguments("--headless");
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
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }

}
