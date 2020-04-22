package gui;

import javafx.application.Application;
import javafx.stage.Stage;
import login.Login;
import model.Account;
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
        if (file.exists()) {
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
                if (scanner.hasNext()) {
                    savedMail = scanner.nextLine();
                    if (scanner.hasNext()) {
                        savedPassword = scanner.nextLine();
                        Login.signIn(savedMail, savedPassword, true);
                        Thread.sleep(1000);
                        Account account = new Account();
                        if (account.getIdUser() != -1) {
                            LoaderNewScene.load("/gui/app.fxml");//admin
                        } else {
                            LoaderNewScene.load("/gui/signIn.fxml");
                        }
                    } else {
                        LoaderNewScene.load("/gui/signIn.fxml");
                    }
                } else {
                    LoaderNewScene.load("/gui/signIn.fxml");
                }
            } else {
                LoaderNewScene.load("/gui/signIn.fxml");
            }
        } else {
            LoaderNewScene.load("/gui/signIn.fxml");
        }
    }
}