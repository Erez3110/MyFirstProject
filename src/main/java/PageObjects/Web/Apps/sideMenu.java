package PageObjects.Web.Apps;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class sideMenu
{
    @FindBy(xpath = "//input[@class=\"search-input\"]")
    public WebElement searchApp_txt;

    @FindBy(xpath = "//div[@class=\"categories module\"]/ul/li/a")
    public List<WebElement> categories_list;

    @FindBy(xpath = "//a[text()=\"All\"]")
    public WebElement all_btn;

    @FindBy(xpath = "//a[text()=\"Activity Trackers\"]")
    public WebElement activityTrackers_btn;

    @FindBy(xpath = "//a[text()=\"Step Trackers\"]")
    public WebElement stepTrackers_btn;

    @FindBy(xpath = "//a[text()=\"Scales\"]")
    public WebElement scales_btn;

    @FindBy(xpath = "//a[text()=\"Lifestyle\"]")
    public WebElement lifestyle_btn;

    @FindBy(xpath = "//a[text()=\"Wearables\"]")
    public WebElement wearables_btn;

    @FindBy(xpath = "//a[text()=\"Fitness Apps\"]")
    public WebElement fitnessApps_btn;

    @FindBy(xpath = "//a[text()=\"Exercise Equipment\"]")
    public WebElement exerciseEquipment_btn;

    @FindBy(xpath = "//a[text()=\"Fertility\"]")
    public WebElement fertility_btn;
}
