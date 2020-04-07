package gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import login.DatabaseHandler;
import login.Login;
import model.Account;
import settings.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class SignUpController {

    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private TextField mailField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button signUpButton;
    @FXML
    private TextField usernameField;
    @FXML
    private ComboBox locationComboBox;
    @FXML
    private Label signUpErrorMessages;
    @FXML
    private Button authSignInButton;
    @FXML
    private CheckBox savePasswordCheckBox;

    @FXML
    void initialize() {
        ObservableList<String> comboBoxList = FXCollections.observableArrayList("Россия, ru", "Україна, ua", "England, uk");
        locationComboBox.setValue(Text.get("LOCATION"));
        locationComboBox.setItems(comboBoxList);

        signUpButton.setOnAction(event -> {
            String username = usernameField.getText();
            String mail = mailField.getText();
            String password = passwordField.getText();
            String locale = locationComboBox.getValue().toString();
            if (!username.equals("") && !mail.equals("") && !password.equals("") && !locale.equals("") && !locale.equals("Страна, язык")) {
                Account account = Login.signUp(username, mail, password, locale, new DatabaseHandler(), savePasswordCheckBox.isSelected());
                if (account != null) {
                    signUpButton.getScene().getWindow().hide();
                    LoaderNewScene.load("/gui/app.fxml");
                } else {
                    signUpErrorMessages.setText(Text.get("SIGN_UP_REPEAT_ERROR"));
                }
            } else {
                signUpErrorMessages.setText(Text.get("SIGN_UP_EMPTY_ERROR"));
            }
        });

        authSignInButton.setOnAction(event -> {
            authSignInButton.getScene().getWindow().hide();
            LoaderNewScene.load("/gui/SignIn.fxml");
        });
    }
}
