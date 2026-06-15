package pages;

import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver)
    {
        this.driver=driver;
    }
    public void enterUsername() {

        System.out.println("Username entered");
    }

    public void enterPassword() {
        System.out.println("Password entered");
    }

    public void clickLogin() {
        System.out.println("Login button clicked");
    }
}
