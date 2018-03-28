import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import PatternsForAT.DriverSingleton;

public class Tests {

DriverSingleton myDriver = DriverSingleton.getInstance();

    @Test
    public void logInIUA()
    {
        myDriver.getDriver().get("http://i.ua");
        myDriver.getDriver().manage().window().maximize();

        try
        {
            myDriver.getDriver().findElement(By.cssSelector("div[class = \"content clear\"]"));
            myDriver.getDriver().findElement(By.id("close")).click();
            myDriver.getDriver().findElement(By.cssSelector("a[title = \"русский\"]"));
            myDriver.getDriver().findElement(By.cssSelector("a[title = \"русский\"]")).click();
        }catch (Exception e) {
            System.out.println("Что-то пошло не так!");
        }


        myDriver.getDriver().findElement(By.name("login")).sendKeys("testmailswat@i.ua");
        myDriver.getDriver().findElement(By.name("pass")).sendKeys("123456qwerty");
        myDriver.getDriver().findElement(By.cssSelector("input[value = \"Войти\"]")).click();
        WebDriverWait wb = new WebDriverWait(myDriver.getDriver(),10);

        wb.until(ExpectedConditions.presenceOfElementLocated(By.className("sn_menu_title")));
        myDriver.getDriver().navigate().refresh();
        String act = myDriver.getDriver().findElement(By.className("sn_menu_title")).getText();
        Assert.assertEquals( "TestMailSWAT@i.ua",act);
        myDriver.getDriver().close();

    }
}
