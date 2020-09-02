package com.codebit.codemarket;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class WebViewClientImpl extends WebViewClient {

    private Activity activity = null;

    public WebViewClientImpl(Activity activity) {
        this.activity = activity;
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView webView, String url) {
        if (!DetectConnection.checkInternetConnection(activity)) {
            Toast.makeText(activity.getApplicationContext(), "Sem conexão com a internet!", Toast.LENGTH_SHORT).show();

        } else {
            if(url.contains("https://lecard-delivery.netlify.com/")) return false;

            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            activity.startActivity(intent);
            return true;
        }

        return false;
    }
}