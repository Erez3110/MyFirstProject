package PageObjects.Mobile.Diary;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class exerciseDiary
{
    private AppiumDriver mobileDriver;

    public exerciseDiary(AppiumDriver mobileDriver)
    {
        this.mobileDriver = mobileDriver;
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver,3, TimeUnit.SECONDS),this);
    }

    @AndroidFindBy(id = "editTxtSearchExercise")
    public AndroidElement searchExercise_txt;

    @AndroidFindBy(id = "key_pos_ime_action")
    public AndroidElement searchExercise_btn;

    @AndroidFindBy(xpath = "//*[@id='double_line_container']")
    public List<AndroidElement> exerciseResult_list;

    @AndroidFindBy(id = "editTxtExerciseInterval")
    public AndroidElement minutes_txt;

    @AndroidFindBy(id = "editTxtCaloriesBurned")
    public AndroidElement burned_lbl;

    @AndroidFindBy(xpath = "//*[@contentDescription='Add Now']")
    public AndroidElement addExercise_btn;
}
