package driver;

import org.openqa.selenium.WebDriver;

import java.util.Objects;

public final class DriverManager {

    private static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    private DriverManager() {
    }

    public static WebDriver getDriver() {
        return driverThreadLocal.get();
    }

    static void setDriver(WebDriver driverThreadLocalRef) {
        if (Objects.nonNull(driverThreadLocalRef)) {
            driverThreadLocal.set(driverThreadLocalRef);
        }
    }

    static void unload() {
        driverThreadLocal.remove();
    }
}
