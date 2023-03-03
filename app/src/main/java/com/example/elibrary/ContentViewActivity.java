package com.example.elibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;

public class ContentViewActivity extends AppCompatActivity {
    WebView webView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_view);
        Bundle b = getIntent().getExtras();
        String content = "";

        if(b != null){
            content = b.getString("content");
        }

        webView = (WebView) findViewById(R.id.content_view);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadData(content,"text/html", "UTF-8");


    }
}