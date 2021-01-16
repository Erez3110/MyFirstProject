package PageObjects.Web.Food;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class food
{
    @FindBy(xpath = "//input[@type=\"search\"]")
    public WebElement searchFood_txt;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    public WebElement search_btn;

    @FindBy(xpath = "//div[@class=\"main-2ZMcp\"]/div/div/a")
    public List<WebElement> searchResults_list;
}
