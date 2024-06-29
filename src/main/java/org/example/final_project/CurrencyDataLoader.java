package org.example.final_project;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CurrencyDataLoader {

    private static CurrencyDataLoader instance;

    public static double USD;
    public static String date;
    public static double EUR;
    public static double TOMAN;
    public static double YEN;
    public static double GBP;

    private BufferedReader br;
    private String filename = "C:\\Users\\asus\\IdeaProjects\\Final_Project\\src\\main\\resources\\imed\\currency_prices.csv";
    private Timeline timeline;

    private CurrencyDataLoader() {
        try {
            br = new BufferedReader(new FileReader(filename));
            // Initialize the timeline to update data every 3 seconds
            timeline = new Timeline(new KeyFrame(Duration.seconds(3), event -> readAndUpdateData()));
            timeline.setCycleCount(Timeline.INDEFINITE);
            timeline.play();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static CurrencyDataLoader getInstance() {
        if (instance == null) {
            instance = new CurrencyDataLoader();
        }
        return instance;
    }

    public void readAndUpdateData() {
        try {
            String line = br.readLine();
            while (line != null && line.trim().isEmpty()) {
                line = br.readLine(); // Skip empty lines
            }
            if (line != null) {
                String[] parts = line.split("\\s+");
                date = parts[0] + " " + parts[1];
                USD = Double.parseDouble(parts[2]);
                EUR = Double.parseDouble(parts[3]);
                TOMAN = Double.parseDouble(parts[4]);
                YEN = Double.parseDouble(parts[5]);
                GBP = Double.parseDouble(parts[6]);

                System.out.println("Date: " + date);
                System.out.println("USD: " + USD);
                System.out.println("EUR: " + EUR);
                System.out.println("TOMAN: " + TOMAN);
                System.out.println("YEN: " + YEN);
                System.out.println("GBP: " + GBP);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stopUpdating() {
        if (timeline != null) {
            timeline.stop();
        }
    }
}