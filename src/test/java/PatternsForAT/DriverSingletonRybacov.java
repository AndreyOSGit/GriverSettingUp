package PatternsForAT;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//Based on Thread Safe Singleton - https://www.journaldev.com/1377/java-singleton-design-pattern-best-practices-examples
public class DriverSingletonRybacov
{

    public static DriverSingletonRybacov instance = null;
    private WebDriver driver;


    private DriverSingletonRybacov() {
        System.setProperty("webdriver.chrome.driver", "src\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    public WebDriver getDriver(){

        return driver;
    }


    public static synchronized DriverSingletonRybacov getInstance() // синхронизированный метод создания драйвера - чтобы в разных потоках использовался один и тот же драйвер
    {
        if(instance == null ) {
            instance = new DriverSingletonRybacov();
        }
        return instance;
    }

}
