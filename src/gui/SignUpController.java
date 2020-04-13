package gui;

import database.DatabaseHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import login.Filter;
import login.Login;
import login.MailSender;
import settings.Settings;
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
    String username;
    String mail;
    String password;
    String locale;
    int confirmMail;
    Boolean savePassword;
    @FXML
    private Label confirmLabel;
    @FXML
    private TextField confirmField;

    @FXML
    void initialize() {
        confirmField.setVisible(false);
        confirmLabel.setVisible(false);
        usernameField.setVisible(true);
        mailField.setVisible(true);
        passwordField.setVisible(true);
        locationComboBox.setVisible(true);
        savePasswordCheckBox.setVisible(true);
        ObservableList<String> comboBoxList = FXCollections.observableArrayList("Россия, ru", "Україна, ua", "England, uk");
        locationComboBox.setValue(Text.get("LOCATION"));
        locationComboBox.setItems(comboBoxList);

        signUpButton.setOnAction(event -> {
            if (usernameField.isVisible() && mailField.isVisible() && passwordField.isVisible() && locationComboBox.isVisible()) {
                username = usernameField.getText();
                mail = mailField.getText();
                password = passwordField.getText();
                locale = locationComboBox.getValue().toString();
                savePassword = savePasswordCheckBox.isSelected();
                DatabaseHandler dbHandler = new DatabaseHandler();
                if (!username.equals("") && !mail.equals("") && !password.equals("") && !locale.equals("") && !locale.equals("Страна, язык")) {
                    System.out.println(Filter.verifyUsername(username) + " " + Filter.verifyMail(mail) + " " + Filter.verifyPassword(password) + " " + Filter.verifyLocation(locale) + " " +
                            dbHandler.verifyUsernameDB(username) + " " + dbHandler.verifyMailDB(mail));
                    if (Filter.verifyUsername(username) && Filter.verifyMail(mail) && Filter.verifyPassword(password) && Filter.verifyLocation(locale) &&
                            dbHandler.verifyUsernameDB(username) && dbHandler.verifyMailDB(mail)) {
                        usernameField.setVisible(false);
                        mailField.setVisible(false);
                        passwordField.setVisible(false);
                        locationComboBox.setVisible(false);
                        savePasswordCheckBox.setVisible(false);
                        confirmLabel.setVisible(true);
                        confirmField.setVisible(true);
                        confirmMail = (int) Math.floor(Math.random() * 1000000);
                        MailSender sender = new MailSender(Settings.MAIL_ADDRESS, Settings.MAIL_PASSWORD);
                        sender.send("Підтвердіть почту для реєстрації в додатку RecipeBook", "Ваш код: " + confirmMail, "recipebook@gmail.com", "olexienko.vova.k@gmail.com");
                    } else {
                        signUpErrorMessages.setText(Text.get("SIGN_UP_REPEAT_ERROR"));
                    }
                } else {
                    signUpErrorMessages.setText(Text.get("SIGN_UP_EMPTY_ERROR"));
                }
            } else {
                if (confirmMail == Integer.parseInt(confirmField.getText().trim())) {
                    Login.signUp(username, mail, password, locale, new DatabaseHandler(), savePassword);
                    signUpButton.getScene().getWindow().hide();
                    LoaderNewScene.load("/gui/app.fxml");
                }
            }
        });

        authSignInButton.setOnAction(event -> {
            authSignInButton.getScene().getWindow().hide();
            LoaderNewScene.load("/gui/signIn.fxml");
        });
    }
}
