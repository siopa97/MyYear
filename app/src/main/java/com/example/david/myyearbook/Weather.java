package com.example.david.myyearbook;

import android.content.Intent;
import android.net.Network;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import javax.net.ssl.HttpsURLConnection;

public class Weather extends AppCompatActivity {
    URL url;
    String responseText;
    StringBuffer response;
    WeatherObject weather;
    WeatherList data = new WeatherList();
    Button update;

    private String path = "http://api.weatherunlocked.com/api/forecast/us.11720?app_id=b51fbba4&app_key=7a45bd08651c576aeef6b08b1b2bb5f0";

    public Weather() throws MalformedURLException {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weather);

        new getWeather().execute();

    }

    public void refresh() {
        //Intent i = new Intent(Weather.this, Weather.class);
        //fill();
        startActivity(getIntent());
        finish();


    }


    private class getWeather extends AsyncTask<Void, Void, String> {


        @Override
        protected String doInBackground(Void... String) {
            String hello = "";
            getWebServiceData();
            return hello;
        }

        protected Void getWebServiceData() {
            try {
                url = new URL(path);
                Log.d("getWebServiceData: ", path);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setReadTimeout(15000);
                conn.setConnectTimeout(15000);
                conn.setRequestMethod("GET");

                int responseCode = conn.getResponseCode();

                Log.d("Response code: ", responseCode + "");
                if (responseCode == HttpsURLConnection.HTTP_OK) {
                    // Reading response from input Stream
                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(conn.getInputStream()));
                    String output;
                    response = new StringBuffer();

                    while ((output = in.readLine()) != null) {
                        response.append(output);
                    }
                    in.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            responseText = response.toString();

            Log.d("data:", responseText);
            try {
                JSONObject obj = new JSONObject(responseText);
                JSONArray jsonarray = obj.getJSONArray("Days");
                Log.d("getWebServiceData: ", jsonarray.length() + "");
                for (int i = 0; i < 6; i++) {
                    JSONObject jsonobject = jsonarray.getJSONObject(i);
                    String date = jsonobject.getString("date");
                    double max = jsonobject.getInt("temp_max_f");
                    Log.d("Max: ", "" + max);
                    double min = jsonobject.getInt("temp_min_f");
                    Log.d("Min: ", "" + min);
                    int chance = jsonobject.getInt("prob_precip_pct");
                    Log.d("Weather Report:", date + " minTemp:" + min + " maxTemp:" + max +
                            " Chance of Rain: " + chance);
                    weather = new WeatherObject(date, max, min, chance);
                    data.add(weather);

                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String hello) {
            try {
                fill();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }


    }

    public void fill() throws ParseException {

        //DAY 1
        TextView date1 = findViewById(R.id.date1);
        TextView min1 = findViewById(R.id.minTemp1);
        TextView max1 = findViewById(R.id.maxTemp1);
        TextView rain1 = findViewById(R.id.chanceofRain1);

        date1.setText(data.get(0).getDate());
        min1.setText(data.get(0).getTempMin());
        max1.setText(data.get(0).getTempMax());
        rain1.setText(data.get(0).getRainPercent() + "");

        //DAY2
        TextView date2 = findViewById(R.id.date2);
        TextView min2 = findViewById(R.id.minTemp2);
        TextView max2 = findViewById(R.id.maxTemp2);
        TextView rain2 = findViewById(R.id.chanceofRain2);

        date2.setText(data.get(1).getDate());
        min2.setText(data.get(1).getTempMin());
        max2.setText(data.get(1).getTempMax());
        rain2.setText(data.get(1).getRainPercent() + "");

        //DAY3
        TextView date3 = findViewById(R.id.date3);
        TextView min3 = findViewById(R.id.minTemp3);
        TextView max3 = findViewById(R.id.maxTemp3);
        TextView rain3 = findViewById(R.id.chanceofRain3);

        date3.setText(data.get(2).getDate());
        min3.setText(data.get(2).getTempMin());
        max3.setText(data.get(2).getTempMax());
        rain3.setText(data.get(2).getRainPercent() + "");

        //DAY 4
        TextView date4 = findViewById(R.id.date4);
        TextView min4 = findViewById(R.id.minTemp4);
        TextView max4 = findViewById(R.id.maxTemp4);
        TextView rain4 = findViewById(R.id.chanceofRain4);

        date4.setText(data.get(3).getDate());
        min4.setText(data.get(3).getTempMin());
        max4.setText(data.get(3).getTempMax());
        rain4.setText(data.get(3).getRainPercent() + "");

        //DAY5
        TextView date5 = findViewById(R.id.date5);
        TextView min5 = findViewById(R.id.minTemp5);
        TextView max5 = findViewById(R.id.maxTemp5);
        TextView rain5 = findViewById(R.id.chanceofRain5);

        date5.setText(data.get(4).getDate());
        min5.setText(data.get(4).getTempMin());
        max5.setText(data.get(4).getTempMax());
        rain5.setText(data.get(4).getRainPercent() + "");
    }

}





