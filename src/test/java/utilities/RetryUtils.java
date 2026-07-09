package utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RetryUtils implements IRetryAnalyzer {
    private Map<String, Integer> retryCounts = new HashMap<>();
    private ConfigReaderUtils config = new ConfigReaderUtils();
    private final int maxRetryCount =config.getRetryCount();
    @Override
    public boolean retry(ITestResult result) {

        String key = result.getName() + Arrays.toString(result.getParameters());
        int currentCount = retryCounts.getOrDefault(key, 0);
        if (currentCount < maxRetryCount) {
            retryCounts.put(key, currentCount + 1);
            System.out.println("Retrying Test: " + result.getName() +
                    " | Dataset: " + Arrays.toString(result.getParameters()) +
                    " | Attempt: " + (currentCount + 1));
            return true;
        }
        return false;
    }
}