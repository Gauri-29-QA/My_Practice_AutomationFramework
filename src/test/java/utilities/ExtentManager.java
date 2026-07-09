package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import java.io.File;

public class ExtentManager {

    private static ExtentReports extent;
    private static String executionFolder;

    public static ExtentReports getExtent() {
        if (extent == null) {
            executionFolder = System.getProperty("user.dir")
                    + "/Output/report/Execution_" + DateTimeUtils.getDateTime();

            new File(executionFolder).mkdirs();
            File screenShotDir= new File(executionFolder + "/Screenshots");
            screenShotDir.mkdirs();

            ExtentSparkReporter spark =
                    new ExtentSparkReporter(executionFolder+
                            "/ExtentReport_"+DateTimeUtils.getDateTime()+".html");

            extent = new ExtentReports();
            extent.attachReporter(spark);
        }
        return extent;
    }
    public static String getScreenShotDri() {
        return executionFolder;
    }

}