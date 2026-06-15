package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getExtent() {
        if (extent == null) {
            LocalDateTime currentDateTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            String formattedDateTime = currentDateTime.format(formatter);
            ExtentSparkReporter spark =
                    new ExtentSparkReporter(
                            "Output/report/ExtentReport_"+formattedDateTime.replace(":","_")+".html");

            extent = new ExtentReports();
            extent.attachReporter(spark);
        }
        return extent;
    }
}