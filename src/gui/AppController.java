package gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import login.Account;
import login.DatabaseHandler;
import login.Filter;
import model.Dish;
import model.Shopping;
import saveload.Playlist;
import saveload.SaveData;
import saveload.SaveLoad;
import settings.Settings;
import settings.Text;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
    private Tab libraryTab;

    @FXML
    private ImageView image6;

    @FXML
    private ImageView image7;

    @FXML
    private ImageView image8;

    @FXML
    private Button backLikeButton;

    @FXML
    private Button nextLikeButton;

    @FXML
    private Button title6;

    @FXML
    private Button title7;

    @FXML
    private Button title8;

    @FXML
    private ImageView image9;

    @FXML
    private ImageView image10;

    @FXML
    private ImageView image11;

    @FXML
    private Button title9;

    @FXML
    private Button title10;

    @FXML
    private Button title11;

    @FXML
    private ImageView image12;

    @FXML
    private ImageView image13;

    int idActivePlaylist = -1;

    @FXML
    private ImageView image14;

    @FXML
    private Button title12;

    @FXML
    private Button title13;

    @FXML
    private Button title14;

    @FXML
    private ImageView image15;

    @FXML
    private ImageView image16;

    @FXML
    private ImageView image17;

    @FXML
    private Button title15;

    @FXML
    private Button title16;

    @FXML
    private Button title17;

    @FXML
    private ImageView image18;

    @FXML
    private ImageView image19;

    @FXML
    private ImageView image20;

    @FXML
    private Button title18;

    @FXML
    private Button title19;

    @FXML
    private Button title20;

    @FXML
    private ScrollPane scrollPane3;

    @FXML
    private ScrollPane scrollPane4;

    @FXML
    private Label likeDishTitle;

    @FXML
    private ImageView likeDishImage;

    @FXML
    private Label likeDishDescription;

    @FXML
    private Label likeDishRecipe;

    @FXML
    private Button likeBackToCategoryButton;

    @FXML
    private TableView<Shopping> likeGroceryTableView;

    @FXML
    private ImageView likeFieldForLikedDish;

    @FXML
    private Button aboutUsButton;

    @FXML
    private Button supportButton;

    @FXML
    private Button exitButton;

    @FXML
    private Button changeUserInfoButton;

    @FXML
    private AnchorPane aboutUsOrSupportPane;

    @FXML
    private Button backBtn;

    @FXML
    private Label aboutUsOrSupportLabel;

    @FXML
    private AnchorPane settingsPane;

    @FXML
    private AnchorPane changeUserInfoPain;

    @FXML
    private Button changeMail;

    @FXML
    private TextField mailLabel;

    @FXML
    private TextField repeatMailLabel;

    @FXML
    private Button changePassword;

    @FXML
    private TextField passwordLabel;

    @FXML
    private TextField repeatPasswordLabel;

    @FXML
    private Button backBtn1;

    @FXML
    private Label changeMailErrorField;

    @FXML
    private Label changePasswordErrorField;

    @FXML
    private Label descriptionLabel1;

    @FXML
    private Label descriptionLabel2;

    @FXML
    private Label descriptionLabel3;

    @FXML
    private Label descriptionLabel4;

    @FXML
    private Label descriptionLabel5;

    @FXML
    private AnchorPane dishViewPane;

    @FXML
    private ImageView addInFavouriteButton;

    @FXML
    private Button likePlaylistButton;

    @FXML
    private Button playlistButton1;

    @FXML
    private Button playlistButton2;
    @FXML
    private AnchorPane frameScrollPane1;

    @FXML
    private Button playlistButton3;

    @FXML
    private Button playlistButton4;

    @FXML
    private Button playlistButton5;

    @FXML
    private AnchorPane playlistsPane;

    @FXML
    private Button addPlaylistsButton;

    @FXML
    private Button removePlaylistsButton;

    String filters;

    Dish activeDish;

    @FXML
    private Button backToPlaylistsButton;

    @FXML
    private ImageView nextLikeIcon;

    @FXML
    private ImageView nextIcon1;

    @FXML
    private ImageView nextIcon2;

    @FXML
    private ImageView nextIcon3;

    @FXML
    private ImageView nextIcon4;

    @FXML
    private ImageView nextIcon5;
    @FXML
    private ImageView likeAddInFavouriteButton;
    @FXML
    private Button removeDishInPlaylistButton;
    @FXML
    private Button removePlaylistButton;

    @FXML
    void initialize() {
        SaveData sd = new SaveData();
        Account account = new Account();
        /**
         * Home page
         * **/
        scrollPane2.setVisible(false);
        filterComboBox.setItems(comboBoxList);
        backButton.setDisable(true);
        next(sd, "Всі страви");

        nextButton.setOnAction(actionEvent -> {
            backButton.setDisable(false);
            nextButton.setDisable(false);
            scrollPane.setFitToHeight(false);
            if (filterComboBox.getValue() == null)
                next(sd, "Всі страви");
            else next(sd, filterComboBox.getValue());
        });

        filterComboBox.setOnAction(event -> {
            backButton.setDisable(true);
            nextButton.setDisable(false);
            scrollPane.setFitToHeight(false);
            nextButton.setLayoutY(850);
            backButton.setLayoutY(850);
            sd.setCounter(0);
            sd.setLastCounterChange(5);
            frameScrollPane.setMinHeight(959);
            frameScrollPane.setMaxHeight(959);
            frameScrollPane.setPrefHeight(959);
            if (filterComboBox.getValue() == null)
                next(sd, "Всі страви");
            else next(sd, filterComboBox.getValue());
        });

        backButton.setOnAction(actionEvent -> {
            frameScrollPane.setMinHeight(959);
            frameScrollPane.setMaxHeight(959);
            frameScrollPane.setPrefHeight(959);
            nextButton.setDisable(false);
            scrollPane.setFitToHeight(false);
            nextButton.setLayoutY(850);
            backButton.setLayoutY(850);
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
            if (sd.getLike().indexOf(activeDish) != -1) {
                likeField.setImage(new Image(new File(Settings.getImageDir() + "noliked.png").toURI().toString()));
                sd.getLike().remove(activeDish);
                sd.removeLikedDishes(account.getIdUser(), activeDish.getId());
            } else {
                likeField.setImage(new Image(new File(Settings.getImageDir() + "liked.png").toURI().toString()));
                sd.getLike().add(activeDish);
                sd.saveLikedDishes(account.getIdUser(), activeDish.getId());
            }
        });

        addInFavouriteButton.setVisible(true);
        addInFavouriteButton.setImage(new Image(new File(Settings.getImageDir() + "addInFavourite.png").toURI().toString()));
        addInFavouriteButton.setOnMouseClicked(mouseEvent -> {
            List<String> choices = new ArrayList<>();
            if (sd.getPlaylists().size() != 0) {
                for (int i = 0; i < sd.getPlaylists().size(); i++) {
                    choices.add(sd.getPlaylists().get(i).getTitle());
                }
            } else {
                choices.add("Добавте список відтворення на вкладці бібліотека");
            }
            ChoiceDialog<String> dialog = new ChoiceDialog<>("Виберіть список відтворення", choices);
            dialog.setTitle("RecipeBook");
            dialog.setHeaderText(null);
            dialog.setContentText("Добавте страву в список відтворення");
            dialog.initStyle(StageStyle.UTILITY);
            dialog.setResizable(false);
            Optional<String> result = dialog.showAndWait();
            result.ifPresent(letter -> {
                if (letter != "Виберіть список відтворення" && letter != "У вас немає списків відтворення") {
                    for (int i = 0; i < sd.getPlaylists().size(); i++) {
                        if (sd.getPlaylists().get(i).getTitle() == letter) {
                            boolean b = true;
                            for (int j = 0; j < sd.getPlaylists().get(i).getDishes().size(); j++) {
                                if (sd.getPlaylists().get(i).getDishes().get(j).getTitle().equals(activeDish.getTitle())) {
                                    b = false;
                                    break;
                                }
                            }
                            if (b) {
                                SaveLoad.addDishInPlaylist(sd.getPlaylists().get(i).getId(), activeDish.getId());
                                sd.getPlaylists().get(i).getDishes().add(activeDish);
                            }
                            break;
                        }
                    }
                }
            });
        });

        /**
         * Library page
         * */
        nextLikeIcon.setImage(new Image(new File(Settings.getImageDir() + "next.png").toURI().toString()));
        nextIcon1.setImage(new Image(new File(Settings.getImageDir() + "next.png").toURI().toString()));
        nextIcon2.setImage(new Image(new File(Settings.getImageDir() + "next.png").toURI().toString()));
        nextIcon3.setImage(new Image(new File(Settings.getImageDir() + "next.png").toURI().toString()));
        nextIcon4.setImage(new Image(new File(Settings.getImageDir() + "next.png").toURI().toString()));
        nextIcon5.setImage(new Image(new File(Settings.getImageDir() + "next.png").toURI().toString()));
        likeAddInFavouriteButton.setImage(new Image((new File(Settings.getImageDir() + "addInFavourite.png").toURI().toString())));
        scrollPane4.setVisible(false);
        scrollPane3.setVisible(false);
        backLikeButton.setDisable(true);
        playlistsPane.setVisible(true);
        libraryTab.setOnSelectionChanged(event -> {
            playlistsPaneRedraw(sd);
        });
        likePlaylistButton.setOnAction(actionEvent -> {
            idActivePlaylist = -1;
            sd.setLikeCounter(0);
            sd.setLastCounterChange(14);
            scrollPane3.setVisible(true);
            scrollPane4.setVisible(false);
            playlistsPane.setVisible(false);
            filters = "like";
            removePlaylistButton.setVisible(false);
            likeNext(sd, "like");
        });
        playlistButton1.setOnAction(actionEvent -> {
            idActivePlaylist = 0;
            sd.setLikeCounter(0);
            sd.setLastCounterChange(14);
            scrollPane3.setVisible(true);
            scrollPane4.setVisible(false);
            playlistsPane.setVisible(false);
            filters = "playlist1";
            removePlaylistButton.setVisible(true);
            likeNext(sd, "playlist1");
        });
        playlistButton2.setOnAction(actionEvent -> {
            idActivePlaylist = 1;
            sd.setLikeCounter(0);
            sd.setLastCounterChange(14);
            scrollPane3.setVisible(true);
            scrollPane4.setVisible(false);
            playlistsPane.setVisible(false);
            filters = "playlist2";
            removePlaylistButton.setVisible(true);
            likeNext(sd, "playlist2");
        });
        playlistButton3.setOnAction(actionEvent -> {
            idActivePlaylist = 2;
            sd.setLikeCounter(0);
            sd.setLastCounterChange(14);
            scrollPane3.setVisible(true);
            scrollPane4.setVisible(false);
            playlistsPane.setVisible(false);
            filters = "playlist3";
            removePlaylistButton.setVisible(true);
            likeNext(sd, "playlist3");
        });
        playlistButton4.setOnAction(actionEvent -> {
            idActivePlaylist = 3;
            sd.setLikeCounter(0);
            sd.setLastCounterChange(14);
            scrollPane3.setVisible(true);
            scrollPane4.setVisible(false);
            playlistsPane.setVisible(false);
            filters = "playlist4";
            removePlaylistButton.setVisible(true);
            likeNext(sd, "playlist4");
        });
        playlistButton5.setOnAction(actionEvent -> {
            idActivePlaylist = 4;
            sd.setLikeCounter(0);
            sd.setLastCounterChange(14);
            scrollPane3.setVisible(true);
            scrollPane4.setVisible(false);
            playlistsPane.setVisible(false);
            filters = "playlist5";
            removePlaylistButton.setVisible(true);
            likeNext(sd, "playlist5");
        });
        nextLikeIcon.setOnMouseClicked(mouseEvent -> {
            sd.setLikeCounter(0);
            sd.setLastCounterChange(14);
            scrollPane3.setVisible(true);
            scrollPane4.setVisible(false);
            playlistsPane.setVisible(false);
            filters = "like";
            removePlaylistButton.setVisible(false);
            likeNext(sd, "like");
        });
        nextIcon1.setOnMouseClicked(mouseEvent -> {
            sd.setLikeCounter(0);
            sd.setLastCounterChange(14);
            scrollPane3.setVisible(true);
            scrollPane4.setVisible(false);
            playlistsPane.setVisible(false);
            filters = "playlist1";
            removePlaylistButton.setVisible(true);
            likeNext(sd, "playlist1");
        });
        nextIcon2.setOnMouseClicked(mouseEvent -> {
            sd.setLikeCounter(0);
            sd.setLastCounterChange(14);
            scrollPane3.setVisible(true);
            scrollPane4.setVisible(false);
            playlistsPane.setVisible(false);
            filters = "playlist2";
            removePlaylistButton.setVisible(true);
            likeNext(sd, "playlist2");
        });
        nextIcon3.setOnMouseClicked(mouseEvent -> {
            sd.setLikeCounter(0);
            sd.setLastCounterChange(14);
            scrollPane3.setVisible(true);
            scrollPane4.setVisible(false);
            playlistsPane.setVisible(false);
            filters = "playlist3";
            removePlaylistButton.setVisible(true);
            likeNext(sd, "playlist3");
        });
        nextIcon4.setOnMouseClicked(mouseEvent -> {
            sd.setLikeCounter(0);
            sd.setLastCounterChange(14);
            scrollPane3.setVisible(true);
            scrollPane4.setVisible(false);
            playlistsPane.setVisible(false);
            filters = "playlist4";
            removePlaylistButton.setVisible(true);
            likeNext(sd, "playlist4");
        });
        nextIcon5.setOnMouseClicked(mouseEvent -> {
            sd.setLikeCounter(0);
            sd.setLastCounterChange(14);
            scrollPane3.setVisible(true);
            scrollPane4.setVisible(false);
            playlistsPane.setVisible(false);
            filters = "playlist5";
            removePlaylistButton.setVisible(true);
            likeNext(sd, "playlist5");
        });
        backLikeButton.setOnAction(event -> {
            likeBack(sd);
        });
        nextLikeButton.setOnAction(event -> {
            likeNext(sd, filters);
        });

        title6.setOnAction(event -> {
            likeDishView(sd, title6.getText());
        });
        title7.setOnAction(event -> {
            likeDishView(sd, title7.getText());
        });
        title8.setOnAction(event -> {
            likeDishView(sd, title8.getText());
        });
        title9.setOnAction(event -> {
            likeDishView(sd, title9.getText());
        });
        title10.setOnAction(event -> {
            likeDishView(sd, title10.getText());
        });
        title11.setOnAction(event -> {
            likeDishView(sd, title11.getText());
        });
        title12.setOnAction(event -> {
            likeDishView(sd, title12.getText());
        });
        title13.setOnAction(event -> {
            likeDishView(sd, title13.getText());
        });
        title14.setOnAction(event -> {
            likeDishView(sd, title14.getText());
        });
        title15.setOnAction(event -> {
            likeDishView(sd, title15.getText());
        });
        title16.setOnAction(event -> {
            likeDishView(sd, title16.getText());
        });
        title17.setOnAction(event -> {
            likeDishView(sd, title17.getText());
        });
        title18.setOnAction(event -> {
            likeDishView(sd, title18.getText());
        });
        title19.setOnAction(event -> {
            likeDishView(sd, title19.getText());
        });
        title20.setOnAction(event -> {
            likeDishView(sd, title20.getText());
        });

        likeFieldForLikedDish.setOnMouseClicked(event -> {
          /*  String title = likeDishTitle.getText();
            if (sd.getLikedDishes().indexOf(title) != -1) {
                likeFieldForLikedDish.setImage(new Image(new File(Settings.getImageDir() + "noliked.png").toURI().toString()));
                sd.getLikedDishes().remove(title);
                sd.getLike().remove(title);
                Account account = new Account();
                sd.removeLikedDishes(account.getIdUser(), title);
            } else {
                likeFieldForLikedDish.setImage(new Image(new File(Settings.getImageDir() + "liked.png").toURI().toString()));
                sd.getLikedDishes().add(title);
                Account account = new Account();
                sd.saveLikedDishes(account.getIdUser(), title);
                sd.reloadLikedDishes();
            }*/
        });
        backToPlaylistsButton.setOnAction(actionEvent -> {
            sd.setLikeLastCounterChange(15);
            sd.setLikeCounter(0);
            scrollPane4.setVisible(false);
            scrollPane3.setVisible(false);
            playlistsPane.setVisible(true);
        });
        likeBackToCategoryButton.setOnAction(event -> {
            sd.setLikeLastCounterChange(15);
            sd.setLikeCounter(0);
            likeNext(sd, filters);
            scrollPane4.setVisible(false);
            scrollPane3.setVisible(true);
        });
        addPlaylistsButton.setOnAction(actionEvent -> {
            TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("RecipeBook");
            dialog.setHeaderText(null);
            dialog.setContentText("Введіть назву нового списка відтворення(" + sd.getPlaylists().size() + "/5)");
            dialog.initStyle(StageStyle.UTILITY);
            dialog.setResizable(false);
            Optional<String> result = dialog.showAndWait();
            result.ifPresent(name -> {
                if (sd.getPlaylists().size() < 5) {
                    Playlist playlist = new Playlist(SaveLoad.addPlaylist(account.getIdUser(), name), name, new ArrayList<>());
                    sd.getPlaylists().add(playlist);
                    playlistsPaneRedraw(sd);
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("RecipeBook");
                    alert.setHeaderText(null);
                    alert.setContentText("У вас вже є 5 списків відтворень, ви досягли ліміту!");
                    alert.showAndWait();
                }
            });
        });
        removePlaylistsButton.setOnAction(actionEvent -> {
            List<String> choices = new ArrayList<>();
            if (sd.getPlaylists().size() != 0) {
                for (int i = 0; i < sd.getPlaylists().size(); i++) {
                    choices.add(sd.getPlaylists().get(i).getTitle());
                }
            } else {
                choices.add("У вас немає списків відтворення");
            }
            ChoiceDialog<String> dialog = new ChoiceDialog<>("Виберіть список відтворення", choices);
            dialog.setTitle("RecipeBook");
            dialog.setHeaderText(null);
            dialog.setContentText("Видалить список відтворення");
            dialog.initStyle(StageStyle.UTILITY);
            dialog.setResizable(false);
            Optional<String> result = dialog.showAndWait();
            result.ifPresent(letter -> {
                if (letter != "Виберіть список відтворення" && letter != "У вас немає списків відтворення") {
                    for (int i = 0; i < sd.getPlaylists().size(); i++) {
                        if (sd.getPlaylists().get(i).getTitle() == letter) {
                            SaveLoad.removePlaylist(sd.getPlaylists().get(i).getId());
                            sd.getPlaylists().remove(sd.getPlaylists().get(i));
                            playlistsPaneRedraw(sd);
                            break;
                        }
                    }
                }
            });
        });
        likeAddInFavouriteButton.setOnMouseClicked(mouseEvent -> {
            List<String> choices = new ArrayList<>();
            if (sd.getPlaylists().size() != 0) {
                for (int i = 0; i < sd.getPlaylists().size(); i++) {
                    choices.add(sd.getPlaylists().get(i).getTitle());
                }
            } else {
                choices.add("Добавте список відтворення на вкладці бібліотека");
            }
            ChoiceDialog<String> dialog = new ChoiceDialog<>("Виберіть список відтворення", choices);
            dialog.setTitle("RecipeBook");
            dialog.setHeaderText(null);
            dialog.setContentText("Добавте страву в список відтворення");
            dialog.initStyle(StageStyle.UTILITY);
            dialog.setResizable(false);
            Optional<String> result = dialog.showAndWait();
            result.ifPresent(letter -> {
                if (letter != "Виберіть список відтворення" && letter != "Добавте список відтворення на вкладці бібліотека") {
                    for (int i = 0; i < sd.getPlaylists().size(); i++) {
                        if (sd.getPlaylists().get(i).getTitle() == letter) {
                            boolean b = true;
                            for (int j = 0; j < sd.getPlaylists().get(i).getDishes().size(); j++) {
                                if (sd.getPlaylists().get(i).getDishes().get(j).getTitle().equals(activeDish.getTitle())) {
                                    b = false;
                                    break;
                                }
                            }
                            if (b) {
                                SaveLoad.addDishInPlaylist(sd.getPlaylists().get(i).getId(), activeDish.getId());
                                sd.getPlaylists().get(i).getDishes().add(activeDish);
                            }
                            break;
                        }
                    }
                }
            });
        });
        removeDishInPlaylistButton.setOnAction(actionEvent -> {
            List<String> choices = new ArrayList<>();
            int listSize;
            if (idActivePlaylist != -1) {
                listSize = sd.getPlaylists().get(idActivePlaylist).getDishes().size();
                if (listSize != 0) {
                    for (int i = 0; i < sd.getPlaylists().get(idActivePlaylist).getDishes().size(); i++) {
                        choices.add(sd.getPlaylists().get(idActivePlaylist).getDishes().get(i).getTitle());
                    }
                } else {
                    choices.add("У цьому спискі немає страв");
                }
                ChoiceDialog<String> dialog = new ChoiceDialog<>("Виберіть страву", choices);
                dialog.setTitle("RecipeBook");
                dialog.setHeaderText(null);
                dialog.setContentText("Видалить страву з списка");
                dialog.initStyle(StageStyle.UTILITY);
                dialog.setResizable(false);
                Optional<String> result = dialog.showAndWait();
                result.ifPresent(letter -> {
                    if (letter != "Виберіть страву" && letter != "У цьому спискі немає страв") {
                        for (int i = 0; i < sd.getPlaylists().get(idActivePlaylist).getDishes().size(); i++) {
                            if (sd.getPlaylists().get(idActivePlaylist).getDishes().get(i).getTitle().equals(letter)) {
                                SaveLoad.removeDishInPlaylist(sd.getPlaylists().get(idActivePlaylist).getId(), sd.getPlaylists().get(idActivePlaylist).getDishes().get(i).getId());
                                sd.getPlaylists().get(idActivePlaylist).getDishes().remove(sd.getPlaylists().get(idActivePlaylist).getDishes().get(i));
                                sd.setLikeCounter(0);
                                sd.setLikeLastCounterChange(14);
                                likeNext(sd, "playlist" + (idActivePlaylist + 1));
                                break;
                            }
                        }
                    }
                });
            } else {
                listSize = sd.getLike().size();
                if (listSize != 0) {
                    for (int i = 0; i < listSize; i++) {
                        choices.add(sd.getLike().get(i).getTitle());
                    }
                } else {
                    choices.add("У цьому спискі немає страв");
                }
                ChoiceDialog<String> dialog = new ChoiceDialog<>("Виберіть страву", choices);
                dialog.setTitle("RecipeBook");
                dialog.setHeaderText(null);
                dialog.setContentText("Видалить страву з списка");
                dialog.initStyle(StageStyle.UTILITY);
                dialog.setResizable(false);
                Optional<String> result = dialog.showAndWait();
                result.ifPresent(letter -> {
                    if (letter != "Виберіть страву" && letter != "У цьому спискі немає страв") {
                        for (int i = 0; i < sd.getLike().size(); i++) {
                            if (sd.getLike().get(i).getTitle().equals(letter)) {
                                SaveLoad.removeLikedDishes(account.getIdUser(), sd.getLike().get(i).getId());
                                sd.getLike().remove(sd.getLike().get(i));
                                sd.setLikeCounter(0);
                                sd.setLikeLastCounterChange(14);
                                likeNext(sd, "like");
                                break;
                            }
                        }
                    }
                });
            }
        });
        removePlaylistButton.setOnAction(actionEvent -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("RecipeBook");
            alert.setHeaderText(null);
            alert.setContentText("Ви справді хочете видалити цей список?");

            Optional<ButtonType> option = alert.showAndWait();

            if (option.get() != null) {
                if (option.get() == ButtonType.OK) {
                    SaveLoad.removePlaylist(sd.getPlaylists().get(idActivePlaylist).getId());
                    sd.getPlaylists().remove(idActivePlaylist);
                    playlistsPane.setVisible(true);
                    scrollPane3.setVisible(false);
                    playlistsPaneRedraw(sd);
                }
            }
        });

        /**
         * Settings page
         */
        settingsPane.setVisible(true);
        changeUserInfoPain.setVisible(false);
        aboutUsOrSupportPane.setVisible(false);
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
        aboutUsButton.setOnAction(event -> {
            settingsPane.setVisible(false);
            changeUserInfoPain.setVisible(false);
            aboutUsOrSupportPane.setVisible(true);
            aboutUsOrSupportLabel.setText("1");
        });
        supportButton.setOnAction(event -> {
            settingsPane.setVisible(false);
            changeUserInfoPain.setVisible(false);
            aboutUsOrSupportPane.setVisible(true);
            aboutUsOrSupportLabel.setText("2");
        });
        changeUserInfoButton.setOnAction(event -> {
            settingsPane.setVisible(false);
            changeUserInfoPain.setVisible(true);
            aboutUsOrSupportPane.setVisible(false);
        });
        backBtn.setOnAction(event -> {
            settingsPane.setVisible(true);
            changeUserInfoPain.setVisible(false);
            aboutUsOrSupportPane.setVisible(false);
        });
        backBtn1.setOnAction(event -> {
            settingsPane.setVisible(true);
            changeUserInfoPain.setVisible(false);
            aboutUsOrSupportPane.setVisible(false);
        });
        changeMail.setOnAction(event -> {
            if (mailLabel.getText().equals(repeatMailLabel.getText()) && !mailLabel.getText().equals("")) {
                if (Filter.verifyMail(mailLabel.getText()) == true) {
                    DatabaseHandler databaseHandler = new DatabaseHandler();
                    databaseHandler.changeMail(account.getMail(), mailLabel.getText());
                    changeMailErrorField.setText(Text.get("SUCCESSFUL_REPLACEMENT_MAIL"));
                    account.setMail(mailLabel.getText());
                    mailLabel.clear();
                    repeatMailLabel.clear();
                } else {
                    changeMailErrorField.setText(Text.get("CHANGE_MAIL_BAD_MAIL_ERROR"));
                }
            } else {
                changeMailErrorField.setText(Text.get("CHANGE_EMPTY_ERROR"));
            }
        });
        changePassword.setOnAction(event -> {
            if (passwordLabel.getText().equals(repeatPasswordLabel.getText()) && !passwordLabel.getText().equals("")) {
                if (Filter.verifyPassword(passwordLabel.getText()) == true) {
                    DatabaseHandler databaseHandler = new DatabaseHandler();
                    databaseHandler.changePassword(account.getMail(), account.getPassword(), passwordLabel.getText());
                    changePasswordErrorField.setText(Text.get("SUCCESSFUL_REPLACEMENT_PASSWORD"));
                    account.setPassword(passwordLabel.getText());
                    passwordLabel.clear();
                    repeatPasswordLabel.clear();
                } else {
                    changePasswordErrorField.setText(Text.get("CHANGE_PASSWORD_BAD_PASSWORD_ERROR"));
                }
            } else {
                changePasswordErrorField.setText(Text.get("CHANGE_EMPTY_ERROR"));
            }
        });
    }

    private void playlistsPaneRedraw(SaveData sd) {
        nextLikeIcon.setVisible(true);
        nextIcon1.setVisible(true);
        nextIcon2.setVisible(true);
        nextIcon3.setVisible(true);
        nextIcon4.setVisible(true);
        nextIcon5.setVisible(true);
        playlistButton1.setVisible(true);
        playlistButton2.setVisible(true);
        playlistButton3.setVisible(true);
        playlistButton4.setVisible(true);
        playlistButton5.setVisible(true);
        nextIcon1.setVisible(true);
        sd.setLikeLastCounterChange(15);
        sd.setLikeCounter(0);
        int i = 0;
        if (sd.getPlaylists().size() > i) {
            playlistButton1.setText(sd.getPlaylists().get(i).getTitle());
            i++;
        } else {
            nextIcon1.setVisible(false);
            playlistButton1.setVisible(false);
        }
        if (sd.getPlaylists().size() > i) {
            playlistButton2.setText(sd.getPlaylists().get(i).getTitle());
            i++;
        } else {
            nextIcon2.setVisible(false);
            playlistButton2.setVisible(false);
        }
        if (sd.getPlaylists().size() > i) {
            playlistButton3.setText(sd.getPlaylists().get(i).getTitle());
            i++;
        } else {
            nextIcon3.setVisible(false);
            playlistButton3.setVisible(false);
        }
        if (sd.getPlaylists().size() > i) {
            playlistButton4.setText(sd.getPlaylists().get(i).getTitle());
            i++;
        } else {
            nextIcon4.setVisible(false);
            playlistButton4.setVisible(false);
        }
        if (sd.getPlaylists().size() > i) {
            playlistButton5.setText(sd.getPlaylists().get(i).getTitle());
            i++;
        } else {
            nextIcon5.setVisible(false);
            playlistButton5.setVisible(false);
        }
    }

    /**
     * Home page
     **/
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
        } else if (filter == "Напої") {
            list = sd.getC7();
        } else {
            list = sd.getDishes();
        }

        int counter = sd.getCounter();
        if (counter == 0) counter = -1;
        int listSize = list.size();

        title1.setVisible(true);
        title2.setVisible(true);
        title3.setVisible(true);
        title4.setVisible(true);
        title5.setVisible(true);
        image1.setVisible(true);
        image2.setVisible(true);
        image3.setVisible(true);
        image4.setVisible(true);
        image5.setVisible(true);
        descriptionLabel1.setVisible(true);
        descriptionLabel2.setVisible(true);
        descriptionLabel3.setVisible(true);
        descriptionLabel4.setVisible(true);
        descriptionLabel5.setVisible(true);

        if (counter < listSize - 1) {
            if (counter + 1 < listSize) {
                counter++;
                title1.setText(list.get(counter).getTitle());
                image1.setImage(new Image(new File(Settings.getImageDir() + list.get(counter).getPhoto()).toURI().toString()));
                descriptionLabel1.setText(list.get(counter).getDescription());
            } else {
                title1.setVisible(false);
                image1.setVisible(false);
                descriptionLabel1.setVisible(false);
            }
            if (counter + 1 < listSize) {
                counter++;
                title2.setText(list.get(counter).getTitle());
                image2.setImage(new Image(new File(Settings.getImageDir() + list.get(counter).getPhoto()).toURI().toString()));
                descriptionLabel2.setText(list.get(counter).getDescription());
            } else {
                title2.setVisible(false);
                image2.setVisible(false);
                descriptionLabel2.setVisible(false);
            }
            if (counter + 1 < listSize) {
                counter++;
                title3.setText(list.get(counter).getTitle());
                image3.setImage(new Image(new File(Settings.getImageDir() + list.get(counter).getPhoto()).toURI().toString()));
                descriptionLabel3.setText(list.get(counter).getDescription());
            } else {
                title3.setVisible(false);
                image3.setVisible(false);
                descriptionLabel3.setVisible(false);
            }
            if (counter + 1 < listSize) {
                counter++;
                title4.setText(list.get(counter).getTitle());
                image4.setImage(new Image(new File(Settings.getImageDir() + list.get(counter).getPhoto()).toURI().toString()));
                descriptionLabel4.setText(list.get(counter).getDescription());
            } else {
                title4.setVisible(false);
                image4.setVisible(false);
                descriptionLabel4.setVisible(false);
            }
            if (counter + 1 < listSize) {
                counter++;
                title5.setText(list.get(counter).getTitle());
                image5.setImage(new Image(new File(Settings.getImageDir() + list.get(counter).getPhoto()).toURI().toString()));
                descriptionLabel5.setText(list.get(counter).getDescription());
            } else {
                title5.setVisible(false);
                image5.setVisible(false);
                descriptionLabel5.setVisible(false);
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
                if ((counter + 2) % 10 == 0) {
                    nextButton.setLayoutY(700);
                    backButton.setLayoutY(700);
                    frameScrollPane.setMinHeight(800);
                    frameScrollPane.setMaxHeight(800);
                    frameScrollPane.setPrefHeight(800);
                } else {
                    frameScrollPane.setMinHeight(670);
                    frameScrollPane.setMaxHeight(670);
                    frameScrollPane.setPrefHeight(670);
                    nextButton.setLayoutY(580);
                    backButton.setLayoutY(580);
                }
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
        image1.setVisible(true);
        image2.setVisible(true);
        image3.setVisible(true);
        image4.setVisible(true);
        image5.setVisible(true);
        descriptionLabel1.setVisible(true);
        descriptionLabel2.setVisible(true);
        descriptionLabel3.setVisible(true);
        descriptionLabel4.setVisible(true);
        descriptionLabel5.setVisible(true);
        if (lastCounterChange != 5 && counter - lastCounterChange - 4 >= 0) {
            counter = counter - (lastCounterChange + 4);
        } else {
            counter -= lastCounterChange;
        }
        counter--;
        if (counter >= -1) {
            if (counter + 1 < listSize) {
                counter++;
                title1.setText(list.get(counter).getTitle());
                image1.setImage(new Image(new File(Settings.getImageDir() + list.get(counter).getPhoto()).toURI().toString()));
                descriptionLabel1.setText(list.get(counter).getDescription());
            } else {
                title1.setVisible(false);
                image1.setVisible(false);
                descriptionLabel1.setVisible(false);
            }
            if (counter + 1 < listSize) {
                counter++;
                title2.setText(list.get(counter).getTitle());
                image2.setImage(new Image(new File(Settings.getImageDir() + list.get(counter).getPhoto()).toURI().toString()));
                descriptionLabel2.setText(list.get(counter).getDescription());
            } else {
                title2.setVisible(false);
                image2.setVisible(false);
                descriptionLabel2.setVisible(false);
            }
            if (counter + 1 < listSize) {
                counter++;
                title3.setText(list.get(counter).getTitle());
                image3.setImage(new Image(new File(Settings.getImageDir() + list.get(counter).getPhoto()).toURI().toString()));
                descriptionLabel3.setText(list.get(counter).getDescription());
            } else {
                title3.setVisible(false);
                image3.setVisible(false);
                descriptionLabel3.setVisible(false);
            }
            if (counter + 1 < listSize) {
                counter++;
                title4.setText(list.get(counter).getTitle());
                image4.setImage(new Image(new File(Settings.getImageDir() + list.get(counter).getPhoto()).toURI().toString()));
                descriptionLabel4.setText(list.get(counter).getDescription());
            } else {
                title4.setVisible(false);
                image4.setVisible(false);
                descriptionLabel4.setVisible(false);
            }
            if (counter + 1 < listSize) {
                counter++;
                title5.setText(list.get(counter).getTitle());
                image5.setImage(new Image(new File(Settings.getImageDir() + list.get(counter).getPhoto()).toURI().toString()));
                descriptionLabel5.setText(list.get(counter).getDescription());
            } else {
                title5.setVisible(false);
                image5.setVisible(false);
                descriptionLabel5.setVisible(false);
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
        image1.setVisible(true);
        image2.setVisible(true);
        image3.setVisible(true);
        image4.setVisible(true);
        image5.setVisible(true);
        descriptionLabel1.setVisible(true);
        descriptionLabel2.setVisible(true);
        descriptionLabel3.setVisible(true);
        descriptionLabel4.setVisible(true);
        descriptionLabel5.setVisible(true);

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
                descriptionLabel1.setText(list.get(counter).getDescription());
            } else {
                title1.setVisible(false);
                image1.setVisible(false);
                descriptionLabel1.setVisible(false);
            }
            if (counter + 1 < listSize) {
                counter++;
                title2.setText(list.get(counter).getTitle());
                image2.setImage(new Image(new File(Settings.getImageDir() + list.get(counter).getPhoto()).toURI().toString()));
                descriptionLabel2.setText(list.get(counter).getDescription());
            } else {
                title2.setVisible(false);
                image2.setVisible(false);
                descriptionLabel2.setVisible(false);
            }
            if (counter + 1 < listSize) {
                counter++;
                title3.setText(list.get(counter).getTitle());
                image3.setImage(new Image(new File(Settings.getImageDir() + list.get(counter).getPhoto()).toURI().toString()));
                descriptionLabel3.setText(list.get(counter).getDescription());
            } else {
                title3.setVisible(false);
                image3.setVisible(false);
                descriptionLabel3.setVisible(false);
            }
            if (counter + 1 < listSize) {
                counter++;
                title4.setText(list.get(counter).getTitle());
                image4.setImage(new Image(new File(Settings.getImageDir() + list.get(counter).getPhoto()).toURI().toString()));
                descriptionLabel4.setText(list.get(counter).getDescription());
            } else {
                title4.setVisible(false);
                image4.setVisible(false);
                descriptionLabel4.setVisible(false);
            }
            if (counter + 1 < listSize) {
                counter++;
                title5.setText(list.get(counter).getTitle());
                image5.setImage(new Image(new File(Settings.getImageDir() + list.get(counter).getPhoto()).toURI().toString()));
                descriptionLabel5.setText(list.get(counter).getDescription());
            } else {
                title5.setVisible(false);
                image5.setVisible(false);
                descriptionLabel5.setVisible(false);
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
            activeDish = dish;
            dishTitle.setText(dish.getTitle());
            dishImage.setImage(new Image(new File(Settings.getImageDir() + dish.getPhoto()).toURI().toString()));
            dishDescription.setText(dish.getDescription());
            String s = "";
            for (int i = 0; i < dish.getRecipe().size(); i++) {
                s += "Етап №" + (i + 1) + "\n" + "     " + dish.getRecipe().get(i);
                if (i != dish.getRecipe().size() - 1) {
                    s += "\n\n";
                }
            }
            dishRecipe.setText(s);
            System.out.println(s + "\n");
            System.out.println(dishRecipe.getPrefHeight() + " " + dishRecipe.getHeight() + " " + dishRecipe.getMaxHeight() + " " + dishRecipe.getBaselineOffset());
            System.out.println(s.length() / 100 * 10 * dish.getRecipe().size());
            dishRecipe.setMinHeight(s.length() / 100 * 10 * dish.getRecipe().size());
            dishRecipe.setMaxHeight(s.length() / 100 * 10 * dish.getRecipe().size());
            //зробить самоизменяющийся размер у label dishRecipe
            //убрать дублірувание інгрідієнтів
            scrollPane.setVisible(false);

            groceryTableView.setPrefHeight(dish.getGroceryList().size() * 25 + 20);

            ObservableList<Shopping> grocery = FXCollections.observableArrayList();
            for (int i = 0; i < dish.getGroceryList().size(); i++) {
                if(dish.getUnitsOfMeasurementList().get(i) == "-") {
                    grocery.add(new Shopping(dish.getGroceryList().get(i), dish.getCountList().get(i)));
                } else {
                    grocery.add(new Shopping(dish.getGroceryList().get(i), dish.getCountList().get(i) + " " + dish.getUnitsOfMeasurementList().get(i)));
                }
            }

            groceryTableView.setItems(grocery);

            TableColumn<Shopping, String> groceryColumn = new TableColumn<>("Продукти");
            groceryColumn.setCellValueFactory(new PropertyValueFactory<>("grocery"));
            groceryTableView.getColumns().add(groceryColumn);

            TableColumn<Shopping, Double> weightColumn = new TableColumn<>("Кількість");
            weightColumn.setCellValueFactory(new PropertyValueFactory<>("weight"));
            groceryTableView.getColumns().add(weightColumn);

            groceryTableView.setVisible(true);

            if (sd.getLike() != null && sd.getLike().indexOf(dish) != -1) {
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

    /**
     * Library page
     **/
    //next
    private void likeNext(SaveData sd, String filter) {
        List<Dish> list;
        if (filter.equals("playlist1")) {
            list = sd.getPlaylists().get(0).getDishes();
        } else if (filter.equals("playlist2")) {
            list = sd.getPlaylists().get(1).getDishes();
        } else if (filter.equals("playlist3")) {
            list = sd.getPlaylists().get(2).getDishes();
        } else if (filter.equals("playlist4")) {
            list = sd.getPlaylists().get(3).getDishes();
        } else if (filter.equals("playlist5")) {
            list = sd.getPlaylists().get(4).getDishes();
        } else {
            list = sd.getLike();
        }

        int counter = sd.getLikeCounter();
        if (counter == 0) counter = -1;
        int listSize = list.size();

        title6.setVisible(true);
        title7.setVisible(true);
        title8.setVisible(true);
        title9.setVisible(true);
        title10.setVisible(true);
        title11.setVisible(true);
        title12.setVisible(true);
        title13.setVisible(true);
        title14.setVisible(true);
        title15.setVisible(true);
        title16.setVisible(true);
        title17.setVisible(true);
        title18.setVisible(true);
        title19.setVisible(true);
        title20.setVisible(true);
        image6.setVisible(true);
        image7.setVisible(true);
        image8.setVisible(true);
        image9.setVisible(true);
        image10.setVisible(true);
        image11.setVisible(true);
        image12.setVisible(true);
        image13.setVisible(true);
        image14.setVisible(true);
        image15.setVisible(true);
        image16.setVisible(true);
        image17.setVisible(true);
        image18.setVisible(true);
        image19.setVisible(true);
        image20.setVisible(true);

        if (counter < listSize - 1) {
            if (counter + 1 < listSize) {
                counter++;
                title6.setText(list.get(counter).getTitle());
                image6.setImage(new Image(new File(Settings.getImageDir() + list.get(counter).getPhoto()).toURI().toString()));
            } else {
                title6.setVisible(false);
                image6.setVisible(false);
            }
            if (counter + 1 < listSize) {
                counter++;
                title7.setText(list.get(counter).getTitle());
                image7.setImage(new Image(new File(Settings.getImageDir() + list.get(counter).getPhoto()).toURI().toString()));
            } else {
                title7.setVisible(false);
                image7.setVisible(false);
            }
            if (counter + 1 < listSize) {
                counter++;
                title8.setText(list.get(counter).getTitle());
                image8.setImage(new Image(new File(Settings.getImageDir() + list.get(counter).getPhoto()).toURI().toString()));
            } else {
                title8.setVisible(false);
                image8.setVisible(false);
            }
            if (counter + 1 < listSize) {
                counter++;
                title9.setText(list.get(counter).getTitle());
                image9.setImage(new Image(new File(Settings.getImageDir() + list.get(counter).getPhoto()).toURI().toString()));
            } else {
                title9.setVisible(false);
                image9.setVisible(false);
            }
            if (counter + 1 < listSize) {
                counter++;
                title10.setText(list.get(counter).getTitle());
                image10.setImage(new Image(new File(Settings.getImageDir() + list.get(counter).getPhoto()).toURI().toString()));
            } else {
                title10.setVisible(false);
                image10.setVisible(false);
            }
            if (counter + 1 < listSize) {
                counter++;
                title11.setText(list.get(counter).getTitle());
                image11.setImage(new Image(new File(Settings.getImageDir() + list.get(counter).getPhoto()).toURI().toString()));
            } else {
                title11.setVisible(false);
                image11.setVisible(false);
            }
            if (counter + 1 < listSize) {
                counter++;
                title12.setText(list.get(counter).getTitle());
                image12.setImage(new Image(new File(Settings.getImageDir() + list.get(counter).getPhoto()).toURI().toString()));
            } else {
                title12.setVisible(false);
                image12.setVisible(false);
            }
            if (counter + 1 < listSize) {
                counter++;
                title13.setText(list.get(counter).getTitle());
                image13.setImage(new Image(new File(Settings.getImageDir() + list.get(counter).getPhoto()).toURI().toString()));
            } else {
                title13.setVisible(false);
                image13.setVisible(false);
            }
            if (counter + 1 < listSize) {
                counter++;
                title14.setText(list.get(counter).getTitle());
                image14.setImage(new Image(new File(Settings.getImageDir() + list.get(counter).getPhoto()).toURI().toString()));
            } else {
                title14.setVisible(false);
                image14.setVisible(false);
            }
            if (counter + 1 < listSize) {
                counter++;
                title15.setText(list.get(counter).getTitle());
                image15.setImage(new Image(new File(Settings.getImageDir() + list.get(counter).getPhoto()).toURI().toString()));
            } else {
                title15.setVisible(false);
                image15.setVisible(false);
            }
            if (counter + 1 < listSize) {
                counter++;
                title16.setText(list.get(counter).getTitle());
                image16.setImage(new Image(new File(Settings.getImageDir() + list.get(counter).getPhoto()).toURI().toString()));
            } else {
                title16.setVisible(false);
                image16.setVisible(false);
            }
            if (counter + 1 < listSize) {
                counter++;
                title17.setText(list.get(counter).getTitle());
                image17.setImage(new Image(new File(Settings.getImageDir() + list.get(counter).getPhoto()).toURI().toString()));
            } else {
                title17.setVisible(false);
                image17.setVisible(false);
            }
            if (counter + 1 < listSize) {
                counter++;
                title18.setText(list.get(counter).getTitle());
                image18.setImage(new Image(new File(Settings.getImageDir() + list.get(counter).getPhoto()).toURI().toString()));
            } else {
                title18.setVisible(false);
                image18.setVisible(false);
            }
            if (counter + 1 < listSize) {
                counter++;
                title19.setText(list.get(counter).getTitle());
                image19.setImage(new Image(new File(Settings.getImageDir() + list.get(counter).getPhoto()).toURI().toString()));
            } else {
                title19.setVisible(false);
                image19.setVisible(false);
            }
            if (counter + 1 < listSize) {
                counter++;
                title20.setText(list.get(counter).getTitle());
                image20.setImage(new Image(new File(Settings.getImageDir() + list.get(counter).getPhoto()).toURI().toString()));
            } else {
                title20.setVisible(false);
                image20.setVisible(false);
            }
            if (counter - sd.getLikeCounter() != 0) {
                sd.setLikeLastCounterChange(counter - sd.getLikeCounter());
            }
            sd.setLikeCounter(counter);
            scrollPane3.setVvalue(0);
            if (counter >= listSize - 1) {
                nextLikeButton.setDisable(true);
            }
            if (nextLikeButton.isDisable() && counter - sd.getLikeCounter() >= 0 && counter - sd.getLikeCounter() < 15) {
                if (counter + 1 <= 6) {
                    nextLikeButton.setLayoutY(555);
                    backLikeButton.setLayoutY(555);
                    frameScrollPane1.setMinHeight(670);
                    frameScrollPane1.setMaxHeight(670);
                    frameScrollPane1.setPrefHeight(670);
                } else if (counter + 1 <= 9) {
                    frameScrollPane1.setMinHeight(810);
                    frameScrollPane1.setMaxHeight(810);
                    frameScrollPane1.setPrefHeight(810);
                    nextLikeButton.setLayoutY(720);
                    backLikeButton.setLayoutY(720);
                } else if (counter + 1 <= 12) {
                    frameScrollPane1.setMinHeight(1015);
                    frameScrollPane1.setMaxHeight(1015);
                    frameScrollPane1.setPrefHeight(1015);
                    nextLikeButton.setLayoutY(935);
                    backLikeButton.setLayoutY(935);
                }
            }
        } else {
            title6.setVisible(false);
            title7.setVisible(false);
            title8.setVisible(false);
            title9.setVisible(false);
            title10.setVisible(false);
            title11.setVisible(false);
            title12.setVisible(false);
            title13.setVisible(false);
            title14.setVisible(false);
            title15.setVisible(false);
            title16.setVisible(false);
            title17.setVisible(false);
            title18.setVisible(false);
            title19.setVisible(false);
            title20.setVisible(false);
            image6.setVisible(false);
            image7.setVisible(false);
            image8.setVisible(false);
            image9.setVisible(false);
            image10.setVisible(false);
            image11.setVisible(false);
            image12.setVisible(false);
            image13.setVisible(false);
            image14.setVisible(false);
            image15.setVisible(false);
            image16.setVisible(false);
            image17.setVisible(false);
            image18.setVisible(false);
            image19.setVisible(false);
            image20.setVisible(false);
            nextLikeButton.setDisable(true);
        }
    }

    //back
    private void likeBack(SaveData sd) {
        List<Dish> list = sd.getLike();
        int counter = sd.getLikeCounter();
        int listSize = list.size();
        int lastCounterChange = sd.getLikeLastCounterChange();

        title6.setVisible(true);
        title7.setVisible(true);
        title8.setVisible(true);
        title9.setVisible(true);
        title10.setVisible(true);
        title11.setVisible(true);
        title12.setVisible(true);
        title13.setVisible(true);
        title14.setVisible(true);
        title15.setVisible(true);
        title16.setVisible(true);
        title17.setVisible(true);
        title18.setVisible(true);
        title19.setVisible(true);
        title20.setVisible(true);
        image6.setVisible(true);
        image7.setVisible(true);
        image8.setVisible(true);
        image9.setVisible(true);
        image10.setVisible(true);
        image11.setVisible(true);
        image12.setVisible(true);
        image13.setVisible(true);
        image14.setVisible(true);
        image15.setVisible(true);
        image16.setVisible(true);
        image17.setVisible(true);
        image18.setVisible(true);
        image19.setVisible(true);
        image20.setVisible(true);

        if (lastCounterChange != 15 && counter - lastCounterChange - 14 >= 0) {
            counter -= lastCounterChange + 14;
        } else {
            counter -= lastCounterChange;
        }
        counter--;
        if (counter >= -1) {
            if (counter + 1 < listSize) {
                counter++;
                title6.setText(list.get(counter).getTitle());
                image6.setImage(new Image(new File(Settings.getImageDir() + list.get(counter).getPhoto()).toURI().toString()));
            } else {
                title6.setVisible(false);
                image6.setVisible(false);
            }
            if (counter + 1 < listSize) {
                counter++;
                title7.setText(list.get(counter).getTitle());
                image7.setImage(new Image(new File(Settings.getImageDir() + list.get(counter).getPhoto()).toURI().toString()));
            } else {
                title7.setVisible(false);
                image7.setVisible(false);
            }
            if (counter + 1 < listSize) {
                counter++;
                title8.setText(list.get(counter).getTitle());
                image8.setImage(new Image(new File(Settings.getImageDir() + list.get(counter).getPhoto()).toURI().toString()));
            } else {
                title8.setVisible(false);
                image8.setVisible(false);
            }
            if (counter + 1 < listSize) {
                counter++;
                title9.setText(list.get(counter).getTitle());
                image9.setImage(new Image(new File(Settings.getImageDir() + list.get(counter).getPhoto()).toURI().toString()));
            } else {
                title9.setVisible(false);
                image9.setVisible(false);
            }
            if (counter + 1 < listSize) {
                counter++;
                title10.setText(list.get(counter).getTitle());
                image10.setImage(new Image(new File(Settings.getImageDir() + list.get(counter).getPhoto()).toURI().toString()));
            } else {
                title10.setVisible(false);
                image10.setVisible(false);
            }
            if (counter + 1 < listSize) {
                counter++;
                title11.setText(list.get(counter).getTitle());
                image11.setImage(new Image(new File(Settings.getImageDir() + list.get(counter).getPhoto()).toURI().toString()));
            } else {
                title11.setVisible(false);
                image11.setVisible(false);
            }
            if (counter + 1 < listSize) {
                counter++;
                title12.setText(list.get(counter).getTitle());
                image12.setImage(new Image(new File(Settings.getImageDir() + list.get(counter).getPhoto()).toURI().toString()));
            } else {
                title12.setVisible(false);
                image12.setVisible(false);
            }
            if (counter + 1 < listSize) {
                counter++;
                title13.setText(list.get(counter).getTitle());
                image13.setImage(new Image(new File(Settings.getImageDir() + list.get(counter).getPhoto()).toURI().toString()));
            } else {
                title13.setVisible(false);
                image13.setVisible(false);
            }
            if (counter + 1 < listSize) {
                counter++;
                title14.setText(list.get(counter).getTitle());
                image14.setImage(new Image(new File(Settings.getImageDir() + list.get(counter).getPhoto()).toURI().toString()));
            } else {
                title14.setVisible(false);
                image14.setVisible(false);
            }
            if (counter + 1 < listSize) {
                counter++;
                title15.setText(list.get(counter).getTitle());
                image15.setImage(new Image(new File(Settings.getImageDir() + list.get(counter).getPhoto()).toURI().toString()));
            } else {
                title15.setVisible(false);
                image15.setVisible(false);
            }
            if (counter + 1 < listSize) {
                counter++;
                title16.setText(list.get(counter).getTitle());
                image16.setImage(new Image(new File(Settings.getImageDir() + list.get(counter).getPhoto()).toURI().toString()));
            } else {
                title16.setVisible(false);
                image16.setVisible(false);
            }
            if (counter + 1 < listSize) {
                counter++;
                title17.setText(list.get(counter).getTitle());
                image17.setImage(new Image(new File(Settings.getImageDir() + list.get(counter).getPhoto()).toURI().toString()));
            } else {
                title17.setVisible(false);
                image17.setVisible(false);
            }
            if (counter + 1 < listSize) {
                counter++;
                title18.setText(list.get(counter).getTitle());
                image18.setImage(new Image(new File(Settings.getImageDir() + list.get(counter).getPhoto()).toURI().toString()));
            } else {
                title18.setVisible(false);
                image18.setVisible(false);
            }
            if (counter + 1 < listSize) {
                counter++;
                title19.setText(list.get(counter).getTitle());
                image19.setImage(new Image(new File(Settings.getImageDir() + list.get(counter).getPhoto()).toURI().toString()));
            } else {
                title19.setVisible(false);
                image19.setVisible(false);
            }
            if (counter + 1 < listSize) {
                counter++;
                title20.setText(list.get(counter).getTitle());
                image20.setImage(new Image(new File(Settings.getImageDir() + list.get(counter).getPhoto()).toURI().toString()));
            } else {
                title20.setVisible(false);
                image20.setVisible(false);
            }
            sd.setLastCounterChange(15);
            sd.setCounter(counter);
            scrollPane.setVvalue(0);
            if (counter == 14) {
                backButton.setDisable(true);
            }
        } else {
            backButton.setDisable(true);
        }
    }

    private void likeDishView(SaveData sd, String title) {
        scrollPane3.setVisible(false);
        scrollPane4.setVisible(true);
        scrollPane4.setVvalue(0);
        Dish dish = null;
        for (int i = 0; i < sd.getDishes().size(); i++) {
            if (sd.getDishes().get(i).getTitle().equals(title)) {
                dish = sd.getDishes().get(i);
            }
        }
        System.out.println();
        if (dish != null) {
            activeDish = dish;
            likeDishTitle.setText(dish.getTitle());
            likeDishImage.setImage(new Image(new File(Settings.getImageDir() + dish.getPhoto()).toURI().toString()));
            likeDishDescription.setText(dish.getDescription());
            String s = "";
            for (int i = 0; i < dish.getRecipe().size(); i++) {
                s += "Етап №" + (i + 1) + "\n" + "     " + dish.getRecipe().get(i);
                if (i != dish.getRecipe().size() - 1) {
                    s += "\n\n";
                }
            }
            likeDishRecipe.setText(s);
            System.out.println(s + "\n");
            System.out.println(dishRecipe.getPrefHeight() + " " + dishRecipe.getHeight() + " " + dishRecipe.getMaxHeight() + " " + dishRecipe.getBaselineOffset());
            System.out.println(s.length() / 100 * 10 * dish.getRecipe().size());
            likeDishRecipe.setMinHeight(s.length() / 100 * 10 * dish.getRecipe().size());
            likeDishRecipe.setMaxHeight(s.length() / 100 * 10 * dish.getRecipe().size());
            //зробить самоизменяющийся размер у label dishRecipe
            //убрать дублірувание інгрідієнтів

            groceryTableView.setPrefHeight(dish.getGroceryList().size() * 25 + 20);

            ObservableList<Shopping> grocery = FXCollections.observableArrayList();
            Shopping shopping = new Shopping();
            for (int i = 0; i < dish.getGroceryList().size(); i++) {
                if (dish.getUnitsOfMeasurementList().get(i) == "-") {
                    grocery.add(new Shopping(dish.getGroceryList().get(i), dish.getCountList().get(i)));
                } else {
                    grocery.add(new Shopping(dish.getGroceryList().get(i), dish.getCountList().get(i) + " " + dish.getUnitsOfMeasurementList().get(i)));
                }
            }
            likeGroceryTableView.setItems(grocery);

            TableColumn<Shopping, String> groceryColumn = new TableColumn<>("Продукти");
            groceryColumn.setCellValueFactory(new PropertyValueFactory<>("grocery"));
            likeGroceryTableView.getColumns().add(groceryColumn);

            TableColumn<Shopping, Double> weightColumn = new TableColumn<>("Вага");
            weightColumn.setCellValueFactory(new PropertyValueFactory<>("weight"));
            likeGroceryTableView.getColumns().add(weightColumn);

            likeGroceryTableView.setVisible(true);

            if (sd.getLike() != null && sd.getLike().indexOf(dish) != -1) {
                likeFieldForLikedDish.setImage(new Image(new File(Settings.getImageDir() + "liked.png").toURI().toString()));
            } else {
                likeFieldForLikedDish.setImage(new Image(new File(Settings.getImageDir() + "noliked.png").toURI().toString()));
            }
        }
    }
}