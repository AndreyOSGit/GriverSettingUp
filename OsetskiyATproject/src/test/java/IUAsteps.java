

import PatternsForAT.DriverFactory;
import PatternsForAT.DriverSingleton;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pom.MailPage;
import pom.MainPage;


public class IUAsteps {

    WebDriver runDriver = new DriverSingleton().driver;
    DriverFactory driverFactory = new DriverFactory();
   // WebDriver runDriver = driverFactory.getBrowser("firefox");
  //  WebDriver runDriver2 = driverFactory.getBrowser("firefox");
    protected MainPage MainPageInstance = null;

    @Before
    public void before()
    {
        runDriver.manage().window().maximize();
       // runDriver2.manage().window().maximize();
        MainPageInstance = PageFactory.initElements(runDriver,MainPage.class);
       // MainPageInstance = PageFactory.initElements(runDriver2,MainPage.class);
    }

    @After
    public void after()
    {
   //     driverFactory.closeAllDriver();
        runDriver.close();
        runDriver.quit();
    }

    @Given("^I on iua main page$")
    public void IonMainPage ()
        {
            runDriver.get("http://i.ua");
//            runDriver2.get("http://i.ua");
        }

    @When("^Enter e-mail as (.*) and password as (.*) and press login button$")
    public void EnterEmailAndPasswordAndPressLoginButton ( String login, String password)
    {
        MainPageInstance.loginToaccount(login, password, runDriver);
//        MainPageInstance.loginToaccount(login, password, runDriver2);
    }

    @Then("^Check my login (.*)$")
        public void checkMyLogin(String exp)
    {
        String act1 = PageFactory.initElements(runDriver,MailPage.class).getAccountName();
//        String act2 = PageFactory.initElements(runDriver2,MailPage.class).getAccountName();
        Assert.assertEquals(exp,act1);
//        Assert.assertEquals(exp,act2);
    }

}
