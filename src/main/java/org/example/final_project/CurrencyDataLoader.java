package org.example.final_project;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CurrencyDataLoader extends Application {

    public static double USD;
    public static String date;
    public static double EUR;
    public static double TOMAN;
    public static double YEN;
    public static double GBP;

    public BufferedReader br;
    private String filename = "C:\\Users\\asus\\IdeaProjects\\Final_Project\\src\\main\\resources\\imed\\currency_prices.csv";

    public CurrencyDataLoader() {
        try {
            br = new BufferedReader(new FileReader(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            br = new BufferedReader(new FileReader(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(3), event -> readAndUpdateData()));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }
    int count = 0;
    public void readAndUpdateData() {
        try {
            String line = br.readLine();

            if (  line!=null) {

                String[] parts = line.split("\\s+");
                date = parts[0] + " " + parts[1];
                USD = Double.parseDouble(parts[2]);
                EUR = Double.parseDouble(parts[3]);
                TOMAN = Double.parseDouble(parts[4]);
                YEN = Double.parseDouble(parts[5]);
                GBP = Double.parseDouble(parts[6]);

                // چاپ داده‌ها
                System.out.println("Date: " + date);
                System.out.println("USD: " + USD);
                System.out.println("EUR: " + EUR);
                System.out.println("TOMAN: " + TOMAN);
                System.out.println("YEN: " + YEN);
                System.out.println("GBP: " + GBP);
            }
            count++;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}