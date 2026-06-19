package tests;

import TestDataProviders.LoginDataProvider;
import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.*;

import java.io.IOException;

@Listeners(ExtentListener.class)
public class LoginTest extends BaseTest {
    ConfigReader reader=new ConfigReader();

 @Test(dataProvider ="loginData", dataProviderClass = LoginDataProvider.class)
    public void  Test_1(String userName,String password) throws IOException {
     LoginPage login = new LoginPage();
        getURL(reader.getUrl());
        login.enterUsername();
        login.enterPassword();
        login.clickLogin(userName,password);

    }
}
