package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MailPage extends BasePage
{
    @FindBy(css = "form[name = \"aform\"] .frm")
    protected List<WebElement> mailsList;

    @FindBy(css = "form[name = \"aform\"] .attr input")
    protected List<WebElement> mailsListCheckBox;

    @FindBy(css = ".current.new a")
    protected WebElement inboxButton;

    @FindBy(css = ".make_message a")
    protected WebElement createMail;

    @FindBy(css = ".sn_menu_title")
    protected WebElement accountName;

    protected void showMeInbox()
    {
        inboxButton.click();
    }
    protected void goToCreateMail()
    {
        createMail.click();
    }
    public String getAccountName()
    {

    return accountName.getText();
    }

}
