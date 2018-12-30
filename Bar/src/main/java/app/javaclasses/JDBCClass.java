package app.javaclasses;

import javax.servlet.http.HttpServletRequest;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class JDBCClass {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "12345";
    private static final String URL = "jdbc:mysql://localhost:3306/nightstalker?autoReconnect=true&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";


    public static ArrayList<String> getCocktailsList(HttpServletRequest req) {

        ArrayList<String> cocktailsList = new ArrayList<>();

        try ( Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
              Statement statement = connection.createStatement()){

           ResultSet resultSet = statement.executeQuery("SELECT name FROM recip;");

            while (resultSet.next()){
               cocktailsList.add(resultSet.getString("name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cocktailsList;
    }



    public static boolean putReq(HttpServletRequest req){
        /*try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            //driver = new com.mysql.cj.jdbc.Driver();
          // DriverManager.registerDriver(driver);
          // connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        } catch (ClassNotFoundException  e) {
            System.out.println("ClassNotFoundException");
            e.printStackTrace();
            return;
            //e.printStackTrace();
        }*/
        try ( Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
              Statement statement = connection.createStatement();
              PreparedStatement putRecipe = connection.prepareStatement("insert into recip(name,alcoholPercent) values(?, ?)");
              PreparedStatement putIngredient = connection.prepareStatement("insert into `values`(`volume (ml)`, drinkId, recipeId) values(?, ?, ?)")){

            Recipe recipe = new Recipe(req);

            putRecipe.setString(1,recipe.getRecipeName());
            putRecipe.setInt(2,recipe.getAlcoholPercent());
            putRecipe.execute();

            int lastRecipeId = 0;
            ResultSet resultSet = statement.executeQuery("SELECT * FROM recip ORDER BY recipeId DESC LIMIT 1");
            if (resultSet.next()){
               lastRecipeId = resultSet.getInt("recipeId");
            }

            Iterator<Ingredient> ingredientIterator = recipe.getIngredients().iterator();
            Ingredient ingredient = null;
            while (ingredientIterator.hasNext()){
                ingredient = ingredientIterator.next();
                if (ingredient.getVolume() != 0) {
                    putIngredient.setInt(1, ingredient.getVolume());
                    putIngredient.setInt(2, ingredient.getDrinkId());
                    putIngredient.setInt(3, lastRecipeId);
                    putIngredient.execute();
                }

            }

            //statement.addBatch("a");
            //statement.executeBatch();
            //statement.clearBatch();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

}

