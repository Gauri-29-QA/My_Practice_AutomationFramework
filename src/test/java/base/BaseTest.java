package base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import utilities.DriverFactory;

abstract public class BaseTest {

    @Parameters("browser")
    @BeforeMethod()
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

    @DataProvider(name = "browserProvider", parallel = true)
    public Object[][] getBrowsers() {
        return new Object[][] { {"chrome"}, {"firefox"} };
    }
}
