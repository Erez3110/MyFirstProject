package WorkFlows;

import Extensions.mobileActions;
import Extensions.uiActions;
import Utilities.commonOps;
import io.appium.java_client.android.AndroidElement;
import io.qameta.allure.Step;

public class mobileFlows extends commonOps
{
    @Step("Add a Food Item to Diary")
    public static String addFood(String meal, String foodName)
    {
        String calories = "";
        uiActions.click(mobileMain_mfp.menuToggle_btn);
        uiActions.click(mainMenu_mfp.diary_btn);
        if(meal.equalsIgnoreCase("breakfast"))
        {
            uiActions.click(diary_mfp.addFoodBreakfast_btn);
            uiActions.click(searchFood_mfp.searchFood_txt);
            uiActions.updateText(searchFood_mfp.searchFood_txt,foodName);
        }

        else if(meal.equalsIgnoreCase("lunch"))
        {
            uiActions.click(diary_mfp.addFoodLunch_btn);
            uiActions.click(searchFood_mfp.searchFood_txt);
            uiActions.updateText(searchFood_mfp.searchFood_txt,foodName);
        }

        else if(meal.equalsIgnoreCase("dinner"))
        {
            uiActions.click(diary_mfp.addFoodDinner_btn);
            uiActions.click(searchFood_mfp.searchFood_txt);
            uiActions.updateText(searchFood_mfp.searchFood_txt,foodName);
        }

        else if(meal.equalsIgnoreCase("snack"))
        {
            uiActions.click(diary_mfp.addFoodSnack_btn);
            uiActions.click(searchFood_mfp.searchFood_txt);
            uiActions.updateText(searchFood_mfp.searchFood_txt,foodName);
        }
        uiActions.click(searchFood_mfp.search_btn);
        uiActions.click(searchFood_mfp.searchResult_list.get(1));
        calories = foodInfo_mfp.foodCalories_lbl.getText();
        uiActions.click(foodInfo_mfp.addFood_btn);
        return calories;
    }

    @Step("Add an Exercise to Diary")
    public static String addExercise(String type, String exerciseName, String duration)
    {
        uiActions.click(mobileMain_mfp.diary_btn);
        mobileActions.swipe("verticle",1000,0,2000);
        uiActions.click(diary_mfp.addExercise_btn);
        if(type.equalsIgnoreCase("cardio"))
        {
            uiActions.click(diary_mfp.cardio_btn);
        }
        else if(type.equalsIgnoreCase("strength"))
        {
            uiActions.click(diary_mfp.strength_btn);
        }
        uiActions.click(exerciseDiary_mfp.searchExercise_txt);
        uiActions.updateText(exerciseDiary_mfp.searchExercise_txt, exerciseName);
        uiActions.click(exerciseDiary_mfp.searchExercise_btn);
        uiActions.click(exerciseDiary_mfp.exerciseResult_list.get(0));
        uiActions.updateText(exerciseDiary_mfp.minutes_txt, duration);
        String calories = exerciseDiary_mfp.burned_lbl.getText();
        uiActions.click(exerciseDiary_mfp.addExercise_btn);
        return calories;
    }

    @Step("Add Water to Diary")
    public static void addWater(String cups)
    {
        uiActions.click(mobileMain_mfp.diary_btn);
        mobileActions.swipe("verticle",1000,0,2000);
        uiActions.click(diary_mfp.addWater_btn);
        uiActions.updateText(water_mfp.waterCups_txt, cups);
        uiActions.click(water_mfp.confirm_btn);
    }

    @Step("Delete an Exercise or Water from Diary")
    public static void deleteExerciseOrWater(AndroidElement elem)
    {
        uiActions.click(mobileMain_mfp.diary_btn);
        mobileActions.swipe("verticle",1500,0,2000);
        mobileActions.clickAndHold(elem);
        uiActions.click(diary_mfp.delete_btn);
    }

    @Step("Delete a Food Item from Diary")
    public static void deleteFood(AndroidElement elem)
    {
        uiActions.click(mobileMain_mfp.diary_btn);
        mobileActions.clickAndHold(elem);
        uiActions.click(diary_mfp.delete_btn);
    }

    @Step("Add Note to Diary")
    public static void addNote(String type, String content)
    {
        uiActions.click(mobileMain_mfp.diary_btn);
        mobileActions.swipe("verticle",2000,0,2000);
        uiActions.click(diary_mfp.notes_btn);
        if(type.equalsIgnoreCase("food"))
        {
            uiActions.click(diary_mfp.foodNotes_btn);
        }
        else if(type.equalsIgnoreCase("exercise"))
        {
            uiActions.click(diary_mfp.exerciseNotes_btn);
        }
        uiActions.updateText(diary_mfp.noteContent_txt, content);
        uiActions.click(diary_mfp.saveNote_btn);
    }
}
