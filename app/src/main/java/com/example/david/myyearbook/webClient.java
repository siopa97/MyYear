package com.example.david.myyearbook;

import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by David on 3/2/2018.
 */

public class webClient extends WebViewClient {
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        view.loadUrl(url);
        return true;
    }
}
