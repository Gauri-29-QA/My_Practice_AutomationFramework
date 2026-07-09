package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.DriverFactory;
import utilities.WaitUtils;

public class LoginPage {
    WebDriver driver;
    WebElement username;
    WebElement password;
    WebElement btn_Submit;
    WebElement link_ShoppingCart;
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

        btn_Submit= driver.findElement(By.id("login-button"));
        WaitUtils.waitForClickable(btn_Submit);
        btn_Submit.click();

        link_ShoppingCart=driver.findElement(By.className("shopping_cart_link"));
        WaitUtils.waitForVisibility(link_ShoppingCart);

        //Alert alert=driver.switchTo().alert();
        //alert.dismiss();

    }
}
