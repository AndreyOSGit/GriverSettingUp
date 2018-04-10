

import PatternsForAT.DriverSingleton;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class IUA {
DriverSingleton dr = new DriverSingleton();
    WebDriver driver = dr.getDriver();

        @Given("^I on iua main page with russian localization$")
    public void IonMainPage () {

        driver.get("http://i.ua");
        driver.manage().window().maximize();

        try {
            driver.findElement(By.cssSelector("div[class = \"content clear\"]"));
            driver.findElement(By.id("close")).click();
            driver.findElement(By.cssSelector("a[title = \"русский\"]"));
            driver.findElement(By.cssSelector("a[title = \"русский\"]")).click();
        } catch (Exception e) {
            System.out.println("сайт уже на русском");
        }
    }
    @When("^Enter e-mail as (.*) and password as (.*) and press login button$")
    public void EnterEmailAndPasswordAndPressLoginButton ( String login, String password) {
        driver.findElement(By.name("login")).sendKeys(login);
        driver.findElement(By.name("pass")).sendKeys(password);
        driver.findElement(By.cssSelector("input[value = \"Войти\"]")).click();
    }



    @Then("^Check my login$")
        public void checkMyLogin(){
        driver.navigate().refresh();

            WebDriverWait wb = new WebDriverWait(driver, 10);
        wb.until(ExpectedConditions.presenceOfElementLocated(By.className("sn_menu_title")));

        String act = driver.findElement(By.className("sn_menu_title")).getText();
        Assert.assertEquals("TestMailSWAT@i.ua",act);
        driver.quit();
    }

}
