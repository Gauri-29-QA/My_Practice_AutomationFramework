package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;
import java.util.Arrays;

public class ExtentListener implements ITestListener {
    ExtentReports extent = ExtentManager.getExtent();
    ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        String baseName = result.getMethod().getMethodName()
                + " | Dataset: " + Arrays.toString(result.getParameters());

        // ✅ Always create a new node per dataset (unique by parameters)
        test.set(extent.createTest(baseName));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        int attempt = result.getMethod().getCurrentInvocationCount();
        // ✅ Always mark success as Pass
        test.get().pass("Passed on attempt " + (attempt + 1));
    }

    @Override
    public void onTestFailure(ITestResult result) {
        int attempt = result.getMethod().getCurrentInvocationCount();
        int maxRetries = new ConfigReaderUtils().getRetryCount();

        ScreenshotUtils screenshot = new ScreenshotUtils();
        String path;
        try {
            path = screenshot.captureScreenshot(result.getName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (attempt < maxRetries) {
            // ✅ Log retry attempt inside the same dataset node
            test.get().info("Retry attempt " + (attempt + 1) + " failed, will retry...")
                    .addScreenCaptureFromPath(path, result.getName());
        } else {
            // ✅ Final failure only
            test.get().fail("Failed after " + (attempt + 1) + " attempts")
                    .fail(result.getThrowable())
                    .addScreenCaptureFromPath(path, result.getName());
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
