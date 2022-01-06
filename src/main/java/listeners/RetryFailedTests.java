package listeners;

import enums.ConfigProperties;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import utils.PropertyUtils;

public final class RetryFailedTests implements IRetryAnalyzer {

    private int count = 0;
    private int retries = 1;

    @Override
    public boolean retry(ITestResult result) {
        boolean shouldRetry = false;
        if (PropertyUtils.get(ConfigProperties.RETRYFAILEDTESTS).equalsIgnoreCase("yes")) {
            shouldRetry = count < retries;
            count++;
        }
        return shouldRetry;
    }
}
