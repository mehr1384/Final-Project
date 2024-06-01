package org.example.final_project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.regex.Pattern;


public class logIn implements Initializable {

    @FXML
    private Button btnSignUp;
    @FXML
    private Button btnLogIn;
    @FXML
    private Button btnForgotPassword;
    @FXML
    private Label lblRandom;
    @FXML
    private TextField password;
    @FXML
    private Label usernameError;
    @FXML
    private Label passError;
    @FXML
    private TextField username;
    @FXML
    private Label captchaError;
    @FXML
    private TextField captcha;
    public int randomNumber;

    @Override
    public void initialize(URL url, java.util.ResourceBundle resourceBundle) {
        Random random = new Random();
        randomNumber = 10000 + random.nextInt(90000);
        lblRandom.setText(String.valueOf(randomNumber));
    }

    @FXML
    public boolean validatePassword(ActionEvent event) {
        String pass = password.getText();
        String regex = "^[a-zA-Z0-9]{8,12}$";
        if (!(Pattern.matches(regex, pass))) {
            passError.setText("Password is incorrect!");
            return false;
        } else {
            passError.setText("");
            return true;
        }
    }

    public boolean validateUsername(ActionEvent event) {
        String regex = "^[a-zA-Z0-9]{5,12}$";
        if (!(Pattern.matches(regex, username.getText()))) {
            usernameError.setText("Username is incorrect!");
            return false;
        } else {
            usernameError.setText("");
            return true;
        }
    }
    public boolean validateCaptcha(ActionEvent event){
        if (!(randomNumber == Integer.parseInt(captcha.getText()))) {
            captchaError.setText("Captcha is incorrect!");
            return false;
        } else {
            captchaError.setText("");
            return true;
        }
    }
    public void checkAllValidate(ActionEvent event) throws IOException {
        validatePassword(event);
        validateCaptcha(event);
        validateUsername(event);
        if(validatePassword(event) && validateCaptcha(event) && validateUsername(event)){
            Stage stage =(Stage) btnLogIn.getScene().getWindow();
            stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(HomePage.class.getResource("HomePage.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Hello!");
            stage.setScene(scene);
            stage.show();
        }
    }
    @FXML
    void SignUp(ActionEvent event) throws IOException {
        Stage stage =(Stage) btnSignUp.getScene().getWindow();
         stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(SignUp.class.getResource("SignUp.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void forgotPassword(ActionEvent event) throws IOException {
        Stage stage =(Stage) btnForgotPassword.getScene().getWindow();
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(ForgotPassword.class.getResource("forgotPassword.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
}