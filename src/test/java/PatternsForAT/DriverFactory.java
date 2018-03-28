package PatternsForAT;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;

public class DriverFactory
{

//    private static Map<String,WebDriver> drivers = new HashMap<>()
//    {
//        put("", new ChromeDriver());
//    }

    public WebDriver driver;

    private static WebDriver getDriver(String DriverType) {

        WebDriver driver = null;
        if (DriverType.equals("GCh"))
        {
            System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (DriverType.equals("FF"))
        {
            System.setProperty("webdriver.gecko.drive", "C:\\webdrivers\\geckodriver.exe");
            driver = new FirefoxDriver();
        }
        return driver;
    }

}
