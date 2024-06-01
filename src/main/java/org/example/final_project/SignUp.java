package org.example.final_project;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.regex.Pattern;
public class SignUp implements Initializable {
    private int randomNumber;
    @FXML
    private Button btnSignUp;
    @FXML
    private Label lblCaptcha;
    @FXML
    private Label lblCreateAccount;
    @FXML
    private Label lblRandom;
    @FXML
    private Label lblErrorCaptcha;
    @FXML
    private Label lblErrorEmail;
    @FXML
    private Label lblErrorFirstName;
    @FXML
    private Label lblErrorLastName;
    @FXML
    private Label lblErrorPassword;
    @FXML
    private Label lblErrorPhoneNumber;
    @FXML
    private Label lblErrorRePassword;
    @FXML
    private Label lblErrorUsername;
    @FXML
    private TextField textCaptchaCode;
    @FXML
    private TextField textEmail;
    @FXML
    private TextField textFirstName;
    @FXML
    private TextField textLastName;
    @FXML
    private PasswordField textPassword;
    @FXML
    private TextField textPhoneNumber;
    @FXML
    private PasswordField textRePassword;
    @FXML
    private TextField textUsername;
    @FXML
    void SignUp(ActionEvent event) throws IOException {
        TextFieldCaptchaCode(event);
        TextFieldEmail(event);
        TextFieldFirstName(event);
        TextFieldLastName(event);
        TextFieldPassword(event);
        TextFieldRePassword(event);
        TextFieldPhoneNumber(event);
        TextFieldUsername(event);
        if(
        TextFieldCaptchaCode(event)&&
        TextFieldEmail(event)&&
        TextFieldFirstName(event)&&
        TextFieldLastName(event)&&
        TextFieldPassword(event)&&
        TextFieldRePassword(event)&&
        TextFieldPhoneNumber(event)&&
        TextFieldUsername(event)){
            Stage stage =(Stage) btnSignUp.getScene().getWindow();
            stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(HomePage.class.getResource("HomePage.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Hello!");
            stage.setScene(scene);
            stage.show();
        }
    }
    @FXML
    public boolean TextFieldCaptchaCode(ActionEvent event) {
        if(!(randomNumber== Integer.parseInt(textCaptchaCode.getText()))){
            lblErrorCaptcha.setText("CAPTCHA code is incorrect.");
            return false;
        }else {
            lblErrorCaptcha.setText("");
            return true;
        }
    }
    @FXML
    boolean TextFieldEmail(ActionEvent event) {
        String regex = "^[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.com$";
        if (Pattern.matches(regex, textEmail.getText())) {
            lblErrorEmail.setText("");
            return true;
        }else{
            lblErrorEmail.setText("Email is incorrect.");
            return false;}
    }
    @FXML
    boolean TextFieldFirstName(ActionEvent event) {
        String regex = "^[a-zA-Z]{1,18}$";
        if(Pattern.matches(regex, textFirstName.getText())){
            lblErrorFirstName.setText("");
            return true;
        }else {
            lblErrorFirstName.setText("First name is incorrect.");
            return false;
        }
    }
    @FXML
    boolean TextFieldLastName(ActionEvent event) {
        String regex = "^[a-zA-Z]{1,18}$";
        if ((Pattern.matches(regex, textLastName.getText()))) {
            lblErrorLastName.setText("");
            return true;
        }else {
            lblErrorLastName.setText("Last name is incorrect.");
            return false;
        }
    }
    @FXML
    boolean TextFieldPassword(ActionEvent event) {
        String regex = "^[a-zA-Z0-9]{8,12}$";
        if (Pattern.matches(regex, textPassword.getText())){
            lblErrorPassword.setText("");
            return true;
        }else{
            lblErrorPassword.setText("Password is incorrect.");
            return false;
        }
    }
    @FXML
    boolean TextFieldRePassword(ActionEvent event) {
        String regex = "^[a-zA-Z0-9]{8,12}$";
        if (Pattern.matches(regex, textRePassword.getText())){
            if(textRePassword.getText().equals(textPassword.getText())){
            lblErrorRePassword.setText("");}
            return true;
        }else{
            lblErrorRePassword.setText("Repeat Password is incorrect.");
            return false;
        }
    }
    @FXML
    boolean TextFieldPhoneNumber(ActionEvent event) {
        String regex = "^09[0-9]{9}$";
        if (Pattern.matches(regex, textPhoneNumber.getText())){
            lblErrorPhoneNumber.setText("");
            return true;
        }else{
            lblErrorPhoneNumber.setText("Phone number is incorrect.");
            return false;
        }
    }
    @FXML
    boolean TextFieldUsername(ActionEvent event) {
        String regex = "^[a-zA-Z0-9]{5,12}$";
        if(( Pattern.matches(regex, textUsername.getText()))){
            lblErrorUsername.setText("");
            return true;
        }else {
            lblErrorUsername.setText("Username is incorrect.");
            return false;
        }
    }
    @Override
    public void initialize(URL url, java.util.ResourceBundle resourceBundle) {
        Random random = new Random();
         randomNumber = 10000 + random.nextInt(90000);
        lblRandom.setText(String.valueOf(randomNumber));
    }
}
