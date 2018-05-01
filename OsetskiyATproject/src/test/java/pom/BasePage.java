package pom;

import PatternsForAT.DriverSingleton;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class BasePage
{
// protected WebDriver driver = DriverSingleton
//    public DriverSingleton driverSingleton;
    public WebDriver driver; // = driverSingleton.driver;

    public Object executeJavaScript(String script)
    {
        return ((JavascriptExecutor) driver).executeScript(script);
    }
}
