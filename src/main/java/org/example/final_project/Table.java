package org.example.final_project;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class Table {
    private SimpleStringProperty tableMarket, tableType, tableMarketExchange;
    private SimpleDoubleProperty tablePrice, tableConversion, tableMax, tableMin, tableAmount, tableBasePrice;

    public Table(String tableMarket, double tablePrice, double tableConversion, double tableMax, double tableMin) {
        this.tableMarket = new SimpleStringProperty(tableMarket);
        this.tablePrice = new SimpleDoubleProperty(tablePrice);
        this.tableConversion = new SimpleDoubleProperty(tableConversion);
        this.tableMax = new SimpleDoubleProperty(tableMax);
        this.tableMin = new SimpleDoubleProperty(tableMin);
    }

    public Table(String tableMarket, double tableAmount,double tableBasePrice, String tableType) {
        this.tableMarketExchange = new SimpleStringProperty(tableMarket);
        this.tableType = new SimpleStringProperty(tableType);
        this.tableBasePrice = new SimpleDoubleProperty(tableBasePrice);
        this.tableAmount = new SimpleDoubleProperty(tableAmount);

    }

    // Getters and setters
    public String getTableMarket() {
        return tableMarket != null ? tableMarket.get() : null;
    }

    public void setTableMarket(String tableMarket) {
        if (this.tableMarket != null) {
            this.tableMarket.set(tableMarket);
        } else {
            this.tableMarket = new SimpleStringProperty(tableMarket);
        }
    }

    public String getTableMarketExchange() {
        return tableMarketExchange != null ? tableMarketExchange.get() : null;
    }

//    public void setTableBasePrice(String tableMarketExchange) {
//        if (this.tableBasePrice != null) {
//            this.tableBasePrice.set(tableBasePrice);
//        } else {
//            this.tableBasePrice = new SimpleStringProperty(tableBasePrice);
//        }
//    }
//
//    public Double getTableBasePrice() {
//        return tableBasePrice != null ? tableBasePrice.get() : null;
//    }

    public void setTableMarketExchange(String tableMarketExchange) {
        if (this.tableMarketExchange != null) {
            this.tableMarketExchange.set(tableMarketExchange);
        } else {
            this.tableMarketExchange = new SimpleStringProperty(tableMarketExchange);
        }
    }
    public String getTableType() {
        return tableType != null ? tableType.get() : null;
    }

    public void setTableType(String tableType) {
        if (this.tableType != null) {
            this.tableType.set(tableType);
        } else {
            this.tableType = new SimpleStringProperty(tableType);
        }
    }

    public double getTablePrice() {
        return tablePrice != null ? tablePrice.get() : 0;
    }

    public void setTablePrice(double tablePrice) {
        if (this.tablePrice != null) {
            this.tablePrice.set(tablePrice);
        } else {
            this.tablePrice = new SimpleDoubleProperty(tablePrice);
        }
    }

    public double getTableConversion() {
        return tableConversion != null ? tableConversion.get() : 0;
    }

    public void setTableConversion(double tableConversion) {
        if (this.tableConversion != null) {
            this.tableConversion.set(tableConversion);
        } else {
            this.tableConversion = new SimpleDoubleProperty(tableConversion);
        }
    }

    public double getTableMax() {
        return tableMax != null ? tableMax.get() : 0;
    }

    public void setTableMax(double tableMax) {
        if (this.tableMax != null) {
            this.tableMax.set(tableMax);
        } else {
            this.tableMax = new SimpleDoubleProperty(tableMax);
        }
    }

    public double getTableMin() {
        return tableMin != null ? tableMin.get() : 0;
    }

    public void setTableMin(double tableMin) {
        if (this.tableMin != null) {
            this.tableMin.set(tableMin);
        } else {
            this.tableMin = new SimpleDoubleProperty(tableMin);
        }
    }

    public double getTableAmount() {
        return tableAmount != null ? tableAmount.get() : 0;
    }

    public void setTableAmount(double tableAmount) {
        if (this.tableAmount != null) {
            this.tableAmount.set(tableAmount);
        } else {
            this.tableAmount = new SimpleDoubleProperty(tableAmount);
        }
    }

    public void setTableBasePrice(double tableBasePrice) {
        this.tableBasePrice.set(tableBasePrice);
    }

    public double getTableBasePrice() {
        return tableBasePrice.get();
    }
}