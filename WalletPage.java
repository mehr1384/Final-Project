package org.example.final_project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class WalletPage implements Initializable {

    @FXML
    private Button btnHomePage;

    @FXML
    private Button btnProfile;


    @FXML
    private LineChart<Number, Number> currencyLineChart;
    @FXML
    private ChoiceBox<String> currencyChoiceBox;
    private String[] currency = {"USD","EUR","TOMAN","YEN","GBP"};


    @FXML
    private NumberAxis xAxis;

    @FXML
    private NumberAxis yAxis;
    @FXML
    private Label lblCurrency;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        currencyChoiceBox.getItems().addAll(currency);
        currencyChoiceBox.setOnAction(this::getCurrency);
        // تنظیمات اولیه برای محورهای نمودار
        xAxis.setLabel("Time");
        yAxis.setLabel("Value");

        // مسیر فایل CSV را تنظیم کنید
        String csvFilePath = "src/main/resources/imed/currency_prices.csv";

        // خواندن داده‌ها از فایل CSV و به روز رسانی نمودار
        updateChartFromCSV(csvFilePath);
    }
    public void getCurrency(ActionEvent event){
        String currency = currencyChoiceBox.getValue();
    }
    public void updateChartFromCSV(String filePath) {
        List<Pair<Number, Number>> newData = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        series.setName("Updated Currency Value");

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean header = true;

            while ((line = br.readLine()) != null) {
                if (header) {
                    header = false; // Skip header line
                    continue;
                }

                String[] values = line.split("    ");
                try {
                    LocalDateTime dateTime = LocalDateTime.parse(values[0].trim(), formatter);
                    double time = dateTime.toEpochSecond(java.time.ZoneOffset.UTC); // Convert to epoch seconds
                    double usdValue = Double.parseDouble(values[1].trim());

                    newData.add(new Pair<>(time, usdValue));
                } catch (DateTimeParseException e) {
                    System.err.println("Error parsing date: " + values[0]);
                } catch (NumberFormatException e) {
                    System.err.println("Error parsing value: " + values[1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Pair<Number, Number> dataPoint : newData) {
            series.getData().add(new XYChart.Data<>(dataPoint.getKey(), dataPoint.getValue()));
        }

        currencyLineChart.getData().clear(); // پاک کردن داده‌های قبلی
        currencyLineChart.getData().add(series); // اضافه کردن داده‌های جدید
    }
    @FXML
    void HomePage(ActionEvent event) throws IOException {
        Stage stage =(Stage) btnHomePage.getScene().getWindow();
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(HomePage.class.getResource("HomePage.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Home Page!");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void Profile(ActionEvent event) throws IOException {
        Stage stage =(Stage) btnProfile.getScene().getWindow();
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(ProfilePage.class.getResource("ProfilePage.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Profile");
        stage.setScene(scene);
        stage.show();
    }
}