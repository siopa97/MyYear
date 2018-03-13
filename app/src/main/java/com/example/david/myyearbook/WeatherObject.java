package com.example.david.myyearbook;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class WeatherObject {
    private String date;
    private double tempMax;
    private double tempMin;
    private int rainPercent;

    public WeatherObject(String date, double tempMax, double tempMin, int rainPercent) {
        this.date = date;
        this.tempMax = tempMax;
        this.tempMin = tempMin;
        this.rainPercent = rainPercent;
    }

    public String getDate() throws ParseException {
        String newDate = "";

        try {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            Date usDate = format.parse(date);

            SimpleDateFormat usFormat = new SimpleDateFormat("MM/dd/yyyy");
            TimeZone tz = TimeZone.getTimeZone("America/New_York");
            usFormat.setTimeZone(tz);

            newDate = usFormat.format(usDate);

        } catch(Exception bug){
            bug.printStackTrace();
        }


        return newDate;
    }

    public String getTempMax() {

        return String.valueOf(tempMax) + " °F";
    }

    public String getRainPercent() {

        return String.valueOf(rainPercent) + "%";
    }

    public String getTempMin() {

        return String.valueOf(tempMin) + " °F";
    }
}
