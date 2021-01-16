package PageObjects.Web.MyAccount;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class userHome
{
    @FindBy(xpath = "//h2[contains(text(), 'Your Daily Summary')]")
    public WebElement summaryHeader_txt;

    @FindBy(linkText = "Goals")
    public WebElement goals_btn;

    @FindBy(xpath = "//a[@class='close-btn']")
    public WebElement closePopup_btn;
}
