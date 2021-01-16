package Utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.restassured.path.json.JsonPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class base
{
    public static WebDriver driver;
    protected static AppiumDriver mobileDriver;
    public static WebDriverWait wait;
    public static Actions action;
    public static Screenshot imageScreenShot;
    public static ImageDiffer imageDiff = new ImageDiffer();
    public static ImageDiff diff;
    public static DesiredCapabilities dc = new DesiredCapabilities();
    public static TouchAction touchAction;

    public static PageObjects.Web.topMenu topMenu_mfp;
    public static PageObjects.Web.homePage homePage_mfp;
    public static PageObjects.Web.Food.food food_mfp;
    public static PageObjects.Web.Food.foodNutritionData foodNutritionData_mfp;
    public static PageObjects.Web.Exercise.exercise exercise_mfp;
    public static PageObjects.Web.Apps.apps apps_mfp;
    public static PageObjects.Web.Apps.sideMenu sideMenu_mfp;
    public static PageObjects.Web.login login_mfp;
    public static PageObjects.Web.MyAccount.userHome userHome_mfp;
    public static PageObjects.Web.MyAccount.Goals.nutritionGoals nutritionGoals_mfp;

    protected static PageObjects.Mobile.mainPage mobileMain_mfp;
    protected static PageObjects.Mobile.mainMenu mainMenu_mfp;
    protected static PageObjects.Mobile.Diary.diary diary_mfp;
    protected static PageObjects.Mobile.Diary.searchFood searchFood_mfp;
    protected static PageObjects.Mobile.Diary.foodInfo foodInfo_mfp;
    protected static PageObjects.Mobile.Diary.exerciseDiary exerciseDiary_mfp;
    protected static PageObjects.Mobile.Diary.waterDiary water_mfp;

    public static RequestSpecification httpRequest;
    public static Response response;
    public static JSONObject requestParams = new JSONObject();
    public static JsonPath jp;

    protected static PageObjects.ElectronDemo.electronMainPage electronMain;
    protected static PageObjects.Calculator.calculatorMain calculatorMain;

    public static Connection con;
    public static Statement stmt;
    public static ResultSet rs;
}
