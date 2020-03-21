package gui;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class LibraryController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private AnchorPane frameScrollPane;

    @FXML
    private ComboBox<?> filterComboBox;

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
    private ScrollPane scrollPane2;

    @FXML
    private Label dishTitle;

    @FXML
    private ImageView dishImage;

    @FXML
    private Label dishDescription;

    @FXML
    private Label dishRecipe;

    @FXML
    private Button backToCategoryButton;

    @FXML
    private TableView<?> groceryTableView;

    @FXML
    private ImageView likeField;

    @FXML
    private ScrollPane scrollPane1;

    @FXML
    private AnchorPane frameScrollPane1;

    @FXML
    private Button backButton1;

    @FXML
    private Button nextButton1;

    @FXML
    private ImageView image6;

    @FXML
    private Button title6;

    @FXML
    private ImageView image7;

    @FXML
    private ImageView image8;

    @FXML
    private ImageView image9;

    @FXML
    private Button title7;

    @FXML
    private Button title8;

    @FXML
    private Button title9;

    @FXML
    private ImageView image10;

    @FXML
    private ImageView image11;

    @FXML
    private ImageView image12;

    @FXML
    private Button title10;

    @FXML
    private Button title11;

    @FXML
    private Button title12;

    @FXML
    private ImageView image13;

    @FXML
    private ImageView image14;

    @FXML
    private ImageView image15;

    @FXML
    private Button title13;

    @FXML
    private Button title14;

    @FXML
    private Button title15;

    @FXML
    void initialize() {
        assert scrollPane != null : "fx:id=\"scrollPane\" was not injected: check your FXML file 'app.fxml'.";
        assert frameScrollPane != null : "fx:id=\"frameScrollPane\" was not injected: check your FXML file 'app.fxml'.";
        assert filterComboBox != null : "fx:id=\"filterComboBox\" was not injected: check your FXML file 'app.fxml'.";
        assert image1 != null : "fx:id=\"image1\" was not injected: check your FXML file 'app.fxml'.";
        assert image2 != null : "fx:id=\"image2\" was not injected: check your FXML file 'app.fxml'.";
        assert image3 != null : "fx:id=\"image3\" was not injected: check your FXML file 'app.fxml'.";
        assert image4 != null : "fx:id=\"image4\" was not injected: check your FXML file 'app.fxml'.";
        assert image5 != null : "fx:id=\"image5\" was not injected: check your FXML file 'app.fxml'.";
        assert backButton != null : "fx:id=\"backButton\" was not injected: check your FXML file 'app.fxml'.";
        assert nextButton != null : "fx:id=\"nextButton\" was not injected: check your FXML file 'app.fxml'.";
        assert title1 != null : "fx:id=\"title1\" was not injected: check your FXML file 'app.fxml'.";
        assert title2 != null : "fx:id=\"title2\" was not injected: check your FXML file 'app.fxml'.";
        assert title3 != null : "fx:id=\"title3\" was not injected: check your FXML file 'app.fxml'.";
        assert title4 != null : "fx:id=\"title4\" was not injected: check your FXML file 'app.fxml'.";
        assert title5 != null : "fx:id=\"title5\" was not injected: check your FXML file 'app.fxml'.";
        assert scrollPane2 != null : "fx:id=\"scrollPane2\" was not injected: check your FXML file 'app.fxml'.";
        assert dishTitle != null : "fx:id=\"dishTitle\" was not injected: check your FXML file 'app.fxml'.";
        assert dishImage != null : "fx:id=\"dishImage\" was not injected: check your FXML file 'app.fxml'.";
        assert dishDescription != null : "fx:id=\"dishDescription\" was not injected: check your FXML file 'app.fxml'.";
        assert dishRecipe != null : "fx:id=\"dishRecipe\" was not injected: check your FXML file 'app.fxml'.";
        assert backToCategoryButton != null : "fx:id=\"backToCategoryButton\" was not injected: check your FXML file 'app.fxml'.";
        assert groceryTableView != null : "fx:id=\"groceryTableView\" was not injected: check your FXML file 'app.fxml'.";
        assert likeField != null : "fx:id=\"likeField\" was not injected: check your FXML file 'app.fxml'.";
        assert scrollPane1 != null : "fx:id=\"scrollPane1\" was not injected: check your FXML file 'app.fxml'.";
        assert frameScrollPane1 != null : "fx:id=\"frameScrollPane1\" was not injected: check your FXML file 'app.fxml'.";
        assert backButton1 != null : "fx:id=\"backButton1\" was not injected: check your FXML file 'app.fxml'.";
        assert nextButton1 != null : "fx:id=\"nextButton1\" was not injected: check your FXML file 'app.fxml'.";
        assert image6 != null : "fx:id=\"image6\" was not injected: check your FXML file 'app.fxml'.";
        assert title6 != null : "fx:id=\"title6\" was not injected: check your FXML file 'app.fxml'.";
        assert image7 != null : "fx:id=\"image7\" was not injected: check your FXML file 'app.fxml'.";
        assert image8 != null : "fx:id=\"image8\" was not injected: check your FXML file 'app.fxml'.";
        assert image9 != null : "fx:id=\"image9\" was not injected: check your FXML file 'app.fxml'.";
        assert title7 != null : "fx:id=\"title7\" was not injected: check your FXML file 'app.fxml'.";
        assert title8 != null : "fx:id=\"title8\" was not injected: check your FXML file 'app.fxml'.";
        assert title9 != null : "fx:id=\"title9\" was not injected: check your FXML file 'app.fxml'.";
        assert image10 != null : "fx:id=\"image10\" was not injected: check your FXML file 'app.fxml'.";
        assert image11 != null : "fx:id=\"image11\" was not injected: check your FXML file 'app.fxml'.";
        assert image12 != null : "fx:id=\"image12\" was not injected: check your FXML file 'app.fxml'.";
        assert title10 != null : "fx:id=\"title10\" was not injected: check your FXML file 'app.fxml'.";
        assert title11 != null : "fx:id=\"title11\" was not injected: check your FXML file 'app.fxml'.";
        assert title12 != null : "fx:id=\"title12\" was not injected: check your FXML file 'app.fxml'.";
        assert image13 != null : "fx:id=\"image13\" was not injected: check your FXML file 'app.fxml'.";
        assert image14 != null : "fx:id=\"image14\" was not injected: check your FXML file 'app.fxml'.";
        assert image15 != null : "fx:id=\"image15\" was not injected: check your FXML file 'app.fxml'.";
        assert title13 != null : "fx:id=\"title13\" was not injected: check your FXML file 'app.fxml'.";
        assert title14 != null : "fx:id=\"title14\" was not injected: check your FXML file 'app.fxml'.";
        assert title15 != null : "fx:id=\"title15\" was not injected: check your FXML file 'app.fxml'.";

    }
}
