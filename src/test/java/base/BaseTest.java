package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {

    protected static ThreadLocal<WebDriver> driver=new ThreadLocal<>();

    public static WebDriver getDriver() {
        return driver.get();
    }

    @Parameters("browser")
    @BeforeMethod
    public void setup(String browser) {

        if(browser.equalsIgnoreCase("chrome")) {
            driver.set(new ChromeDriver());
        }

        getDriver().manage().window().maximize();
    }

    public void getURL(String url)
    {
        getDriver().get(url);
    }


    @AfterMethod
    public void tearDown() {

        getDriver().quit();
        driver.remove();
    }
}
