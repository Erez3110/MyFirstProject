package PageObjects.Mobile;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class mainMenu
{
    private AppiumDriver mobileDriver;

    public mainMenu(AppiumDriver mobileDriver)
    {
        this.mobileDriver = mobileDriver;
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver,3, TimeUnit.SECONDS),this);
    }

    @AndroidFindBy(xpath = "//*[@id='text' and text()='Home']")
    public AndroidElement home_btn;

    @AndroidFindBy(xpath = "//*[@id='text' and text()='Diary']")
    public AndroidElement diary_btn;

    @AndroidFindBy(xpath = "//*[@id='text' and text()='Progress']")
    public AndroidElement progress_btn;

    @AndroidFindBy(xpath = "//*[@id='text' and text()='Goals']")
    public AndroidElement goals_btn;

    @AndroidFindBy(xpath = "//*[@id='text' and text()='Nutrition']")
    public AndroidElement nutrition_btn;
}
