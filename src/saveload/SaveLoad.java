package saveload;

import exception.ModelException;
import login.DatabaseHandler;
import model.Dish;
import model.ShoppingList;
import settings.Settings;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

public class SaveLoad {

    public static void load(SaveData sd, int iduser) {
        ArrayList<Dish> dishes = new ArrayList<>();
        DatabaseHandler databaseHandler = new DatabaseHandler();
        ResultSet resultSet = databaseHandler.getRecipe();
        try {
            while (resultSet.next()) {
                String title = resultSet.getString(Settings.DISH_TITLE);

                String photo = resultSet.getString(Settings.DISH_PHOTO);

                String description = resultSet.getString(Settings.DISH_DESCRIPTION);

                String category = resultSet.getString(Settings.DISH_CATEGORY);

                ArrayList<String> recipe = new ArrayList<>();
                Collections.addAll(recipe, resultSet.getString(Settings.DISH_RECIPE).split("/"));

                ArrayList<String> groceryList = new ArrayList<>();
                Collections.addAll(groceryList, resultSet.getString(Settings.DISH_GROCERYLIST).split("/"));

                ArrayList<String> countList = new ArrayList<>();
                Collections.addAll(countList, resultSet.getString(Settings.DISH_COUNTLIST).split("/"));

                ArrayList<String> unitsOfMeasurementList = new ArrayList<>();
                Collections.addAll(unitsOfMeasurementList, resultSet.getString(Settings.DISH_UNITSOFMEASUREMENTLIST).split("/"));

                int numberOfLikes = Integer.parseInt(resultSet.getString(Settings.DISH_NUMBER_OF_LIKES));

                Dish dish = new Dish(title, photo, description, category, recipe, groceryList, countList, unitsOfMeasurementList, numberOfLikes);
                dishes.add(dish);
            }
            sd.setDishes(dishes);
        } catch (SQLException e) { e.printStackTrace(); } catch (ModelException e) {
            e.printStackTrace();
        }
        ArrayList<String> likedDishes = new ArrayList<>();
        ResultSet resSet = databaseHandler.getLikedDishes(iduser);
        try {
            while (resSet.next()) {
                String title = resSet.getString(Settings.LIKED_DISHES_DISHTITLE);
                likedDishes.add(title);
            }
            sd.setLikedDishes(likedDishes);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        sd.setShoppingList(new ShoppingList());
    }

    public static void saveLikedDishes(SaveData sd, int iduser, String title) {
        DatabaseHandler databaseHandler = new DatabaseHandler();
        databaseHandler.setLikedDishes(iduser, title);
    }

    public static boolean saveRecipe(Dish recipe){
        boolean b = true;
        DatabaseHandler databaseHandler = new DatabaseHandler();
        databaseHandler.setRecipe(recipe.getTitle(), recipe.getPhoto(), recipe.getDescription(), recipe.getRecipe(), recipe.getGroceryList(),
                                  recipe.getCountList(), recipe.getUnitsOfMeasurementList(), recipe.getNumberOfLikes());
        return b;
    }

    public  static ArrayList<Double> strListToDoubleList(String[] stringArrayList){
        ArrayList<Double> doubleArrayList = new ArrayList<Double>();
        for (int i = 0; i < stringArrayList.length; i++) {
            doubleArrayList.add(Double.parseDouble(stringArrayList[i]));
        }
        return doubleArrayList;
    }

    public static void removeLikedDishes(SaveData saveData, int idUser, String title) {
        DatabaseHandler databaseHandler = new DatabaseHandler();
        databaseHandler.removeLikedDishes(idUser, title);
    }
}
