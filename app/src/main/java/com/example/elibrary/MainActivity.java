package com.example.elibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.example.elibrary.env.EnvVariable;
import com.example.elibrary.model.LevelItem;
import com.example.elibrary.model.Levels;
import com.example.elibrary.model.ListData;

import java.util.ArrayList;
import java.util.List;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<ListData> listItems = new ArrayList<>();

        MyListAdapter adapter = new MyListAdapter(this, listItems, MainActivity2.class);
        ListView listView = findViewById(R.id.list);

        Retrofit retrofit = new Retrofit.Builder().baseUrl(EnvVariable.API).addConverterFactory(GsonConverterFactory.create()).build();

        ApiInterface apiInterface = retrofit.create(ApiInterface.class);

        Call<Levels> call = apiInterface.getLevels();

        call.enqueue(new Callback<Levels>() {
            @Override
            public void onResponse(Call<Levels> call, Response<Levels> response) {
                if(response.isSuccessful()){
                    ArrayList <LevelItem> item = response.body().getItems();
                    for (int i = 0; i < item.size(); i++) {
                        listItems.add(new ListData(item.get(i).getLevel(), item.get(i).getLevel_img(), item.get(i).getLevel_id()));
                        listView.setAdapter(adapter);
                    }
                    return;
                }
            }

            @Override
            public void onFailure(Call<Levels> call, Throwable t) {

            }


        });


    }
}