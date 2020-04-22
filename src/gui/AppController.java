package gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.StageStyle;
import login.Filter;
import login.Login;
import login.SaveLoadRemote;
import model.*;
import settings.Text;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class AppController {

    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    Dish activeDish1;
    @FXML
    private ScrollPane homeScroll;
    @FXML
    private AnchorPane homePagePane;
    @FXML
    private ComboBox<String> filterComboBoxOnHomePage;
    @FXML
    private Button title1OnHomePage;
    @FXML
    private Button title2OnHomePage;
    @FXML
    private Button title3OnHomePage;
    @FXML
    private Button title4OnHomePage;
    @FXML
    private Button title5OnHomePage;
    @FXML
    private ImageView image1OnHomePage;
    @FXML
    private ImageView image2OnHomePage;
    @FXML
    private ImageView image3OnHomePage;
    @FXML
    private ImageView image4OnHomePage;
    @FXML
    private ImageView image5OnHomePage;
    Account account = new Account();
    SaveData sd = account.getSaveData();
    String filters;
    Dish activeDish2;
    @FXML
    private Tab homeTab;
    int idActivePlaylist = -1;
    @FXML
    private Label description1OnHomePage;
    @FXML
    private Button nextButtonOnHomePage;
    @FXML
    private ScrollPane dishViewOnHomePageScroll;
    @FXML
    private AnchorPane dishViewOnHomePagePane;
    @FXML
    private Label dishTitleInDishViewOnHomePage;
    @FXML
    private ImageView dishImageInDishViewOnHomePage;
    @FXML
    private Label dishDescriptionInDishViewOnHomePage;
    @FXML
    private Label description2OnHomePage;
    @FXML
    private Label description3OnHomePage;
    @FXML
    private Label description4OnHomePage;
    @FXML
    private Label description5OnHomePage;
    @FXML
    private Button backButtonOnHomePage;
    @FXML
    private Label dishRecipeInDishViewOnHomePage;
    @FXML
    private Label numberOfLikeInDishViewOnHomePage;
    @FXML
    private TableView<Shopping> groceryTableViewInDishViewOnHomePage;
    @FXML
    private ImageView likeFieldInDishViewOnHomePage;
    @FXML
    private ImageView addInFavouriteButtonInDishViewOnHomePage;
    @FXML
    private Button backToCategoryButtonInDishViewOnHomePage;
    @FXML
    private Tab libraryTab;
    @FXML
    private AnchorPane playlistsPaneOnLibraryPage;
    @FXML
    private Button likePlaylistButtonOnLibraryPage;
    @FXML
    private Button playlistButton1OnLibraryPage;
    @FXML
    private Button playlistButton2OnLibraryPage;
    @FXML
    private Button playlistButton3OnLibraryPage;
    @FXML
    private Button playlistButton4OnLibraryPage;
    @FXML
    private Button playlistButton5OnLibraryPage;
    @FXML
    private ImageView likeListIconOnLibraryPage;
    @FXML
    private ImageView playlistIcon1OnLibraryPage;
    @FXML
    private ImageView playlistIcon2OnLibraryPage;
    @FXML
    private ImageView playlistIcon3OnLibraryPage;
    @FXML
    private ImageView playlistIcon4OnLibraryPage;
    @FXML
    private ImageView playlistIcon5OnLibraryPage;
    @FXML
    private Button addPlaylistsButtonOnLibraryPage;
    @FXML
    private Button removePlaylistsButtonOnLibraryPage;
    @FXML
    private ScrollPane libraryPageScroll;
    @FXML
    private AnchorPane libraryPagePane;
    @FXML
    private Button removeDishInPlaylistButton;
    @FXML
    private Button removePlaylistButton;
    @FXML
    private Label numberOfLikeInDishViewOnLibraryPage;
    @FXML
    private ImageView image1OnLibraryPage;
    @FXML
    private ImageView image2OnLibraryPage;
    @FXML
    private ImageView image3OnLibraryPage;
    @FXML
    private Button title1OnLibraryPage;
    @FXML
    private Button title2OnLibraryPage;
    @FXML
    private Button title3OnLibraryPage;
    @FXML
    private ImageView image4OnLibraryPage;
    @FXML
    private ImageView image5OnLibraryPage;
    @FXML
    private ImageView image6OnLibraryPage;
    @FXML
    private Button title4OnLibraryPage;
    @FXML
    private Button title5OnLibraryPage;
    @FXML
    private Button title6OnLibraryPage;
    @FXML
    private ImageView image7OnLibraryPage;
    @FXML
    private ImageView image8OnLibraryPage;
    @FXML
    private ImageView image9OnLibraryPage;
    @FXML
    private Button title7OnLibraryPage;
    @FXML
    private Button title8OnLibraryPage;
    @FXML
    private Button title9OnLibraryPage;
    @FXML
    private ImageView image10OnLibraryPage;
    @FXML
    private ImageView image11OnLibraryPage;
    @FXML
    private ImageView image12OnLibraryPage;
    @FXML
    private Button title10OnLibraryPage;
    @FXML
    private Button title11OnLibraryPage;
    @FXML
    private Button title12OnLibraryPage;
    @FXML
    private ImageView image13OnLibraryPage;
    @FXML
    private ImageView image14OnLibraryPage;
    @FXML
    private ImageView image15OnLibraryPage;
    @FXML
    private Button title13OnLibraryPage;
    @FXML
    private Button title14OnLibraryPage;
    @FXML
    private Button title15OnLibraryPage;
    @FXML
    private Button backToPlaylistsButtonOnLibraryPage;
    @FXML
    private Button nextButtonOnLibraryPage;
    @FXML
    private ScrollPane dishViewScrollOnLibraryPage;
    @FXML
    private AnchorPane dishViewPaneOnLibraryPage;
    @FXML
    private Label dishTitleInDishViewOnLibraryPage;
    @FXML
    private ImageView dishImageInDishViewOnLibraryPage;
    @FXML
    private Label dishRecipeInDishViewOnLibraryPage;
    @FXML
    private Label dishDescriptionInDishViewOnLibraryPage;
    @FXML
    private TableView<Shopping> groceryTableViewInDishViewOnLibraryPage;
    @FXML
    private ImageView likeFieldInDishViewOnLibraryPage;
    @FXML
    private ImageView addInFavouriteButtonInDishViewOnLibraryPage;
    @FXML
    private Button removeDishInDishViewOnLibraryPage;
    @FXML
    private Button backToCategoryButtonInDishViewOnLibraryPage;
    @FXML
    private Button backButtonOnLibraryPage;
    @FXML
    private AnchorPane settingsMenuPane;
    @FXML
    private Button aboutUsButton;
    @FXML
    private Button supportButton;
    @FXML
    private Button changeUserInfoButton;
    @FXML
    private Button exitButton;
    @FXML
    private AnchorPane changeUserInfoPain;
    @FXML
    private Button backToMenuSettingsButtonFromChangeUserInfoPain;
    @FXML
    private Button changePassword;
    @FXML
    private TextField passwordLabel;
    @FXML
    private TextField repeatPasswordLabel;
    @FXML
    private Label changePasswordErrorField;
    @FXML
    private AnchorPane aboutUsPane;
    @FXML
    private Label aboutUsLabel;
    @FXML
    private Button backToSettingsMenuFromAboutUsPaneButton;
    @FXML
    private Button changeUsername;
    @FXML
    private TextField usernameLabel;
    @FXML
    private ComboBox<String> locationField;
    @FXML
    private Button changeLocation;

    @FXML
    void initialize() {
        init();
        /*Home page*/
        homeTab.setOnSelectionChanged(event -> {
            if (homeScroll.isVisible()) {
                sd.setCounter(sd.getCounter() - sd.getLastCounterChange());
                sd.setLastCounterChange(14);
                if (filterComboBoxOnHomePage.getValue() == null) next("Всі страви");
                else next(filterComboBoxOnHomePage.getValue());
            } else if (dishViewOnHomePagePane.isVisible() && activeDish1 != null) {
                dishView(activeDish1.getTitle());
            }
        });
        filterComboBoxOnHomePage.setOnAction(event -> {
            backButtonOnHomePage.setDisable(true);
            nextButtonOnHomePage.setDisable(false);
            nextButtonOnHomePage.setLayoutY(850);
            backButtonOnHomePage.setLayoutY(850);
            homePagePane.setMinHeight(959);
            homePagePane.setMaxHeight(959);
            homePagePane.setPrefHeight(959);
            sd.setCounter(0);
            sd.setLastCounterChange(5);
            if (filterComboBoxOnHomePage.getValue() == null) next("Всі страви");
            else next(filterComboBoxOnHomePage.getValue());
        });
        nextButtonOnHomePage.setOnAction(actionEvent -> {
            backButtonOnHomePage.setDisable(false);
            nextButtonOnHomePage.setDisable(false);
            if (filterComboBoxOnHomePage.getValue() == null) next("Всі страви");
            else next(filterComboBoxOnHomePage.getValue());
        });
        backButtonOnHomePage.setOnAction(actionEvent -> {
            homePagePane.setMinHeight(959);
            homePagePane.setMaxHeight(959);
            homePagePane.setPrefHeight(959);
            nextButtonOnHomePage.setDisable(false);
            homeScroll.setFitToHeight(false);
            nextButtonOnHomePage.setLayoutY(850);
            backButtonOnHomePage.setLayoutY(850);
            if (filterComboBoxOnHomePage.getValue() == null || filterComboBoxOnHomePage.getValue().equals("Всі страви"))
                back("Всі страви");
            else back(filterComboBoxOnHomePage.getValue());
        });
        title1OnHomePage.setOnAction(event -> {
            homeScroll.setVisible(false);
            dishView(title1OnHomePage.getText());
        });
        title2OnHomePage.setOnAction(event -> {
            homeScroll.setVisible(false);
            dishView(title2OnHomePage.getText());
        });
        title3OnHomePage.setOnAction(event -> {
            homeScroll.setVisible(false);
            dishView(title3OnHomePage.getText());
        });
        title4OnHomePage.setOnAction(event -> {
            homeScroll.setVisible(false);
            dishView(title4OnHomePage.getText());
        });
        title5OnHomePage.setOnAction(event -> {
            homeScroll.setVisible(false);
            dishView(title5OnHomePage.getText());
        });
        backToCategoryButtonInDishViewOnHomePage.setOnAction(event -> {
            dishViewOnHomePageScroll.setVisible(false);
            homeScroll.setVisible(true);
        });
        likeFieldInDishViewOnHomePage.setOnMouseClicked(event -> {
            if (sd.getLike().indexOf(activeDish1) != -1) {
                int numberOfLike = activeDish1.getNumberOfLikes();
                removeLikedDish(numberOfLike, activeDish1);
                sd.reloadAllLists();
                likeFieldInDishViewOnHomePage.setImage(new Image("https://cdn4.iconfinder.com/data/icons/app-custom-ui-1/48/Heart-512.png"));
                numberOfLikeInDishViewOnHomePage.setText(String.valueOf(activeDish1.getNumberOfLikes()));
            } else {
                int numberOfLike = activeDish1.getNumberOfLikes();
                addLikedDish(numberOfLike, activeDish1);
                sd.reloadAllLists();
                likeFieldInDishViewOnHomePage.setImage(new Image("https://cdn1.iconfinder.com/data/icons/instagram-ui-flat/48/Instagram_UI-07-512.png"));
                numberOfLikeInDishViewOnHomePage.setText(String.valueOf(activeDish1.getNumberOfLikes()));
            }
        });
        numberOfLikeInDishViewOnHomePage.setOnMouseClicked(mouseEvent -> {
            if (sd.getLike().indexOf(activeDish1) != -1) {
                int numberOfLike = activeDish1.getNumberOfLikes();
                removeLikedDish(numberOfLike, activeDish1);
                sd.reloadAllLists();
                likeFieldInDishViewOnHomePage.setImage(new Image("https://cdn4.iconfinder.com/data/icons/app-custom-ui-1/48/Heart-512.png"));
                numberOfLikeInDishViewOnHomePage.setText(String.valueOf(activeDish1.getNumberOfLikes()));
            } else {
                int numberOfLike = activeDish1.getNumberOfLikes();
                addLikedDish(numberOfLike, activeDish1);
                sd.reloadAllLists();
                likeFieldInDishViewOnHomePage.setImage(new Image("https://cdn1.iconfinder.com/data/icons/instagram-ui-flat/48/Instagram_UI-07-512.png"));
                numberOfLikeInDishViewOnHomePage.setText(String.valueOf(activeDish1.getNumberOfLikes()));
            }
        });
        addInFavouriteButtonInDishViewOnHomePage.setOnMouseClicked(mouseEvent -> {
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
                if (!letter.equals("Виберіть список відтворення") && !letter.equals("У вас немає списків відтворення")) {
                    for (int i = 0; i < sd.getPlaylists().size(); i++) {
                        if (sd.getPlaylists().get(i).getTitle().equals(letter)) {
                            boolean b = true;
                            for (int j = 0; j < sd.getPlaylists().get(i).getDishes().size(); j++) {
                                if (sd.getPlaylists().get(i).getDishes().get(j).getTitle().equals(activeDish1.getTitle())) {
                                    b = false;
                                    break;
                                }
                            }
                            if (b) {
                                SaveLoadRemote.addDishInPlaylist(sd.getPlaylists().get(i).getId(), activeDish1.getId(), account.getMail(), account.getPassword());
                                sd.getPlaylists().get(i).getDishes().add(activeDish1);
                            }
                            break;
                        }
                    }
                }
            });
        });
        /*Library page*/
        libraryTab.setOnSelectionChanged(event -> {
            if (playlistsPaneOnLibraryPage.isVisible()) {
                playlistsPaneRedraw();
            } else if (libraryPageScroll.isVisible()) {
                sd.setLikeCounter(sd.getLikeCounter() - sd.getLikeLastCounterChange());
                sd.setLikeLastCounterChange(14);
                if (idActivePlaylist == -1) {
                    likeNext("like");
                } else {
                    likeNext("playlist" + (idActivePlaylist + 1));
                }
            } else if (dishViewPaneOnLibraryPage.isVisible() && activeDish2 != null) {
                likeDishView(activeDish2.getTitle());
            }
        });
        likePlaylistButtonOnLibraryPage.setOnAction(actionEvent -> {
            idActivePlaylist = -1;
            filters = "like";
            playlistIconOrButtonAction();
        });
        playlistButton1OnLibraryPage.setOnAction(actionEvent -> {
            idActivePlaylist = 0;
            filters = "playlist1";
            playlistIconOrButtonAction();
        });
        playlistButton2OnLibraryPage.setOnAction(actionEvent -> {
            idActivePlaylist = 1;
            filters = "playlist2";
            playlistIconOrButtonAction();
        });
        playlistButton3OnLibraryPage.setOnAction(actionEvent -> {
            idActivePlaylist = 2;
            filters = "playlist3";
            playlistIconOrButtonAction();
        });
        playlistButton4OnLibraryPage.setOnAction(actionEvent -> {
            idActivePlaylist = 3;
            filters = "playlist4";
            playlistIconOrButtonAction();
        });
        playlistButton5OnLibraryPage.setOnAction(actionEvent -> {
            idActivePlaylist = 4;
            filters = "playlist5";
            playlistIconOrButtonAction();
        });
        likeListIconOnLibraryPage.setOnMouseClicked(mouseEvent -> {
            idActivePlaylist = -1;
            filters = "like";
            playlistIconOrButtonAction();
        });
        playlistIcon1OnLibraryPage.setOnMouseClicked(mouseEvent -> {
            idActivePlaylist = 0;
            filters = "playlist1";
            playlistIconOrButtonAction();
        });
        playlistIcon2OnLibraryPage.setOnMouseClicked(mouseEvent -> {
            idActivePlaylist = 1;
            filters = "playlist2";
            playlistIconOrButtonAction();
        });
        playlistIcon3OnLibraryPage.setOnMouseClicked(mouseEvent -> {
            idActivePlaylist = 2;
            filters = "playlist3";
            playlistIconOrButtonAction();
        });
        playlistIcon4OnLibraryPage.setOnMouseClicked(mouseEvent -> {
            idActivePlaylist = 3;
            filters = "playlist4";
            playlistIconOrButtonAction();
        });
        playlistIcon5OnLibraryPage.setOnMouseClicked(mouseEvent -> {
            idActivePlaylist = 4;
            filters = "playlist5";
            playlistIconOrButtonAction();
        });
        backButtonOnLibraryPage.setOnAction(event -> likeBack(filters));
        nextButtonOnLibraryPage.setOnAction(event -> likeNext(filters));
        title2OnLibraryPage.setOnAction(event -> {
            libraryPageScroll.setVisible(false);
            likeDishView(title2OnLibraryPage.getText());
        });
        title3OnLibraryPage.setOnAction(event -> {
            libraryPageScroll.setVisible(false);
            likeDishView(title3OnLibraryPage.getText());
        });
        title4OnLibraryPage.setOnAction(event -> {
            libraryPageScroll.setVisible(false);
            likeDishView(title4OnLibraryPage.getText());
        });
        title5OnLibraryPage.setOnAction(event -> {
            libraryPageScroll.setVisible(false);
            likeDishView(title5OnLibraryPage.getText());
        });
        title6OnLibraryPage.setOnAction(event -> {
            libraryPageScroll.setVisible(false);
            likeDishView(title6OnLibraryPage.getText());
        });
        title7OnLibraryPage.setOnAction(event -> {
            libraryPageScroll.setVisible(false);
            likeDishView(title7OnLibraryPage.getText());
        });
        title8OnLibraryPage.setOnAction(event -> {
            libraryPageScroll.setVisible(false);
            likeDishView(title8OnLibraryPage.getText());
        });
        title9OnLibraryPage.setOnAction(event -> {
            libraryPageScroll.setVisible(false);
            likeDishView(title9OnLibraryPage.getText());
        });
        title10OnLibraryPage.setOnAction(event -> {
            libraryPageScroll.setVisible(false);
            likeDishView(title10OnLibraryPage.getText());
        });
        title11OnLibraryPage.setOnAction(event -> {
            libraryPageScroll.setVisible(false);
            likeDishView(title11OnLibraryPage.getText());
        });
        title12OnLibraryPage.setOnAction(event -> {
            libraryPageScroll.setVisible(false);
            likeDishView(title12OnLibraryPage.getText());
        });
        title13OnLibraryPage.setOnAction(event -> {
            libraryPageScroll.setVisible(false);
            likeDishView(title13OnLibraryPage.getText());
        });
        title14OnLibraryPage.setOnAction(event -> {
            libraryPageScroll.setVisible(false);
            likeDishView(title14OnLibraryPage.getText());
        });
        title15OnLibraryPage.setOnAction(event -> {
            libraryPageScroll.setVisible(false);
            likeDishView(title15OnLibraryPage.getText());
        });
        title1OnLibraryPage.setOnAction(event -> {
            libraryPageScroll.setVisible(false);
            likeDishView(title1OnLibraryPage.getText());
        });
        removeDishInDishViewOnLibraryPage.setOnAction(actionEvent -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("RecipeBook");
            alert.setHeaderText(null);
            alert.setContentText("Ви справді хочете видалити страву з цього списку?");
            Optional<ButtonType> option = alert.showAndWait();
            if (option.get().equals(ButtonType.OK)) {
                if (idActivePlaylist != -1) {
                    SaveLoadRemote.removeDishInPlaylist(sd.getPlaylists().get(idActivePlaylist).getId(), activeDish2.getId(), account.getMail(), account.getPassword());
                    sd.getPlaylists().get(idActivePlaylist).getDishes().remove(activeDish2);
                    libraryPageScroll.setVisible(true);
                    dishViewScrollOnLibraryPage.setVisible(false);
                    sd.setLikeCounter(0);
                    sd.setLikeLastCounterChange(14);
                    likeNext("playlist" + (idActivePlaylist + 1));
                } else {
                    SaveLoadRemote.removeLikedDishes(account.getIdUser(), activeDish2.getId(), account.getMail(), account.getPassword());
                    sd.getLike().remove(activeDish2);
                    libraryPageScroll.setVisible(true);
                    dishViewScrollOnLibraryPage.setVisible(false);
                    sd.setLikeCounter(0);
                    sd.setLikeLastCounterChange(14);
                    likeNext("like");
                }
            }
        });
        likeFieldInDishViewOnLibraryPage.setOnMouseClicked(event -> {
            if (sd.getLike().indexOf(activeDish2) != -1) {
                int numberOfLike = activeDish2.getNumberOfLikes();
                removeLikedDish(numberOfLike, activeDish2);
                sd.reloadAllLists();
                likeFieldInDishViewOnLibraryPage.setImage(new Image("https://cdn4.iconfinder.com/data/icons/app-custom-ui-1/48/Heart-512.png"));
                numberOfLikeInDishViewOnLibraryPage.setText(String.valueOf(activeDish2.getNumberOfLikes()));
            } else {
                int numberOfLike = activeDish2.getNumberOfLikes();
                addLikedDish(numberOfLike, activeDish2);
                sd.reloadAllLists();
                likeFieldInDishViewOnLibraryPage.setImage(new Image("https://cdn1.iconfinder.com/data/icons/instagram-ui-flat/48/Instagram_UI-07-512.png"));
                numberOfLikeInDishViewOnLibraryPage.setText(String.valueOf(activeDish2.getNumberOfLikes()));
            }
        });
        numberOfLikeInDishViewOnLibraryPage.setOnMouseClicked(mouseEvent -> {
            if (sd.getLike().indexOf(activeDish2) != -1) {
                int numberOfLike = activeDish2.getNumberOfLikes();
                removeLikedDish(numberOfLike, activeDish2);
                sd.reloadAllLists();
                likeFieldInDishViewOnLibraryPage.setImage(new Image("https://cdn4.iconfinder.com/data/icons/app-custom-ui-1/48/Heart-512.png"));
                numberOfLikeInDishViewOnLibraryPage.setText(String.valueOf(activeDish2.getNumberOfLikes()));
            } else {
                int numberOfLike = activeDish2.getNumberOfLikes();
                addLikedDish(numberOfLike, activeDish2);
                sd.reloadAllLists();
                likeFieldInDishViewOnLibraryPage.setImage(new Image("https://cdn1.iconfinder.com/data/icons/instagram-ui-flat/48/Instagram_UI-07-512.png"));
                numberOfLikeInDishViewOnLibraryPage.setText(String.valueOf(activeDish2.getNumberOfLikes()));
            }
        });
        backToPlaylistsButtonOnLibraryPage.setOnAction(actionEvent -> {
            dishViewScrollOnLibraryPage.setVisible(false);
            libraryPageScroll.setVisible(false);
            playlistsPaneOnLibraryPage.setVisible(true);
            sd.setLikeLastCounterChange(15);
            sd.setLikeCounter(0);
        });
        backToCategoryButtonInDishViewOnLibraryPage.setOnAction(event -> {
            dishViewScrollOnLibraryPage.setVisible(false);
            playlistsPaneOnLibraryPage.setVisible(false);
            libraryPageScroll.setVisible(true);
            sd.setLikeLastCounterChange(15);
            sd.setLikeCounter(0);
            likeNext(filters);
        });
        addPlaylistsButtonOnLibraryPage.setOnAction(actionEvent -> {
            TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("RecipeBook");
            dialog.setHeaderText(null);
            dialog.setContentText("Введіть назву нового списка відтворення(" + sd.getPlaylists().size() + "/5)");
            dialog.initStyle(StageStyle.UTILITY);
            dialog.setResizable(false);
            Optional<String> result = dialog.showAndWait();
            result.ifPresent(name -> {
                if (sd.getPlaylists().size() < 5) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Playlist playlist = new Playlist(SaveLoadRemote.addPlaylist(account.getIdUser(), name, account.getMail(), account.getPassword()), name, new ArrayList<>());
                    sd.getPlaylists().add(playlist);
                    playlistsPaneRedraw();
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("RecipeBook");
                    alert.setHeaderText(null);
                    alert.setContentText("У вас вже є 5 списків відтворень, ви досягли ліміту!");
                    alert.showAndWait();
                }
            });
        });
        removePlaylistsButtonOnLibraryPage.setOnAction(actionEvent -> {
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
                if (!letter.equals("Виберіть список відтворення") && !letter.equals("У вас немає списків відтворення")) {
                    for (int i = 0; i < sd.getPlaylists().size(); i++) {
                        if (sd.getPlaylists().get(i).getTitle().equals(letter)) {
                            SaveLoadRemote.removePlaylist(sd.getPlaylists().get(i).getId(), account.getMail(), account.getPassword());
                            sd.getPlaylists().remove(sd.getPlaylists().get(i));
                            playlistsPaneRedraw();
                            break;
                        }
                    }
                }
            });
        });
        addInFavouriteButtonInDishViewOnLibraryPage.setOnMouseClicked(mouseEvent -> {
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
                if (!letter.equals("Виберіть список відтворення") && !letter.equals("Добавте список відтворення на вкладці бібліотека")) {
                    for (int i = 0; i < sd.getPlaylists().size(); i++) {
                        if (sd.getPlaylists().get(i).getTitle().equals(letter)) {
                            boolean b = true;
                            for (int j = 0; j < sd.getPlaylists().get(i).getDishes().size(); j++) {
                                if (sd.getPlaylists().get(i).getDishes().get(j).getTitle().equals(activeDish2.getTitle())) {
                                    b = false;
                                    break;
                                }
                            }
                            if (b) {
                                SaveLoadRemote.addDishInPlaylist(sd.getPlaylists().get(i).getId(), activeDish2.getId(), account.getMail(), account.getPassword());
                                sd.getPlaylists().get(i).getDishes().add(activeDish2);
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
                    if (!letter.equals("Виберіть страву") && !letter.equals("У цьому спискі немає страв")) {
                        for (int i = 0; i < sd.getPlaylists().get(idActivePlaylist).getDishes().size(); i++) {
                            if (sd.getPlaylists().get(idActivePlaylist).getDishes().get(i).getTitle().equals(letter)) {
                                SaveLoadRemote.removeDishInPlaylist(sd.getPlaylists().get(idActivePlaylist).getId(), sd.getPlaylists().get(idActivePlaylist).getDishes().get(i).getId(), account.getMail(), account.getPassword());
                                sd.getPlaylists().get(idActivePlaylist).getDishes().remove(sd.getPlaylists().get(idActivePlaylist).getDishes().get(i));
                                sd.setLikeCounter(0);
                                sd.setLikeLastCounterChange(14);
                                likeNext("playlist" + (idActivePlaylist + 1));
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
                    if (!letter.equals("Виберіть страву") && !letter.equals("У цьому спискі немає страв")) {
                        for (int i = 0; i < sd.getLike().size(); i++) {
                            if (sd.getLike().get(i).getTitle().equals(letter)) {
                                SaveLoadRemote.removeLikedDishes(account.getIdUser(), sd.getLike().get(i).getId(), account.getMail(), account.getPassword());
                                sd.getLike().remove(sd.getLike().get(i));
                                sd.setLikeCounter(0);
                                sd.setLikeLastCounterChange(14);
                                likeNext("like");
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
            if (option.get().equals(ButtonType.OK)) {
                SaveLoadRemote.removePlaylist(sd.getPlaylists().get(idActivePlaylist).getId(), account.getMail(), account.getPassword());
                sd.getPlaylists().remove(idActivePlaylist);
                playlistsPaneOnLibraryPage.setVisible(true);
                libraryPageScroll.setVisible(false);
                playlistsPaneRedraw();
            }
        });

        /*Settings page*/
        exitButton.setOnAction(event -> {
            Login.noSavePassword();
            exitButton.getScene().getWindow().hide();
            LoaderNewScene.load("/gui/signIn.fxml");
        });
        aboutUsButton.setOnAction(event -> {
            settingsMenuPane.setVisible(false);
            changeUserInfoPain.setVisible(false);
            aboutUsPane.setVisible(true);
            aboutUsLabel.setText("1");
        });
        supportButton.setOnAction(event -> {
            settingsMenuPane.setVisible(false);
            changeUserInfoPain.setVisible(false);
            //добавить пейн з сапортом
        });
        changeUserInfoButton.setOnAction(event -> {
            settingsMenuPane.setVisible(false);
            changeUserInfoPain.setVisible(true);
            aboutUsPane.setVisible(false);
        });
        backToSettingsMenuFromAboutUsPaneButton.setOnAction(event -> {
            settingsMenuPane.setVisible(true);
            changeUserInfoPain.setVisible(false);
            aboutUsPane.setVisible(false);
        });
        backToMenuSettingsButtonFromChangeUserInfoPain.setOnAction(event -> {
            settingsMenuPane.setVisible(true);
            changeUserInfoPain.setVisible(false);
            aboutUsPane.setVisible(false);
        });
        ////////////////////////////////////////////////////////////////
        changePassword.setOnAction(event -> {
            if (passwordLabel.getText().equals(repeatPasswordLabel.getText()) && !passwordLabel.getText().equals("")) {
                if (Filter.verifyPassword(passwordLabel.getText())) {
                    Login.noSavePassword();
                    SaveLoadRemote.changePassword(passwordLabel.getText(), account.getMail(), account.getPassword());
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
        /////////////////////////////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////
        //////////////////////добавить проверку ніка на унікальность
        changeUsername.setOnAction(actionEvent -> {
            if (!usernameLabel.getText().equals("")) {
                if (Filter.verifyUsername(usernameLabel.getText())) {
                    SaveLoadRemote.changeUsername(usernameLabel.getText(), account.getMail(), account.getPassword());
                    changePasswordErrorField.setText(Text.get("SUCCESSFUL_REPLACEMENT_PASSWORD"));
                    account.setUserName(usernameLabel.getText());
                    usernameLabel.clear();
                } else {
                    changePasswordErrorField.setText(Text.get("CHANGE_PASSWORD_BAD_PASSWORD_ERROR"));
                }
            } else {
                changePasswordErrorField.setText(Text.get("CHANGE_EMPTY_ERROR"));
            }
        });
        changeLocation.setOnAction(actionEvent -> {
            if (locationField.getValue() != null && !locationField.getValue().equals("Виберіть країну")) {
                if (Filter.verifyLocation(locationField.getValue())) {
                    SaveLoadRemote.changeLocation(locationField.getValue(), account.getMail(), account.getPassword());
                    changePasswordErrorField.setText(Text.get("SUCCESSFUL_REPLACEMENT_PASSWORD"));
                    account.setLocation(locationField.getValue());
                    locationField.setValue("Виберіть країну");
                } else {
                    changePasswordErrorField.setText(Text.get("CHANGE_PASSWORD_BAD_PASSWORD_ERROR"));
                }
            } else {
                changePasswordErrorField.setText(Text.get("CHANGE_EMPTY_ERROR"));
            }
        });
    }

    private void init() {
        ObservableList<String> comboBoxList = FXCollections.observableArrayList("Всі страви", "Перші страви", "Другі страви",
                "Салати та закуски", "Випічка", "Торти", "Десерти", "Напої");
        filterComboBoxOnHomePage.setItems(comboBoxList);
        dishViewOnHomePageScroll.setVisible(false);
        backButtonOnHomePage.setDisable(true);
        next("Всі страви");
        addInFavouriteButtonInDishViewOnHomePage.setVisible(true);
        addInFavouriteButtonInDishViewOnHomePage.setImage(new Image("https://cdn1.iconfinder.com/data/icons/social-shade-rounded-rects/512/addthis-512.png"));
        likeListIconOnLibraryPage.setImage(new Image("https://www.materialui.co/materialIcons/image/navigate_next_black_144x144.png"));
        playlistIcon1OnLibraryPage.setImage(new Image("https://www.materialui.co/materialIcons/image/navigate_next_black_144x144.png"));
        playlistIcon2OnLibraryPage.setImage(new Image("https://www.materialui.co/materialIcons/image/navigate_next_black_144x144.png"));
        playlistIcon3OnLibraryPage.setImage(new Image("https://www.materialui.co/materialIcons/image/navigate_next_black_144x144.png"));
        playlistIcon4OnLibraryPage.setImage(new Image("https://www.materialui.co/materialIcons/image/navigate_next_black_144x144.png"));
        playlistIcon5OnLibraryPage.setImage(new Image("https://www.materialui.co/materialIcons/image/navigate_next_black_144x144.png"));
        addInFavouriteButtonInDishViewOnLibraryPage.setImage(new Image("https://cdn1.iconfinder.com/data/icons/social-shade-rounded-rects/512/addthis-512.png"));
        dishViewScrollOnLibraryPage.setVisible(false);
        libraryPageScroll.setVisible(false);
        backButtonOnLibraryPage.setDisable(true);
        playlistsPaneOnLibraryPage.setVisible(true);
        settingsMenuPane.setVisible(true);
        changeUserInfoPain.setVisible(false);
        aboutUsPane.setVisible(false);
        ObservableList<String> comboBoxListForChangeLocation = FXCollections.observableArrayList("Виберіть країну", "Россия, ru", "Україна, ua", "England, uk");
        locationField.setItems(comboBoxListForChangeLocation);
        locationField.setValue("Виберіть країну");
    }

    private void addLikedDish(int numberOfLike, Dish dish) {
        int index = sd.getDishes().indexOf(dish);
        sd.getDishes().get(index).setNumberOfLikes(numberOfLike + 1);
        dish = sd.getDishes().get(index);
        sd.getLike().add(dish);
        sd.saveLikedDishes(account.getMail(), account.getPassword(), account.getIdUser(), dish.getId());
        SaveLoadRemote.addOneLike(dish.getId(), account.getMail(), account.getPassword());
    }

    private void removeLikedDish(int numberOfLike, Dish dish) {
        int index = sd.getDishes().indexOf(dish);
        sd.getDishes().get(index).setNumberOfLikes(numberOfLike - 1);
        dish = sd.getDishes().get(index);
        sd.getLike().remove(dish);
        sd.removeLikedDishes(account.getMail(), account.getPassword(), account.getIdUser(), dish.getId());
        SaveLoadRemote.removeOneLike(dish.getId(), account.getMail(), account.getPassword());
    }

    private void playlistsPaneRedraw() {
        likeListIconOnLibraryPage.setVisible(true);
        likePlaylistButtonOnLibraryPage.setVisible(true);
        if (sd.getPlaylists() != null) {
            playlistIcon1OnLibraryPage.setVisible(true);
            playlistIcon2OnLibraryPage.setVisible(true);
            playlistIcon3OnLibraryPage.setVisible(true);
            playlistIcon4OnLibraryPage.setVisible(true);
            playlistIcon5OnLibraryPage.setVisible(true);
            playlistButton1OnLibraryPage.setVisible(true);
            playlistButton2OnLibraryPage.setVisible(true);
            playlistButton3OnLibraryPage.setVisible(true);
            playlistButton4OnLibraryPage.setVisible(true);
            playlistButton5OnLibraryPage.setVisible(true);
            sd.setLikeLastCounterChange(15);
            sd.setLikeCounter(0);
            int i = 0;
            if (sd.getPlaylists().size() > i) {
                playlistButton1OnLibraryPage.setText(sd.getPlaylists().get(i).getTitle());
                i++;
            } else {
                playlistIcon1OnLibraryPage.setVisible(false);
                playlistButton1OnLibraryPage.setVisible(false);
            }
            if (sd.getPlaylists().size() > i) {
                playlistButton2OnLibraryPage.setText(sd.getPlaylists().get(i).getTitle());
                i++;
            } else {
                playlistIcon2OnLibraryPage.setVisible(false);
                playlistButton2OnLibraryPage.setVisible(false);
            }
            if (sd.getPlaylists().size() > i) {
                playlistButton3OnLibraryPage.setText(sd.getPlaylists().get(i).getTitle());
                i++;
            } else {
                playlistIcon3OnLibraryPage.setVisible(false);
                playlistButton3OnLibraryPage.setVisible(false);
            }
            if (sd.getPlaylists().size() > i) {
                playlistButton4OnLibraryPage.setText(sd.getPlaylists().get(i).getTitle());
                i++;
            } else {
                playlistIcon4OnLibraryPage.setVisible(false);
                playlistButton4OnLibraryPage.setVisible(false);
            }
            if (sd.getPlaylists().size() > i) {
                playlistButton5OnLibraryPage.setText(sd.getPlaylists().get(i).getTitle());
                i++;
            } else {
                playlistIcon5OnLibraryPage.setVisible(false);
                playlistButton5OnLibraryPage.setVisible(false);
            }
        } else {
            playlistIcon1OnLibraryPage.setVisible(false);
            playlistIcon2OnLibraryPage.setVisible(false);
            playlistIcon3OnLibraryPage.setVisible(false);
            playlistIcon4OnLibraryPage.setVisible(false);
            playlistIcon5OnLibraryPage.setVisible(false);
            playlistButton1OnLibraryPage.setVisible(false);
            playlistButton2OnLibraryPage.setVisible(false);
            playlistButton3OnLibraryPage.setVisible(false);
            playlistButton4OnLibraryPage.setVisible(false);
            playlistButton5OnLibraryPage.setVisible(false);
        }
    }

    private void playlistIconOrButtonAction() {
        libraryPageScroll.setVisible(true);
        dishViewScrollOnLibraryPage.setVisible(false);
        playlistsPaneOnLibraryPage.setVisible(false);
        sd.setLikeCounter(0);
        sd.setLastCounterChange(14);
        if (idActivePlaylist == -1) {
            removePlaylistButton.setVisible(false);
        } else {
            removePlaylistButton.setVisible(true);
        }
        likeNext(filters);
    }

    private List<Dish> setFieldForHomeDishViewVisibleAndFilter(String filter) {
        List<Dish> list;
        switch (filter) {
            case "Перші страви":
                list = sd.getCategory1();
                break;
            case "Другі страви":
                list = sd.getCategory2();
                break;
            case "Салати та закуски":
                list = sd.getCategory3();
                break;
            case "Випічка":
                list = sd.getCategory4();
                break;
            case "Торти":
                list = sd.getCategory5();
                break;
            case "Десерти":
                list = sd.getCategory6();
                break;
            case "Напої":
                list = sd.getCategory7();
                break;
            default:
                list = sd.getDishes();
                break;
        }
        title1OnHomePage.setVisible(true);
        title2OnHomePage.setVisible(true);
        title3OnHomePage.setVisible(true);
        title4OnHomePage.setVisible(true);
        title5OnHomePage.setVisible(true);
        image1OnHomePage.setVisible(true);
        image2OnHomePage.setVisible(true);
        image3OnHomePage.setVisible(true);
        image4OnHomePage.setVisible(true);
        image5OnHomePage.setVisible(true);
        description1OnHomePage.setVisible(true);
        description2OnHomePage.setVisible(true);
        description3OnHomePage.setVisible(true);
        description4OnHomePage.setVisible(true);
        description5OnHomePage.setVisible(true);
        return list;
    }

    private void next(String filter) {
        List<Dish> list = setFieldForHomeDishViewVisibleAndFilter(filter);
        int counter = sd.getCounter();
        if (counter == 0) counter = -1;
        int listSize = list.size();

        if (counter < listSize - 1) {
            if (counter + 1 < listSize) {
                counter++;
                title1OnHomePage.setText(list.get(counter).getTitle());
                image1OnHomePage.setImage(new Image(list.get(counter).getPhoto()));
                description1OnHomePage.setText(list.get(counter).getDescription());
            } else {
                title1OnHomePage.setVisible(false);
                image1OnHomePage.setVisible(false);
                description1OnHomePage.setVisible(false);
            }
            if (counter + 1 < listSize) {
                counter++;
                title2OnHomePage.setText(list.get(counter).getTitle());
                image2OnHomePage.setImage(new Image(list.get(counter).getPhoto()));
                description2OnHomePage.setText(list.get(counter).getDescription());
            } else {
                title2OnHomePage.setVisible(false);
                image2OnHomePage.setVisible(false);
                description2OnHomePage.setVisible(false);
            }
            if (counter + 1 < listSize) {
                counter++;
                title3OnHomePage.setText(list.get(counter).getTitle());
                image3OnHomePage.setImage(new Image(list.get(counter).getPhoto()));
                description3OnHomePage.setText(list.get(counter).getDescription());
            } else {
                title3OnHomePage.setVisible(false);
                image3OnHomePage.setVisible(false);
                description3OnHomePage.setVisible(false);
            }
            if (counter + 1 < listSize) {
                counter++;
                title4OnHomePage.setText(list.get(counter).getTitle());
                image4OnHomePage.setImage(new Image(list.get(counter).getPhoto()));
                description4OnHomePage.setText(list.get(counter).getDescription());
            } else {
                title4OnHomePage.setVisible(false);
                image4OnHomePage.setVisible(false);
                description4OnHomePage.setVisible(false);
            }
            if (counter + 1 < listSize) {
                counter++;
                title5OnHomePage.setText(list.get(counter).getTitle());
                image5OnHomePage.setImage(new Image(list.get(counter).getPhoto()));
                description5OnHomePage.setText(list.get(counter).getDescription());
            } else {
                title5OnHomePage.setVisible(false);
                image5OnHomePage.setVisible(false);
                description5OnHomePage.setVisible(false);
            }
            if (counter - sd.getCounter() != 0) {
                sd.setLastCounterChange(counter - sd.getCounter());
            }
            sd.setCounter(counter);
            homeScroll.setVvalue(0);
            if (counter >= listSize - 1) {
                nextButtonOnHomePage.setDisable(true);
            }
            if (nextButtonOnHomePage.isDisable() && counter - sd.getCounter() >= 0 && counter - sd.getCounter() < 5) {
                if ((counter + 2) % 10 == 0) {
                    nextButtonOnHomePage.setLayoutY(700);
                    backButtonOnHomePage.setLayoutY(700);
                    homePagePane.setMinHeight(800);
                    homePagePane.setMaxHeight(800);
                    homePagePane.setPrefHeight(800);
                } else {
                    homePagePane.setMinHeight(670);
                    homePagePane.setMaxHeight(670);
                    homePagePane.setPrefHeight(670);
                    nextButtonOnHomePage.setLayoutY(580);
                    backButtonOnHomePage.setLayoutY(580);
                }
            }
        } else {
            nextButtonOnHomePage.setDisable(true);
        }
    }

    private void back(String filter) {
        List<Dish> list = setFieldForHomeDishViewVisibleAndFilter(filter);
        int counter = sd.getCounter();
        int listSize = list.size();
        int lastCounterChange = sd.getLastCounterChange();

        if (lastCounterChange != 5 && counter - lastCounterChange - 4 >= 0) {
            counter -= lastCounterChange + 4;
        } else {
            counter -= lastCounterChange;
        }
        counter--;
        if (counter >= -1) {
            if (counter + 1 < listSize) {
                counter++;
                title1OnHomePage.setText(list.get(counter).getTitle());
                image1OnHomePage.setImage(new Image(list.get(counter).getPhoto()));
                description1OnHomePage.setText(list.get(counter).getDescription());
            } else {
                title1OnHomePage.setVisible(false);
                image1OnHomePage.setVisible(false);
                description1OnHomePage.setVisible(false);
            }
            if (counter + 1 < listSize) {
                counter++;
                title2OnHomePage.setText(list.get(counter).getTitle());
                image2OnHomePage.setImage(new Image(list.get(counter).getPhoto()));
                description2OnHomePage.setText(list.get(counter).getDescription());
            } else {
                title2OnHomePage.setVisible(false);
                image2OnHomePage.setVisible(false);
                description2OnHomePage.setVisible(false);
            }
            if (counter + 1 < listSize) {
                counter++;
                title3OnHomePage.setText(list.get(counter).getTitle());
                image3OnHomePage.setImage(new Image(list.get(counter).getPhoto()));
                description3OnHomePage.setText(list.get(counter).getDescription());
            } else {
                title3OnHomePage.setVisible(false);
                image3OnHomePage.setVisible(false);
                description3OnHomePage.setVisible(false);
            }
            if (counter + 1 < listSize) {
                counter++;
                title4OnHomePage.setText(list.get(counter).getTitle());
                image4OnHomePage.setImage(new Image(list.get(counter).getPhoto()));
                description4OnHomePage.setText(list.get(counter).getDescription());
            } else {
                title4OnHomePage.setVisible(false);
                image4OnHomePage.setVisible(false);
                description4OnHomePage.setVisible(false);
            }
            if (counter + 1 < listSize) {
                counter++;
                title5OnHomePage.setText(list.get(counter).getTitle());
                image5OnHomePage.setImage(new Image(list.get(counter).getPhoto()));
                description5OnHomePage.setText(list.get(counter).getDescription());
            } else {
                title5OnHomePage.setVisible(false);
                image5OnHomePage.setVisible(false);
                description5OnHomePage.setVisible(false);
            }
            sd.setLastCounterChange(5);
            sd.setCounter(counter);
            homeScroll.setVvalue(0);
            if (counter == 4) {
                backButtonOnHomePage.setDisable(true);
            }
        } else {
            backButtonOnHomePage.setDisable(true);
        }
    }

    private void dishView(String title) {

        dishViewOnHomePageScroll.setVisible(true);
        dishViewOnHomePageScroll.setVvalue(0);
        Dish dish = null;
        for (int i = 0; i < sd.getDishes().size(); i++) {
            if (sd.getDishes().get(i).getTitle().equals(title)) {
                dish = sd.getDishes().get(i);
            }
        }
        if (dish != null) {
            activeDish1 = dish;

            homeScroll.setVisible(false);
            dishTitleInDishViewOnHomePage.setText(dish.getTitle());
            dishImageInDishViewOnHomePage.setImage(new Image(dish.getPhoto()));
            dishDescriptionInDishViewOnHomePage.setText(dish.getDescription());
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < dish.getRecipe().size(); i++) {
                s.append("Етап №").append(i + 1).append("\n").append("     ").append(dish.getRecipe().get(i));
                if (i != dish.getRecipe().size() - 1) {
                    s.append("\n\n");
                }
            }
            dishRecipeInDishViewOnHomePage.setText(s.toString());
            //System.out.println(s + "\n");
            //зробить самоизменяющийся размер у label dishRecipe
            groceryTableViewInDishViewOnHomePage.getColumns().clear();
            groceryTableViewInDishViewOnHomePage.setPrefHeight(dish.getGroceryList().size() * 25 + 20);
            ObservableList<Shopping> grocery = FXCollections.observableArrayList();
            grocery.addAll(dish.getGroceryList());
            groceryTableViewInDishViewOnHomePage.setItems(grocery);
            TableColumn<Shopping, String> groceryColumn = new TableColumn<>("Продукти");
            groceryColumn.setCellValueFactory(new PropertyValueFactory<>("grocery"));
            groceryTableViewInDishViewOnHomePage.getColumns().add(groceryColumn);
            TableColumn<Shopping, Double> weightColumn = new TableColumn<>("Кількість");
            weightColumn.setCellValueFactory(new PropertyValueFactory<>("weight"));
            groceryTableViewInDishViewOnHomePage.getColumns().add(weightColumn);
            groceryTableViewInDishViewOnHomePage.setVisible(true);
            if (sd.getLike() != null && sd.getLike().indexOf(dish) != -1) {
                likeFieldInDishViewOnHomePage.setImage(new Image("https://cdn1.iconfinder.com/data/icons/instagram-ui-flat/48/Instagram_UI-07-512.png"));
            } else {
                likeFieldInDishViewOnHomePage.setImage(new Image("https://cdn4.iconfinder.com/data/icons/app-custom-ui-1/48/Heart-512.png"));
            }
            numberOfLikeInDishViewOnHomePage.setText(String.valueOf(dish.getNumberOfLikes()));
        }
    }

    private List<Dish> setFieldForLibraryDishViewVisibleAndFilter(String filter) {
        List<Dish> list;
        switch (filter) {
            case "playlist1":
                list = sd.getPlaylists().get(0).getDishes();
                break;
            case "playlist2":
                list = sd.getPlaylists().get(1).getDishes();
                break;
            case "playlist3":
                list = sd.getPlaylists().get(2).getDishes();
                break;
            case "playlist4":
                list = sd.getPlaylists().get(3).getDishes();
                break;
            case "playlist5":
                list = sd.getPlaylists().get(4).getDishes();
                break;
            default:
                list = sd.getLike();
                break;
        }
        title1OnLibraryPage.setVisible(true);
        title2OnLibraryPage.setVisible(true);
        title3OnLibraryPage.setVisible(true);
        title4OnLibraryPage.setVisible(true);
        title5OnLibraryPage.setVisible(true);
        title6OnLibraryPage.setVisible(true);
        title7OnLibraryPage.setVisible(true);
        title8OnLibraryPage.setVisible(true);
        title9OnLibraryPage.setVisible(true);
        title10OnLibraryPage.setVisible(true);
        title11OnLibraryPage.setVisible(true);
        title12OnLibraryPage.setVisible(true);
        title13OnLibraryPage.setVisible(true);
        title14OnLibraryPage.setVisible(true);
        title15OnLibraryPage.setVisible(true);
        image1OnLibraryPage.setVisible(true);
        image2OnLibraryPage.setVisible(true);
        image3OnLibraryPage.setVisible(true);
        image4OnLibraryPage.setVisible(true);
        image5OnLibraryPage.setVisible(true);
        image6OnLibraryPage.setVisible(true);
        image7OnLibraryPage.setVisible(true);
        image8OnLibraryPage.setVisible(true);
        image9OnLibraryPage.setVisible(true);
        image10OnLibraryPage.setVisible(true);
        image11OnLibraryPage.setVisible(true);
        image12OnLibraryPage.setVisible(true);
        image13OnLibraryPage.setVisible(true);
        image14OnLibraryPage.setVisible(true);
        image15OnLibraryPage.setVisible(true);
        return list;
    }

    private void likeNext(String filter) {
        List<Dish> list = setFieldForLibraryDishViewVisibleAndFilter(filter);
        if (list != null) {
            int counter = sd.getLikeCounter();
            if (counter == 0) counter = -1;
            int listSize = list.size();

            if (counter + 1 < listSize) {
                counter++;
                title1OnLibraryPage.setText(list.get(counter).getTitle());
                image1OnLibraryPage.setImage(new Image(list.get(counter).getPhoto()));
            } else {
                title1OnLibraryPage.setVisible(false);
                image1OnLibraryPage.setVisible(false);
            }
            if (counter + 1 < listSize) {
                counter++;
                title2OnLibraryPage.setText(list.get(counter).getTitle());
                image2OnLibraryPage.setImage(new Image(list.get(counter).getPhoto()));
            } else {
                title2OnLibraryPage.setVisible(false);
                image2OnLibraryPage.setVisible(false);
            }
            if (counter + 1 < listSize) {
                counter++;
                title3OnLibraryPage.setText(list.get(counter).getTitle());
                image3OnLibraryPage.setImage(new Image(list.get(counter).getPhoto()));
            } else {
                title3OnLibraryPage.setVisible(false);
                image3OnLibraryPage.setVisible(false);
            }
            if (counter + 1 < listSize) {
                counter++;
                title4OnLibraryPage.setText(list.get(counter).getTitle());
                image4OnLibraryPage.setImage(new Image(list.get(counter).getPhoto()));
            } else {
                title4OnLibraryPage.setVisible(false);
                image4OnLibraryPage.setVisible(false);
            }
            if (counter + 1 < listSize) {
                counter++;
                title5OnLibraryPage.setText(list.get(counter).getTitle());
                image5OnLibraryPage.setImage(new Image(list.get(counter).getPhoto()));
            } else {
                title5OnLibraryPage.setVisible(false);
                image5OnLibraryPage.setVisible(false);
            }
            if (counter + 1 < listSize) {
                counter++;
                title6OnLibraryPage.setText(list.get(counter).getTitle());
                image6OnLibraryPage.setImage(new Image(list.get(counter).getPhoto()));
            } else {
                title6OnLibraryPage.setVisible(false);
                image6OnLibraryPage.setVisible(false);
            }
            if (counter + 1 < listSize) {
                counter++;
                title7OnLibraryPage.setText(list.get(counter).getTitle());
                image7OnLibraryPage.setImage(new Image(list.get(counter).getPhoto()));
            } else {
                title7OnLibraryPage.setVisible(false);
                image7OnLibraryPage.setVisible(false);
            }
            if (counter + 1 < listSize) {
                counter++;
                title8OnLibraryPage.setText(list.get(counter).getTitle());
                image8OnLibraryPage.setImage(new Image(list.get(counter).getPhoto()));
            } else {
                title8OnLibraryPage.setVisible(false);
                image8OnLibraryPage.setVisible(false);
            }
            if (counter + 1 < listSize) {
                counter++;
                title9OnLibraryPage.setText(list.get(counter).getTitle());
                image9OnLibraryPage.setImage(new Image(list.get(counter).getPhoto()));
            } else {
                title9OnLibraryPage.setVisible(false);
                image9OnLibraryPage.setVisible(false);
            }
            if (counter + 1 < listSize) {
                counter++;
                title10OnLibraryPage.setText(list.get(counter).getTitle());
                image10OnLibraryPage.setImage(new Image(list.get(counter).getPhoto()));
            } else {
                title10OnLibraryPage.setVisible(false);
                image10OnLibraryPage.setVisible(false);
            }
            if (counter + 1 < listSize) {
                counter++;
                title11OnLibraryPage.setText(list.get(counter).getTitle());
                image11OnLibraryPage.setImage(new Image(list.get(counter).getPhoto()));
            } else {
                title11OnLibraryPage.setVisible(false);
                image11OnLibraryPage.setVisible(false);
            }
            if (counter + 1 < listSize) {
                counter++;
                title12OnLibraryPage.setText(list.get(counter).getTitle());
                image12OnLibraryPage.setImage(new Image(list.get(counter).getPhoto()));
            } else {
                title12OnLibraryPage.setVisible(false);
                image12OnLibraryPage.setVisible(false);
            }
            if (counter + 1 < listSize) {
                counter++;
                title13OnLibraryPage.setText(list.get(counter).getTitle());
                image13OnLibraryPage.setImage(new Image(list.get(counter).getPhoto()));
            } else {
                title13OnLibraryPage.setVisible(false);
                image13OnLibraryPage.setVisible(false);
            }
            if (counter + 1 < listSize) {
                counter++;
                title14OnLibraryPage.setText(list.get(counter).getTitle());
                image14OnLibraryPage.setImage(new Image(list.get(counter).getPhoto()));
            } else {
                title14OnLibraryPage.setVisible(false);
                image14OnLibraryPage.setVisible(false);
            }
            if (counter + 1 < listSize) {
                counter++;
                title15OnLibraryPage.setText(list.get(counter).getTitle());
                image15OnLibraryPage.setImage(new Image(list.get(counter).getPhoto()));
            } else {
                title15OnLibraryPage.setVisible(false);
                image15OnLibraryPage.setVisible(false);
            }
            if (counter - sd.getLikeCounter() != 0) {
                sd.setLikeLastCounterChange(counter - sd.getLikeCounter());
            }
            sd.setLikeCounter(counter);
            libraryPageScroll.setVvalue(0);
            if (counter >= listSize - 1) {
                nextButtonOnLibraryPage.setDisable(true);
            }
            if (nextButtonOnLibraryPage.isDisable() && counter - sd.getLikeCounter() >= 0 && counter - sd.getLikeCounter() < 15) {
                if (counter + 1 <= 6) {
                    nextButtonOnLibraryPage.setLayoutY(555);
                    backButtonOnLibraryPage.setLayoutY(555);
                    libraryPagePane.setMinHeight(670);
                    libraryPagePane.setMaxHeight(670);
                    libraryPagePane.setPrefHeight(670);
                } else if (counter + 1 <= 9) {
                    libraryPagePane.setMinHeight(810);
                    libraryPagePane.setMaxHeight(810);
                    libraryPagePane.setPrefHeight(810);
                    nextButtonOnLibraryPage.setLayoutY(720);
                    backButtonOnLibraryPage.setLayoutY(720);
                } else if (counter + 1 <= 12) {
                    libraryPagePane.setMinHeight(1015);
                    libraryPagePane.setMaxHeight(1015);
                    libraryPagePane.setPrefHeight(1015);
                    nextButtonOnLibraryPage.setLayoutY(935);
                    backButtonOnLibraryPage.setLayoutY(935);
                }
            }
        } else {
            title1OnLibraryPage.setVisible(false);
            title2OnLibraryPage.setVisible(false);
            title3OnLibraryPage.setVisible(false);
            title4OnLibraryPage.setVisible(false);
            title5OnLibraryPage.setVisible(false);
            title6OnLibraryPage.setVisible(false);
            title7OnLibraryPage.setVisible(false);
            title8OnLibraryPage.setVisible(false);
            title9OnLibraryPage.setVisible(false);
            title10OnLibraryPage.setVisible(false);
            title11OnLibraryPage.setVisible(false);
            title12OnLibraryPage.setVisible(false);
            title13OnLibraryPage.setVisible(false);
            title14OnLibraryPage.setVisible(false);
            title15OnLibraryPage.setVisible(false);
            image1OnLibraryPage.setVisible(false);
            image2OnLibraryPage.setVisible(false);
            image3OnLibraryPage.setVisible(false);
            image4OnLibraryPage.setVisible(false);
            image5OnLibraryPage.setVisible(false);
            image6OnLibraryPage.setVisible(false);
            image7OnLibraryPage.setVisible(false);
            image8OnLibraryPage.setVisible(false);
            image9OnLibraryPage.setVisible(false);
            image10OnLibraryPage.setVisible(false);
            image11OnLibraryPage.setVisible(false);
            image12OnLibraryPage.setVisible(false);
            image13OnLibraryPage.setVisible(false);
            image14OnLibraryPage.setVisible(false);
            image15OnLibraryPage.setVisible(false);
        }
    }

    private void likeBack(String filter) {
        List<Dish> list = setFieldForLibraryDishViewVisibleAndFilter(filter);
        if (list != null) {
            int counter = sd.getLikeCounter();
            if (counter == 0) counter = -1;
            int listSize = list.size();
            int lastCounterChange = sd.getLikeLastCounterChange();

            if (lastCounterChange != 15 && counter - lastCounterChange - 14 >= 0) {
                counter -= lastCounterChange + 14;
            } else {
                counter -= lastCounterChange;
            }
            counter--;
            if (counter >= -1) {
                if (counter + 1 < listSize) {
                    counter++;
                    title1OnLibraryPage.setText(list.get(counter).getTitle());
                    image1OnLibraryPage.setImage(new Image(list.get(counter).getPhoto()));
                } else {
                    title1OnLibraryPage.setVisible(false);
                    image1OnLibraryPage.setVisible(false);
                }
                if (counter + 1 < listSize) {
                    counter++;
                    title2OnLibraryPage.setText(list.get(counter).getTitle());
                    image2OnLibraryPage.setImage(new Image(list.get(counter).getPhoto()));
                } else {
                    title2OnLibraryPage.setVisible(false);
                    image2OnLibraryPage.setVisible(false);
                }
                if (counter + 1 < listSize) {
                    counter++;
                    title3OnLibraryPage.setText(list.get(counter).getTitle());
                    image3OnLibraryPage.setImage(new Image(list.get(counter).getPhoto()));
                } else {
                    title3OnLibraryPage.setVisible(false);
                    image3OnLibraryPage.setVisible(false);
                }
                if (counter + 1 < listSize) {
                    counter++;
                    title4OnLibraryPage.setText(list.get(counter).getTitle());
                    image4OnLibraryPage.setImage(new Image(list.get(counter).getPhoto()));
                } else {
                    title4OnLibraryPage.setVisible(false);
                    image4OnLibraryPage.setVisible(false);
                }
                if (counter + 1 < listSize) {
                    counter++;
                    title5OnLibraryPage.setText(list.get(counter).getTitle());
                    image5OnLibraryPage.setImage(new Image(list.get(counter).getPhoto()));
                } else {
                    title5OnLibraryPage.setVisible(false);
                    image5OnLibraryPage.setVisible(false);
                }
                if (counter + 1 < listSize) {
                    counter++;
                    title6OnLibraryPage.setText(list.get(counter).getTitle());
                    image6OnLibraryPage.setImage(new Image(list.get(counter).getPhoto()));
                } else {
                    title6OnLibraryPage.setVisible(false);
                    image6OnLibraryPage.setVisible(false);
                }
                if (counter + 1 < listSize) {
                    counter++;
                    title7OnLibraryPage.setText(list.get(counter).getTitle());
                    image7OnLibraryPage.setImage(new Image(list.get(counter).getPhoto()));
                } else {
                    title7OnLibraryPage.setVisible(false);
                    image7OnLibraryPage.setVisible(false);
                }
                if (counter + 1 < listSize) {
                    counter++;
                    title8OnLibraryPage.setText(list.get(counter).getTitle());
                    image8OnLibraryPage.setImage(new Image(list.get(counter).getPhoto()));
                } else {
                    title8OnLibraryPage.setVisible(false);
                    image8OnLibraryPage.setVisible(false);
                }
                if (counter + 1 < listSize) {
                    counter++;
                    title9OnLibraryPage.setText(list.get(counter).getTitle());
                    image9OnLibraryPage.setImage(new Image(list.get(counter).getPhoto()));
                } else {
                    title9OnLibraryPage.setVisible(false);
                    image9OnLibraryPage.setVisible(false);
                }
                if (counter + 1 < listSize) {
                    counter++;
                    title10OnLibraryPage.setText(list.get(counter).getTitle());
                    image10OnLibraryPage.setImage(new Image(list.get(counter).getPhoto()));
                } else {
                    title10OnLibraryPage.setVisible(false);
                    image10OnLibraryPage.setVisible(false);
                }
                if (counter + 1 < listSize) {
                    counter++;
                    title11OnLibraryPage.setText(list.get(counter).getTitle());
                    image11OnLibraryPage.setImage(new Image(list.get(counter).getPhoto()));
                } else {
                    title11OnLibraryPage.setVisible(false);
                    image11OnLibraryPage.setVisible(false);
                }
                if (counter + 1 < listSize) {
                    counter++;
                    title12OnLibraryPage.setText(list.get(counter).getTitle());
                    image12OnLibraryPage.setImage(new Image(list.get(counter).getPhoto()));
                } else {
                    title12OnLibraryPage.setVisible(false);
                    image12OnLibraryPage.setVisible(false);
                }
                if (counter + 1 < listSize) {
                    counter++;
                    title13OnLibraryPage.setText(list.get(counter).getTitle());
                    image13OnLibraryPage.setImage(new Image(list.get(counter).getPhoto()));
                } else {
                    title13OnLibraryPage.setVisible(false);
                    image13OnLibraryPage.setVisible(false);
                }
                if (counter + 1 < listSize) {
                    counter++;
                    title14OnLibraryPage.setText(list.get(counter).getTitle());
                    image14OnLibraryPage.setImage(new Image(list.get(counter).getPhoto()));
                } else {
                    title14OnLibraryPage.setVisible(false);
                    image14OnLibraryPage.setVisible(false);
                }
                if (counter + 1 < listSize) {
                    counter++;
                    title15OnLibraryPage.setText(list.get(counter).getTitle());
                    image15OnLibraryPage.setImage(new Image(list.get(counter).getPhoto()));
                } else {
                    title15OnLibraryPage.setVisible(false);
                    image15OnLibraryPage.setVisible(false);
                }
                sd.setLastCounterChange(15);
                sd.setCounter(counter);
                homeScroll.setVvalue(0);
                if (counter == 14) {
                    backButtonOnHomePage.setDisable(true);
                }
            } else {
                backButtonOnHomePage.setDisable(true);
            }
        }
    }

    private void likeDishView(String title) {
        libraryPageScroll.setVisible(false);
        dishViewScrollOnLibraryPage.setVisible(true);
        dishViewScrollOnLibraryPage.setVvalue(0);
        Dish dish = null;
        for (int i = 0; i < sd.getDishes().size(); i++) {
            if (sd.getDishes().get(i).getTitle().equals(title)) {
                dish = sd.getDishes().get(i);
            }
        }
        if (dish != null) {
            activeDish2 = dish;
            dishTitleInDishViewOnLibraryPage.setText(dish.getTitle());
            dishImageInDishViewOnLibraryPage.setImage(new Image(dish.getPhoto()));
            dishDescriptionInDishViewOnLibraryPage.setText(dish.getDescription());
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < dish.getRecipe().size(); i++) {
                s.append("Етап №").append(i + 1).append("\n").append("     ").append(dish.getRecipe().get(i));
                if (i != dish.getRecipe().size() - 1) {
                    s.append("\n\n");
                }
            }
            dishRecipeInDishViewOnLibraryPage.setText(s.toString());
            //System.out.println(s + "\n");
            //зробить самоизменяющийся размер у label dishRecipe
            //убрать дублірувание інгрідієнтів
            groceryTableViewInDishViewOnLibraryPage.getColumns().clear();
            groceryTableViewInDishViewOnHomePage.setPrefHeight(dish.getGroceryList().size() * 25 + 20);
            ObservableList<Shopping> grocery = FXCollections.observableArrayList();
            grocery.addAll(dish.getGroceryList());
            groceryTableViewInDishViewOnLibraryPage.setItems(grocery);
            TableColumn<Shopping, String> groceryColumn = new TableColumn<>("Продукти");
            groceryColumn.setCellValueFactory(new PropertyValueFactory<>("grocery"));
            groceryTableViewInDishViewOnLibraryPage.getColumns().add(groceryColumn);
            TableColumn<Shopping, Double> weightColumn = new TableColumn<>("Вага");
            weightColumn.setCellValueFactory(new PropertyValueFactory<>("weight"));
            groceryTableViewInDishViewOnLibraryPage.getColumns().add(weightColumn);
            groceryTableViewInDishViewOnLibraryPage.setVisible(true);
            if (sd.getLike() != null && sd.getLike().indexOf(dish) != -1) {
                likeFieldInDishViewOnLibraryPage.setImage(new Image("https://cdn1.iconfinder.com/data/icons/instagram-ui-flat/48/Instagram_UI-07-512.png"));
            } else {
                likeFieldInDishViewOnLibraryPage.setImage(new Image("https://cdn4.iconfinder.com/data/icons/app-custom-ui-1/48/Heart-512.png"));
            }
            numberOfLikeInDishViewOnLibraryPage.setText(String.valueOf(dish.getNumberOfLikes()));
        }
    }
}