package PageObjects.Web.MyAccount.Goals;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class nutritionGoals
{
    @FindBy(linkText = "Edit")
    public WebElement editGoals_btn;

    @FindBy(xpath = "//input[@class='ember-view ember-text-field mfp-input form-control']")
    public WebElement calories_txt;

    @FindBy(xpath = "//div[@class='input-group  ']/div/div[3]/div/span")
    public WebElement carbsGrams_lbl;

    @FindBy(xpath = "//div[@class='input-group  ']/div/div[3]/div[2]/div/select")
    public WebElement carbsPercent_dropDown;

    @FindBy(xpath = "//div[@class='input-group  ']/div/div[4]/div/span")
    public WebElement fatGrams_lbl;

    @FindBy(xpath = "//div[@class='input-group  ']/div/div[4]/div[2]/div/select")
    public WebElement fatPercent_dropDown;

    @FindBy(xpath = "//div[@class='input-group  ']/div/div[5]/div/span")
    public WebElement proteinGrams_lbl;

    @FindBy(xpath = "//div[@class='input-group  ']/div/div[5]/div[2]/div/select")
    public WebElement proteinPercent_dropDown;

    @FindBy(xpath = "//div[@class='actions']/a[2]")
    public WebElement save_btn;
}
