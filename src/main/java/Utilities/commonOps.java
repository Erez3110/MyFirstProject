package Utilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.windows.WindowsDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class commonOps extends base
{
    public static String getData (String nodeName)
    {
        DocumentBuilder dBuilder;
        Document doc = null;
        File fXmlFile = new File("Configuration\\dataConfig.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            try
        {
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fXmlFile);
        }
            catch(Exception e)
        {
            System.out.println("Exception in reading XML file: " + e);
        }
            doc.getDocumentElement().normalize();
            return doc.getElementsByTagName(nodeName).item(0).getTextContent();
    }

    public static void initBrowser(String browserType)
    {
        if(browserType.equalsIgnoreCase("chrome"))
            driver = initChromeDriver();
        else if(browserType.equalsIgnoreCase("firefox"))
            driver = initFFDriver();
        else if(browserType.equalsIgnoreCase("ie"))
            driver = initIEDriver();
        else
            throw new RuntimeException("Invalid platform name stated");
        driver.manage().window().maximize();
        driver.get(getData("url"));
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("timeout")) , TimeUnit.SECONDS);
        wait = new WebDriverWait(driver,Long.parseLong(getData("timeout")));
        action = new Actions(driver);
        helperMethods.closePopUp();
    }

    public static WebDriver initChromeDriver()
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        return driver;
    }

    public static WebDriver initFFDriver()
    {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        return driver;
    }

    public static WebDriver initIEDriver()
    {
        WebDriverManager.iedriver().setup();
        WebDriver driver = new InternetExplorerDriver();
        return driver;
    }

    public static void initMobile()
    {
        dc.setCapability(MobileCapabilityType.UDID, getData("UDID"));
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, getData("APP_PACKAGE"));
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, getData("APP_ACTIVITY"));
        try
        {
            mobileDriver = new AndroidDriver(new URL(getData("AppiumServer") + "/wd/hub"), dc);
        }
        catch (Exception e)
        {
            System.out.println("Cannot Connect to Appium Server, See Details: " + e);
        }
        managePages.initMobile();
    }

    public static void initAPI()
    {
        RestAssured.baseURI = getData("url_api");
        httpRequest = RestAssured.given().auth().preemptive().basic("admin", "admin");
    }

    public static void initElectron()
    {
        System.setProperty("webdriver.chrome.driver", getData("ElectronDriverPath"));
        ChromeOptions opt = new ChromeOptions();
        opt.setBinary(getData("ElectronAppPath"));
        dc.setCapability("chromeOptions",opt);
        dc.setBrowserName("chrome");
        driver = new ChromeDriver(dc);
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("timeout")) , TimeUnit.SECONDS);
    }

    public static void initDesktop()
    {
        dc.setCapability("app",getData("CalculatorApp"));
        try
        {
            driver = new WindowsDriver(new URL(getData("AppiumServer")), dc);
        }
        catch (Exception e)
        {
            System.out.println("Cannot Connect to Appium Server, See Details: " + e);
        }
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("timeout")) , TimeUnit.SECONDS);
    }

    @BeforeClass
    public void startSession()
    {
        if(getData("platformType").equalsIgnoreCase("web"))
            initBrowser(getData("browser"));
        else if(getData("platformType").equalsIgnoreCase("mobile"))
            initMobile();
        else if(getData("platformType").equalsIgnoreCase("api"))
            initAPI();
        else if(getData("platformType").equalsIgnoreCase("electron"))
            initElectron();
        else if(getData("platformType").equalsIgnoreCase("desktop"))
            initDesktop();
        else
            throw new RuntimeException("Invalid platform name stated");
        managePages.init();
        manageDB.initConnection(getData("dbURL"),getData("dbUser"),getData("dbPass"));
    }

    @AfterMethod
    public void afterMethod()
    {
        if(getData("platformType").equalsIgnoreCase("web"))
            driver.get(getData("url"));
        else if(getData("platformType").equalsIgnoreCase("mobile"))
            mobileDriver.findElement(By.id("action_home")).click();
    }

    @AfterClass
    public void closeSession()
    {
        manageDB.closeConnection();
        if(getData("platformType").equalsIgnoreCase("web"))
            driver.quit();
        else if(getData("platformType").equalsIgnoreCase("mobile"))
            mobileDriver.quit();
    }
}
