package PageObjects.Web;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class homePage
{
    @FindBy(xpath = "//h1[@class=\"MuiTypography-root jss14 MuiTypography-gutterBottom\"]")
    public WebElement mainHeader_lbl;

    @FindBy(xpath = "//input[@type=\"search\"]")
    public WebElement searchFood_txt;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    public WebElement search_btn;

    @FindBy(xpath = "//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained jss24 jss25 jss26 jss30 MuiButton-containedPrimary MuiButton-containedSizeSmall MuiButton-sizeSmall']")
    public WebElement popUp_btn;
}
