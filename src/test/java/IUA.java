import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IUA {


    public String loginToIUA (WebDriver driver) {
        driver.get("http://i.ua");
        driver.manage().window().maximize();

        try
        {
            driver.findElement(By.cssSelector("div[class = \"content clear\"]"));
            driver.findElement(By.id("close")).click();
            driver.findElement(By.cssSelector("a[title = \"русский\"]"));
            driver.findElement(By.cssSelector("a[title = \"русский\"]")).click();
        }catch (Exception e) {
            System.out.println("");
        }


        driver.findElement(By.name("login")).sendKeys("testmailswat@i.ua");
        driver.findElement(By.name("pass")).sendKeys("123456qwerty");
        driver.findElement(By.cssSelector("input[value = \"Войти\"]")).click();
        WebDriverWait wb = new WebDriverWait(driver, 10);

        wb.until(ExpectedConditions.presenceOfElementLocated(By.className("sn_menu_title")));
        driver.navigate().refresh();
        String act = driver.findElement(By.className("sn_menu_title")).getText();

        return act;
    }
}
