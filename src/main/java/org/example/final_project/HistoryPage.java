package org.example.final_project;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HistoryPage implements Initializable {

    @FXML
    private TableView<Table> table;

    @FXML
    private TableColumn<Table, Double> tableAmount;
    @FXML
    private TableColumn<Table, String> tableStatus;

    @FXML
    private TableColumn<Table, String> tableDate;

    @FXML
    private TableColumn<Table, String> tableMarket;

    @FXML
    private TableColumn<Table, Double> tablePrice;

    @FXML
    private TableColumn<Table, String> tableType;

    @FXML
    private Button btnExport;

    public static ObservableList<Table> observableListTable = FXCollections.observableArrayList();

    @FXML
    void Export(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnExport.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ExchangePage.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Wallet Page");
        stage.setScene(scene);
        stage.show();
    }
    public static void updateHistory(Table item, String status) {
        for (Table tableItem : observableListTable) {
            if (tableItem.equals(item)) {
                tableItem.setTableStatus(status);
                break;
            }
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tableMarket.setCellValueFactory(new PropertyValueFactory<>("tableMarketHistory"));
        tableAmount.setCellValueFactory(new PropertyValueFactory<>("tableAmountHistory"));
        tablePrice.setCellValueFactory(new PropertyValueFactory<>("tableBasePriceHistory"));
        tableType.setCellValueFactory(new PropertyValueFactory<>("tableTypeHistory"));
        tableStatus.setCellValueFactory(new PropertyValueFactory<>("tableStatus"));
        tableDate.setCellValueFactory(new PropertyValueFactory<>("tableDate"));

        table.setItems(observableListTable);
    }

    public static void addToHistory(Table item) {
        observableListTable.add(item);
    }
}
