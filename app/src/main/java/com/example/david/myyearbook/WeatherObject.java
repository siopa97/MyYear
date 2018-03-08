package com.example.david.myyearbook;

public class WeatherObject {
    private String date;
    private int tempMax;
    private int tempMin;
    private int snow;
    private String rainPercent;

    public WeatherObject(String date, int tempMax, int tempMin, int snow, String rainPercent) {
        this.date = date;
        this.tempMax = tempMax;
        this.tempMin = tempMin;
        this.snow = snow;
        this.rainPercent = rainPercent;
    }

    public String getDate() {
        return date;
    }

    public int getTempMax() {
        return tempMax;
    }

    public int getSnow() {
        return snow;
    }

    public String getRainPercent() {
        return rainPercent;
    }

    public int getTempMin() {

        return tempMin;
    }
}
