package PatternsForAT;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;

public class DriverFactory
{

  private static Map<String, WebDriver> drivers = new HashMap<String, WebDriver>();


    public static WebDriver getBrowser(String browserName)
    {
        WebDriver driver = null;
        if (browserName.equals("firefox") || browserName.equals("Firefox") || browserName.equals("FF"))
        {
            driver = drivers.get("FF");
            System.setProperty("webdriver.gecko.driver", "src\\drivers\\geckodriver.exe");
            driver = new FirefoxDriver();
            drivers.put("FF",driver);
        }
        else if (browserName.equals("googlechrome") || browserName.equals("GoogleChrome") || browserName.equals("GCh"))
        {
            driver = drivers.get("GCh");
            System.setProperty("webdriver.chrome.driver", "src\\drivers\\chromedriver.exe");
            driver = new ChromeDriver();
            drivers.put("GCh",driver);
        }
        return driver;

    }

    public static void closeAllDriver()
    {
        for (String key : drivers.keySet())
        {
            drivers.get(key).close();
            drivers.get(key).quit();
        }
    }

}
