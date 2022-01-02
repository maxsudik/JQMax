package screenshot;

import base.ExtentReporterNG;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import tests.BaseTest;

public class Listeners extends BaseTest implements ITestListener {

    ExtentTest test;
    ExtentReports extent = ExtentReporterNG.getReportObject();
    ThreadLocal<ExtentTest> extentTest = new ThreadLocal();

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
        extentTest.set(test);
    }

    //TODO implement screenshot on test completion
    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.get().log(Status.PASS, "Test Passed");

    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }

    //TODO fix implementation of screenshots for extent report on failure
//    @Override
//    public void onTestFailure(ITestResult result) {
//
//        WebDriver driver = null;
//        String testMethodName = result.getMethod().getMethodName();
//
//        extentTest.get().fail(result.getThrowable());
//
//        try {
//            driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        try {
//            extentTest.get().addScreenCaptureFromPath(getScreenshot(testMethodName, driver), result.getMethod().getMethodName());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
