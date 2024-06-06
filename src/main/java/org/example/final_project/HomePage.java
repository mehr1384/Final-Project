package org.example.final_project;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
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
    @FXML
    private Button btnProfile;

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
    private double[] price = new double[]{5,22};



    private ObservableList<Table> observableList = FXCollections.observableArrayList(
            new Table("faeze", price[0], 0,price[0], price[0]),
            new Table("example", price[1], 0, price[1], price[1])

    );

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TableMarket.setCellValueFactory(new PropertyValueFactory<>("TableMarket"));
        TablePrice.setCellValueFactory(new PropertyValueFactory<>("TablePrice"));
        TableConversion.setCellValueFactory(new PropertyValueFactory<>("TableConversion"));
        TableMin.setCellValueFactory(new PropertyValueFactory<>("TableMin"));
        TableMax.setCellValueFactory(new PropertyValueFactory<>("TableMax"));


        TableMarket.setCellFactory(new Callback<>() {
            @Override
            public TableCell<Table, String> call(TableColumn<Table, String> param) {
                return new TableCell<>() {
                    @Override
                    protected void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item != null) {
                            setText(item);
                            setStyle("-fx-text-fill: blue;");
                        } else {
                            setText(null);
                        }
                    }
                };
            }
        });

        TableConversion.setCellFactory(column -> new TableCell<>() {
            @Override
            public void updateItem(Double item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                    setStyle("");
                } else {

                   // String formattedValue = String.format("%.2f", item); // فرمت دو رقم اعشار
                    setText("%" + String.valueOf(String.format("%.2f", item)) + "+");
                    setStyle(" -fx-text-fill: green;");
//                    DecimalFormat df = new DecimalFormat("#.##");
//                    setText("%" + df.format(item) + "+");
                }
            }
        });

        TableView.setItems(observableList);

        // Initialize the timeline for updating data every minute
        Timeline timeline = new Timeline(new KeyFrame(Duration.minutes(1), event -> updateData()));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        TableMarket.setCellFactory(new Callback<>() {
            @Override
            public TableCell<Table, String> call(TableColumn<Table, String> param) {
                return new TableCell<>() {
                    @Override
                    protected void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item != null) {
                            setText(item);
                            setStyle("-fx-text-fill: blue;");
                            // اضافه کردن رویداد کلیک برای هر سلول
                            setOnMouseClicked(event -> {
                                if (!isEmpty()) {
                                    openPage(); // فراخوانی متد باز کردن صفحه "Song App"
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

    public void openPage() {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SignUp.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("SignUp");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
        private void updateData() {
        for (Table item : observableList) {

            CurrencyRate rate = new CurrencyRate(item.getTableMarket(), item.getTablePrice(), item.getTablePrice() + 1);
            item.setTablePrice(item.getTablePrice()+1);
            item.setTableConversion(rate.getPercentChange());
            if(item.getTableMax() < item.getTablePrice() ){
                item.setTableMax(item.getTablePrice()) ;
            }
            if(item.getTableMin() > item.getTablePrice() ){
                item.setTableMin(item.getTablePrice()) ;
            }

        }


        TableView.refresh();

    }
}