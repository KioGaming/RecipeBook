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
import java.util.List;

public class SaveLoad {

    public static void load(SaveData sd, int iduser) {
        ArrayList<Dish> dishes = new ArrayList<>();
        DatabaseHandler databaseHandler = new DatabaseHandler();
        ResultSet resultSet = databaseHandler.getRecipe();
        try {
            while (resultSet.next()) {
                int id = resultSet.getInt(Settings.DISH_ID);

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

                Dish dish = new Dish(id, title, photo, description, category, recipe, groceryList, countList, unitsOfMeasurementList, numberOfLikes);
                dishes.add(dish);
            }
            sd.setDishes(dishes);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ModelException e) {
            e.printStackTrace();
        }
        ArrayList<Dish> like = new ArrayList<>();
        resultSet = databaseHandler.getLikedDishes(iduser);
        try {
            while (resultSet.next()) {
                int id = resultSet.getInt(Settings.DISH_ID);

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

                Dish dish = new Dish(id, title, photo, description, category, recipe, groceryList, countList, unitsOfMeasurementList, numberOfLikes);
                like.add(dish);
            }
            sd.setLike(like);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ModelException e) {
            e.printStackTrace();
        }
        ArrayList<Playlist> playlists = new ArrayList<>();
        resultSet = databaseHandler.getPlaylists(iduser);
        try {
            while (resultSet.next()) {
                int id = resultSet.getInt(Settings.DISH_ID);

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

                String name = resultSet.getString(Settings.PLAYLISTS_NAME);

                Dish dish = new Dish(id, title, photo, description, category, recipe, groceryList, countList, unitsOfMeasurementList, numberOfLikes);

                boolean b = false;
                for (int i = 0; i < playlists.size(); i++) {
                    if (playlists.get(i).getTitle() == name) {
                        b = true;
                        playlists.get(i).getDishes().add(dish);
                    }
                }
                if (b == false) {
                    List<Dish> list = new ArrayList<>();
                    list.add(dish);
                    playlists.add(new Playlist(name, list));
                }
                b = false;
            }
            sd.setPlaylists(playlists);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ModelException e) {
            e.printStackTrace();
        }
        sd.setShoppingList(new ShoppingList());
    }

    public static void saveLikedDishes(int iduser, int iddish) {
        DatabaseHandler databaseHandler = new DatabaseHandler();
        databaseHandler.addLikedDishes(iduser, iddish);
    }

    public static boolean saveRecipe(Dish recipe) {
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

    public static void removeLikedDishes(int idUser, int iddish) {
        DatabaseHandler databaseHandler = new DatabaseHandler();
        databaseHandler.removeLikedDishes(idUser, iddish);
    }
}
