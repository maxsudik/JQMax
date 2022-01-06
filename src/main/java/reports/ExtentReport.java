package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import constants.FrameworkConstants;
import enums.CategoryType;

import java.awt.*;
import java.io.File;
import java.util.Objects;

public final class ExtentReport {

    private static ExtentReports extent;

    private ExtentReport() {
    }

    public static void initReport() throws Exception {
        if (Objects.isNull(extent)) {
            extent = new ExtentReports();
            ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getExtentReportFilePath());
            extent.attachReporter(spark);
            spark.config().setTheme(Theme.DARK);
            spark.config().setDocumentTitle("JQMax Report");
            spark.config().setReportName("OrangeHRM Demo");
        }
    }

    public static void flushReports() throws Exception {
        if (Objects.nonNull(extent)) {
            extent.flush();
        }
        ExtentManager.unload();
        Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentReportFilePath()).toURI());
    }

    public static void createTest(String testCaseName) {
        ExtentTest test = extent.createTest(testCaseName);
        ExtentManager.setExtentTest(test);
    }

    public static void addAuthors(String[] authors) {
        for (String author : authors) {
            ExtentManager.getExtentTest().assignAuthor(author);
        }
    }

    public static void addCategories(CategoryType[] categories) {
        for (CategoryType category : categories) {
            ExtentManager.getExtentTest().assignCategory(category.toString());
        }
    }
}
