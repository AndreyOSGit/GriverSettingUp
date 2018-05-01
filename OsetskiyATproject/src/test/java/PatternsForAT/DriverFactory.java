package PatternsForAT;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import javax.xml.bind.annotation.XmlType;
import java.util.HashMap;
import java.util.Map;

public class DriverFactory
{

  public static Map<String, WebDriver> drivers = new HashMap<String, WebDriver>();

   public DriverFactory()
  {


  }


    public  WebDriver getBrowser(String browserName)
    {
        WebDriver driver = null;
        if (browserName.equals("firefox") || browserName.equals("Firefox") || browserName.equals("FF"))
        {  System.setProperty("webdriver.gecko.driver", "src\\drivers\\geckodriver.exe");
            drivers.put("FF", new FirefoxDriver());
            driver = drivers.get("FF");
        }
        else if (browserName.equals("googlechrome") || browserName.equals("GoogleChrome") || browserName.equals("GCh"))
        { System.setProperty("webdriver.chrome.driver", "src\\drivers\\chromedriver.exe");
            drivers.put("GCh",new ChromeDriver());
            driver = drivers.get("GCh");
        }
        return driver;
    }

    public void closeAllDriver()
    {
        for (String key : drivers.keySet())
        {
         //   drivers.get(key).close();
            drivers.get(key).quit();
        }
    }

}
