package com.example.david.myyearbook;

import java.util.Date;

public class WeatherObject {
    //private Date date;
    private double tempMax;
    private double tempMin;
    private double snow;
    private int rainPercent;

    public WeatherObject( double tempMax, double tempMin, double snow, int rainPercent) {
        //this.date = date;
        this.tempMax = tempMax;
        this.tempMin = tempMin;
        this.snow = snow;
        this.rainPercent = rainPercent;
    }

    //public Date getDate() {
      //  return date;
    //}

    public double getTempMax() {
        return tempMax;
    }

    public double getSnow() {
        return snow;
    }

    public int getRainPercent() {
        return rainPercent;
    }

    public double getTempMin() {

        return tempMin;
    }
}
