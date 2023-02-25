package com.example.elibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    String api = "http://192.168.1.79:3001/api/";
    private TextView textViewResult;
    private Button move;
    TextView l;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        List<ListData> listItems = new ArrayList<>();

        MyListAdapter adapter = new MyListAdapter(this, listItems);
        ListView listView = findViewById(R.id.list);

        Retrofit retrofit = new Retrofit.Builder().baseUrl(api).addConverterFactory(GsonConverterFactory.create()).build();

        ApiInterface apiInterface = retrofit.create(ApiInterface.class);

        Call<Levels> call = apiInterface.getPosts();

        call.enqueue(new Callback<Levels>() {
            @Override
            public void onResponse(Call<Levels> call, Response<Levels> response) {
                Log.d("nigga", "Sad Response: ");
                if(response.isSuccessful()){
                    ArrayList <Item> item = response.body().getItems();
                    String[] names = new String[item.size()];
                    for (int i = 0; i < item.size(); i++) {
                        listItems.add(new ListData(item.get(i).getLevel(), item.get(i).getLevel_img()));
                        listView.setAdapter(adapter);
                    }
                    return;
                }
            }


            @Override
            public void onFailure(Call<Levels> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }


        });


    }
}