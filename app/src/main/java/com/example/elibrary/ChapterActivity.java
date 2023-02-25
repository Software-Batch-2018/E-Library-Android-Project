package com.example.elibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ChapterActivity extends AppCompatActivity {

    String api = "http://192.168.1.73:3001/api/";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter);

        Bundle b = getIntent().getExtras();
        String content_id = "";

        if(b != null){
            content_id = b.getString("content_id");
        }
        TextView c_id = findViewById(R.id.message);
        c_id.setText(content_id);
    }
}