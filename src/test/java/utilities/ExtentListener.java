package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class ExtentListener implements ITestListener {
    ExtentReports extent =  ExtentManager.getExtent();
    ThreadLocal<ExtentTest> test =  new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        test.set(extent.createTest(result.getMethod().getMethodName()));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().pass("Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ScreenshotUtility screenshot = new ScreenshotUtility();
        String path = null;
        try {
            path = screenshot.captureScreenshot(result.getName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        test.get().fail("Failed").addScreenCaptureFromPath(path);

    }

    @Override
    public void onFinish( ITestContext context) {
        extent.flush();
    }
}
