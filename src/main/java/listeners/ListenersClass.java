package listeners;

import annotations.FrameworkAnnotation;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import reports.ExtentLogger;
import reports.ExtentReport;
import utils.ELKUtils;

import java.util.Arrays;

public class ListenersClass implements ITestListener, ISuiteListener {

    @Override
    public void onStart(ISuite suite) {
        ExtentReport.initReport();
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentReport.createTest(result.getMethod().getMethodName());
        ExtentReport.addAuthors(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class).author());
        ExtentReport.addCategories(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class).category());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentLogger.pass(result.getMethod().getMethodName() + "is passed");
        ELKUtils.sendDetailsToElk(result.getMethod().getDescription(), "passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentLogger.fail(result.getMethod().getMethodName() + "is failed", true);
        ExtentLogger.fail(result.getThrowable().toString());
        ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));
        ELKUtils.sendDetailsToElk(result.getMethod().getDescription(), "failed");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentLogger.skip(result.getMethod().getMethodName() + "is skipped");
        ELKUtils.sendDetailsToElk(result.getMethod().getDescription(), "skipped");
    }

    @Override
    public void onFinish(ISuite suite) {
        ExtentReport.flushReports();
    }
}
