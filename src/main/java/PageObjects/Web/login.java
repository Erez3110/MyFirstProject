package PageObjects.Web;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class login
{
    @FindBy(xpath = "//input[@placeholder=\"Email Address\"]")
    public WebElement userName_txt;

    @FindBy(xpath = "//input[@placeholder=\"Password\"]")
    public WebElement password_txt;

    @FindBy(xpath = "//input[@name=\"remember_me\"]")
    public WebElement remember_check;

    @FindBy(xpath = "//input[@type=\"submit\"]")
    public WebElement submit_btn;
}
