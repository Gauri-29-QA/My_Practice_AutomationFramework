package utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryUtils implements IRetryAnalyzer {
    private int count = 0;
    private ConfigReaderUtils config = new ConfigReaderUtils();
    private final int maxRetryCount =config.getRetryCount();
    @Override
    public boolean retry(ITestResult result) {
        if (count < maxRetryCount) {
            count++;
            System.out.println("Retrying Test: "+ result.getName()+ " | Attempt: " + count);
            return true;
        }
        return false;
    }
}
