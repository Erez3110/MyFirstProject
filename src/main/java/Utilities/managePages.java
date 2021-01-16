package Utilities;

import PageObjects.Web.homePage;
import PageObjects.Web.login;
import PageObjects.Web.topMenu;
import org.openqa.selenium.support.PageFactory;

public class managePages extends base
{
    public static void init()
    {
        topMenu_mfp = PageFactory.initElements(driver, topMenu.class);
        homePage_mfp = PageFactory.initElements(driver, homePage.class);
        food_mfp = PageFactory.initElements(driver, PageObjects.Web.Food.food.class);
        foodNutritionData_mfp = PageFactory.initElements(driver, PageObjects.Web.Food.foodNutritionData.class);
        exercise_mfp = PageFactory.initElements(driver, PageObjects.Web.Exercise.exercise.class);
        apps_mfp = PageFactory.initElements(driver, PageObjects.Web.Apps.apps.class);
        sideMenu_mfp = PageFactory.initElements(driver, PageObjects.Web.Apps.sideMenu.class);
        login_mfp = PageFactory.initElements(driver, login.class);
        userHome_mfp = PageFactory.initElements(driver, PageObjects.Web.MyAccount.userHome.class);
        nutritionGoals_mfp = PageFactory.initElements(driver, PageObjects.Web.MyAccount.Goals.nutritionGoals.class);

        electronMain = PageFactory.initElements(driver, PageObjects.ElectronDemo.electronMainPage.class);
        calculatorMain = PageFactory.initElements(driver, PageObjects.Calculator.calculatorMain.class);
    }

    public static void initMobile()
    {
        mobileMain_mfp = new PageObjects.Mobile.mainPage(mobileDriver);
        mainMenu_mfp = new PageObjects.Mobile.mainMenu(mobileDriver);
        diary_mfp = new PageObjects.Mobile.Diary.diary(mobileDriver);
        searchFood_mfp = new PageObjects.Mobile.Diary.searchFood(mobileDriver);
        foodInfo_mfp = new PageObjects.Mobile.Diary.foodInfo(mobileDriver);
        exerciseDiary_mfp = new PageObjects.Mobile.Diary.exerciseDiary(mobileDriver);
        water_mfp = new PageObjects.Mobile.Diary.waterDiary(mobileDriver);
    }
}
