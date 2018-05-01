package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends BasePage
{

    @FindBy(name = "login")
    protected WebElement emailInput;
    @FindBy(name = "pass")
    protected WebElement passwordImput;
    @FindBy(css = "input[type = \"submit\"][tabindex=\"5\"]")
    protected WebElement loginButton;

    protected void goToMainPage()
    {
        //Driver .get("http://i.ua");
    }

    public void loginToaccount(String login, String password, WebDriver driver){

        emailInput.sendKeys(login);
        passwordImput.sendKeys(password);
        loginButton.click();

        WebDriverWait wb = new WebDriverWait(driver, 10);
        wb.until(ExpectedConditions.presenceOfElementLocated(By.className("sn_menu_title")));
        driver.navigate().refresh();
    }
}
