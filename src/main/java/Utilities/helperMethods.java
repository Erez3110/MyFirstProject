package Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;

import javax.imageio.ImageIO;
import java.io.File;

public class helperMethods extends commonOps
{
    public static void takeElementScreenShot(WebElement imageElem, String imageName)
    {
        imageScreenShot = new AShot().coordsProvider((new WebDriverCoordsProvider())).takeScreenshot(driver,imageElem); //win 10
        //imageScreenShot = new AShot().takeScreenshot(driver,imageElem); //win 7
        try
        {
            ImageIO.write(imageScreenShot.getImage(),"png", new File(getData("imageRepo") + imageName + ".png"));

        }
        catch (Exception e)
        {
            System.out.println("Error writing image file, see details: " + e);
        }
    }

    public static String trimGrams(String value)
    {
        String[] trimmedValue = value.split("g");
        return trimmedValue[0].trim();
    }

    public static WebElement getAppLogo(String appName)
    {
        topMenu_mfp.apps_btn.click();
        sideMenu_mfp.searchApp_txt.sendKeys(appName);
        sideMenu_mfp.searchApp_txt.sendKeys(Keys.ENTER);
        return apps_mfp.searchResultLogo_img;
    }

    public static void closePopUp()
    {
        WebElement button = driver.findElement(By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained jss24 jss25 jss26 jss30 MuiButton-containedPrimary MuiButton-containedSizeSmall MuiButton-sizeSmall']"));
        if(button.isDisplayed())
        {
            button.click();
        }
    }
}
