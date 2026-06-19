package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.DriverFactory;
import utilities.WaitUtils;

public class LoginPage {
    WebDriver driver;
    WebElement username;
    WebElement password;
    public LoginPage()
    {
        this.driver=DriverFactory.getDriver();
    }
    public void enterUsername() { }

    public void enterPassword() { }

    public void clickLogin(String user,String paa) {
        username=driver.findElement(By.id("user-name"));
        WaitUtils.waitForVisibility(username).sendKeys(user);
        password=driver.findElement(By.id("password"));
        WaitUtils.waitForVisibility(password).sendKeys(paa);

    }
}
