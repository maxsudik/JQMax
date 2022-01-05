package driver;

import enums.ConfigProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utils.JsonUtils;

import java.util.Objects;

public final class Driver {

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
            DriverManager.getDriver().get(JsonUtils.get(ConfigProperties.URL));
        }
    }

    public static void quitDriver() {
        if (Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }
}
