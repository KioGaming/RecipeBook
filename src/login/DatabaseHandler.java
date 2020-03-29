package login;

import saveload.Playlist;
import settings.Settings;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static settings.Settings.DISH_PHOTO;

public class DatabaseHandler extends Configs {

    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString  = "jdbc:mysql://" + dbHost + ":" +
                                   dbPort + "/" + dbName+ "?useUnicode=true&serverTimezone=UTC";

        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);

        return dbConnection;
    }

    public void signUpUser(String username, String mail, String password, String location){
        String insert = "INSERT INTO " + Settings.USER_TABLE + "(" + Settings.USER_USERNAME + ","
                + Settings.USER_MAIL + "," + Settings.USER_PASSWORD + "," + Settings.USER_LOCATION + ")" + "VALUES(?,?,?,?)";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, username);
            prSt.setString(2, mail);
            prSt.setString(3, password);
            prSt.setString(4, location);
            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ResultSet signInUser(String mail, String password){
        ResultSet resSet = null;

        String select = "SELECT * FROM " + Settings.USER_TABLE + " WHERE " + Settings.USER_MAIL + "=? AND "
                        + Settings.USER_PASSWORD + "=?";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1, mail);
            prSt.setString(2, password);
            resSet = prSt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resSet;
    }

    public boolean verifyMailDB(String mail){
        boolean b = true;
        ResultSet resultSet = null;
        String select = "SELECT * FROM " + Settings.USER_TABLE + " WHERE " + Settings.USER_MAIL + "=?";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1, mail);
            resultSet = prSt.executeQuery();
            System.out.println(resultSet);
            if(resultSet.next()){
                b = false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return b;
    }

    public boolean verifyUsernameDB(String username){
        boolean b = true;
        ResultSet resultSet = null;
        String select = "SELECT * FROM " + Settings.USER_TABLE + " WHERE " + Settings.USER_USERNAME + "=?";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1, username);
            resultSet = prSt.executeQuery();
            System.out.println(resultSet);
            if(resultSet.next()){
                b = false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return b;
    }

    public ResultSet getRecipe(){
        ResultSet resSet = null;

        String select = "SELECT * FROM " + Settings.DISH_TABLE;

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            resSet = prSt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resSet;
    }

    public ResultSet getLikedDishes(int iduser) {
        ResultSet resSet = null;

        String select = "SELECT d." + Settings.DISH_ID + ", " + Settings.DISH_TITLE + ", " + Settings.DISH_PHOTO + ", " + Settings.DISH_DESCRIPTION
                + ", " + Settings.DISH_RECIPE + ", " + Settings.DISH_GROCERYLIST + ", " + Settings.DISH_COUNTLIST + ", " + Settings.DISH_UNITSOFMEASUREMENTLIST
                + ", " + Settings.DISH_NUMBER_OF_LIKES + ", " + Settings.DISH_CATEGORY + " FROM "
                + Settings.DISH_TABLE + " d JOIN " + Settings.LIKED_DISHES_TABLE + " ld ON d." + Settings.DISH_ID + " = ld." + Settings.LIKED_DISHES_DISH_ID
                + " WHERE " + Settings.LIKED_DISHES_USER_ID + " = ?";
        System.out.println(select);
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setInt(1, iduser);
            resSet = prSt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resSet;
    }

    public void setRecipe(String title, String photo, String description, ArrayList<String> recipe, ArrayList<String> groceryList,
                          ArrayList<String> countList, ArrayList<String> unitsOfMeasurementList, int numberOfLikes) {
        String insert = "INSERT INTO " + Settings.DISH_TABLE + "(" + Settings.DISH_TITLE + "," + DISH_PHOTO + ","
                + Settings.DISH_DESCRIPTION + "," + Settings.DISH_RECIPE + "," + Settings.DISH_GROCERYLIST + ","
                + Settings.DISH_COUNTLIST + "," + Settings.DISH_UNITSOFMEASUREMENTLIST + "," + Settings.DISH_NUMBER_OF_LIKES
                + ")" + "VALUES(?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, title);
            prSt.setString(2, photo);
            prSt.setString(3, description);
            prSt.setString(4, listToStr(recipe));
            prSt.setString(5, listToStr(groceryList));
            prSt.setString(6, listToStr(countList));
            prSt.setString(7, listToStr(unitsOfMeasurementList));
            prSt.setLong(8, numberOfLikes);
            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    private String listToStr(ArrayList list){
        String str = "";
        str += list.get(0);
        for (int i = 1; i < list.size(); i++) {
            str += "/" + list.get(i);
        }
        return str;
    }

    public int maxIdUser() {
        int last_id = 0;
        ResultSet resultSet;
        String select = "select last_insert_id() as last_id from " + Settings.USER_TABLE;
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            resultSet = prSt.executeQuery();
            last_id = Integer.parseInt(resultSet.getString("last_id"));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return last_id;
    }

    public void addLikedDishes(int iduser, int iddish) {
        String insert = "INSERT INTO " + Settings.LIKED_DISHES_TABLE + "(" + Settings.LIKED_DISHES_USER_ID + "," + Settings.LIKED_DISHES_DISH_ID + ")"
                + "VALUES(?,?)";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setInt(1, iduser);
            prSt.setInt(2, iddish);
            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void removeLikedDishes(int idUser, int iddish) {
        String delete = "DELETE FROM " + Settings.LIKED_DISHES_TABLE + " WHERE " + Settings.USER_ID + " = ? AND "
                + Settings.LIKED_DISHES_DISH_ID + " = ?";
        try {
            PreparedStatement statement = getDbConnection().prepareStatement(delete);
            statement.setInt(1, idUser);
            statement.setInt(1, iddish);
            statement.executeUpdate(delete);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void changeMail(String oldMail, String newMail) {
        String update = "UPDATE " + Settings.USER_TABLE + " SET " + Settings.USER_MAIL + " = ? WHERE " + Settings.USER_MAIL + " = ?";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(update);
            prSt.setString(1, newMail);
            prSt.setString(2, oldMail);
            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void changePassword(String mail, String oldPassword, String newPassword) {
        String update = "UPDATE " + Settings.USER_TABLE + " SET " + Settings.USER_PASSWORD
                + " = ? WHERE " + Settings.USER_PASSWORD + " = ?" + " AND " + Settings.USER_MAIL + " = ?";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(update);
            prSt.setString(1, newPassword);
            prSt.setString(2, oldPassword);
            prSt.setString(3, mail);
            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ResultSet getPlaylists(int iduser) {
        List<Playlist> list = new ArrayList<>();
        ResultSet resultSet = null;
        String select = "SELECT " + Settings.DISH_ID + ", " + Settings.DISH_TITLE + ", " + Settings.DISH_PHOTO + ", " + Settings.DISH_DESCRIPTION + ", "
                + Settings.DISH_RECIPE + ", " + Settings.DISH_GROCERYLIST + ", " + Settings.DISH_COUNTLIST + ", " + Settings.DISH_UNITSOFMEASUREMENTLIST
                + ", " + Settings.DISH_NUMBER_OF_LIKES + ", " + Settings.DISH_CATEGORY + ", " + Settings.PLAYLISTS_NAME + " FROM "
                + Settings.USER_PLAYLISTS_TABLE + " up JOIN " + Settings.PLAYLISTS_DISH_TABLE + " pd ON up." + Settings.USER_PLAYLISTS_IDPLAYLIST
                + " = pd." + Settings.PLAYLISTS_DISH_ID + " JOIN " + Settings.DISH_TABLE + " d ON pd." + Settings.PLAYLISTS_DISH_ID + " = "
                + " d." + Settings.DISH_ID + " JOIN " + Settings.PLAYLISTS_TABLE + " p ON up." + Settings.USER_PLAYLISTS_IDPLAYLIST
                + " = p." + Settings.PLAYLISTS_ID + " where " + Settings.USER_PLAYLISTS_IDUSER + " = ?";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setInt(1, iduser);
            resultSet = prSt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
}
