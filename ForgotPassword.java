package org.example.final_project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;

public class ForgotPassword {

    @FXML
    private Button btnContinueCode;

    @FXML
    private Button btnContinueEmail;
    @FXML
    private Button btnSignUp;

    @FXML
    private Label lblCode;

    @FXML
    private Label lblEmail;
    @FXML
    private TextField textCode;

    @FXML
    private TextField textEmail;
    @FXML
    void ContinueCode(ActionEvent event) throws IOException {
        Stage stage =(Stage) btnContinueCode.getScene().getWindow();
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(HomePage.class.getResource("HomePage.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void ContinueEmail(ActionEvent event) {
        lblEmail.setVisible(false);
        btnContinueEmail.setVisible(false);
        textEmail.setVisible(false);
        lblCode.setVisible(true);
        btnContinueCode.setVisible(true);
        textCode.setVisible(true);


//        String code = generateCode();
//
//        // ارسال کد به ایمیل کاربر
//        String userEmail = textEmail.getText();
//
//        // فرض کنید کاربر ایمیل و کلمه عبور خود را از طریق ورودی‌ها گرفته و به تابع sendEmail ارسال می‌کند
//        String username = "@yahoo.com";
//        String password = "";
//
//        EmailSender.sendEmail(userEmail, code, username, password);
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
    void TextFieldCode(ActionEvent event) {

    }

    @FXML
    void TextFieldEmail(ActionEvent event) {

    }
    public static String generateCode() {
        Random random = new Random();
        int code = 10000 + random.nextInt(90000);
        return String.valueOf(code);
    }
}
