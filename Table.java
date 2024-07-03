package org.example.final_project;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
public class Table {
    private SimpleStringProperty tableMarket, tableType, tableMarketExchange,tableDate, tableMarketHistory, tableStatus;
    private SimpleDoubleProperty tablePrice, tableConversion, tableMax, tableMin, tableAmount, tableBasePrice, tableBasePriceHistory, tableAmountHistory;

    private SimpleStringProperty tableTypeHistory;
    public Table(String tableMarket, double tablePrice, double tableConversion, double tableMax, double tableMin) {
        this.tableMarket = new SimpleStringProperty(tableMarket);
        this.tablePrice = new SimpleDoubleProperty(tablePrice);
        this.tableConversion = new SimpleDoubleProperty(tableConversion);
        this.tableMax = new SimpleDoubleProperty(tableMax);
        this.tableMin = new SimpleDoubleProperty(tableMin);
    }

    public Table(String tableMarket, double tableAmount, double tableBasePrice, String tableType) {
        this.tableMarketExchange = new SimpleStringProperty(tableMarket);
        this.tableType = new SimpleStringProperty(tableType);
        this.tableBasePrice = new SimpleDoubleProperty(tableBasePrice);
        this.tableAmount = new SimpleDoubleProperty(tableAmount);
        this.tableStatus = new SimpleStringProperty("Pending");
    }
    public Table(String tableMarket, double tableAmount, double tableBasePrice, String tableType, String tableStatus, String tableDate) {
        this.tableMarketHistory = new SimpleStringProperty(tableMarket);
        this.tableTypeHistory = new SimpleStringProperty(tableType);
        this.tableBasePriceHistory = new SimpleDoubleProperty(tableBasePrice);
        this.tableAmountHistory = new SimpleDoubleProperty(tableAmount);
        this.tableDate = new SimpleStringProperty(tableDate);
        this.tableStatus = new SimpleStringProperty(tableStatus);
    }
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
    public String getTableMarketHistory() {
        return tableMarketHistory != null ? tableMarketHistory.get() : null;
    }
    public void setTableMarketHistory(String tableMarketHistory) {
        if (this.tableMarketHistory != null) {
            this.tableMarketHistory.set(tableMarketHistory);
        } else {
            this.tableMarketHistory = new SimpleStringProperty(tableMarketHistory);
        }
    }
    public void setTableStatus(String tableStatus) {
        this.tableStatus.set(tableStatus);
    }
    public String getTableStatus() {
        return tableStatus.get();
    }
    public void setTableTypeHistory(String tableTypeHistory) {
        this.tableTypeHistory.set(tableTypeHistory );
    }
    public String getTableTypeHistory() {
        return tableTypeHistory.get();
    }
    public void setTableAmountHistory(double tableAmountHistory) {
        this.tableAmountHistory.set(tableAmountHistory);
    }
    public void setTableBasePriceHistory(double tableBasePriceHistory) {
        this.tableBasePriceHistory.set(tableBasePriceHistory);
    }
    public double getTableAmountHistory() {
        return tableAmountHistory.get();
    }
    public double getTableBasePriceHistory() {
        return tableBasePriceHistory.get();
    }
    public void setTableDate(String tableDate) {
        this.tableDate.set(tableDate);
    }
    public String getTableDate() {
        return tableDate.get();
    }
    public String getTableMarketExchange() {
        return tableMarketExchange != null ? tableMarketExchange.get() : null;
    }
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