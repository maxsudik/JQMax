package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public final class Driver {

    public static Properties properties;
    public static Logger log = LogManager.getLogger("logger");
    static ChromeOptions options = new ChromeOptions();
    private static WebDriver driver;

    private Driver() {
    }

    public static void initializeDriver() throws IOException {
        if (Objects.isNull(DriverManager.getDriver())) {
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            //TODO Implement headless mode only for the server runs
            //options.addArguments("--headless");

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);
            DriverManager.setDriver(driver);

            //TODO replace deprecated implicitlyWait
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            properties = new Properties();
            FileInputStream file = new FileInputStream("src/main/resources/local.properties");
            properties.load(file);
            DriverManager.getDriver().get(properties.getProperty("url"));
            log.info("driver.Driver successfully initialized");

        }
    }

    public static void quitDriver() {
        if (Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }
}
