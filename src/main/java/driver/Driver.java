package driver;

import enums.ConfigProperties;
import exceptions.BrowserInvocationFailedException;
import factories.DriverFactory;
import utils.JsonUtils;

import java.net.MalformedURLException;
import java.util.Objects;

public final class Driver {

    private Driver() {
    }

    public static void initializeDriver(String browser, String version) {
        if (Objects.isNull(DriverManager.getDriver())) {
            try {
                DriverManager.setDriver(DriverFactory.getDriver(browser, version));
            } catch (MalformedURLException e) {
                throw new BrowserInvocationFailedException("Browser invocation failed. Please check the capabilities", e);
            }
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
