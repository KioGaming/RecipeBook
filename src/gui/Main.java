package gui;

import javafx.application.Application;
import javafx.stage.Stage;
import login.Account;
import login.DatabaseHandler;
import login.Login;
import settings.Text;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main extends Application {

    public static void main(String[] args) {
        myinit();
        launch(args);
    }

    public static void myinit() {
        Text.init();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        File file = new File(System.getenv("APPDATA") + "/recipebook/rb.txt");
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String savedPassword;
        String savedMail;
        boolean bool = scanner.nextBoolean();
        if (bool) {
            scanner.nextLine();
            savedMail = scanner.nextLine();
            savedPassword = scanner.nextLine();
            Account account = Login.signIn(savedMail, savedPassword, new DatabaseHandler(), true);
            if (account != null) {
                if (Account.getRole().equals("admin")) {
                    LoaderNewScene.load("/gui/admin.fxml");
                } else {
                    LoaderNewScene.load("/gui/app.fxml");
                }
            }
        } else {
            LoaderNewScene.load("signIn.fxml");
        }
    }
}
