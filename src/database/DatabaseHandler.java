package database;

import settings.Settings;

import java.security.SecureRandom;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends Configs {

    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":" +
                dbPort + "/" + dbName + "?useUnicode=true&serverTimezone=UTC";
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
        return dbConnection;
    }

    public ResultSet signInUser(String mail) {
        ResultSet resSet = null;
        String select = "SELECT * FROM " + Settings.USER_TABLE + " WHERE " + Settings.USER_MAIL + "=?";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1, mail);
            resSet = prSt.executeQuery();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resSet;
    }

    public void signUpUser(String username, String mail, String password, String salt, String location) {
        String insert = "INSERT INTO " + Settings.USER_TABLE + "(" + Settings.USER_USERNAME + "," + Settings.USER_MAIL + ","
                + Settings.USER_PASSWORD + "," + Settings.USER_PASSWORD_SALT + "," + Settings.USER_LOCATION + "," + Settings.USER_ROLE + ")"
                + "VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, username);
            prSt.setString(2, mail);
            prSt.setString(3, password);
            prSt.setString(4, salt);
            prSt.setString(5, location);
            prSt.setInt(6, 2);
            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public boolean verifyMailDB(String mail){
        boolean b = true;
        ResultSet resultSet;
        String select = "SELECT * FROM " + Settings.USER_TABLE + " WHERE " + Settings.USER_MAIL + "=?";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1, mail);
            resultSet = prSt.executeQuery();
            if (resultSet.next()) {
                b = false;
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return b;
    }

    public boolean verifyUsernameDB(String username){
        boolean b = true;
        ResultSet resultSet;
        String select = "SELECT * FROM " + Settings.USER_TABLE + " WHERE " + Settings.USER_USERNAME + "=?";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1, username);
            resultSet = prSt.executeQuery();
            if (resultSet.next()) {
                b = false;
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return b;
    }

    public int maxIdUser() {
        int last_id = 0;
        ResultSet resultSet;
        String select = "SELECT " + Settings.USER_ID + " as last_id FROM " + Settings.USER_TABLE + " ORDER BY " + Settings.USER_ID + " DESC LIMIT 1";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            resultSet = prSt.executeQuery();
            resultSet.next();
            last_id = Integer.parseInt(resultSet.getString("last_id"));
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return last_id;
    }

    public void changePassword(String mail, String newPassword) {
        byte[] salt = new byte[16];
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextBytes(salt);
        String generatedSecuredPasswordHash = lambdaworks.crypto.SCryptUtil.scrypt(newPassword + salt.toString(), 16, 16, 16);
        String update = "UPDATE " + Settings.USER_TABLE + " SET " + Settings.USER_PASSWORD
                + " = ? WHERE " + Settings.USER_MAIL + " = ?";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(update);
            prSt.setString(1, generatedSecuredPasswordHash);
            prSt.setString(2, mail);
            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        update = "UPDATE " + Settings.USER_TABLE + " SET " + Settings.USER_PASSWORD_SALT
                + " = ? WHERE " + Settings.USER_MAIL + " = ?";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(update);
            prSt.setString(1, salt.toString());
            prSt.setString(2, mail);
            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ResultSet getRecipe() {
        ResultSet resSet = null;
        String select = "SELECT * FROM " + Settings.DISH_TABLE;
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            resSet = prSt.executeQuery();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resSet;
    }

    public void setRecipe(String title, String category, String photo, String description, ArrayList<String> recipe, ArrayList<String> groceryList,
                          ArrayList<String> countList, ArrayList<String> unitsOfMeasurementList, int numberOfLikes) {
        String insert = "INSERT INTO " + Settings.DISH_TABLE + "(" + Settings.DISH_TITLE + "," + Settings.DISH_CATEGORY + "," + Settings.DISH_PHOTO + ","
                + Settings.DISH_DESCRIPTION + "," + Settings.DISH_RECIPE + "," + Settings.DISH_GROCERYLIST + ","
                + Settings.DISH_WEIGTHLIST + "," + Settings.DISH_NUMBER_OF_LIKES + ")" + "VALUES(?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, title);
            prSt.setString(2, category);
            prSt.setString(3, photo);
            prSt.setString(4, description);
            prSt.setString(5, listToStr(recipe));
            prSt.setString(6, listToStr(groceryList));
            prSt.setString(7, listToStr(countList));
            prSt.setString(8, listToStr(unitsOfMeasurementList));
            prSt.setLong(9, numberOfLikes);
            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ResultSet getLikedDishes(int iduser) {
        ResultSet resSet = null;
        String select = "SELECT d." + Settings.DISH_ID + ", " + Settings.DISH_TITLE + ", " + Settings.DISH_PHOTO + ", " + Settings.DISH_CATEGORY + " , " + Settings.DISH_DESCRIPTION
                + ", " + Settings.DISH_RECIPE + ", " + Settings.DISH_GROCERYLIST + ", d." + Settings.DISH_WEIGTHLIST + ", " + Settings.DISH_NUMBER_OF_LIKES + " FROM "
                + Settings.DISH_TABLE + " d JOIN " + Settings.LIKED_DISHES_TABLE + " ld ON d." + Settings.DISH_ID + " = ld." + Settings.LIKED_DISHES_DISH_ID
                + " WHERE " + Settings.LIKED_DISHES_USER_ID + " = ?";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setInt(1, iduser);
            resSet = prSt.executeQuery();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resSet;
    }

    public void addLikedDishes(int iduser, int iddish) {
        String insert = "INSERT INTO " + Settings.LIKED_DISHES_TABLE + "(" + Settings.LIKED_DISHES_USER_ID + "," + Settings.LIKED_DISHES_DISH_ID + ")" + "VALUES(?,?)";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setInt(1, iduser);
            prSt.setInt(2, iddish);
            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void removeLikedDishes(int idUser, int iddish) {
        String delete = "DELETE FROM " + Settings.LIKED_DISHES_TABLE + " WHERE " + Settings.LIKED_DISHES_USER_ID + " = " + idUser + " AND "
                + Settings.LIKED_DISHES_DISH_ID + " = " + iddish;
        try {
            Statement statement = getDbConnection().createStatement();
            statement.executeUpdate(delete);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ResultSet getPlaylists(int iduser) {
        ResultSet resultSet = null;
        String select = "SELECT " + Settings.DISH_ID + ", " + Settings.DISH_TITLE + ", " + Settings.DISH_PHOTO + ", " + Settings.DISH_DESCRIPTION + ", "
                + Settings.DISH_RECIPE + ", " + Settings.DISH_GROCERYLIST + ", " + Settings.DISH_WEIGTHLIST + ", " + Settings.DISH_NUMBER_OF_LIKES
                + ", " + Settings.DISH_CATEGORY + ", " + Settings.PLAYLISTS_NAME + "," + Settings.PLAYLISTS_ID + " FROM "
                + Settings.USER_PLAYLISTS_TABLE + " up JOIN " + Settings.PLAYLISTS_DISH_TABLE + " pd ON up." + Settings.USER_PLAYLISTS_IDPLAYLIST
                + " = pd." + Settings.PLAYLISTS_DISH_PLAYLISTID + " JOIN " + Settings.DISH_TABLE + " d ON pd." + Settings.PLAYLISTS_DISH_DISHID + " = "
                + " d." + Settings.DISH_ID + " JOIN " + Settings.PLAYLISTS_TABLE + " p ON up." + Settings.USER_PLAYLISTS_IDPLAYLIST
                + " = p." + Settings.PLAYLISTS_ID + " where " + Settings.USER_PLAYLISTS_IDUSER + " = ?";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setInt(1, iduser);
            resultSet = prSt.executeQuery();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public ResultSet getEmptyPlaylists(int idUser) {
        ResultSet resultSet = null;
        String select = "SELECT * FROM " + Settings.PLAYLISTS_TABLE + " p JOIN " + Settings.USER_PLAYLISTS_TABLE + " up ON p."
                + Settings.PLAYLISTS_ID + " = up." + Settings.USER_PLAYLISTS_IDPLAYLIST + " WHERE up." + Settings.USER_PLAYLISTS_IDUSER + " =?";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setInt(1, idUser);
            resultSet = prSt.executeQuery();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public int addPlaylists(int idUser, String name) {
        String insert1 = "INSERT INTO " + Settings.PLAYLISTS_TABLE + "(" + Settings.PLAYLISTS_NAME + ")" + "VALUES(?)";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert1);
            prSt.setString(1, name);
            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        int last_id = 0;
        String select = "SELECT idplaylists as last_id FROM playlists ORDER BY idplaylists DESC LIMIT 1";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            ResultSet resultSet = prSt.executeQuery();
            resultSet.next();
            last_id = resultSet.getInt("last_id");
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        String insert2 = "INSERT INTO " + Settings.USER_PLAYLISTS_TABLE + "(" + Settings.USER_PLAYLISTS_IDUSER + ", "
                + Settings.USER_PLAYLISTS_IDPLAYLIST + ")" + " VALUES(?, ?)";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert2);
            prSt.setInt(1, idUser);
            prSt.setInt(2, last_id);
            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return last_id;
    }

    public void removePlaylists(int idPlaylist) {
        String delete1 = "DELETE FROM " + Settings.PLAYLISTS_TABLE + " WHERE " + Settings.PLAYLISTS_ID + " = " + idPlaylist;
        try {
            Statement statement = getDbConnection().createStatement();
            statement.executeUpdate(delete1);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        String delete2 = "DELETE FROM " + Settings.USER_PLAYLISTS_TABLE + " WHERE " + Settings.USER_PLAYLISTS_IDPLAYLIST + " = " + idPlaylist;
        try {
            Statement statement = getDbConnection().createStatement();
            statement.executeUpdate(delete2);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        String delete3 = "DELETE FROM " + Settings.PLAYLISTS_DISH_TABLE + " WHERE " + Settings.PLAYLISTS_DISH_PLAYLISTID + " = " + idPlaylist;
        try {
            Statement statement = getDbConnection().createStatement();
            statement.executeUpdate(delete3);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void addDishInPlaylist(int idPlaylists, int idDish) {
        String insert = "INSERT INTO " + Settings.PLAYLISTS_DISH_TABLE + "(" + Settings.PLAYLISTS_DISH_PLAYLISTID + ","
                + Settings.PLAYLISTS_DISH_DISHID + ")" + " VALUES(?,?)";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setInt(1, idPlaylists);
            prSt.setInt(2, idDish);
            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void removeDishInPlaylist(int idPlaylist, int idDish) {
        String delete = "DELETE FROM " + Settings.PLAYLISTS_DISH_TABLE + " WHERE " + Settings.PLAYLISTS_DISH_PLAYLISTID + " = " + idPlaylist + " AND "
                + Settings.PLAYLISTS_DISH_DISHID + " = " + idDish;
        try {
            Statement statement = getDbConnection().createStatement();
            statement.executeUpdate(delete);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private String listToStr(List list) {
        StringBuilder str = new StringBuilder();
        str.append(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            str.append("/").append(list.get(i));
        }
        return str.toString();
    }

    public void addOneLike(int idDish) {
        String update = "UPDATE " + Settings.DISH_TABLE + " SET " + Settings.DISH_NUMBER_OF_LIKES + " = " + Settings.DISH_NUMBER_OF_LIKES + " + 1 WHERE "
                + Settings.DISH_ID + " = ?";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(update);
            prSt.setInt(1, idDish);
            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void removeOneLike(int idDish) {
        String update = "UPDATE " + Settings.DISH_TABLE + " SET " + Settings.DISH_NUMBER_OF_LIKES + " = " + Settings.DISH_NUMBER_OF_LIKES + " - 1 WHERE "
                + Settings.DISH_ID + " = ?";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(update);
            prSt.setInt(1, idDish);
            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void changeUsername(String mail, String newUsername) {
        String update = "UPDATE " + Settings.USER_TABLE + " SET " + Settings.USER_USERNAME
                + " = ? WHERE " + Settings.USER_MAIL + " = ?";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(update);
            prSt.setString(1, newUsername);
            prSt.setString(2, mail);
            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void changeLocation(String mail, String location) {
        String update = "UPDATE " + Settings.USER_TABLE + " SET " + Settings.USER_LOCATION
                + " = ? WHERE " + Settings.USER_MAIL + " = ?";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(update);
            prSt.setString(1, location);
            prSt.setString(2, mail);
            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}