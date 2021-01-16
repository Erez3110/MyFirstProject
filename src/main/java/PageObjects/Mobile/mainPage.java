package PageObjects.Mobile;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class mainPage
{
    private AppiumDriver mobileDriver;

    public mainPage(AppiumDriver mobileDriver)
    {
        this.mobileDriver = mobileDriver;
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver,3, TimeUnit.SECONDS),this);
    }

    @AndroidFindBy(className = "android.widget.TextView")
    public AndroidElement mainHeader_lbl;

    @AndroidFindBy(className = "android.widget.ImageButton")
    public AndroidElement menuToggle_btn;

    @AndroidFindBy(id = "action_diary")
    public AndroidElement diary_btn;

    @AndroidFindBy(id = "action_home")
    public AndroidElement home_btn;
}
