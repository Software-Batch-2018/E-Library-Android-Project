package com.example.elibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import com.example.elibrary.env.EnvVariable;
import com.example.elibrary.model.Chapter;
import com.example.elibrary.model.ChapterItem;
import com.example.elibrary.model.ListData;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ChapterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter);

        Bundle b = getIntent().getExtras();
        String content_id = "";

        if(b != null){
            content_id = b.getString("content_id");
        }


        List<ListData> listItems = new ArrayList<>();

        MyListAdapter adapter = new MyListAdapter(this, listItems, ContentViewActivity.class);

        ListView listView = findViewById(R.id.list);
        TextView heading = findViewById(R.id.heading);
        TextView message = findViewById(R.id.message);


        Retrofit retrofit = new Retrofit.Builder().baseUrl(EnvVariable.API).addConverterFactory(GsonConverterFactory.create()).build();

        ApiInterface apiInterface = retrofit.create(ApiInterface.class);

        Call<Chapter> call = apiInterface.getChapterAndContent(content_id);

        call.enqueue(new Callback<Chapter>() {
            @Override
            public void onResponse(Call<Chapter> call, Response<Chapter> response) {
                if(response.isSuccessful()){
                    ArrayList<ChapterItem> item = response.body().getItems();

                    if(item.size() == 0 ){
                        heading.setText("No Chapter Available");
                        message.setText("We Will be adding soon, stay tuned!");

                    }
                    for (int i = 0; i< item.size(); i++){
                        listItems.add(new ListData(item.get(i).getContent_title(), item.get(i).getTitle_image(), item.get(i).getContent()));
                        listView.setAdapter(adapter);
                    }
                    return;
                }
            }

            @Override
            public void onFailure(Call<Chapter> call, Throwable t) {

            }
        });


    }
}