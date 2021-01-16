package PageObjects.Web.Food;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class foodNutritionData
{
    @FindBy(xpath = "//input[@type=\"search\"]")
    public WebElement searchFood_txt;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    public WebElement search_btn;

    @FindBy(xpath = "//span[@class=\"title-cgZqW\"]")
    public WebElement calories_lbl;

    @FindBy(xpath = "//div[@class=\"root-1W4Ez\"]/div[2]/span[2]")
    public WebElement carbs_lbl;

    @FindBy(xpath = "//div[@class=\"root-1W4Ez\"]/div[3]/span[2]")
    public WebElement fat_lbl;

    @FindBy(xpath = "//div[@class=\"root-1W4Ez\"]/div[4]/span[2]")
    public WebElement protein_lbl;
}
