package gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import login.Account;
import model.Dish;
import model.Shopping;
import saveload.SaveData;
import settings.Settings;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class AppController {

    ObservableList<String> comboBoxList = FXCollections.observableArrayList("Всі страви", "Перші страви", "Другі страви", "Салати та закуски",
            "Випічка", "Торти", "Десерти", "Напої");

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private ScrollPane scrollPane2;

    @FXML
    private ComboBox<String> filterComboBox;

    @FXML
    private AnchorPane frameScrollPane;

    @FXML
    private Button title1;

    @FXML
    private Button title2;

    @FXML
    private Button title3;

    @FXML
    private Button title4;

    @FXML
    private Button title5;

    @FXML
    private ImageView image1;

    @FXML
    private ImageView image2;

    @FXML
    private ImageView image3;

    @FXML
    private ImageView image4;

    @FXML
    private ImageView image5;

    @FXML
    private Button backButton;

    @FXML
    private Button nextButton;

    @FXML
    private Button backToCategoryButton;

    @FXML
    private Label dishTitle;

    @FXML
    private Label dishDescription;

    @FXML
    private Label dishRecipe;

    @FXML
    private ImageView dishImage;

    @FXML
    private ImageView likeField;

    @FXML
    private TableView<Shopping> groceryTableView;

    @FXML
    void initialize() {
        scrollPane2.setVisible(false);
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

        title1.setOnAction(event -> {
            dishView(sd, title1.getText());
        });
        title2.setOnAction(event -> {
            dishView(sd, title2.getText());
        });
        title3.setOnAction(event -> {
            dishView(sd, title3.getText());
        });
        title4.setOnAction(event -> {
            dishView(sd, title4.getText());
        });
        title5.setOnAction(event -> {
            dishView(sd, title5.getText());
        });

        backToCategoryButton.setOnAction(event -> {
            backToCategory(sd);
        });

        likeField.setOnMouseClicked(event -> {
            String title = dishTitle.getText();
            if (sd.getLikedDishes().indexOf(title) != -1) {
                likeField.setImage(new Image(new File(Settings.getImageDir() + "noliked.png").toURI().toString()));
                sd.getLikedDishes().remove(title);
                Account account = new Account();
                sd.removeLikedDishes(account.getIdUser(), title);
            } else {
                likeField.setImage(new Image(new File(Settings.getImageDir() + "liked.png").toURI().toString()));
                sd.getLikedDishes().add(title);
                Account account = new Account();
                sd.saveLikedDishes(account.getIdUser(), title);
            }
        });
    }

    //next
    private void next(SaveData sd) {
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
                image1.setImage(new Image(new File(Settings.getImageDir() + list.get(counter).getPhoto()).toURI().toString()));
            } else {
                title1.setVisible(false);
                image1.setVisible(false);
            }
            if (counter + 1 < listSize) {
                counter++;
                title2.setText(list.get(counter).getTitle());
                image2.setImage(new Image(new File(Settings.getImageDir() + list.get(counter).getPhoto()).toURI().toString()));
            } else {
                title2.setVisible(false);
                image2.setVisible(false);
            }
            if (counter + 1 < listSize) {
                counter++;
                title3.setText(list.get(counter).getTitle());
                image3.setImage(new Image(new File(Settings.getImageDir() + list.get(counter).getPhoto()).toURI().toString()));
            } else {
                title3.setVisible(false);
                image3.setVisible(false);
            }
            if (counter + 1 < listSize) {
                counter++;
                title4.setText(list.get(counter).getTitle());
                image4.setImage(new Image(new File(Settings.getImageDir() + list.get(counter).getPhoto()).toURI().toString()));
            } else {
                title4.setVisible(false);
                image4.setVisible(false);
            }
            if (counter + 1 < listSize) {
                counter++;
                title5.setText(list.get(counter).getTitle());
                image5.setImage(new Image(new File(Settings.getImageDir() + list.get(counter).getPhoto()).toURI().toString()));
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
    private void next(SaveData sd, String filter) {
        List<Dish> list;
        if (filter == "Перші страви") {
            list = sd.getC1();
        } else if (filter == "Другі страви") {
            list = sd.getC2();
        } else if (filter == "Салати та закуски") {
            list = sd.getC3();
        } else if (filter == "Випічка") {
            list = sd.getC4();
        } else if (filter == "Торти") {
            list = sd.getC5();
        } else if (filter == "Десерти") {
            list = sd.getC6();
        } else {
            list = sd.getC7();
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
                image1.setImage(new Image(new File(Settings.getImageDir() + list.get(counter).getPhoto()).toURI().toString()));
            } else {
                title1.setVisible(false);
                image1.setVisible(false);
            }
            if (counter + 1 < listSize) {
                counter++;
                title2.setText(list.get(counter).getTitle());
                image2.setImage(new Image(new File(Settings.getImageDir() + list.get(counter).getPhoto()).toURI().toString()));
            } else {
                title2.setVisible(false);
                image2.setVisible(false);
            }
            if (counter + 1 < listSize) {
                counter++;
                title3.setText(list.get(counter).getTitle());
                image3.setImage(new Image(new File(Settings.getImageDir() + list.get(counter).getPhoto()).toURI().toString()));
            } else {
                title3.setVisible(false);
                image3.setVisible(false);
            }
            if (counter + 1 < listSize) {
                counter++;
                title4.setText(list.get(counter).getTitle());
                image4.setImage(new Image(new File(Settings.getImageDir() + list.get(counter).getPhoto()).toURI().toString()));
            } else {
                title4.setVisible(false);
                image4.setVisible(false);
            }
            if (counter + 1 < listSize) {
                counter++;
                title5.setText(list.get(counter).getTitle());
                image5.setImage(new Image(new File(Settings.getImageDir() + list.get(counter).getPhoto()).toURI().toString()));
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
    private void back(SaveData sd) {
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
                image1.setImage(new Image(new File(Settings.getImageDir() + list.get(counter).getPhoto()).toURI().toString()));
            } else {
                title1.setVisible(false);
                image1.setVisible(false);
            }
            if (counter + 1 < listSize) {
                counter++;
                title2.setText(list.get(counter).getTitle());
                image2.setImage(new Image(new File(Settings.getImageDir() + list.get(counter).getPhoto()).toURI().toString()));
            } else {
                title2.setVisible(false);
                image2.setVisible(false);
            }
            if (counter + 1 < listSize) {
                counter++;
                title3.setText(list.get(counter).getTitle());
                image3.setImage(new Image(new File(Settings.getImageDir() + list.get(counter).getPhoto()).toURI().toString()));
            } else {
                title3.setVisible(false);
                image3.setVisible(false);
            }
            if (counter + 1 < listSize) {
                counter++;
                title4.setText(list.get(counter).getTitle());
                image4.setImage(new Image(new File(Settings.getImageDir() + list.get(counter).getPhoto()).toURI().toString()));
            } else {
                title4.setVisible(false);
                image4.setVisible(false);
            }
            if (counter + 1 < listSize) {
                counter++;
                title5.setText(list.get(counter).getTitle());
                image5.setImage(new Image(new File(Settings.getImageDir() + list.get(counter).getPhoto()).toURI().toString()));
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
    private void back(SaveData sd, String filter) {
        List<Dish> list;
        if (filter == "Перші страви") {
            list = sd.getC1();
        } else if (filter == "Другі страви") {
            list = sd.getC2();
        } else if (filter == "Салати та закуски") {
            list = sd.getC3();
        } else if (filter == "Випічка") {
            list = sd.getC4();
        } else if (filter == "Торти") {
            list = sd.getC5();
        } else if (filter == "Десерти") {
            list = sd.getC6();
        } else {
            list = sd.getC7();
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
                image1.setImage(new Image(new File(Settings.getImageDir() + list.get(counter).getPhoto()).toURI().toString()));
            } else {
                title1.setVisible(false);
                image1.setVisible(false);
            }
            if (counter + 1 < listSize) {
                counter++;
                title2.setText(list.get(counter).getTitle());
                image2.setImage(new Image(new File(Settings.getImageDir() + list.get(counter).getPhoto()).toURI().toString()));
            } else {
                title2.setVisible(false);
                image2.setVisible(false);
            }
            if (counter + 1 < listSize) {
                counter++;
                title3.setText(list.get(counter).getTitle());
                image3.setImage(new Image(new File(Settings.getImageDir() + list.get(counter).getPhoto()).toURI().toString()));
            } else {
                title3.setVisible(false);
                image3.setVisible(false);
            }
            if (counter + 1 < listSize) {
                counter++;
                title4.setText(list.get(counter).getTitle());
                image4.setImage(new Image(new File(Settings.getImageDir() + list.get(counter).getPhoto()).toURI().toString()));
            } else {
                title4.setVisible(false);
                image4.setVisible(false);
            }
            if (counter + 1 < listSize) {
                counter++;
                title5.setText(list.get(counter).getTitle());
                image5.setImage(new Image(new File(Settings.getImageDir() + list.get(counter).getPhoto()).toURI().toString()));
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

    private void dishView(SaveData sd, String title) {
        scrollPane2.setVisible(true);
        scrollPane2.setVvalue(0);
        Dish dish = null;
        for (int i = 0; i < sd.getDishes().size(); i++) {
            if (sd.getDishes().get(i).getTitle() == title) {
                dish = sd.getDishes().get(i);
            }
        }
        if (dish != null) {
            dishTitle.setText(dish.getTitle());
            dishImage.setImage(new Image(new File(Settings.getImageDir() + dish.getPhoto()).toURI().toString()));
            dishDescription.setText(dish.getDescription());
            String s = "";
            for (int i = 0; i < dish.getRecipe().size(); i++) {
                s += "     " + dish.getRecipe().get(i);
                if (i != dish.getRecipe().size() - 1) {
                    s += "\n";
                }
            }
            dishRecipe.setText(s);
            scrollPane.setVisible(false);


            groceryTableView.setPrefWidth(600);
            groceryTableView.setPrefHeight(dish.getGroceryList().size() * 30 + 30);

            ObservableList<Shopping> grocery = FXCollections.observableArrayList();
            Shopping shopping = new Shopping();
            for (int i = 0; i < dish.getGroceryList().size(); i++) {
                shopping.setGrocery(dish.getGroceryList().get(i));
                shopping.setUnitsOfMeasurement(dish.getUnitsOfMeasurementList().get(i));
                shopping.setWeight(dish.getCountList().get(i));
                grocery.add(shopping);
            }
            groceryTableView.setItems(grocery);

            TableColumn<Shopping, String> groceryColumn = new TableColumn<>("Продукти");
            groceryColumn.setCellValueFactory(new PropertyValueFactory<>("grocery"));
            groceryTableView.getColumns().add(groceryColumn);

            TableColumn<Shopping, Double> weightColumn = new TableColumn<>("Вага");
            weightColumn.setCellValueFactory(new PropertyValueFactory<>("weight"));
            groceryTableView.getColumns().add(weightColumn);

            TableColumn<Shopping, String> uomColumn = new TableColumn<>("Одиниці виміру");
            uomColumn.setCellValueFactory(new PropertyValueFactory<>("unitsOfMeasurement"));
            groceryTableView.getColumns().add(uomColumn);
/*
            TableColumn<Shopping, CheckBox> isSelectedColumn = new TableColumn<>(" + в список покупок");
            isSelectedColumn.setCellValueFactory(new PropertyValueFactory<>("isSelected"));
            groceryTableView.getColumns().add(isSelectedColumn);
            */
            groceryTableView.setVisible(true);

            if (sd.getLikedDishes() != null && sd.getLikedDishes().size() == 0) {
                likeField.setImage(new Image(new File(Settings.getImageDir() + "noliked.png").toURI().toString()));
            } else if (sd.getLikedDishes() != null && sd.getLikedDishes().indexOf(dish.getTitle()) != -1) {
                likeField.setImage(new Image(new File(Settings.getImageDir() + "liked.png").toURI().toString()));
            } else {
                likeField.setImage(new Image(new File(Settings.getImageDir() + "noliked.png").toURI().toString()));
            }
        }
    }

    private void backToCategory(SaveData sd) {
        scrollPane2.setVisible(false);
        scrollPane.setVisible(true);
    }
}