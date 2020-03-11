package gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import model.Dish;
import saveload.SaveData;

import java.net.URL;
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
    void initialize() {
//сначала инициализирувать

        filterComboBox.setItems(comboBoxList);
        filterComboBox.setOnAction(event -> {
            String str = filterComboBox.getValue();
            SaveData saveData = new SaveData();
            for (int i = 0; i < saveData.getDishes().size(); i++) {
                Dish dish = saveData.getDishes().get(i);
                //шото нада зделать шоб работало
                if (dish.getCategory() == str) {
                    Label title = new Label();
                    //title.setFont(new Font("Lobster", ));
                    title.setText(dish.getTitle());
                    title.setScaleX(300);
                    title.setScaleY(600);
                    title.setVisible(true);
                    Group group = new Group(title);
                    ImageView imageView = new ImageView();
                    imageView.setImage(new Image(dish.getPhoto()));
                    Label description = new Label();
                    //description.setFont(new Font("Lobster", ));
                    description.setText(dish.getDescription());
                    frameScrollPane.getChildren().add(title);
                }
            }
        });
    }
}

