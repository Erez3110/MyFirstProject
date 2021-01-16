package PageObjects.Web.Apps;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class apps
{
    @FindBy(xpath = "//div[@class=\"featured-apps\"]/div/div/div[2]/div/a")
    public List<WebElement> featuredAppsNames_list;

    @FindBy(xpath = "//div[@class=\"featured-apps\"]/div/div/div/a/img")
    public List<WebElement> featuredAppsLogos_list;

    @FindBy(xpath = "//div[@class=\"apps-gallery\"]")
    public WebElement searchResultLogo_img;
}
