package org.example.final_project;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class Table {
    private SimpleStringProperty TableMarket;
    private SimpleDoubleProperty TablePrice,TableConversion,TableMax,TableMin;

    public Table(String tableMarket, double tablePrice, double tableConversion, double tableMax, double tableMin) {
        this.TableMarket = new SimpleStringProperty(tableMarket) ;
        this.TablePrice = new SimpleDoubleProperty(tablePrice);
        this.TableConversion = new SimpleDoubleProperty(tableConversion);
        this.TableMax = new SimpleDoubleProperty(tableMax);
        this.TableMin = new SimpleDoubleProperty(tableMin);
    }

    public String getTableMarket() {
        return TableMarket.get();
    }

    public void setTableMarket(String tableMarket) {
        this.TableMarket = new SimpleStringProperty(tableMarket) ;
    }

    public double getTablePrice() {
        return TablePrice.get();
    }

    public void setTablePrice(double tablePrice) {
        this.TablePrice = new SimpleDoubleProperty(tablePrice);
    }

    public double getTableConversion() {
        return TableConversion.get();
    }

    public void setTableConversion(double tableConversion) {
        this.TableConversion = new SimpleDoubleProperty(tableConversion);
    }

    public double getTableMax() {
        return TableMax.get();
    }

    public void setTableMax(double tableMax) {
        this.TableMax = new SimpleDoubleProperty(tableMax);
    }

    public double getTableMin() {
        return TableMin.get();
    }

    public void setTableMin(double tableMin) {
        this.TableMin = new SimpleDoubleProperty(tableMin);
    }
}
