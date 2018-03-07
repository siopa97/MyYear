package com.example.david.myyearbook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;

public class Resume extends AppCompatActivity {

    String url = "https://drive.google.com/open?id=14GkV1IZQ5OixDs6AyTlNBSfynIOOf3Fg";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resume);

        WebView web = findViewById(R.id.web);
        web.getSettings().setJavaScriptEnabled(true);
        web.loadUrl(url);
       web.setWebViewClient(new webClient());
    }


}

