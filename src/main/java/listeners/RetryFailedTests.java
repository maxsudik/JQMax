package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public final class RetryFailedTests implements IRetryAnalyzer {

    private int count = 0;
    private int retries = 1;

    @Override
    public boolean retry(ITestResult result) {
        boolean shouldRetry = count < retries;
        count++;
        return shouldRetry;
    }
}
