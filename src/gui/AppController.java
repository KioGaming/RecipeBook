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

    ObservableList<String> comboBoxList = FXCollections.observableArrayList("Всі страви", "Супи та борщі", "Гарячі страви", "Салати", "Закуски", "Напої",
            "Соуси", "Випічка", "Десерти", "Заготовки", "Каші", "Приготування молочних продуктів");

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
        backButton.setDisable(true);
        SaveData sd = new SaveData();
        next(sd);

        nextButton.setOnAction(actionEvent -> {
            backButton.setDisable(false);
            nextButton.setDisable(false);
            scrollPane.setFitToHeight(false);
            if (filterComboBox.getValue() == null || filterComboBox.getValue() == "Всі страви")
                next(sd);
            else next(sd, filterComboBox.getValue());
        });

        filterComboBox.setOnAction(event -> {
            backButton.setDisable(true);
            nextButton.setDisable(false);
            scrollPane.setFitToHeight(false);
            nextButton.setLayoutY(1300);
            backButton.setLayoutY(1300);
            sd.setCounter(0);
            sd.setLastCounterChange(5);
            if (filterComboBox.getValue() == null || filterComboBox.getValue() == "Всі страви")
                next(sd);
            else next(sd, filterComboBox.getValue());
        });
//добавить появление ImageView
        backButton.setOnAction(actionEvent -> {
            nextButton.setDisable(false);
            scrollPane.setFitToHeight(false);
            nextButton.setLayoutY(1300);
            backButton.setLayoutY(1300);
            if (filterComboBox.getValue() == null || filterComboBox.getValue() == "Всі страви")
                back(sd);
            else back(sd, filterComboBox.getValue());
        });
    }

    //next
    public void next(SaveData sd) {
        List<Dish> list = sd.getDishes();
        int counter = sd.getCounter();
        if (counter == 0) counter = -1;
        int listSize = list.size();

        title1.setVisible(true);
        title2.setVisible(true);
        title3.setVisible(true);
        title4.setVisible(true);
        title5.setVisible(true);

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
            if (nextButton.isDisable() && counter - sd.getCounter() >= 0 && counter - sd.getCounter() < 5) {
                scrollPane.setFitToHeight(true);
                nextButton.setLayoutX(800);
                nextButton.setLayoutY(500);
                backButton.setLayoutX(300);
                backButton.setLayoutY(500);
            }
        } else {
            nextButton.setDisable(true);
        }
    }

    //next + filter
    public void next(SaveData sd, String filter) {
        List<Dish> list;
        if (filter == "Супи та борщі") {
            list = sd.getC1();
        } else if (filter == "Гарячі страви") {
            list = sd.getC2();
        } else if (filter == "Салати") {
            list = sd.getC3();
        } else if (filter == "Закуски") {
            list = sd.getC4();
        } else if (filter == "Напої") {
            list = sd.getC5();
        } else if (filter == "Соуси") {
            list = sd.getC6();
        } else if (filter == "Випічка") {
            list = sd.getC7();
        } else if (filter == "Десерти") {
            list = sd.getC8();
        } else if (filter == "Заготовки") {
            list = sd.getC9();
        } else if (filter == "Каші") {
            list = sd.getC10();
        } else {
            list = sd.getC11();
        }
        int counter = sd.getCounter();
        if (counter == 0) counter = -1;
        int listSize = list.size();

        title1.setVisible(true);
        title2.setVisible(true);
        title3.setVisible(true);
        title4.setVisible(true);
        title5.setVisible(true);

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
            if (nextButton.isDisable() && counter - sd.getCounter() >= 0 && counter - sd.getCounter() < 5) {
                scrollPane.setFitToHeight(true);
                nextButton.setLayoutX(800);
                nextButton.setLayoutY(500);
                backButton.setLayoutX(300);
                backButton.setLayoutY(500);
            }
        } else {
            nextButton.setDisable(true);
        }
    }

    //back
    public void back(SaveData sd) {
        List<Dish> list = sd.getDishes();
        int counter = sd.getCounter();
        int listSize = list.size();
        int lastCounterChange = sd.getLastCounterChange();

        title1.setVisible(true);
        title2.setVisible(true);
        title3.setVisible(true);
        title4.setVisible(true);
        title5.setVisible(true);

        if (lastCounterChange != 5 && counter - lastCounterChange - 4 >= 0) {
            counter -= lastCounterChange + 4;
        } else {
            counter -= lastCounterChange;
        }
        counter--;
        if (counter >= -1) {
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
            sd.setLastCounterChange(5);
            sd.setCounter(counter);
            scrollPane.setVvalue(0);
            if (counter == 4) {
                backButton.setDisable(true);
            }
        } else {
            backButton.setDisable(true);
        }
    }

    //back + filter
    public void back(SaveData sd, String filter) {
        List<Dish> list;
        if (filter == "Супи та борщі") {
            list = sd.getC1();
        } else if (filter == "Гарячі страви") {
            list = sd.getC2();
        } else if (filter == "Салати") {
            list = sd.getC3();
        } else if (filter == "Закуски") {
            list = sd.getC4();
        } else if (filter == "Напої") {
            list = sd.getC5();
        } else if (filter == "Соуси") {
            list = sd.getC6();
        } else if (filter == "Випічка") {
            list = sd.getC7();
        } else if (filter == "Десерти") {
            list = sd.getC8();
        } else if (filter == "Заготовки") {
            list = sd.getC9();
        } else if (filter == "Каші") {
            list = sd.getC10();
        } else {
            list = sd.getC11();
        }
        int counter = sd.getCounter();
        int listSize = list.size();
        int lastCounterChange = sd.getLastCounterChange();

        title1.setVisible(true);
        title2.setVisible(true);
        title3.setVisible(true);
        title4.setVisible(true);
        title5.setVisible(true);

        if (lastCounterChange != 5 && counter - lastCounterChange - 4 >= 0) {
            counter -= lastCounterChange + 4;
        } else {
            counter -= lastCounterChange;
        }
        counter--;
        if (counter >= -1) {
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
            sd.setLastCounterChange(5);
            sd.setCounter(counter);
            scrollPane.setVvalue(0);
            if (counter == 4) {
                backButton.setDisable(true);
            }
        } else {
            backButton.setDisable(true);
        }
    }
}

