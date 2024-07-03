package org.example.final_project;

public class CurrencyRate {
    private String currencyName;
    private  double oldRate;
    private  double currentRate;

    public CurrencyRate(String currencyName, double oldRate,double currentRate) {
        this.currencyName = currencyName;
        this.oldRate = oldRate;
        this.currentRate = currentRate;
    }
    public void updateRate(double newRate) {
        this.oldRate = this.currentRate;
        this.currentRate = newRate;
    }
    public   double getPercentChange() {
        return  (((currentRate - oldRate) / oldRate) * 100);
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public double getCurrentRate() {
        return currentRate;
    }

    public double getOldRate() {
        return oldRate;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public void setCurrentRate(double currentRate) {
        this.currentRate = currentRate;
    }

    public void setOldRate(double oldRate) {
        this.oldRate = oldRate;
    }
}