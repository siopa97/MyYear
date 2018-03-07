package com.example.david.myyearbook;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.weatherbtn);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                weather(v);
            }
        });
    }

    public void resume(View view) {
        Intent i = new Intent(MainActivity.this, Resume.class);
        startActivity(i);
    }

    public void weather(View view) {
        Intent i = new Intent(MainActivity.this, Weather.class);
        startActivity(i);
    }


}
