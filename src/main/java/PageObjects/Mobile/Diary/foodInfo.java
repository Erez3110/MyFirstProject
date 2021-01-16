package PageObjects.Mobile.Diary;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class foodInfo
{
    private AppiumDriver mobileDriver;

    public foodInfo(AppiumDriver mobileDriver)
    {
        this.mobileDriver = mobileDriver;
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver,3, TimeUnit.SECONDS),this);
    }

    @AndroidFindBy(xpath = "//*[@contentDescription='Add']")
    public AndroidElement addFood_btn;

    @AndroidFindBy(id = "txtFoodName")
    public AndroidElement foodName_lbl;

    @AndroidFindBy(id = "txtCalories")
    public AndroidElement foodCalories_lbl;
}
