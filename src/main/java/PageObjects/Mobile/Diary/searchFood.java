package PageObjects.Mobile.Diary;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class searchFood
{
    private AppiumDriver mobileDriver;

    public searchFood(AppiumDriver mobileDriver)
    {
        this.mobileDriver = mobileDriver;
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver,3, TimeUnit.SECONDS),this);
    }

    @AndroidFindBy(id = "searchEditText")
    public AndroidElement searchFood_txt;

    @AndroidFindBy(id = "key_pos_ime_action")
    public AndroidElement search_btn;

    @AndroidFindBy(xpath = "//*[@id='double_line_container']")
    public List<AndroidElement> searchResult_list;
}
