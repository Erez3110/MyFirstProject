package SanityTests;

import Extensions.verifications;
import Utilities.commonOps;
import WorkFlows.calcFlows;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Utilities.listeners.class)
public class calculatorDesktop extends commonOps
{
    @Test(description = "Test 01: Calculate Addition")
    @Description("Verify Addition Result")
    public void test01_Add()
    {
        calcFlows.add();
        verifications.textInElement(calculatorMain.result_lbl,"3");
    }
}
