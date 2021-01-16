package PageObjects.Mobile.Diary;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class waterDiary
{
    private AppiumDriver mobileDriver;

    public waterDiary(AppiumDriver mobileDriver)
    {
        this.mobileDriver = mobileDriver;
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver,3, TimeUnit.SECONDS),this);
    }
    @AndroidFindBy(id = "quick_pick_1")
    public AndroidElement plus7_btn;

    @AndroidFindBy(id = "quick_pick_2")
    public AndroidElement plus1_btn;

    @AndroidFindBy(id = "quick_pick_3")
    public AndroidElement plus2_btn;

    @AndroidFindBy(id = "water_value")
    public AndroidElement waterCups_txt;

    @AndroidFindBy(xpath = "//*[@contentDescription='אישור']")
    public AndroidElement confirm_btn;
}
