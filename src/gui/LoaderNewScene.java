package gui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import settings.Text;

import java.io.IOException;

public class LoaderNewScene {

    public static String dir = "";

    public static void load(String file) {
        FXMLLoader loader = new FXMLLoader();
        /*System.out.println(LoaderNewScene.class.getResource(file).toString());
        if(dir.length() < file.length()) {
            StringBuffer buffer = new StringBuffer(LoaderNewScene.class.getResource(file).toString());
            buffer.delete(buffer.length() - file.length(), buffer.length());
            dir = buffer.toString();
        }
        System.out.println(dir + file);*/
        // try {
        loader.setLocation(LoaderNewScene.class.getResource(file));//new URL(dir + file));
        // }  catch (MalformedURLException e) {
        //      e.printStackTrace();
        // }
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
