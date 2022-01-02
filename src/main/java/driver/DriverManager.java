package driver;

import org.openqa.selenium.WebDriver;

public final class DriverManager {

    private static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    private DriverManager() {
    }

    public static WebDriver getDriver() {
        return driverThreadLocal.get();
    }

    public static void setDriver(WebDriver driverThreadLocalRef) {
        driverThreadLocal.set(driverThreadLocalRef);
    }

    public static void unload() {
        driverThreadLocal.remove();
    }
}
