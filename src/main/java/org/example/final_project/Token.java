//package org.example.final_project;
//
//import javafx.animation.KeyFrame;
//import javafx.animation.Timeline;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.Initializable;
//import javafx.scene.chart.LineChart;
//import javafx.scene.chart.XYChart;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.util.Duration;
//
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//import java.net.URL;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.ResourceBundle;
//
//public class Token implements Initializable {
//    private double price;
//    @FXML
//    private Label currencyLabel;
//    @FXML
//    private Label priceLabel;
//    @FXML
//    private Label conversionLabel;
//
//    @FXML
//    private LineChart<String, Number> XYChart;
//
//    @FXML
//    private Button btn1Day;
//    @FXML
//    private Button btn1Hours;
//    @FXML
//    private Button btn1Minute;
//    @FXML
//    private Button btn1Month;
//    @FXML
//    private Button btn1Week;
//    @FXML
//    private Button btn1Year;
//
//    private Queue<XYChart.Data<String, Number>> dataQueue = new LinkedList<>();
//    private Timeline timeline;
//
//    @FXML
//    void day(ActionEvent event) {
//        loadChartData("C:\\Users\\asus\\IdeaProjects\\Final_Project\\src\\main\\resources\\imed\\currency_prices.csv");
//        startUpdatingChartDataDay();
//    }
//
//    @FXML
//    void hours(ActionEvent event) {
//        loadChartData("C:\\Users\\asus\\IdeaProjects\\Final_Project\\src\\main\\resources\\imed\\currency_prices.csv");
//        startUpdatingChartDataHours();
//    }
//
//    @FXML
//    void minute(ActionEvent event) {
//        if (timeline != null) {
//            timeline.stop();
//        }
//        prepareDataQueue("C:\\Users\\asus\\IdeaProjects\\Final_Project\\src\\main\\resources\\imed\\currency_prices.csv");
//        startUpdatingChartDataMinute();
//    }
//
//    @FXML
//    void month(ActionEvent event) {
//        loadChartData("C:\\Users\\asus\\IdeaProjects\\Final_Project\\src\\main\\resources\\imed\\currency_prices.csv");
//        startUpdatingChartDataMonth();
//    }
//
//    @FXML
//    void week(ActionEvent event) {
//        loadChartData("C:\\Users\\asus\\IdeaProjects\\Final_Project\\src\\main\\resources\\imed\\currency_prices.csv");
//        startUpdatingChartDataWeek();
//    }
//
//    @FXML
//    void year(ActionEvent event) {
//        loadChartData("C:\\Users\\asus\\IdeaProjects\\Final_Project\\src\\main\\resources\\imed\\currency_prices.csv");
//        startUpdatingChartDataYear();
//    }
//
//    public void setToken(String currency, double price, double conversion) {
//        this.price = price;
//
//        if (conversion < 0) {
//            conversionLabel.setStyle("-fx-text-fill: red;");
//        } else {
//            conversionLabel.setStyle("-fx-text-fill: green;");
//        }
//        currencyLabel.setText(currency);
//        priceLabel.setText(String.valueOf(price));
//        conversionLabel.setText(String.format("%.2f%%", conversion));
//    }
//
//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//        // Initialize with default data
//        loadChartData("C:\\Users\\asus\\IdeaProjects\\Final_Project\\src\\main\\resources\\imed\\currency_prices.csv");
//    }
//
//    private void loadChartData(String filename) {
//        XYChart.Series<String, Number> series = new XYChart.Series<>();
//        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
//            String line;
//            while ((line = br.readLine()) != null) {
//                if (line.trim().isEmpty()) continue;
//                String[] parts = line.split("\\s+");
//                if (parts.length >= 6) {
//                    String dateTime = parts[0] + " " + parts[1];
//                    double value = Double.parseDouble(parts[6]);  // فرض کنید می‌خواهید ستون چهارم را نمایش دهید
//                    series.getData().add(new XYChart.Data<>(dateTime, value));
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        XYChart.getData().clear();
//        XYChart.getData().add(series);
//    }private void prepareDataQueue(String filename) {
//        dataQueue.clear();
//        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
//            String line;
//            while ((line = br.readLine()) != null) {
//                if (line.trim().isEmpty()) continue;
//                String[] parts = line.split("\\s+");
//                if (parts.length >= 6) {
//                    String dateTime = parts[0] + " " + parts[1];
//                    double value = Double.parseDouble(parts[6]);  // فرض کنید می‌خواهید ستون چهارم را نمایش دهید
//                    dataQueue.add(new XYChart.Data<>(dateTime, value));
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void startUpdatingChartDataMinute() {
//        XYChart.Series<String, Number> series = new XYChart.Series<>();
//        XYChart.getData().clear();
//        XYChart.getData().add(series);
//
//        timeline = new Timeline(new KeyFrame(Duration.minutes(1), event -> {
//            if (!dataQueue.isEmpty()) {
//                series.getData().add(dataQueue.poll());
//            }
//        }));
//        timeline.setCycleCount(Timeline.INDEFINITE);
//        timeline.play();
//    }
//    private void startUpdatingChartDataHours() {
//        XYChart.Series<String, Number> series = new XYChart.Series<>();
//        XYChart.getData().clear();
//        XYChart.getData().add(series);
//
//        timeline = new Timeline(new KeyFrame(Duration.hours(1), event -> {
//            if (!dataQueue.isEmpty()) {
//                series.getData().add(dataQueue.poll());
//            }
//        }));
//        timeline.setCycleCount(Timeline.INDEFINITE);
//        timeline.play();
//    }
//    private void startUpdatingChartDataDay() {
//        XYChart.Series<String, Number> series = new XYChart.Series<>();
//        XYChart.getData().clear();
//        XYChart.getData().add(series);
//
//        timeline = new Timeline(new KeyFrame(Duration.hours(24), event -> {
//            if (!dataQueue.isEmpty()) {
//                series.getData().add(dataQueue.poll());
//            }
//        }));
//        timeline.setCycleCount(Timeline.INDEFINITE);
//        timeline.play();
//    }
//    private void startUpdatingChartDataMonth() {
//        XYChart.Series<String, Number> series = new XYChart.Series<>();
//        XYChart.getData().clear();
//        XYChart.getData().add(series);
//
//        timeline = new Timeline(new KeyFrame(Duration.minutes(1), event -> {
//            if (!dataQueue.isEmpty()) {
//                series.getData().add(dataQueue.poll());
//            }
//        }));
//        timeline.setCycleCount(Timeline.INDEFINITE);
//        timeline.play();
//    }
//    private void startUpdatingChartDataYear() {
//        XYChart.Series<String, Number> series = new XYChart.Series<>();
//        XYChart.getData().clear();
//        XYChart.getData().add(series);
//
//        timeline = new Timeline(new KeyFrame(Duration.hours(720), event -> {
//            if (!dataQueue.isEmpty()) {
//                series.getData().add(dataQueue.poll());
//            }
//        }));
//        timeline.setCycleCount(Timeline.INDEFINITE);
//        timeline.play();
//    }  private void startUpdatingChartDataWeek() {
//        XYChart.Series<String, Number> series = new XYChart.Series<>();
//        XYChart.getData().clear();
//        XYChart.getData().add(series);
//
//        timeline = new Timeline(new KeyFrame(Duration.hours(8640), event -> {
//            if (!dataQueue.isEmpty()) {
//                series.getData().add(dataQueue.poll());
//            }
//        }));
//        timeline.setCycleCount(Timeline.INDEFINITE);
//        timeline.play();
//    }
//}
package org.example.final_project;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.Queue;
import java.util.List;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Token implements Initializable {
    private double price;
    @FXML
    private Label currencyLabel;
    @FXML
    private Label priceLabel;
    @FXML
    private Label conversionLabel;

    @FXML
    private LineChart<String, Number> XYChart;

    @FXML
    private Button btn1Day;
    @FXML
    private Button btn1Hours;
    @FXML
    private Button btn1Minute;
    @FXML
    private Button btn1Month;
    @FXML
    private Button btn1Week;
    @FXML
    private Button btn1Year;
    @FXML
    private Button btnExchange;

    @FXML
    private Button btnProfile;

    @FXML
    private Button btnSwap;

    private Queue<XYChart.Data<String, Number>> dataQueue = new LinkedList<>();
    private List<XYChart.Data<String, Number>> currentDataList = new ArrayList<>();
    private Timeline timelineRead;
    private Timeline timelineUpdate;
    private int tokenNumber;

    @FXML
    void Exchange(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnExchange.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ExchangePage.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Exchange Page");
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
    void Swap(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnSwap.getScene().getWindow();
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(ProfilePage.class.getResource("SwapPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Swap ");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void day(ActionEvent event) {
        if (timelineRead != null) {
            timelineRead.stop();
        }
        if (timelineUpdate != null) {
            timelineUpdate.stop();
        }
        prepareDataQueue("C:\\Users\\asus\\IdeaProjects\\Final_Project\\src\\main\\resources\\imed\\currency_prices.csv");

        startReadingChartData("C:\\Users\\asus\\IdeaProjects\\Final_Project\\src\\main\\resources\\imed\\currency_prices.csv");
        startUpdatingChartDataDay();
    }

    @FXML
    void hours(ActionEvent event) {
        if (timelineRead != null) {
            timelineRead.stop();
        }
        if (timelineUpdate != null) {
            timelineUpdate.stop();
        }
        prepareDataQueue("C:\\Users\\asus\\IdeaProjects\\Final_Project\\src\\main\\resources\\imed\\currency_prices.csv");

        startReadingChartData("C:\\Users\\asus\\IdeaProjects\\Final_Project\\src\\main\\resources\\imed\\currency_prices.csv");
        startUpdatingChartDataHours();
    }

    @FXML
    void minute(ActionEvent event) {
        if (timelineRead != null) {
            timelineRead.stop();
        }
        if (timelineUpdate != null) {
            timelineUpdate.stop();
        }
        prepareDataQueue("C:\\Users\\asus\\IdeaProjects\\Final_Project\\src\\main\\resources\\imed\\currency_prices.csv");
        startReadingChartData("C:\\Users\\asus\\IdeaProjects\\Final_Project\\src\\main\\resources\\imed\\currency_prices.csv");
        startUpdatingChartDataMinute();
    }

    @FXML
    void month(ActionEvent event) {
        if (timelineRead != null) {
            timelineRead.stop();
        }
        if (timelineUpdate != null) {
            timelineUpdate.stop();
        }
        prepareDataQueue("C:\\Users\\asus\\IdeaProjects\\Final_Project\\src\\main\\resources\\imed\\currency_prices.csv");

        startReadingChartData("C:\\Users\\asus\\IdeaProjects\\Final_Project\\src\\main\\resources\\imed\\currency_prices.csv");
        startUpdatingChartDataMonth();
    }

    @FXML
    void week(ActionEvent event) {
        if (timelineRead != null) {
            timelineRead.stop();
        }
        if (timelineUpdate != null) {
            timelineUpdate.stop();
        }
        prepareDataQueue("C:\\Users\\asus\\IdeaProjects\\Final_Project\\src\\main\\resources\\imed\\currency_prices.csv");

        startReadingChartData("C:\\Users\\asus\\IdeaProjects\\Final_Project\\src\\main\\resources\\imed\\currency_prices.csv");
        startUpdatingChartDataWeek();
    }

    @FXML
    void year(ActionEvent event) {
        if (timelineRead != null) {
            timelineRead.stop();
        }
        if (timelineUpdate != null) {
            timelineUpdate.stop();
        }
        prepareDataQueue("C:\\Users\\asus\\IdeaProjects\\Final_Project\\src\\main\\resources\\imed\\currency_prices.csv");

        startReadingChartData("C:\\Users\\asus\\IdeaProjects\\Final_Project\\src\\main\\resources\\imed\\currency_prices.csv");
        startUpdatingChartDataYear();
    }

    public void setToken(String currency, double price, double conversion) {

        switch (currency){
            case "USD":
                price = 1;
                tokenNumber=2;
                break;
            case "EUR":
                tokenNumber = 3;
                break;
            case "TOMAN":
                tokenNumber = 4;
                break;
            case "YEN":
                tokenNumber = 5;
                break;
            case "GBP":
                tokenNumber = 6;
                break;
        }
        if (conversion < 0) {
            conversionLabel.setStyle("-fx-text-fill: red;");
        } else {
            conversionLabel.setStyle("-fx-text-fill: green;");
        }
        currencyLabel.setText(currency);
        priceLabel.setText(String.valueOf(price));
        conversionLabel.setText(String.format("%.2f%%", conversion));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        startReadingChartData("C:\\Users\\asus\\IdeaProjects\\Final_Project\\src\\main\\resources\\imed\\currency_prices.csv");
    }
    private void startReadingChartData(String filename) {
        timelineRead = new Timeline(new KeyFrame(Duration.minutes(1), event -> {
            readChartData(filename);
        }));
        timelineRead.setCycleCount(Timeline.INDEFINITE);
        timelineRead.play();
    }
    private void readChartData(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                String[] parts = line.split("\\s+");
                if (parts.length >= 6) {
                    String dateTime = parts[1];
                    double value = 0;
                    if(tokenNumber ==2){
                         value = 1;
                    }
                    else {
                       value = Double.parseDouble(parts[tokenNumber]);
                    }
                    dataQueue.add(new XYChart.Data<>(dateTime, value));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void startUpdatingChartDataMinute() {
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        XYChart.getData().clear();
        XYChart.getData().add(series);

        timelineUpdate = new Timeline(new KeyFrame(Duration.minutes(5), event -> {
            currentDataList.clear();
            series.getData().clear();

            for (int i = 0; i < 5; i++) {
                if (!dataQueue.isEmpty()) {
                    XYChart.Data<String, Number> data = dataQueue.poll();
                    currentDataList.add(data);
                    series.getData().add(data);
                }
            }
        }));
        timelineUpdate.setCycleCount(Timeline.INDEFINITE);
        timelineUpdate.play();
    }

    // Implement other startUpdatingChartData methods similarly

    private void startUpdatingChartDataHours() {
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        XYChart.getData().clear();
        XYChart.getData().add(series);

        timelineUpdate = new Timeline(new KeyFrame(Duration.hours(1), event -> {
            // Clear old data
            currentDataList.clear();
            series.getData().clear();

            // Add new data
            for (int i = 0; i < 60; i++) {
                if (!dataQueue.isEmpty()) {
                    XYChart.Data<String, Number> data = dataQueue.poll();
                    currentDataList.add(data);
                    series.getData().add(data);
                }
            }
        }));
        timelineUpdate.setCycleCount(Timeline.INDEFINITE);
        timelineUpdate.play();
        // Similar to startUpdatingChartDataMinute but for hours
    }

    private void startUpdatingChartDataDay() {
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        XYChart.getData().clear();
        XYChart.getData().add(series);

        timelineUpdate = new Timeline(new KeyFrame(Duration.hours(24), event -> {
            // Clear old data
            currentDataList.clear();
            series.getData().clear();

            // Add new data
            for (int i = 0; i < 1440; i++) {
                if (!dataQueue.isEmpty()) {
                    XYChart.Data<String, Number> data = dataQueue.poll();
                    currentDataList.add(data);
                    series.getData().add(data);
                }
            }
        }));
        timelineUpdate.setCycleCount(Timeline.INDEFINITE);
        timelineUpdate.play();
        // Similar to startUpdatingChartDataMinute but for days
    }

    private void startUpdatingChartDataMonth() {
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        XYChart.getData().clear();
        XYChart.getData().add(series);

        timelineUpdate = new Timeline(new KeyFrame(Duration.hours(720), event -> {
            // Clear old data
            currentDataList.clear();
            series.getData().clear();

            // Add new data
            for (int i = 0; i < 43200; i++) {
                if (!dataQueue.isEmpty()) {
                    XYChart.Data<String, Number> data = dataQueue.poll();
                    currentDataList.add(data);
                    series.getData().add(data);
                }
            }
        }));
        timelineUpdate.setCycleCount(Timeline.INDEFINITE);
        timelineUpdate.play();
        // Similar to startUpdatingChartDataMinute but for months
    }

    private void startUpdatingChartDataWeek() {
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        XYChart.getData().clear();
        XYChart.getData().add(series);

        timelineUpdate = new Timeline(new KeyFrame(Duration.hours(168), event -> {
            // Clear old data
            currentDataList.clear();
            series.getData().clear();

            // Add new data
            for (int i = 0; i < 168 * 60; i++) {
                if (!dataQueue.isEmpty()) {
                    XYChart.Data<String, Number> data = dataQueue.poll();
                    currentDataList.add(data);
                    series.getData().add(data);
                }
            }
        }));
        timelineUpdate.setCycleCount(Timeline.INDEFINITE);
        timelineUpdate.play();
        // Similar to startUpdatingChartDataMinute but for weeks
    }

    private void startUpdatingChartDataYear() {
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        XYChart.getData().clear();
        XYChart.getData().add(series);

        timelineUpdate = new Timeline(new KeyFrame(Duration.hours(8760), event -> {
            // Clear old data
            currentDataList.clear();
            series.getData().clear();

            // Add new data
            for (int i = 0; i < 525600; i++) {
                if (!dataQueue.isEmpty()) {
                    XYChart.Data<String, Number> data = dataQueue.poll();
                    currentDataList.add(data);
                    series.getData().add(data);
                }
            }
        }));
        timelineUpdate.setCycleCount(Timeline.INDEFINITE);
        timelineUpdate.play();
        // Similar to startUpdatingChartDataMinute but for years
    }

    private void prepareDataQueue(String filename) {
        dataQueue.clear();
        readChartData(filename);
    }
}