package org.example.final_project;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;
import org.example.final_project.Table;

import java.net.URL;
import java.util.ResourceBundle;

public class HomePage implements Initializable {
    @FXML
    public TableView<Table> TableView;

    @FXML
    public TableColumn<Table, Double> TableConversion;

    @FXML
    public TableColumn<Table, String> TableMarket;

    @FXML
    public TableColumn<Table, Double> TableMax;

    @FXML
    public TableColumn<Table, Double> TableMin;

    @FXML
    public TableColumn<Table, Double> TablePrice;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TableMarket.setCellValueFactory(new PropertyValueFactory<>("TableMarket"));
        TablePrice.setCellValueFactory(new PropertyValueFactory<>("TablePrice"));
        TableConversion.setCellValueFactory(new PropertyValueFactory<>("TableConversion"));
        TableMin.setCellValueFactory(new PropertyValueFactory<>("TableMin"));
        TableMax.setCellValueFactory(new PropertyValueFactory<>("TableMax"));

         //تنظیم CellFactory برای TableMarket
        TableMarket.setCellFactory(new Callback<>() {
            @Override
            public TableCell<Table, String> call(TableColumn<Table, String> param) {
                return new TableCell<Table, String>() {
                    @Override
                    protected void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item != null) {
                            setText(item);
                            setStyle("-fx-text-fill: blue;"); // تغییر رنگ متن به آبی برای همه موارد
                        } else {
                            setText(null);
                        }
                    }
                };
            }
        });
        TableConversion.setCellFactory(column -> new TableCell<Table, Double>() {
            @Override
            public void updateItem(Double item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                    setStyle("");  // حذف هرگونه استایل قبلی
                } else {
                    setText("%"+item.toString()+"+");
                    setStyle(" -fx-text-fill: green;");
                }
            }
        });
        TableView.setItems(observableList);
    }
    int price=55;
    private ObservableList<Table> observableList = FXCollections.observableArrayList(
            new Table("faeze", price, 1, 1, 1),
            new Table("example", 22.0, 2, 2, 2)
    );
}