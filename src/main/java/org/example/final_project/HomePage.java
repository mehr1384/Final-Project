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
    private double[] price = new double[]{5,22};
    private double lastEUR;
    private double lastTOMAN;
    private double lastGBP;
    private double lastYEN;
    private  double[] minPrice = new double[]{0.9,42000.0,110.0,0.8};
    private double[] maxPrice = new double[]{0.9,42000.0,110.0,0.8};
    private CurrencyDataLoader currencyDataLoader = new CurrencyDataLoader() ;

    @FXML
    private Button btnProfile;

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



    private ObservableList<Table> observableList = FXCollections.observableArrayList(

            new Table("USD", 1, 1,1, 1),
            new Table("EUR", CurrencyDataLoader.EUR, 0, maxPrice[0], minPrice[0]),
            new Table("TOMAN",CurrencyDataLoader.TOMAN, 0,maxPrice[1], minPrice[1]),
            new Table("YEN",CurrencyDataLoader.YEN, 0,maxPrice[2], minPrice[2]),
            new Table("GBP", CurrencyDataLoader.GBP, 0, maxPrice[3], minPrice[3])

    );
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TableMarket.setCellValueFactory(new PropertyValueFactory<>("TableMarket"));
        TablePrice.setCellValueFactory(new PropertyValueFactory<>("TablePrice"));
        TableConversion.setCellValueFactory(new PropertyValueFactory<>("TableConversion"));
        TableMin.setCellValueFactory(new PropertyValueFactory<>("TableMin"));
        TableMax.setCellValueFactory(new PropertyValueFactory<>("TableMax"));

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(3), event -> {
            currencyDataLoader.readAndUpdateData();
            updateData();
        }));
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
                                    openPage(); // فراخوانی متد باز کردن صفحه "SignUp"
                                }
                            });
                        } else {
                            setText(null);
                        }
                    }
                };
            }
        });
        TableConversion.setCellFactory(column -> new TableCell<>() {
            @Override
            protected void updateItem(Double item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                    setStyle("");
                } else {
                    setText(String.format("%.2f%%", item));
                    if (item < 0) {
                        setStyle("-fx-text-fill: red;");
                    } else {
                        setStyle("-fx-text-fill: green;");
                    }
                }
            }
        });
        TableView.setItems(observableList);
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
        lastEUR = observableList.get(1).getTablePrice();
        lastGBP = observableList.get(4).getTablePrice();
        lastTOMAN = observableList.get(2).getTablePrice();
        lastYEN = observableList.get(3).getTablePrice();

        observableList.get(1).setTablePrice(CurrencyDataLoader.EUR);
        observableList.get(2).setTablePrice(CurrencyDataLoader.TOMAN);
        observableList.get(3).setTablePrice(CurrencyDataLoader.YEN);
        observableList.get(4).setTablePrice(CurrencyDataLoader.GBP);

        double eurChange = getPercentChange(CurrencyDataLoader.EUR, lastEUR);
        double tomanChange = getPercentChange(CurrencyDataLoader.TOMAN, lastTOMAN);
        double yenChange = getPercentChange(CurrencyDataLoader.YEN, lastYEN);
        double gbpChange = getPercentChange(CurrencyDataLoader.GBP, lastGBP);

        observableList.get(1).setTableConversion(eurChange);
        observableList.get(2).setTableConversion(tomanChange);
        observableList.get(3).setTableConversion(yenChange);
        observableList.get(4).setTableConversion(gbpChange);

        if(minPrice[0] > CurrencyDataLoader.EUR) {
            observableList.get(1).setTableMin(CurrencyDataLoader.EUR);
            minPrice[0] = CurrencyDataLoader.EUR;
        }
        if(maxPrice[0] < CurrencyDataLoader.EUR) {
            observableList.get(1).setTableMax(CurrencyDataLoader.EUR);
            maxPrice[0] = CurrencyDataLoader.EUR;
        }
        if(minPrice[1] > CurrencyDataLoader.TOMAN) {
            observableList.get(2).setTableMin(CurrencyDataLoader.TOMAN);
            minPrice[1] = CurrencyDataLoader.TOMAN;
        }
        if(maxPrice[1] < CurrencyDataLoader.TOMAN) {
            observableList.get(2).setTableMax(CurrencyDataLoader.TOMAN);
            maxPrice[1] = CurrencyDataLoader.TOMAN;
        }
        if(minPrice[2] > CurrencyDataLoader.YEN) {
            observableList.get(3).setTableMin(CurrencyDataLoader.YEN);
            minPrice[2] = CurrencyDataLoader.YEN;
        }
        if(maxPrice[2] < CurrencyDataLoader.YEN) {
            observableList.get(3).setTableMax(CurrencyDataLoader.YEN);
            maxPrice[2] = CurrencyDataLoader.YEN;
        }
        if(minPrice[3] > CurrencyDataLoader.GBP) {
            observableList.get(4).setTableMin(CurrencyDataLoader.GBP);
            minPrice[3] = CurrencyDataLoader.GBP;
        }
        if(maxPrice[3] < CurrencyDataLoader.GBP) {
            observableList.get(4).setTableMax(CurrencyDataLoader.GBP);
            maxPrice[3] = CurrencyDataLoader.GBP;
        }
        TableView.refresh();
    }

    public double getPercentChange(double current, double last) {
        return (((current - last) / last) * 100);
    }


}