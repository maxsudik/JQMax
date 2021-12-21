package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    private static final ChromeOptions CHROME_OPTIONS;
    //public static Logger log = LogManager.getLogger(BaseTest.class.getName());

    static {
        CHROME_OPTIONS = new ChromeOptions();
        String options = System.getenv("CHROME_OPTIONS");
        if (options != null) {
            for (String argument : options.split(";")) {
                CHROME_OPTIONS.addArguments(argument);
            }
        }
        CHROME_OPTIONS.addArguments("--window-size=1920,1080");

        WebDriverManager.chromedriver().setup();
    }

    //public Properties properties;
    protected WebDriver driver;

    @BeforeMethod
    public void setup() {

        driver = new ChromeDriver(CHROME_OPTIONS);
        driver.get("http://the-internet.herokuapp.com/");
        //log.info("Driver successfully initialized");
        //TODO replace deprecated implicitlyWait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void setDown() {
        driver.quit();
    }

    public String getScreenshot(String testMethodName, WebDriver driver) throws IOException {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File file = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String destinationFile = System.getProperty("user.dir") + "/reports/" + testMethodName + ".png";
        FileUtils.copyFile(file, new File(destinationFile));
        return destinationFile;
    }
}
