package gui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import settings.Text;

import java.io.IOException;

public class LoaderNewScene {

    public static void load(String file) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(LoaderNewScene.class.getResource(file));
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
