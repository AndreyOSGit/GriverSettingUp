import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import PatternsForAT.DriverSingleton;

public class TestsSinglton {

    @Test
    public void logInIUA()
    {
       WebDriver driver = DriverSingleton.getInstance().getDriver();

        String act = new IUA().loginToIUA(driver);
        Assert.assertEquals( "TestMailSWAT@i.ua", act );
        driver.close();
        driver.quit();

    }

}
