package base;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import utilities.DriverFactory;
import static utilities.DriverFactory.*;

public class BaseTest {

    @Parameters("browser")
    @BeforeMethod
    public void setup(String browser) {
        DriverFactory.initDriver(browser);
    }

    @AfterMethod
    public void tearDown() {

        DriverFactory.quitDriver();
    }

    public void getURL(String url)
    {
        DriverFactory.getDriver().get(url);
    }

}
