package WorkFlows;

import Extensions.dbActions;
import Extensions.uiActions;
import Utilities.commonOps;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class webFlows extends commonOps
{
    @Step("Search for a Food by Text")
    public static void searchFood(String food)
    {
        uiActions.click(topMenu_mfp.food_btn);
        uiActions.updateText(food_mfp.searchFood_txt, food);
        uiActions.click(food_mfp.search_btn);
    }

    @Step("Search for an Exercise by Text")
    public static String searchExercise(String exercise, String unit, String weight, String minutes)
    {
        uiActions.click(topMenu_mfp.exercise_btn);
        Select dropDownExercise = new Select(exercise_mfp.selectExercise_dropDown);
        List<WebElement> exerciseOptions = dropDownExercise.getOptions();
        for(WebElement workout : exerciseOptions)
        {
            if(workout.getText().equalsIgnoreCase(exercise))
            {
                dropDownExercise.selectByVisibleText(workout.getText());
            }
        }
        if((exerciseOptions.get(0).isSelected()) && (!(exercise.equalsIgnoreCase("9round"))))
        {
            uiActions.updateText(exercise_mfp.searchExercise_txt,exercise);
            uiActions.click(exercise_mfp.searchExercise_btn);
            uiActions.click(exercise_mfp.resultExercise_list.get(0));
        }
        uiActions.updateDropDown(exercise_mfp.selectUnit_dropDown,unit);
        uiActions.updateText(exercise_mfp.weight_txt, weight);
        uiActions.updateText(exercise_mfp.minutes_txt, minutes);
        return exercise_mfp.result_lbl.getText();
    }

    @Step("Search for an Exercise in List")
    public static List<WebElement> searchExerciseInDatabase(String letter)
    {
        uiActions.click(topMenu_mfp.exercise_btn);
        for(WebElement l : exercise_mfp.browseDatabase_list)
        {
            if(letter.equalsIgnoreCase(l.getText()))
            {
                uiActions.click(l);
                break;
            }
        }
        List<WebElement> exerciseList = exercise_mfp.browseResult_list;
        return exerciseList;
    }

    @Step("Search for an Account with Credentials from XML")
    public static void login(String user, String password)
    {
        uiActions.click(topMenu_mfp.login_btn);
        uiActions.updateText(login_mfp.userName_txt, user);
        uiActions.updateText(login_mfp.password_txt, password);
        uiActions.click(login_mfp.remember_check);
        uiActions.click(login_mfp.submit_btn);
        uiActions.click(userHome_mfp.closePopup_btn);
    }

    @Step("Search for an Account with Credentials from DB")
    public static void loginDB()
    {
        List<String> cred = dbActions.getCredentials("SELECT userName, password FROM Credentials WHERE id = 3");
        uiActions.click(topMenu_mfp.login_btn);
        uiActions.updateText(login_mfp.userName_txt, cred.get(0));
        uiActions.updateText(login_mfp.password_txt, cred.get(1));
        uiActions.click(login_mfp.remember_check);
        uiActions.click(login_mfp.submit_btn);
        uiActions.click(driver.findElement(By.xpath("//html")));
    }

    public static void editGoal(String goal)
    {
        driver.get("https://www.myfitnesspal.com/account/my_goals");
        if(goal.equalsIgnoreCase("nutrition"))
        {
            uiActions.click(nutritionGoals_mfp.editGoals_btn);
        }
        else if(goal.equalsIgnoreCase("fitness"))
        {

        }
        else
        {
            System.out.println("Please Select One of the Following: Nutrition / Fitness / Micro nutrients\nAnd Try Again :)");
        }
    }

    public static int[] calculateMacrosDefaultRatio(int calories)
    {
        uiActions.updateText(nutritionGoals_mfp.calories_txt, String.valueOf(calories));
        int[] macros = new int[3];

        int carbs, fat, protein;
        carbs = (int) Math.round(calories*0.5/4);
        fat = (int) Math.round(calories*0.3/9);
        protein = (int) Math.round(calories*0.2/4);

        macros[0] = carbs;
        macros[1] = fat;
        macros[2] = protein;

        return macros;
    }

    public static void changeMacrosRatio(String carbs, String fat, String protein)
    {
        Select carbsRatio = new Select(nutritionGoals_mfp.carbsPercent_dropDown);
        List<WebElement> carbsOptions = carbsRatio.getOptions();

        Select fatRatio = new Select(nutritionGoals_mfp.fatPercent_dropDown);
        List<WebElement> fatOptions = fatRatio.getOptions();

        Select proteinRatio = new Select(nutritionGoals_mfp.proteinPercent_dropDown);
        List<WebElement> proteinOptions = proteinRatio.getOptions();

        for (WebElement item : carbsOptions)
        {
            if(item.getText().equalsIgnoreCase(carbs + "%"))
            {
                carbsRatio.selectByVisibleText(item.getText());
            }
        }

        for (WebElement item : fatOptions)
        {
            if(item.getText().equalsIgnoreCase(fat + "%"))
            {
                fatRatio.selectByVisibleText(item.getText());
            }
        }

        for (WebElement item : proteinOptions)
        {
            if(item.getText().equalsIgnoreCase(protein + "%"))
            {
                proteinRatio.selectByVisibleText(item.getText());
            }
        }
    }
}
