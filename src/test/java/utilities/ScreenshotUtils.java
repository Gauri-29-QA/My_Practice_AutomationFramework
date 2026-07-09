package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;

public class ScreenshotUtils {

    public String captureScreenshot(String fileName) throws IOException {
        String screenshotName = fileName + "_" + DateTimeUtils.getDateTime() + ".png";

        String relativePath = "Screenshots/" + screenshotName;

        File destinationFile=new File(ExtentManager.getScreenShotDri()+"/"+relativePath);
        File screenshotFile= ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile, destinationFile);
        return relativePath;
    }
}
