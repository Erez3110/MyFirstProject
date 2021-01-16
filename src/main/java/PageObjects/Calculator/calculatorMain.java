package PageObjects.Calculator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class calculatorMain
{
    @FindBy(name = "Clear")
    public WebElement clear_btn;

    @FindBy(name = "One")
    public WebElement one_btn;

    @FindBy(name = "Two")
    public WebElement two_btn;

    @FindBy(name = "Plus")
    public WebElement plus_btn;

    @FindBy(name = "Equals")
    public WebElement equals_btn;

    @FindBy(xpath = "//*[@AutomationId = 'CalculatorResults']")
    public WebElement result_lbl;
}
