package com.example.david.myyearbook;

import android.net.Network;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;

import javax.net.ssl.HttpsURLConnection;

public class Weather extends AppCompatActivity {
    URL url;
    String responseText;
    StringBuffer response;
    WeatherObject weather;
    ArrayList<WeatherObject> data = new ArrayList<WeatherObject>();
    Button update;

    private String path = "http://api.weatherunlocked.com/api/forecast/40.71,-74.00?app_id=b51fbba4&app_key=7a45bd08651c576aeef6b08b1b2bb5f0";

    public Weather() throws MalformedURLException {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weather);

        update = findViewById(R.id.update);
        update.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                new getWeather().execute();
                TextView todMin = findViewById(R.id.todMin);
                todMin.setText("Fuck You");
            }
        });


    }


    class getWeather extends AsyncTask {


        @Override
        protected Object doInBackground(Object[] objects) {
            return getWebServiceData();
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
                JSONArray jsonarray = new JSONArray(responseText);
                for (int i = 0; i < jsonarray.length(); i++) {
                    JSONObject jsonobject = jsonarray.getJSONObject(i);
                    Date date =(Date) jsonobject.get("date");
                    double max = jsonobject.getInt("temp_max_f");
                    Log.d ("Max: ", ""+ max);
                    double min = jsonobject.getInt("temp_min_f");
                    Log.d( "Min: ","" + min);
                    double snow = jsonobject.getInt("snow_total_in");
                    int chance = jsonobject.getInt("prob_precip_pct");
                    Log.d("Weather Report:", date + " minTemp:" + min + " maxTemp:" +  max +
                    " snowIn:"  + " Chance of Rain:" + chance);
                    weather = new WeatherObject(date,min,max,snow,chance);
                    data.add(weather);

                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }


    }

}





