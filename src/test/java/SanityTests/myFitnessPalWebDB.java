package SanityTests;

import Extensions.verifications;
import Utilities.commonOps;
import WorkFlows.webFlows;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Utilities.listeners.class)
public class myFitnessPalWebDB extends commonOps
{
    @Test(description = "Test 01: Login to MyFitnessPal with DB")
    @Description("Login to MyFitnessPal Web Application Using Credentials from DB")
    public void test01_Login()
    {
        webFlows.loginDB();
        verifications.textInElement(userHome_mfp.summaryHeader_txt, "Your Daily Summary");
    }

}
