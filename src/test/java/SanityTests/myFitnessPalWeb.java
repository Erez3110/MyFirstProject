package SanityTests;

import Extensions.uiActions;
import Extensions.verifications;
import Utilities.commonOps;
import Utilities.helperMethods;
import WorkFlows.webFlows;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static Utilities.helperMethods.trimGrams;
import static org.testng.Assert.*;

@Listeners(Utilities.listeners.class)
public class myFitnessPalWeb extends commonOps
{
    @Test(description = "Test 01: Home Page Main Header")
    @Description("Verify Text of the Main Header")
    public void test01_verifyMainHeader()
    {
        String expected = "Fitness starts with what you eat.";
        verifications.textInElement(homePage_mfp.mainHeader_lbl,expected);
    }

    @Test(description = "Test 02: Search for a Food Item")
    @Description("Search for a Food Item Using the Search Option")
    public void test02_searchFood()
    {
        webFlows.searchFood("yogurt");
        assertTrue(food_mfp.searchResults_list.size()>0);
    }

    @Test(description = "Test 03: Verify Information of a Food Item")
    @Description("Check Nutritional Value of a Single Food Item")
    public void test03_verifyNutritionalValue()
    {
        webFlows.searchFood("pasta");
        uiActions.click(food_mfp.searchResults_list.get(0));
        assertEquals(trimGrams(foodNutritionData_mfp.calories_lbl.getText()),"130");
        assertEquals(trimGrams(foodNutritionData_mfp.carbs_lbl.getText()),"7");
        assertEquals(trimGrams(foodNutritionData_mfp.fat_lbl.getText()),"2");
        assertEquals(trimGrams(foodNutritionData_mfp.protein_lbl.getText()),"20");
    }

    @Test(description = "Test 04: Search for an Exercise Using Free Text")
    @Description("Free Text - Search for an Exercise and Verify Burnt Calories")
    public void test04_searchExerciseByText()
    {
        String caloriesBurnt = webFlows.searchExercise("kickbox","Kilograms","70","90");
        assertEquals(caloriesBurnt,"1061");
    }

    @Test(description = "Test 05: Search for an Exercise Using Dropdown")
    @Description("Dropdown - Search for an Exercise and Verify Burnt Calories")
    public void test05_searchExerciseFromDropDown()
    {
        String caloriesBurnt = webFlows.searchExercise("yoga","Kilograms","70","90");
        assertEquals(caloriesBurnt,"263");
    }

    @Test(description = "Test 06: Number of Exercises Per Letter")
    @Description("Verify the Number of Exercises Per Letter")
    public void test06_verifyNumberOfExercises()
    {
        verifications.numberOfElements(webFlows.searchExerciseInDatabase("D"), 8);
    }

    @Test(description = "Test 07: App Logo Visual Test")
    @Description("Verify the Logo of a Specific App")
    public void test07_verifyAppLogo()
    {
        verifications.visualElement(helperMethods.getAppLogo("Fitbit Tracker"),"Fitbit_Tracker_Logo");
    }

    @Test(description = "Test 08: Login to an Account")
    @Description("Perform Login to a Member Account")
    public void test08_loginToAccount()
    {
        webFlows.login(getData("user"),getData("password"));
        verifications.textInElement(userHome_mfp.summaryHeader_txt, "Your Daily Summary");
    }

    //------For Tests 9 And Higher, User Needs To Be Logged In------

    @Test(description = "Test 09: Edit Nutrition Goals")
    @Description("Edit the total Amount of Calories and Verify Macro Nutrients")
    public void test09_editCaloriesGoal()
    {
        webFlows.login(getData("user"),getData("password"));
        webFlows.editGoal("nutrition");
        int[] expectedMacros = webFlows.calculateMacrosDefaultRatio(3000);
        assertEquals(trimGrams(nutritionGoals_mfp.carbsGrams_lbl.getText()), String.valueOf(expectedMacros[0]));
        assertEquals(trimGrams(nutritionGoals_mfp.fatGrams_lbl.getText()), String.valueOf(expectedMacros[1]));
        assertEquals(trimGrams(nutritionGoals_mfp.proteinGrams_lbl.getText()), String.valueOf(expectedMacros[2]));
    }

    @Test(description = "Test 09: Edit Macro Nutrients Ratio - Verify Button")
    @Description("Edit the Percentage of Macro Nutrients and Verify Save Changes Button")
    public void test10_editMacrosRatio()
    {
        webFlows.login(getData("user"),getData("password"));
        webFlows.editGoal("nutrition");
        webFlows.changeMacrosRatio("40","40","20"); //if total = 100, active = true | else active = false
        verifications.elementActivated(nutritionGoals_mfp.save_btn,true);
    }
}
