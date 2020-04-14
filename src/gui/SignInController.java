package gui;

import database.DatabaseHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import login.Login;
import model.Account;
import settings.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class SignInController {

    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private TextField mailField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button authSignInButton;
    @FXML
    private Label errorMessagesField;
    @FXML
    private Button loginSignUpButton;
    @FXML
    private ProgressIndicator loadProgress;
    @FXML
    private CheckBox savePasswordCheckBox;

    @FXML
    void initialize() {
        loadProgress.setVisible(false);
        authSignInButton.setOnAction(event -> {
            errorMessagesField.setVisible(false);
            String mail = mailField.getText();
            String password = passwordField.getText();
            boolean b = savePasswordCheckBox.isSelected();
            if (!mail.equals("") && !password.equals("")) {
                Account account = Login.signIn(mail, password, new DatabaseHandler(), b);
                if (account != null) {
                    if (Account.getRole().equals("admin")) {
                        authSignInButton.getScene().getWindow().hide();
                        LoaderNewScene.load("/gui/app.fxml");//admin
                    } else {
                        LoaderNewScene.load("/gui/app.fxml");
                        authSignInButton.getScene().getWindow().hide();
                    }
                } else {
                    errorMessagesField.setVisible(true);
                    errorMessagesField.setText(Text.get("SIGN_IN_EMPTY_ERROR"));
                }
            } else {
                errorMessagesField.setVisible(true);
                errorMessagesField.setText(Text.get("SIGN_IN_EMPTY_ERROR"));
            }
        });

        loginSignUpButton.setOnAction(event -> {
            loginSignUpButton.getScene().getWindow().hide();
            LoaderNewScene.load("/gui/signUp.fxml");
        });
    }
}
