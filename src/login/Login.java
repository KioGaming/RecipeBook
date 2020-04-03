package login;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {

    public static Account signUp(String username, String mail, String originalPassword, String location, DatabaseHandler dbHandler) {
        if (Filter.verifyUsername(username) == true && Filter.verifyMail(mail) == true &&
                Filter.verifyPassword(originalPassword) == true && Filter.verifyLocation(location) == true &&
                dbHandler.verifyUsernameDB(username) == true && dbHandler.verifyMailDB(mail) == true) {
           /* String generatedSecuredPasswordHash = com.lambdaworks.crypto.SCryptUtil.scrypt(originalPassword, 16, 16, 16);
            System.out.println(generatedSecuredPasswordHash);
            dbHandler.signUpUser(username, mail, generatedSecuredPasswordHash, location);*/
            String generatedSecuredPasswordHash = originalPassword;
            int iduser = dbHandler.maxIdUser();
            if (iduser != 0) {
                return new Account(iduser, username, mail, generatedSecuredPasswordHash, location);
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    public static Account signIn(String mail, String password, DatabaseHandler dbHandler) {
        //boolean matched = com.lambdaworks.crypto.SCryptUtil.check("password", generatedSecuredPasswordHash);
        //System.out.println(matched);
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
