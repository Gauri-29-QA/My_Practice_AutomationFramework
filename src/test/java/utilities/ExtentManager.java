package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExtentManager {

    private static ExtentReports extent;
    private static String executionFolder;
    private static String screenShot;
    public static ExtentReports getExtent() {
        if (extent == null) {
            executionFolder = System.getProperty("user.dir")
                    + "/Output/report/Execution_" + DateTimeUtils.getDateTime();

            new File(executionFolder).mkdirs();
            File screenShotDir= new File(executionFolder + "/Screenshots");
            screenShotDir.mkdirs();
            screenShot=screenShotDir.getAbsolutePath();

            ExtentSparkReporter spark =
                    new ExtentSparkReporter(executionFolder+
                            "/ExtentReport_"+DateTimeUtils.getDateTime()+".html");

            extent = new ExtentReports();
            extent.attachReporter(spark);
        }
        return extent;
    }
    public static String getScreenShotDri() {
        return screenShot;
    }

}