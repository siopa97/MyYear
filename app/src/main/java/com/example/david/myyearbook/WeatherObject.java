package com.example.david.myyearbook;

import java.util.Date;

public class WeatherObject {
    private String date;
    private double tempMax;
    private double tempMin;
    private double snow;
    private int rainPercent;

    public WeatherObject(String date, double tempMax, double tempMin, double snow, int rainPercent) {
        this.date = date;
        this.tempMax = tempMax;
        this.tempMin = tempMin;
        this.snow = snow;
        this.rainPercent = rainPercent;
    }

    public String getDate() {
        return date;
    }

    public String getTempMax() {
        return tempMax + " °F";
    }

    public String getSnow() {
        return snow + " inches";
    }

    public String getRainPercent() {
        return rainPercent + "%";
    }

    public String getTempMin() {

        return tempMin + " °F";
    }
}
