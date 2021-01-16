package PageObjects.Web.Exercise;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class exercise
{
    @FindBy(xpath = "//input[@id=\"search\"]")
    public WebElement searchExercise_txt;

    @FindBy(xpath = "//input[@value=\"Search\"]")
    public WebElement searchExercise_btn;

    @FindBy(xpath = "//ul[@id=\"matching\"]/li/a")
    public List<WebElement> resultExercise_list;

    @FindBy(id = "exercise_select")
    public WebElement selectExercise_dropDown;

    @FindBy(id = "weight_display_value")
    public WebElement weight_txt;

    @FindBy(id = "unit_preferences_body_weight")
    public WebElement selectUnit_dropDown;

    @FindBy(id = "minutes")
    public WebElement minutes_txt;

    @FindBy(id = "cresults")
    public WebElement result_lbl;

    @FindBy(xpath = "//div[@id=\"browse_by_name\"]/a")
    public List<WebElement> browseDatabase_list;

    @FindBy(xpath = "//div[@id=\"main\"]//ol/li/a")
    public List<WebElement> browseResult_list;
}
