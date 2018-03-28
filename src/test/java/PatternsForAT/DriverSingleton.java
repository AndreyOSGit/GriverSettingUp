package PatternsForAT;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//Based on Thread Safe Singleton - https://www.journaldev.com/1377/java-singleton-design-pattern-best-practices-examples
public class DriverSingleton
{

    public static DriverSingleton instance = null;
    private WebDriver driver;


    private DriverSingleton() {
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    public WebDriver getDriver(){

        return driver;
    }


    public static synchronized DriverSingleton getInstance()
    {
        if(instance == null ) {
            instance = new DriverSingleton();
        }
        return instance;
    }

}
