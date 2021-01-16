package PageObjects.ElectronDemo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class electronMainPage
{
    @FindBy(id = "button-app-sys-information")
    public WebElement sysInfo_btn;

    @FindBy(id = "screen-info-demo-toggle")
    public WebElement screenInfoToggle_btn;

    @FindBy(id = "screen-info")
    public WebElement viewScreenInfo_btn;

    @FindBy(id = "got-screen-info")
    public WebElement screenInfo_lbl;
}
