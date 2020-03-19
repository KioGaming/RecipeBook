package login;

import settings.Settings;

import java.sql.*;
import java.util.ArrayList;

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

        String select = "SELECT * FROM " + Settings.LIKED_DISHES_TABLE + " WHERE " + Settings.USER_ID + " = " + iduser;

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

    public void setRecipe(String title, String photo, String description, ArrayList<String> recipe, ArrayList<String> groceryList,
                          ArrayList<Double> countList, ArrayList<String> unitsOfMeasurementList, int numberOfLikes){
        String insert = "INSERT INTO " + Settings.DISH_TABLE + "(" + Settings.DISH_TITLE + "," + Settings.DISH_PHOTO + ","
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

    public void setLikedDishes(int iduser, String title) {
        //записать рецепт в базу в табличку лайканих
    }

    public void removeLikedDishes(int idUser, String title) {
        //удалить рецепт з бази з таблички лайканих
    }
}
