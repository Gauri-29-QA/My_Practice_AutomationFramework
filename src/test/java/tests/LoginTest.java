package tests;

import TestDataProviders.LoginDataProvider;
import base.BaseTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.ConfigReaderUtils;
import utilities.ExtentListener;

import java.io.IOException;

@Listeners(ExtentListener.class)
public class LoginTest extends BaseTest {
    ConfigReaderUtils reader=new ConfigReaderUtils();

 @Test(dataProvider ="loginData", dataProviderClass = LoginDataProvider.class)
    public void  Test_1(String userName,String password) throws IOException {
     LoginPage login = new LoginPage();
        getURL(reader.getUrl());
        login.enterUsername();
        login.enterPassword();
        login.clickLogin(userName,password);

    }
}
