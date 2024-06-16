package org.example.final_project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ExchangePage implements Initializable {

    @FXML
    private ChoiceBox<String> ChoiceBoxCurrency;
    private final String[] Currency = {"USD", "EUR", "TOMAN", "YEN", "GBP"};
    @FXML
    private Button btnBuy;

    @FXML
    private Button btnHome;

    @FXML
    private Button btnProfile;

    @FXML
    private Button btnSell;

    @FXML
    private Button btnWallet;

    @FXML
    private TextField textFieldCurrency;

    @FXML
    void Buy(ActionEvent event) {

    }

    @FXML
    void HomePage(ActionEvent event) {

    }

    @FXML
    void Profile(ActionEvent event) {

    }

    @FXML
    void Sell(ActionEvent event) {

    }

    @FXML
    void Wallet(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ChoiceBoxCurrency.getItems().addAll(Currency);
    }
}
