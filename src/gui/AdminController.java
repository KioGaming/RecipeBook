package gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import saveload.SaveLoad;

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
    private TextField categoryField;

    @FXML
    private TextField countListField;

    @FXML
    private TextField unitsOfMeasurementListField;

    @FXML
    void initialize() {
        addRecipe.setOnAction(event ->
        {
            String category = categoryField.getText();
            String title = titleField.getText();
            String photo = photoField.getText();
            String description = descriptionField.getText();
            String groceryList = groceryListField.getText();
            String countList = countListField.getText();
            String unitsOfMeasurementList = unitsOfMeasurementListField.getText();
            String recipe = recipeField.getText();

            if (!title.equals("") && !photo.equals("") && !description.equals("") && !category.equals("") &&
                    !groceryList.equals("") && !countList.equals("") && !unitsOfMeasurementList.equals("") && !recipe.equals("")) {
                String[] tmp1 = groceryList.split("/");
                ArrayList<String> gl = new ArrayList<>();
                for (int i = 0; i < tmp1.length;i++)
                {
                    gl.add(tmp1[i]);
                }

                ArrayList<String> cl = new ArrayList<>();
                String[] tmp2 = countList.split("/");
                for (int i = 0; i < tmp2.length; i++)
                {
                    cl.add(tmp2[i]);
                }

                String[] tmp3 = unitsOfMeasurementList.split("/");
                ArrayList<String> ul = new ArrayList<>();
                for (int i = 0; i < tmp3.length;i++) {
                    ul.add(tmp3[i]);
                }

                String[] tmp4 = recipe.split("/");
                ArrayList<String> r = new ArrayList<>();
                for (int i = 0; i < tmp4.length; i++) {
                    r.add(tmp4[i]);
                }


                SaveLoad saveLoad = new SaveLoad();
                //SaveLoad.saveRecipe(new Dish(0, title, photo, description, category, r, gl, cl, ul, 0));
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
            LoaderNewScene.load("/gui/signIn.fxml");
        });
    }
}
