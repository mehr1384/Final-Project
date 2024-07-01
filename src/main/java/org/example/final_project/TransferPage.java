package org.example.final_project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TransferPage implements Initializable {

    @FXML
    private ChoiceBox<String> ChoiceBoxChangeTo;
    private final String[] Currency = {"USD", "EUR", "TOMAN", "YEN", "GBP"};

    @FXML
    private Button btnHomePage;

    @FXML
    private Button btnProfile;

    @FXML
    private Button btnToken;

    @FXML
    private Button btnTransfer;

    @FXML
    private TextField textFieldAmount;

    @FXML
    private TextField textFieldID;

    @FXML
    void HomePage(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnHomePage.getScene().getWindow();
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(ProfilePage.class.getResource("HomePage.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Home Page");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void ProfilePage(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnProfile.getScene().getWindow();
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(ProfilePage.class.getResource("ProfilePage.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Profile");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void TokenPage(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnToken.getScene().getWindow();
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(ProfilePage.class.getResource("TokenPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Token");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void Transfer(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ChoiceBoxChangeTo.getItems().addAll(Currency);
    }
}
