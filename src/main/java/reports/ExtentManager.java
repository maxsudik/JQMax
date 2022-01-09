package reports;

import com.aventstack.extentreports.ExtentTest;

import java.util.Objects;

public final class ExtentManager {
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    private ExtentManager() {
    }

    static ExtentTest getExtentTest() {
        return extentTest.get();
    }

    static void setExtentTest(ExtentTest test) {
        if (Objects.nonNull(test)) {
            extentTest.set(test);
        }
    }

    static void unload() {
        extentTest.remove();
    }

}
