package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utils.ReadPropertyFile;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public final class Driver {

    public static Logger log = LogManager.getLogger("logger");
    static ChromeOptions options = new ChromeOptions();

    private Driver() {
    }

    public static void initializeDriver() throws Exception {
        if (Objects.isNull(DriverManager.getDriver())) {
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            //TODO Implement headless mode only for the server runs
            //options.addArguments("--headless");

            WebDriverManager.chromedriver().setup();
            DriverManager.setDriver(new ChromeDriver(options));

            //TODO replace deprecated implicitlyWait
            DriverManager.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            DriverManager.getDriver().get(ReadPropertyFile.getValue("url"));
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
