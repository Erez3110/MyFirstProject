package Extensions;

import Utilities.commonOps;
import io.appium.java_client.android.AndroidElement;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

import static org.testng.Assert.*;

public class verifications extends commonOps
{
    @Step("Verify Text in Element")
    public static void textInElement(WebElement elem, String expectedValue)
    {
        if(!getData("platformType").equalsIgnoreCase("mobile")
                && !getData("platformType").equalsIgnoreCase("electron")
                && !getData("platformType").equalsIgnoreCase("desktop"))
            wait.until(ExpectedConditions.visibilityOf(elem));
        if(getData("platformType").equalsIgnoreCase("desktop"))
            assertEquals(elem.getText().replaceAll("Display is", "").trim(),expectedValue);
        else
            assertEquals(elem.getText(),expectedValue);
    }

    @Step("Verify Text in Element")
    public static void textInElement(String elem, String expectedValue)
    {
        if(getData("platformType").equalsIgnoreCase("desktop"))
            assertEquals(elem.replaceAll("Display is", "").trim(),expectedValue);
        else
            assertEquals(elem,expectedValue);
    }

    @Step("Verify Text in Element")
    public static void textNotInElement(WebElement elem, String expectedValue)
    {
        if(!getData("platformType").equalsIgnoreCase("mobile"))
            wait.until(ExpectedConditions.visibilityOf(elem));
        assertNotEquals(elem.getText(),expectedValue);
    }

    @Step("Verify Number of Elements")
    public static void numberOfElements(List<WebElement> elems, int expectedValue)
    {
        if(!getData("platformType").equalsIgnoreCase("mobile"))
            wait.until(ExpectedConditions.visibilityOf(elems.get(elems.size()-1)));
        assertEquals(elems.size(),expectedValue);
    }

    @Step("Verify Image")
    public static void visualElement(WebElement imageElement, String expectedImageName)
    {
        BufferedImage expectedImage = null;
        try
        {
            expectedImage = ImageIO.read(new File(getData("imageRepo") + expectedImageName + ".png"));
        }
        catch (Exception e)
        {
            System.out.println("Error reading image file, see details: " + e);
        }
        Screenshot imageScreenShot = new AShot().takeScreenshot(driver,imageElement);
        BufferedImage actualImage = imageScreenShot.getImage();
        //imageDiff = new ImageDiffer(); אותחל במיין
        diff = imageDiff.makeDiff(actualImage,expectedImage);
        assertFalse(diff.hasDiff(), "Images are not the same");
    }

    @Step("Verify Text with Text")
    public static void text(String actualText, String expectedText)
    {
        assertEquals(actualText, expectedText);
    }

    @Step("Verify if Element is not Disabled By Class Name")
    public static void elementActivated(WebElement elem, boolean active)
    {
        String elemClass = elem.getAttribute("class");
        boolean actualState = !(elemClass.contains("disabled"));
        assertEquals(actualState,active);
    }

    @Step("Verify Element Does Not Exist")
    public static void elementExist(List<AndroidElement> elements, boolean expectedValue)
    {
        assertEquals(!elements.isEmpty(), expectedValue);
    }
}
