package gui;

import exception.ModelException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Dish;
import saveload.SaveLoad;
import settings.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AdminController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField descriptionField;

    @FXML
    private Button addRecipe;

    @FXML
    private TextField titleField;

    @FXML
    private TextField photoField;

    @FXML
    private TextField groceryListField;

    @FXML
    private TextField recipeField;

    @FXML
    private Button exitButton;


    @FXML
    private TextField countListField;

    @FXML
    private TextField unitsOfMeasurementListField;

    @FXML
    void initialize() {
        addRecipe.setOnAction(event ->
        {
            String title = titleField.getText();
            String photo = photoField.getText();
            String description = descriptionField.getText();
            String groceryList = groceryListField.getText();
            String countList = countListField.getText();
            String unitsOfMeasurementList = unitsOfMeasurementListField.getText();
            String recipe = recipeField.getText();

            if (!title.equals("") && !photo.equals("") && !groceryList.equals("") && !recipe.equals(""))
            {
                String[] tmp1 = groceryList.split("/");
                ArrayList<String> gl = new ArrayList<>();
                for (int i = 0; i < tmp1.length;i++)
                {
                    gl.add(tmp1[i]);
                }

                ArrayList<Double> cl = new ArrayList<>();
                String[] tmp2 = countList.split("/");
                for (int i = 0; i < tmp2.length; i++)
                {
                     cl.add(Double.parseDouble(tmp2[i]));
                }

                String[] tmp3 = unitsOfMeasurementList.split("/");
                ArrayList<String> ul = new ArrayList<>();
                for (int i = 0; i < tmp3.length;i++)
                {
                    ul.add(tmp3[i]);
                }

                String[] tmp4 = recipe.split("/");
                ArrayList<String> r = new ArrayList<>();
                for (int i = 0; i < tmp4.length;i++)
                {
                    r.add(tmp4[i]);
                }

                try
                {
                    SaveLoad saveLoad = new SaveLoad();                         // нада помінятьььь
                    SaveLoad.saveRecipe(new Dish(title, photo, description, "Бульоны и супы", r, gl, cl, ul, 0));
                } catch (ModelException e)
                {
                    e.printStackTrace();
                }
                titleField.clear();
                photoField.clear();
                descriptionField.clear();
                groceryListField.clear();
                countListField.clear();
                unitsOfMeasurementListField.clear();
                recipeField.clear();
            } else
                {
                    //тири пири шото тута нада написать
            }
        });

        exitButton.setOnAction(event -> {
            exitButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/gui/SignIn.fxml"));
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
            stage.setMaxHeight(700);
            stage.setMinHeight(700);
            stage.setMaxWidth(1200);
            stage.setMinWidth(1200);
            stage.show();
        });
    }
}
