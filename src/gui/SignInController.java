package gui;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    private ImageView facebookIcon;

    @FXML
    void initialize() {
        facebookIcon.setImage(new Image("https://cdn1.iconfinder.com/data/icons/logotypes/32/square-facebook-512.png"));
        loadProgress.setVisible(false);
        authSignInButton.setOnAction(event -> {
            errorMessagesField.setVisible(false);
            String mail = mailField.getText();
            String password = passwordField.getText();
            boolean b = savePasswordCheckBox.isSelected();
            if (!mail.equals("") && !password.equals("")) {
                Login.signIn(mail, password, b);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Account account = new Account();
                if (account.getIdUser() != -1) {
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
        facebookIcon.setOnMouseClicked(mouseEvent -> {
        });
    }
}
