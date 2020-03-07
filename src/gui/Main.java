package gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import settings.Text;

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
        Parent root = FXMLLoader.load(getClass().getResource("signIn.fxml"));
        primaryStage.setTitle(Text.get("PROGRAM_NAME"));
        primaryStage.setResizable(false);
        primaryStage.setMaxHeight(700);
        primaryStage.setMinHeight(700);
        primaryStage.setMaxWidth(1200);
        primaryStage.setMinWidth(1200);
        primaryStage.setScene(new Scene(root, 1200, 700));
        primaryStage.show();
    }
}
