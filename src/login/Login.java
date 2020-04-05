package login;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.SecureRandom;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {

    public static Account signUp(String username, String mail, String originalPassword, String location, DatabaseHandler dbHandler, boolean savePassword) {
        if (Filter.verifyUsername(username) == true && Filter.verifyMail(mail) == true &&
                Filter.verifyPassword(originalPassword) == true && Filter.verifyLocation(location) == true &&
                dbHandler.verifyUsernameDB(username) == true && dbHandler.verifyMailDB(mail) == true) {
            byte[] salt = new byte[16];
            SecureRandom secureRandom = new SecureRandom();
            secureRandom.nextBytes(salt);
            String generatedSecuredPasswordHash = lambdaworks.crypto.SCryptUtil.scrypt(originalPassword + salt.toString(), 16, 16, 16);
            dbHandler.signUpUser(username, mail, generatedSecuredPasswordHash, salt.toString(), location);
            int iduser = dbHandler.maxIdUser();
            if (savePassword) {
                savePassword(mail, originalPassword);
            } else {
                noSavePassword();
            }
            return new Account(iduser, username, mail, generatedSecuredPasswordHash, location, "user");
        } else {
            return null;
        }
    }

    public static Account signIn(String mail, String password, DatabaseHandler dbHandler, boolean savePassword) {
        Account account = null;
        ResultSet resultSet = dbHandler.signInUser(mail);
        try {
            if (resultSet.next()) {
                int iduser = Integer.parseInt(resultSet.getString("idusers"));
                String username = resultSet.getString("username");
                String location = resultSet.getString("location");
                String role = resultSet.getString("rolename");
                boolean matched = lambdaworks.crypto.SCryptUtil.check(password + resultSet.getString("salt"), resultSet.getString("password"));
                if (matched) {
                    account = new Account(iduser, username, mail, password, location, role);
                    if (savePassword) {
                        savePassword(mail, password);
                    } else {
                        noSavePassword();
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }

    private static void savePassword(String mail, String password) {
        try {
            File folder = new File(System.getenv("APPDATA") + "/recipebook");
            folder.mkdir();
            File file = new File(folder.toString() + "/rb.txt");
            file.createNewFile();
            PrintWriter printWriter = new PrintWriter(file);
            printWriter.println(true);
            printWriter.println(mail);
            printWriter.println(password);
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void noSavePassword() {
        try {
            File folder = new File(System.getenv("APPDATA") + "/recipebook");
            folder.mkdir();
            File file = new File(folder.toString() + "/rb.txt");
            file.createNewFile();
            PrintWriter printWriter = new PrintWriter(file);
            printWriter.println(false);
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
