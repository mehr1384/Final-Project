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
    private ChoiceBox<String> ChoiceBoxRefrencePrice;

    @FXML
    private Label lblChangeTo;

    @FXML
    private Label lblSwap;

    @FXML
    private Label textFieldChangeToOutput;

    @FXML
    private Label lblRefrencePrice; // Label for displaying the reference price

    @FXML
    private TextField textFieldSwapEntrance;

    private String[] Swap = {"USD", "EUR", "TOMAN", "YEN", "GBP"};
    private String[] ChangeTo = {"USD", "EUR", "TOMAN", "YEN", "GBP"};
    private String[] refrencePrice = {"EUR", "TOMAN", "YEN", "GBP"};

    public void initialize(URL url, ResourceBundle resourceBundle) {
        ChoiceBoxChangeTo.getItems().addAll(ChangeTo);
        ChoiceBoxSwap.getItems().addAll(Swap);
        ChoiceBoxRefrencePrice.getItems().addAll(refrencePrice);

        // Add listener to ChoiceBoxRefrencePrice
        ChoiceBoxRefrencePrice.setOnAction(this::updateRefrencePrice);
    }

    // Method to handle updating the reference price label
    public void updateRefrencePrice(ActionEvent event) {
        String selectedPrice = ChoiceBoxRefrencePrice.getValue();
        switch (selectedPrice) {
            case "EUR":
                lblRefrencePrice.setText(String.valueOf(CurrencyDataLoader.EUR));
                break;
            case "YEN":
                lblRefrencePrice.setText(String.valueOf(CurrencyDataLoader.YEN));
                break;
            case "TOMAN":
                lblRefrencePrice.setText(String.valueOf(CurrencyDataLoader.TOMAN));
                break;
            case "GBP":
                lblRefrencePrice.setText(String.valueOf(CurrencyDataLoader.GBP));
                break;
        }
    }
    @FXML
    void HomePage(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnHomePage.getScene().getWindow();
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(HomePage.class.getResource("HomePage.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
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
    void Swap(ActionEvent event) {

        changeToEachOther();
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
    void SwapEntrance(ActionEvent event) {
    }
    double first=0;
    double second = 0;
    public void changeToEachOther(){
        String swap = ChoiceBoxSwap.getValue();
        String changeTo = ChoiceBoxChangeTo.getValue();

        switch (swap) {
            case "EUR":
                first = CurrencyDataLoader.EUR;
                System.out.println(CurrencyDataLoader.EUR + "Eur");
                break;
            case "YEN":
                first = CurrencyDataLoader.YEN;
                break;
            case "TOMAN":
                first = CurrencyDataLoader.TOMAN;
                break;
            case "GBP":
                first = CurrencyDataLoader.GBP;
                break;
            case "USD":
                System.out.println(CurrencyDataLoader.USD + "usd");
                first = 1;
                break;
        }
        switch (changeTo) {
            case "EUR":
                second = CurrencyDataLoader.EUR;
                break;
            case "YEN":
                second = CurrencyDataLoader.YEN;
                break;
            case "TOMAN":
                second = CurrencyDataLoader.TOMAN;
                break;
            case "GBP":
                second = CurrencyDataLoader.GBP;
                break;
            case "USD":
                second = 1;
                break;
        }
        System.out.println(first + "first");
        System.out.println(second + "second");
        textFieldChangeToOutput.setText(String.valueOf((second / first) * Double.parseDouble(textFieldSwapEntrance.getText())));
    }
}