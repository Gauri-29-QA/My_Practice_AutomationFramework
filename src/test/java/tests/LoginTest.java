package tests;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.*;

import java.io.IOException;

@Listeners(ExtentListener.class)
public class LoginTest extends BaseTest {


        LoginPage login = new LoginPage(DriverFactory.getDriver());
        ConfigReader reader=new ConfigReader();
        ScreenshotUtility screenshot = new ScreenshotUtility();
        ConfigReader config = new ConfigReader();
 @Test
    public void  Test_1() throws IOException {

        getURL(reader.getUrl());
        login.enterUsername();
        login.enterPassword();
        login.clickLogin();

    }
}
