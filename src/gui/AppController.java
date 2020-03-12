package gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import model.Dish;
import saveload.SaveData;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class AppController {

    ObservableList<String> comboBoxList = FXCollections.observableArrayList("Все блюда", "Бульоны и супы", "Горячие блюда", "Салаты", "Закуски", "Напитки",
            "Соусы", "Выпечка", "Десерты", "Заготовки", "Каши", "Приготовление молочних продуктов");

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private ComboBox<String> filterComboBox;

    @FXML
    private AnchorPane frameScrollPane;

    @FXML
    private Label title1;

    @FXML
    private ImageView image1;

    @FXML
    private Label title2;

    @FXML
    private ImageView image2;

    @FXML
    private Label title3;

    @FXML
    private ImageView image3;

    @FXML
    private Label title4;

    @FXML
    private ImageView image4;

    @FXML
    private Label title5;

    @FXML
    private ImageView image5;

    @FXML
    private Button backButton;

    @FXML
    private Button nextButton;


    @FXML
    void initialize() {
        filterComboBox.setItems(comboBoxList);
        SaveData sd = new SaveData();
        next(sd);

        nextButton.setOnAction(actionEvent -> {
            if (filterComboBox.getValue() == null || filterComboBox.getValue() == "Все блюда")
                next(sd);
            else next(sd, filterComboBox.getValue());
        });

        filterComboBox.setOnAction(event -> {
            nextButton.setDisable(false);
            next(sd, filterComboBox.getValue());
        });

        backButton.setOnAction(actionEvent -> {
            nextButton.setDisable(false);
            if (filterComboBox.getValue() == null || filterComboBox.getValue() == "Все блюда")
                back(sd);
            else back(sd, filterComboBox.getValue());
        });
    }

    public void next(SaveData sd) {
        List<Dish> list = sd.getDishes();
        int counter = sd.getCounter();
        if (counter == 0) counter = -1;
        int listSize = sd.getDishes().size();

        if (counter < listSize - 1) {
            if (counter + 1 < listSize) {
                counter++;
                title1.setText(list.get(counter).getTitle());
                image1.setImage(new Image(new File("/images/" + list.get(counter).getPhoto()).toURI().toString()));
            } else {
                title1.setVisible(false);
                image1.setVisible(false);
            }
            if (counter + 1 < listSize) {
                counter++;
                title2.setText(list.get(counter).getTitle());
                image2.setImage(new Image(new File("/images/" + list.get(counter).getPhoto()).toURI().toString()));
            } else {
                title2.setVisible(false);
                image2.setVisible(false);
            }
            if (counter + 1 < listSize) {
                counter++;
                title3.setText(list.get(counter).getTitle());
                image3.setImage(new Image(new File("/images/" + list.get(counter).getPhoto()).toURI().toString()));
            } else {
                title3.setVisible(false);
                image3.setVisible(false);
            }
            if (counter + 1 < listSize) {
                counter++;
                title4.setText(list.get(counter).getTitle());
                image4.setImage(new Image(new File("/images/" + list.get(counter).getPhoto()).toURI().toString()));
            } else {
                title4.setVisible(false);
                image4.setVisible(false);
            }
            if (counter + 1 < listSize) {
                counter++;
                title5.setText(list.get(counter).getTitle());
                image5.setImage(new Image(new File("/images/" + list.get(counter).getPhoto()).toURI().toString()));
            } else {
                title5.setVisible(false);
                image5.setVisible(false);
            }
            if (counter - sd.getCounter() != 0) {
                sd.setLastCounterChange(counter - sd.getCounter());
            }
            sd.setCounter(counter);
            scrollPane.setVvalue(0);
            if (counter >= listSize - 1) {
                nextButton.setDisable(true);
            }
        } else {
            nextButton.setDisable(true);
        }
    }

    //next + filter
    public void next(SaveData sd, String str) {
    }

    //back
    public void back(SaveData sd) {
    }

    //back + filter
    public void back(SaveData sd, String filter) {
    }
}

