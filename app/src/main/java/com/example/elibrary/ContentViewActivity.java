package com.example.elibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;

public class ContentViewActivity extends AppCompatActivity {
    WebView webView;

//    public  String html = "<h1>Heading 1</h1>\n" +
//            " <h2>Heading 2</h2>\n" +
//            "<p>This is some html. Look, here's an <u>underline</u>.</p>\n" +
//            "<p>Look, this is <em>emphasized.</em> And here\\\\'s some <b>bold</b>.</p>\n" +
//            "<p>Here are UL list items:\n" +
//            "<ul>\n" +
//            "    <li>One</li>\n" +
//            "    <li>Two</li>\n" +
//            "    <li>Three</li>\n" +
//            "</ul>\n" +
//            "<p>Here are OL list items:\n" +
//            "<ol>\n" +
//            "    <li>One</li>\n" +
//            "    <li>Two</li>\n" +
//            "    <li>Three</li>\n" +
//            "</ol>";

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