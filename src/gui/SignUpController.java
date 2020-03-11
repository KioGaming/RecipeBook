package gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import login.Account;
import login.DatabaseHandler;
import login.Login;
import settings.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SignUpController {

    ObservableList<String> comboBoxList = FXCollections.observableArrayList("Россия, ru", "Україна, ua", "England, uk");

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
    void initialize() {
        locationComboBox.setValue(Text.get("LOCATION"));
        locationComboBox.setItems(comboBoxList);

        signUpButton.setOnAction(event -> {
            String username = usernameField.getText();
            String mail = mailField.getText();
            String password = passwordField.getText();
            String locale = locationComboBox.getValue().toString();
            if (!username.equals("") && !mail.equals("") && !password.equals("") && !locale.equals("") && !locale.equals("Страна, язык")) {
                Account account = Login.signUp(username, mail, password, locale, new DatabaseHandler());
                if (account != null) {
                    signUpButton.getScene().getWindow().hide();
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("/gui/app.fxml"));
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
                } else {
                    signUpErrorMessages.setText(Text.get("SIGN_UP_REPEAT_ERROR"));
                }
            } else {
                signUpErrorMessages.setText(Text.get("SIGN_UP_EMPTY_ERROR"));
            }
        });

        authSignInButton.setOnAction(event -> {
            authSignInButton.getScene().getWindow().hide();
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
    }
}
