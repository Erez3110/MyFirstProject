package WorkFlows;

import Extensions.uiActions;
import Utilities.commonOps;
import io.qameta.allure.Step;

public class electronFlow extends commonOps
{
    @Step("Get Screen Info (Resolution)")
    public static void getScreenInfo()
    {
        uiActions.click(electronMain.sysInfo_btn);
        uiActions.click(electronMain.screenInfoToggle_btn);
        uiActions.click(electronMain.screenInfoToggle_btn);
        uiActions.click(electronMain.viewScreenInfo_btn);
    }
}
