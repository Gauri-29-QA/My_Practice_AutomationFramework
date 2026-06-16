package utilities;

import base.BaseTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenshotUtility {

    public String captureScreenshot(String fileName) throws IOException {
        File destinationFile=new File("C:\\Users\\Gauri\\IdeaProjects\\My_Project\\Output\\"+fileName+".png");
        File screenshotFile= ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile, destinationFile);
        return destinationFile.getPath();
    }
}
