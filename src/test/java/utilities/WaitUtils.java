package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {
    public static WebElement waitForVisibility(WebElement element)
    {
        WebDriver driver=DriverFactory.getDriver();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement waitForClickable(WebElement element){
        WebDriver driver=DriverFactory.getDriver();
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        return  wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
