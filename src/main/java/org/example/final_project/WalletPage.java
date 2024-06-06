package org.example.final_project;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
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
    private LineChart<Number, Number> currencyLineChart;

    @FXML
    private NumberAxis xAxis;

    @FXML
    private NumberAxis yAxis;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // تنظیمات اولیه برای محورهای نمودار
        xAxis.setLabel("Time");
        yAxis.setLabel("Value");

        // مسیر فایل CSV را تنظیم کنید
        String csvFilePath = "src/main/resources/imed/currency_prices.csv";

        // خواندن داده‌ها از فایل CSV و به روز رسانی نمودار
        updateChartFromCSV(csvFilePath);
    }

    public void updateChart(List<Pair<Number, Number>> newData) {
        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        series.setName("Updated Currency Value");

        for (Pair<Number, Number> dataPoint : newData) {
            series.getData().add(new XYChart.Data<>(dataPoint.getKey(), dataPoint.getValue()));
        }

        currencyLineChart.getData().clear(); // پاک کردن داده‌های قبلی
        currencyLineChart.getData().add(series); // اضافه کردن داده‌های جدید
    }

    public void updateChartFromCSV(String filePath) {
        List<Pair<Number, Number>> newData = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS");

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

        updateChart(newData);
    }
}