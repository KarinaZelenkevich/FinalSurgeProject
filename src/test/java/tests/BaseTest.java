package tests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
    CaloricNeedsPage caloricNeedsPage;
    WorkoutPage workoutPage;
    PrintPage printPage;
    PrintWorkout printWorkout;
    WorkoutFullAddPage workoutFullAddPage;
    WorkoutDetailsPage workoutDetailsPage;
    protected String baseUrl = utils.PropertyReader.getProperty("FINAL_SURGE_URL", "finalsurge.baseUrl");
    protected String email = utils.PropertyReader.getProperty("FINAL_SURGE_EMAIL", "finalsurge.email");
    protected String password = utils.PropertyReader.getProperty("FINAL_SURGE_PASSWORD", "finalsurge.password");

    @Parameters({"browser"})
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser) {
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
        profilePage = new ProfilePage(driver);
        profileModalPage = new ProfileModalPage(driver);
        caloricNeedsPage = new CaloricNeedsPage(driver);
        workoutPage = new WorkoutPage(driver);
        printPage = new PrintPage(driver);
        printWorkout = new PrintWorkout(driver);
        workoutFullAddPage = new WorkoutFullAddPage(driver);
        workoutDetailsPage = new WorkoutDetailsPage(driver);

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }

}
