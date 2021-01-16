package SanityTests;

import Extensions.verifications;
import Utilities.commonOps;
import WorkFlows.mobileFlows;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Utilities.listeners.class)
public class myFitnessPalMobile extends commonOps
{
    //-----Login Once to MyFitnessPal App Using these Credentials:
    //-----User Name: erez3110@gmail.com
    //-----Password: 12345678
    @Test(description = "Test 01: Login to MyFitnessPal")
    @Description("Login to MyFitnessPal Web Application Using Credentials from XML")
    public void test01_login()
    {
        verifications.textInElement(mobileMain_mfp.mainHeader_lbl, "MyFitnessPal");
    }

    @Test(description = "Test 02: Add Food to Diary")
    @Description("Add a Food Item to Diary and Verify Calories")
    public void test02_addFoodToDiary()
    {
        String calories = mobileFlows.addFood("breakfast", "peanut butter");
        verifications.textInElement(diary_mfp.breakfastCalories_lbl, calories);
    }

    @Test(description = "Test 03: Delete Food from Diary")
    @Description("Delete a Food Item from Diary and Verify Calories")
    public void test03_removeFoodFromDiary()
    {
        mobileFlows.deleteFood(diary_mfp.foodItem_btn);
        verifications.textInElement(diary_mfp.foodTotal_lbl,"0");
    }

    @Test(description = "Test 04: Add Exercise to Diary")
    @Description("Add an Exercise to Diary and Verify Calories")
    public void test04_addExerciseToDiary()
    {
        String calories = mobileFlows.addExercise("cardio", "running", "90"); //type = cardio/strength
        verifications.textInElement(diary_mfp.exerciseTotal_lbl, calories);
    }

    @Test(description = "Test 05: Delete an Exercise from Diary")
    @Description("Delete an Exercise from Diary and Verify Calories")
    public void test05_removeExerciseFromDiary()
    {
        mobileFlows.deleteExerciseOrWater(diary_mfp.exerciseItem_btn);
        verifications.textInElement(diary_mfp.exerciseCalories_lbl, "0");
    }

    @Test(description = "Test 06: Add Water to Diary")
    @Description("Add Water Entry to Diary")
    public void test06_addWater()
    {
        mobileFlows.addWater("10");
        verifications.textInElement(diary_mfp.waterItem_btn.getText().replaceAll("cups","").trim(), "10");
    }

    @Test(description = "Test 07: Delete a Water Entry from Diary")
    @Description("Delete a Water Entry from Diary and Verify Total Amount")
    public void test07_removeWater()
    {
        mobileFlows.deleteExerciseOrWater(diary_mfp.waterItem_btn);
        verifications.elementExist(diary_mfp.waterItems_list,false);
    }

    @Test(description = "Test 08: Add a Note to Diary")
    @Description("Add a Food or Exercise Notes to Diary")
    public void test08_addNote()
    {
        mobileFlows.addNote("food","Don't eat the whole cake :)");
        verifications.elementExist(diary_mfp.foodNote_list,true);
    }
}
