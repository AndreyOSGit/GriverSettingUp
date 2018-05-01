package PatternsForAT;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//Based on Thread Safe Singleton - https://www.journaldev.com/1377/java-singleton-design-pattern-best-practices-examples
public class DriverSingleton
{

    public static DriverSingleton instance = null;
    public WebDriver driver;


    public DriverSingleton() {
        System.setProperty("webdriver.chrome.driver", "src\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    public WebDriver getDriver()
    {
        return driver;
    }


    public static synchronized DriverSingleton getInstance() // синхронизированный метод создания драйвера - чтобы в разных потоках использовался один и тот же драйвер
    {
        if(instance == null ) {
            instance = new DriverSingleton();
        }
        return instance;
    }

}
