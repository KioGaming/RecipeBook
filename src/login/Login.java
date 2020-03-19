package login;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {

    public static Account signUp(String username, String mail, String password, String location, DatabaseHandler dbHandler){
        if(Filter.verifyUsername(username) == true && Filter.verifyMail(mail) == true &&
           Filter.verifyPassword(password) == true && Filter.verifyLocation(location) == true &&
                dbHandler.verifyUsernameDB(username) == true && dbHandler.verifyMailDB(mail) == true) {
            dbHandler.signUpUser(username, mail, password, location);
            int iduser = dbHandler.maxIdUser();
            if (iduser != 0) {
                return new Account(iduser, username, mail, password, location);
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    public static Account signIn(String mail, String password, DatabaseHandler dbHandler){
        ResultSet resultSet = dbHandler.signInUser(mail, password);

        Account account = null;
        try {
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String location = resultSet.getString("location");
                int iduser = Integer.parseInt(resultSet.getString("idusers"));
                account = new Account(iduser, username, mail, password, location);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return account;
    }
}
