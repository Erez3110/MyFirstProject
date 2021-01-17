package PageObjects.Web;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class homePage
{
    @FindBy(xpath = "//h1[contains(text(), \"Fitness starts with what you eat.\")]")
    public WebElement mainHeader_lbl;

    @FindBy(xpath = "//input[@type=\"search\"]")
    public WebElement searchFood_txt;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    public WebElement search_btn;

    @FindBy(xpath = "//span/div[contains(text(), \"GOT IT\")]")
    public WebElement popUp_btn;
}
