package gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import login.Account;
import login.DatabaseHandler;
import login.Login;
import settings.Text;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
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
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("/gui/admin.fxml"));
                    try {
                        loader.load();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Parent root = loader.getRoot();
                    Stage stage = new Stage();
                    stage.setTitle(Text.get("PROGRAM_NAME"));
                    stage.setScene(new Scene(root));
                    stage.show();
                } else {
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("/gui/app.fxml"));
                    try {
                        loader.load();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Parent root = loader.getRoot();
                    Stage stage = new Stage();
                    stage.setTitle(Text.get("PROGRAM_NAME"));
                    stage.setScene(new Scene(root));
                    stage.setResizable(false);
                    stage.setMaxHeight(729);
                    stage.setMinHeight(729);
                    stage.setMaxWidth(1205);
                    stage.setMinWidth(1205);
                    stage.show();
                }
            }
        } else {
            Parent root = FXMLLoader.load(getClass().getResource("signIn.fxml"));
            Scene scene = new Scene(root, 1200, 700);
            //scene.getStylesheets().add(0, "css/mycss.css");
            primaryStage.setTitle(Text.get("PROGRAM_NAME"));
            primaryStage.setResizable(false);
            primaryStage.setMaxHeight(700);
            primaryStage.setMinHeight(700);
            primaryStage.setMaxWidth(1200);
            primaryStage.setMinWidth(1200);
            primaryStage.setScene(scene);
            primaryStage.show();
        }
    }
}
