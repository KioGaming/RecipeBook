package login;

import java.security.SecureRandom;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {

    public static Account signUp(String username, String mail, String originalPassword, String location, DatabaseHandler dbHandler) {
        if (Filter.verifyUsername(username) == true && Filter.verifyMail(mail) == true &&
                Filter.verifyPassword(originalPassword) == true && Filter.verifyLocation(location) == true &&
                dbHandler.verifyUsernameDB(username) == true && dbHandler.verifyMailDB(mail) == true) {
            byte[] salt = new byte[16];
            SecureRandom secureRandom = new SecureRandom();
            secureRandom.nextBytes(salt);
            String generatedSecuredPasswordHash = lambdaworks.crypto.SCryptUtil.scrypt(originalPassword + salt.toString(), 16, 16, 16);
            dbHandler.signUpUser(username, mail, generatedSecuredPasswordHash, salt.toString(), location);
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
        ResultSet resultSet = dbHandler.signInUser(mail);
        Account account = null;
        try {
            if (resultSet.next()) {
                String username = resultSet.getString("username");
                String location = resultSet.getString("location");
                int iduser = Integer.parseInt(resultSet.getString("idusers"));
                boolean matched = lambdaworks.crypto.SCryptUtil.check(password + resultSet.getString("salt"), resultSet.getString("password"));
                if (matched) {
                    account = new Account(iduser, username, mail, password, location);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return account;
    }
}
