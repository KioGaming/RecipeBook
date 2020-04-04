package gui;

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
        authSignInButton.setOnAction(event -> {
            //errorMessagesField.setVisible(false);
            //loadProgress.setVisible(true);
            String mail = mailField.getText();
            String password = passwordField.getText();
            boolean b = savePasswordCheckBox.isSelected();
            //loadProgress.setProgress(0.25f);
            if (!mail.equals("") && !password.equals("")) {
                //loadProgress.setProgress(0.5f);a
                Account account = Login.signIn(mail, password, new DatabaseHandler(), b);
                //loadProgress.setProgress(0.75f);
                if (account != null) {
                    //loadProgress.setProgress(1);
                    if (Account.getRole().equals("admin")) {
                        authSignInButton.getScene().getWindow().hide();
                        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(getClass().getResource("/gui/admin.fxml"));
                        try {
                            loader.load();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        Parent root = loader.getRoot();
                        Stage stage = new Stage();
                        stage.setTitle(Text.get("PROGRAM_NAME"));
                        stage.setScene(new Scene(root));
                        stage.show();
                    } else {
                        authSignInButton.getScene().getWindow().hide();
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
                        stage.setMaxHeight(729);
                        stage.setMinHeight(729);
                        stage.setMaxWidth(1205);
                        stage.setMinWidth(1205);
                        stage.show();
                    }
                } else {
                    //loadProgress.setProgress(0);
                    //loadProgress.setVisible(false);
                    //errorMessagesField.setVisible(true);
                    errorMessagesField.setText(Text.get("SIGN_IN_EMPTY_ERROR"));
                    //Добавить ошибку
                }
            } else {
                //loadProgress.setProgress(0);
                //loadProgress.setVisible(false);
                //errorMessagesField.setVisible(true);
                errorMessagesField.setText(Text.get("SIGN_IN_EMPTY_ERROR"));
            }
           /* authSignInButton.getScene().getWindow().hide();
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
            stage.setMaxHeight(729);
            stage.setMinHeight(729);
            stage.setMaxWidth(1205);
            stage.setMinWidth(1205);
            stage.show();*/
        });

        loginSignUpButton.setOnAction(event -> {
            loginSignUpButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/gui/SignUp.fxml"));
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
