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

public class Driver {
    public static WebDriver driver;
    public static Properties properties;
    public static Logger log = LogManager.getLogger("logger");
    static ChromeOptions options = new ChromeOptions();

    public static void initializeDriver() throws IOException {
        if (Objects.isNull(driver)) {
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--headless");

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);

            //TODO replace deprecated implicitlyWait
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            properties = new Properties();
            FileInputStream file = new FileInputStream("src/main/resources/local.properties");
            properties.load(file);
            driver.get(properties.getProperty("url"));
            log.info("driver.Driver successfully initialized");
        }
    }

    public static void quitDriver() {
        if (Objects.nonNull(driver)) {
            driver.quit();
            driver = null;
        }
    }
}
