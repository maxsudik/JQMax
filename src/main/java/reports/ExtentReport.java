package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public final class ExtentReport {

    private static ExtentReports extent;

    private ExtentReport() {
    }

    public static void initReport() {
        if (Objects.isNull(extent)) {
            extent = new ExtentReports();
            ExtentSparkReporter spark = new ExtentSparkReporter("index.html");
            extent.attachReporter(spark);
            spark.config().setTheme(Theme.DARK);
            spark.config().setDocumentTitle("JQMax Report");
            spark.config().setReportName("OrangeHRM Demo");
        }
    }

    public static void flushReports() throws IOException {
        if (Objects.nonNull(extent)) {
            extent.flush();
        }
        Desktop.getDesktop().browse(new File("index.html").toURI());
    }

    public static void createTest(String testCaseName) {
        ExtentTest test = extent.createTest(testCaseName);
        ExtentManager.setExtentTest(test);
    }
}
