package saveload;

import login.DatabaseHandler;
import model.Dish;
import model.Playlist;
import model.Shopping;
import settings.Settings;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SaveLoad {

    public SaveLoad() {
    }

    public static void load(SaveData sd, int idUser) {
        List<Dish> dishes = new ArrayList<>();
        DatabaseHandler databaseHandler = new DatabaseHandler();
        ResultSet resultSet = databaseHandler.getRecipe();
        try {
            while (resultSet.next()) {
                int id = resultSet.getInt(Settings.DISH_ID);

                String title = resultSet.getString(Settings.DISH_TITLE);

                String photo = resultSet.getString(Settings.DISH_PHOTO);

                String description = resultSet.getString(Settings.DISH_DESCRIPTION);

                String category = resultSet.getString(Settings.DISH_CATEGORY);

                List<String> recipe = new ArrayList<>();
                Collections.addAll(recipe, resultSet.getString(Settings.DISH_RECIPE).split("/"));

                List<String> grocery = new ArrayList<>();
                Collections.addAll(grocery, resultSet.getString(Settings.DISH_GROCERYLIST).split("/"));

                List<String> weight = new ArrayList<>();
                Collections.addAll(weight, resultSet.getString(Settings.DISH_WEIGTHLIST).split("/"));

                int numberOfLikes = Integer.parseInt(resultSet.getString(Settings.DISH_NUMBER_OF_LIKES));

                List<Shopping> groceryList = new ArrayList<>();
                for (int i = 0; i < grocery.size(); i++) {
                    groceryList.add(new Shopping(grocery.get(i), weight.get(i)));
                }

                Dish dish = new Dish(id, title, photo, description, category, recipe, groceryList, numberOfLikes);
                dishes.add(dish);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        sd.setDishes(dishes);

        List<Dish> like = new ArrayList<>();
        resultSet = databaseHandler.getLikedDishes(idUser);
        try {
            while (resultSet.next()) {
                int id = resultSet.getInt(Settings.DISH_ID);

                String title = resultSet.getString(Settings.DISH_TITLE);

                String photo = resultSet.getString(Settings.DISH_PHOTO);

                String description = resultSet.getString(Settings.DISH_DESCRIPTION);

                String category = resultSet.getString(Settings.DISH_CATEGORY);

                ArrayList<String> recipe = new ArrayList<>();
                Collections.addAll(recipe, resultSet.getString(Settings.DISH_RECIPE).split("/"));

                List<String> grocery = new ArrayList<>();
                Collections.addAll(grocery, resultSet.getString(Settings.DISH_GROCERYLIST).split("/"));

                List<String> weight = new ArrayList<>();
                Collections.addAll(weight, resultSet.getString(Settings.DISH_WEIGTHLIST).split("/"));

                int numberOfLikes = Integer.parseInt(resultSet.getString(Settings.DISH_NUMBER_OF_LIKES));

                List<Shopping> groceryList = new ArrayList<>();
                for (int i = 0; i < grocery.size(); i++) {
                    groceryList.add(new Shopping(grocery.get(i), weight.get(i)));
                }

                Dish dish = new Dish(id, title, photo, description, category, recipe, groceryList, numberOfLikes);
                like.add(dish);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        sd.setLike(like);

        List<Playlist> playlists = new ArrayList<>();
        resultSet = databaseHandler.getPlaylists(idUser);
        try {
            while (resultSet.next()) {
                int idPlaylist = resultSet.getInt(Settings.PLAYLISTS_ID);

                String name = resultSet.getString(Settings.PLAYLISTS_NAME);

                int idDish = resultSet.getInt(Settings.DISH_ID);

                String title = resultSet.getString(Settings.DISH_TITLE);

                String photo = resultSet.getString(Settings.DISH_PHOTO);

                String description = resultSet.getString(Settings.DISH_DESCRIPTION);

                String category = resultSet.getString(Settings.DISH_CATEGORY);

                ArrayList<String> recipe = new ArrayList<>();
                Collections.addAll(recipe, resultSet.getString(Settings.DISH_RECIPE).split("/"));

                List<String> grocery = new ArrayList<>();
                Collections.addAll(grocery, resultSet.getString(Settings.DISH_GROCERYLIST).split("/"));

                List<String> weight = new ArrayList<>();
                Collections.addAll(weight, resultSet.getString(Settings.DISH_WEIGTHLIST).split("/"));

                int numberOfLikes = Integer.parseInt(resultSet.getString(Settings.DISH_NUMBER_OF_LIKES));

                List<Shopping> groceryList = new ArrayList<>();
                for (int i = 0; i < grocery.size(); i++) {
                    groceryList.add(new Shopping(grocery.get(i), weight.get(i)));
                }

                Dish dish = new Dish(idDish, title, photo, description, category, recipe, groceryList, numberOfLikes);

                boolean isAddedPlaylist = false;
                for (int i = 0; i < playlists.size(); i++) {
                    if (playlists.get(i).getTitle().equals(name)) {
                        isAddedPlaylist = true;
                        playlists.get(i).getDishes().add(dish);
                        break;
                    }
                }
                if (isAddedPlaylist == false) {
                    List<Dish> list = new ArrayList<>();
                    list.add(dish);
                    playlists.add(new Playlist(idPlaylist, name, list));
                }
                isAddedPlaylist = false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        sd.setPlaylists(playlists);

        boolean isAddedPlaylist = true;
        resultSet = databaseHandler.getEmptyPlaylists(idUser);
        while (true) {
            try {
                if (!resultSet.next()) break;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < sd.getPlaylists().size(); i++) {
                try {
                    if (sd.getPlaylists().get(i).getTitle().equals(resultSet.getString(Settings.PLAYLISTS_NAME))) {
                        isAddedPlaylist = false;
                        break;
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (isAddedPlaylist) {
                try {
                    sd.getPlaylists().add(new Playlist(resultSet.getInt(Settings.PLAYLISTS_ID), resultSet.getString(Settings.PLAYLISTS_NAME), new ArrayList<>()));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            isAddedPlaylist = true;
        }
    }

    public static void saveLikedDishes(int iduser, int iddish) {
        DatabaseHandler databaseHandler = new DatabaseHandler();
        databaseHandler.addLikedDishes(iduser, iddish);
    }

    public static void removeLikedDishes(int idUser, int iddish) {
        DatabaseHandler databaseHandler = new DatabaseHandler();
        databaseHandler.removeLikedDishes(idUser, iddish);
    }

    public static int addPlaylist(int idUser, String title) {
        DatabaseHandler databaseHandler = new DatabaseHandler();
        return databaseHandler.addPlaylists(idUser, title);
    }

    public static void removePlaylist(int idPlaylist) {
        DatabaseHandler databaseHandler = new DatabaseHandler();
        databaseHandler.removePlaylists(idPlaylist);
    }

    public static void addDishInPlaylist(int idPlaylist, int idDish) {
        DatabaseHandler databaseHandler = new DatabaseHandler();
        databaseHandler.addDishInPlaylist(idPlaylist, idDish);
    }

    public static void removeDishInPlaylist(int idPlaylist, int idDish) {
        DatabaseHandler databaseHandler = new DatabaseHandler();
        databaseHandler.removeDishInPlaylist(idPlaylist, idDish);
    }

    public static boolean saveRecipe(Dish recipe) {
        /*boolean b = true;
        DatabaseHandler databaseHandler = new DatabaseHandler();
        databaseHandler.setRecipe(recipe.getTitle(), recipe.getPhoto(), recipe.getDescription(), recipe.getRecipe(),
                recipe.getGroceryList(), recipe.getNumberOfLikes());
        return b;*/
        return false;
    }
}
