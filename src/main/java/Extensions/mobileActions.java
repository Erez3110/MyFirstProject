package Extensions;

import Utilities.commonOps;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class mobileActions extends commonOps
{
    @Step("Click on Element and Hold")
    public static void clickAndHold(AndroidElement elem)
    {
        if(!getData("platformType").equalsIgnoreCase("mobile")
                && !getData("platformType").equalsIgnoreCase("electron")
                && !getData("platformType").equalsIgnoreCase("desktop"))
            wait.until(ExpectedConditions.visibilityOf(elem));
        touchAction = new TouchAction(mobileDriver);
        touchAction.longPress(elem).perform();
    }

    @Step("Scroll Page")
    public static void swipe(String direction, int startAt, int stopAt, int duration)
    {
        if(direction.equalsIgnoreCase("verticle"))
        {
            mobileDriver.swipe(500, startAt, 500, stopAt, duration);
        }
        else if(direction.equalsIgnoreCase("horizontal"))
        {
            mobileDriver.swipe(startAt, 500, stopAt, 500, duration);
        }
    }
}
