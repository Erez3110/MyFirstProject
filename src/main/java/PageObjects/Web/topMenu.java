package PageObjects.Web;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class topMenu
{
    @FindBy(xpath = "//a[@title=\"UA shop\"]")
    public WebElement underArmour_btn;

    @FindBy(xpath = "//a[@title=\"MapMyFitness site\"]")
    public WebElement mapSite_btn;

    @FindBy(xpath = "//a[@title=\"MyFitnesspal site\"]")
    public WebElement myFitnessPalSite_btn;

    @FindBy(xpath = "//img[@src=\"/react-static/53af3757ef0dac6bc550728bdf9e779b.svg\"]")
    public WebElement logo_img;

    @FindBy(xpath = "//a[@href=\"/account/login\"]")
    public WebElement login_btn;

    @FindBy(xpath = "//a[contains(text(),'Sign Up')]")
    public WebElement sighUp_btn;

    @FindBy(xpath = "//a[@href=\"/welcome/learn_more\"]")
    public WebElement about_btn;

    @FindBy(xpath = "//a[@href=\"/food/calorie-chart-nutrition-facts\"]")
    public WebElement food_btn;

    @FindBy(xpath = "//a[@href=\"/exercise/lookup\"]")
    public WebElement exercise_btn;

    @FindBy(xpath = "//a[@href=\"/apps\"]")
    public WebElement apps_btn;

    @FindBy(xpath = "//a[@href=\"http://community.myfitnesspal.com/en/categories\"]")
    public WebElement community_btn;

    @FindBy(xpath = "http://blog.myfitnesspal.com/")
    public WebElement blog_btn;

    @FindBy(xpath = "//a[@href=\"#\"]")
    public WebElement shop_btn;

    @FindBy(xpath = "//img[@src=\"/react-static/297a39fe7d45b0214ccf3bc8b074c3cf.svg\"]")
    public WebElement shopLogo_img;

    @FindBy(xpath = "/premium?source=menu_bar")
    public WebElement premium_btn;
}
