package SanityTests;

import Extensions.verifications;
import Utilities.commonOps;
import WorkFlows.electronFlow;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Utilities.listeners.class)
public class electronDemo extends commonOps
{
    @Test(description = "Test 01: Screen Resolution")
    @Description("Verify the Screen Resolution")
    public void test01_verifyScreenResolution()
    {
        electronFlow.getScreenInfo();
        verifications.textInElement(electronMain.screenInfo_lbl, "Your screen is: 1280px x 720px");
    }
}
