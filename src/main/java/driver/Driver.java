package driver;

import enums.ConfigProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.JsonUtils;

import java.util.Objects;

public final class Driver {

    static ChromeOptions options = new ChromeOptions();

    private Driver() {
    }

    public static void initializeDriver(String browser) {
        if (Objects.isNull(DriverManager.getDriver())) {
            if (browser.equalsIgnoreCase("chrome")) {
                options.addArguments("--disable-gpu");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
                //TODO Implement headless mode only for the server runs
                //options.addArguments("--headless");

                WebDriverManager.chromedriver().setup();
                DriverManager.setDriver(new ChromeDriver(options));
                DriverManager.getDriver().get(JsonUtils.get(ConfigProperties.URL));
            } else if (browser.equalsIgnoreCase("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                DriverManager.setDriver(new FirefoxDriver());
                DriverManager.getDriver().get(JsonUtils.get(ConfigProperties.URL));
            }
        }
    }

    public static void quitDriver() {
        if (Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }
}
