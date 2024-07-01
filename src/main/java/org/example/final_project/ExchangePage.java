package org.example.final_project;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class ExchangePage implements Initializable {
    static String status = "pending";

    @FXML
    private TableView<Table> Table;

    @FXML
    private TableView<Table> TableTransaction;

    @FXML
    private TableColumn<Table, Double> TableAmount;

    @FXML
    private TableColumn<Table, Double> TableAmountTransaction;

    @FXML
    private TableColumn<Table, String> TableMarket;

    @FXML
    private TableColumn<Table, String> TableMarketTransaction;

    @FXML
    private TableColumn<Table, String> TableType;

    @FXML
    private TableColumn<Table, String> TableTypeTransaction;

    @FXML
    private TableColumn<Table, Double> TablePrice;

    @FXML
    private TableColumn<Table, Double> TablePriceTransaction;

    @FXML
    private ChoiceBox<String> ChoiceBoxCurrency;

    @FXML
    private TextField textFieldPrice;
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

    private ObservableList<Table> observableListTable = TableDataSingleton.getInstance().getTableData();
    private ObservableList<Table> observableListTransaction = TableDataSingleton.getInstance().getTransactionData();

    @FXML
    void Buy(ActionEvent event) {
        try {
            double amount = Double.parseDouble(textFieldCurrency.getText());
            double price = Double.parseDouble(textFieldPrice.getText());
            String selectedMarket = ChoiceBoxCurrency.getValue();

            if (selectedMarket != null && !selectedMarket.isEmpty()) {
                Table newItem = new Table(selectedMarket, amount, price, "Buy");
                observableListTable.add(newItem);

                // Add to history
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String currentDate = dateFormat.format(new Date());
                String status = "pending";
                Table historyItem = new Table(selectedMarket, amount, price, "Buy",status, currentDate);
                HistoryPage.addToHistory(historyItem);

                textFieldCurrency.clear();
                textFieldPrice.clear();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Please select a market from the ChoiceBox.");
                alert.showAndWait();
            }
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Please enter a valid number.");
            alert.showAndWait();
        }
    }

    @FXML
    void HomePage(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnHome.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("HomePage.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Home Page");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void Profile(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnProfile.getScene().getWindow();
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(ProfilePage.class.getResource("ProfilePage.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Profile");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void Sell(ActionEvent event) {
        try {
            double price = Double.parseDouble(textFieldPrice.getText());
            double amount = Double.parseDouble(textFieldCurrency.getText());

            String selectedMarket = ChoiceBoxCurrency.getValue();

            if (selectedMarket != null && !selectedMarket.isEmpty()) {
                Table newItem = new Table(selectedMarket, amount, price, "Sell");
                observableListTable.add(newItem);

                // Add to history
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String currentDate = dateFormat.format(new Date());
                String status = "pending";
                Table historyItem = new Table(selectedMarket, amount, price, "Sell", status, currentDate);
                HistoryPage.addToHistory(historyItem);

                textFieldCurrency.clear();
                textFieldPrice.clear();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Please select a market from the ChoiceBox.");
                alert.showAndWait();
            }
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Please enter a valid number.");
            alert.showAndWait();
        }
    }

    @FXML
    void Wallet(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnWallet.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("WalletPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Wallet Page");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TableMarket.setCellValueFactory(new PropertyValueFactory<>("tableMarketExchange"));
        TableAmount.setCellValueFactory(new PropertyValueFactory<>("tableAmount"));
        TablePrice.setCellValueFactory(new PropertyValueFactory<>("tableBasePrice"));
        TableType.setCellValueFactory(new PropertyValueFactory<>("tableType"));

        TableMarketTransaction.setCellValueFactory(new PropertyValueFactory<>("tableMarketExchange"));
        TableAmountTransaction.setCellValueFactory(new PropertyValueFactory<>("tableAmount"));
        TablePriceTransaction.setCellValueFactory(new PropertyValueFactory<>("tableBasePrice"));
        TableTypeTransaction.setCellValueFactory(new PropertyValueFactory<>("tableType"));

        ChoiceBoxCurrency.getItems().addAll(Currency);

        Table.setItems(observableListTable);
        TableTransaction.setItems(observableListTransaction);
        TableTransaction.refresh();
        TableType.setCellFactory(new Callback<>() {
            @Override
            public TableCell<Table, String> call(TableColumn<Table, String> param) {
                return new TableCell<>() {
                    @Override
                    protected void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item != null && !empty) {
                            setText(String.valueOf(item));
                            setStyle("-fx-text-fill: blue;");
                            setOnMouseClicked(event -> {
                                Table rowData = getTableView().getItems().get(getIndex());
                                if (rowData != null) {
                                    observableListTransaction.add(rowData);
                                    TableTransaction.refresh();
                                }
                            });
                        } else {
                            setText(null);
                        }
                    }
                };
            }
        });
    }
}
