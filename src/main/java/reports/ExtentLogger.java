package reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import driver.DriverManager;
import enums.ConfigProperties;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.PropertyUtils;

public final class ExtentLogger {
    private ExtentLogger() {
    }

    public static void pass(String message) {
        ExtentManager.getExtentTest().pass(message);
    }

    public static void fail(String message) {
        ExtentManager.getExtentTest().fail(message);
    }

    public static void skip(String message) {
        ExtentManager.getExtentTest().skip(message);
    }

    public static void pass(String message, boolean isScreenshotNeeded) throws Exception {
        if (PropertyUtils.get(ConfigProperties.PASSEDSTEPSSCREENSHOT).equalsIgnoreCase("yes") && isScreenshotNeeded) {
            ExtentManager.getExtentTest().pass(message, MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());
        } else {
            pass(message);
        }
    }

    public static void fail(String message, boolean isScreenshotNeeded) throws Exception {
        if (PropertyUtils.get(ConfigProperties.FAILEDSTEPSSCREENSHOT).equalsIgnoreCase("yes") && isScreenshotNeeded) {
            ExtentManager.getExtentTest().fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());
        } else {
            fail(message);
        }
    }

    public static void skip(String message, boolean isScreenshotNeeded) throws Exception {
        if (PropertyUtils.get(ConfigProperties.SKIPPEDSTEPSSCREENSHOT).equalsIgnoreCase("yes") && isScreenshotNeeded) {
            ExtentManager.getExtentTest().fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());
        } else {
            skip(message);
        }
    }

    public static String getBase64Image() {
        return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
    }
}
