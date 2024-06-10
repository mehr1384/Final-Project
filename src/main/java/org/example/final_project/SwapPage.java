package org.example.final_project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SwapPage implements Initializable {

    @FXML
    private Button btnProfile;

    @FXML
    private Button btnHomePage;

    @FXML
    private Button btnSwap;

    @FXML
    private Button btnToken;

    @FXML
    private ChoiceBox<String> ChoiceBoxChangeTo;

    @FXML
    private ChoiceBox<String> ChoiceBoxSwap;
    @FXML
    private Label lblChangeTo;

    @FXML
    private Label lblSwap;
    private String[] Swap = {"Bitcoin", "Litecoin", "Tether", "BAT", "Etherum", "Cardano"};
    private String[] ChangeTo = {"Bitcoin", "Litecoin", "Tether", "BAT", "Etherum", "Cardano"};

    public void initialize(URL url, ResourceBundle resourceBundle) {
        ChoiceBoxChangeTo.getItems().addAll(ChangeTo);
        ChoiceBoxSwap.getItems().addAll(Swap);
        ChoiceBoxSwap.setOnAction(this::getSwap);
        ChoiceBoxChangeTo.setOnAction(this::getSwap);
    }

    public void getSwap(ActionEvent event) {
        String swap = ChoiceBoxSwap.getValue();
        String ChangeTo = ChoiceBoxChangeTo.getValue();
        lblSwap.setText(swap);
        lblChangeTo.setText(ChangeTo);

    }
    @FXML
    void HomePage(ActionEvent event) throws IOException {
        Stage stage =(Stage) btnHomePage.getScene().getWindow();
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(HomePage.class.getResource("HomePage.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void ProfilePage(ActionEvent event) throws IOException {
        Stage stage =(Stage) btnProfile.getScene().getWindow();
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(ProfilePage.class.getResource("ProfilePage.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Profile");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void Swap(ActionEvent event) {

    }

    @FXML
    void TokenPage(ActionEvent event) throws IOException {
        Stage stage =(Stage) btnToken.getScene().getWindow();
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(ProfilePage.class.getResource("TokenPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Token");
        stage.setScene(scene);
        stage.show();

    }
}