package Helpers;

import Utilities.commonOps;
import Utilities.helperMethods;
import org.testng.annotations.Test;

public class visualTesting extends commonOps
{
    @Test
    public void createScreenShot() throws InterruptedException
    {
        helperMethods.closePopUp();
        helperMethods.getAppLogo("Fitbit Tracker");
        helperMethods.takeElementScreenShot(apps_mfp.searchResultLogo_img, "Fitbit_Tracker_Logo");
    }
}
