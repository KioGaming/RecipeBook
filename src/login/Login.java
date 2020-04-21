package login;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class Login {

    public static void signUp(String username, String mail, String password, String location, boolean savePassword) {
        Thread thread = new Thread(new ThreadForDB("signUp", username, mail, password, location), "Thread");
        thread.start();
        if (savePassword) {
            savePassword(mail, password);
        } else {
            noSavePassword();
        }
    }

    public static void signIn(String mail, String password, boolean savePassword) {
        Thread thread = new Thread(new ThreadForDB("signIn", mail, password), "Thread");
        thread.start();
        if (savePassword) {
            savePassword(mail, password);
        } else {
            noSavePassword();
        }
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
