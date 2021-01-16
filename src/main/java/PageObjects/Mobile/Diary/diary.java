package PageObjects.Mobile.Diary;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class diary
{
    private AppiumDriver mobileDriver;

    public diary(AppiumDriver mobileDriver)
    {
        this.mobileDriver = mobileDriver;
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver,3, TimeUnit.SECONDS),this);
    }

    @AndroidFindBy(id = "goal")
    public AndroidElement goal_lbl;

    @AndroidFindBy(id = "food")
    public AndroidElement foodTotal_lbl;

    @AndroidFindBy(id = "exercise")
    public AndroidElement exerciseTotal_lbl;

    @AndroidFindBy(id = "remaining_diary")
    public AndroidElement remaining_lbl;

    @AndroidFindBy(xpath = "(//*[@id='diary_recycler_view']/*/*[@text='Add Food'])[1]")
    public AndroidElement addFoodBreakfast_btn;

    @AndroidFindBy(xpath = "(//*[@id='diary_recycler_view']/*/*[@text='Add Food'])[2]")
    public AndroidElement addFoodLunch_btn;

    @AndroidFindBy(xpath = "(//*[@id='diary_recycler_view']/*/*[@text='Add Food'])[3]")
    public AndroidElement addFoodDinner_btn;

    @AndroidFindBy(xpath = "(//*[@id='diary_recycler_view']/*/*[@text='Add Food'])[4]")
    public AndroidElement addFoodSnack_btn;

    @AndroidFindBy(xpath = "//*[@text='Add Exercise']")
    public AndroidElement addExercise_btn;

    @AndroidFindBy(xpath = "//*[@text='Add Water']")
    public AndroidElement addWater_btn;

    @AndroidFindBy(xpath = "//*[contains(text(),'cups')]")
    public AndroidElement waterItem_btn;

    @AndroidFindBy(xpath = "//*[contains(text(),'Notes')]")
    public AndroidElement notes_btn;

    @AndroidFindBy(xpath = "//*[contains(text(),'Food Notes')]")
    public AndroidElement foodNotes_btn;

    @AndroidFindBy(xpath = "//*[contains(text(),'Exercise Notes')]")
    public AndroidElement exerciseNotes_btn;

    @AndroidFindBy(xpath = "//*[contains(text(),'Enter')]")
    public AndroidElement noteContent_txt;

    @AndroidFindBy(xpath = "//*[@contentDescription='Save']")
    public AndroidElement saveNote_btn;

    @AndroidFindBy(xpath = "//*[@text='Food' and @id='txtItemDescription']")
    public List<AndroidElement> foodNote_list;

    @AndroidFindBy(xpath = "//*[contains(text(),'cups')]")
    public List<AndroidElement> waterItems_list;

    @AndroidFindBy(xpath = "//*[@text='Cardiovascular']")
    public AndroidElement cardio_btn;

    @AndroidFindBy(xpath = "//*[@text='Strength']")
    public AndroidElement strength_btn;

    @AndroidFindBy(xpath = "//*[@id='txtSectionCalories' and (./preceding-sibling::* | ./following-sibling::*)[@text='Breakfast']]")
    public AndroidElement breakfastCalories_lbl;

    @AndroidFindBy(xpath = "//*[@id='txtSectionCalories' and (./preceding-sibling::* | ./following-sibling::*)[@text='Lunch']]")
    public AndroidElement lunchCalories_lbl;

    @AndroidFindBy(xpath = "//*[@id='txtSectionCalories' and (./preceding-sibling::* | ./following-sibling::*)[@text='Dinner']]")
    public AndroidElement dinnerCalories_lbl;

    @AndroidFindBy(xpath = "//*[@id='txtSectionCalories' and (./preceding-sibling::* | ./following-sibling::*)[@text='Snacks']]")
    public AndroidElement snacksCalories_lbl;

    @AndroidFindBy(xpath = "//*[@id='txtSectionCalories' and (./preceding-sibling::* | ./following-sibling::*)[@text='Exercise']]")
    public AndroidElement exerciseCalories_lbl;

    @AndroidFindBy(xpath = "//*[@id='foodSearchViewFoodItem' and @class='android.widget.LinearLayout']")
    public AndroidElement exerciseItem_btn;

    @AndroidFindBy(id = "foodSearchViewFoodItem")
    public AndroidElement foodItem_btn;

    @AndroidFindBy(xpath = "//*[@text='Delete Entry']")
    public AndroidElement delete_btn;
}
