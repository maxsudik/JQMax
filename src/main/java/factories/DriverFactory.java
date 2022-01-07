package factories;

import enums.ConfigProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import utils.PropertyUtils;

import java.net.MalformedURLException;
import java.net.URL;

public final class DriverFactory {

    private DriverFactory() {
    }

    public static WebDriver getDriver(String browser, String version) throws MalformedURLException {

        WebDriver driver = null;

        String runMode = PropertyUtils.get(ConfigProperties.RUNMODE);
        if (browser.equalsIgnoreCase("chrome")) {
            if (runMode.equalsIgnoreCase("remote")) {
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setBrowserName(BrowserType.CHROME);
                capabilities.setVersion(version);
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
            } else {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
        } else if (browser.equalsIgnoreCase("firefox")) {
            if ((runMode.equalsIgnoreCase("remote"))) {
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setBrowserName(BrowserType.FIREFOX);
                capabilities.setVersion(version);
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
            }
        } else {
            WebDriverManager.chromedriver().setup();
            driver = new FirefoxDriver();
        }
        return driver;
    }
}
