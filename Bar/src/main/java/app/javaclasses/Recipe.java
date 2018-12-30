package app.javaclasses;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class Recipe {
    private List<Ingredient> ingredients = new ArrayList<Ingredient>();
    private int alcoholPercent;
    private int recipeVolume;
    private String recipeName;
    private static String[] drinksNames = {"cola","vodka","whisky","beer","gin","tonic"};
    private static double[] alcoholPercentage = {0, 40, 43, 5, 37.5, 0};
    private static int[] drinkIds = {1, 2, 3, 4, 5, 6};


    public Recipe(HttpServletRequest req) {

        recipeName = req.getParameter("recipeName");
        
        for (int i = 0; i < drinksNames.length; i++) {
            Integer volume = Integer.parseInt(req.getParameter(drinksNames[i]));
            ingredients.add(new Ingredient(drinksNames[i],volume,drinkIds[i]));

            alcoholPercent +=  volume*alcoholPercentage[i];
            recipeVolume += volume;
        }
        alcoholPercent = alcoholPercent/recipeVolume;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public int getRecipeVolume() { return recipeVolume; }

    public int getAlcoholPercent() {
        return alcoholPercent;
    }

    @Override
    public String toString() {
        return ingredients + String.valueOf(alcoholPercent) + "%";
    }
}
