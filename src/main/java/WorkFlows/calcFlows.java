package WorkFlows;

import Extensions.uiActions;
import Utilities.commonOps;
import io.qameta.allure.Step;

public class calcFlows extends commonOps
{
    @Step("Calculate Addition")
    public static void add()
    {
        uiActions.click(calculatorMain.clear_btn);
        uiActions.click(calculatorMain.one_btn);
        uiActions.click(calculatorMain.plus_btn);
        uiActions.click(calculatorMain.two_btn);
        uiActions.click(calculatorMain.equals_btn);
    }
}
