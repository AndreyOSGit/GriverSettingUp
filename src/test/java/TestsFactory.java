import PatternsForAT.DriverFactory;
import PatternsForAT.DriverSingleton;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestsFactory {

    @Test
    public void logInIUA_001()
    {
        WebDriver driver2 = DriverFactory.getBrowser("GCh");

        WebDriver driver1 = DriverFactory.getBrowser("FF");

        String act1 = new IUA().loginToIUA(driver1);
        String act2 = new IUA().loginToIUA(driver2);

        DriverFactory.closeAllDriver();

        Assert.assertEquals( act1,act2 );

    }
}
