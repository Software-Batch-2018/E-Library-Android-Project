package com.example.elibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.elibrary.env.EnvVariable;
import com.example.elibrary.model.ListData;
import com.example.elibrary.model.SubjectItem;
import com.example.elibrary.model.Subjects;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity2 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        List<ListData> listItems = new ArrayList<>();

        Bundle b = getIntent().getExtras();
        String level_id = "";

        if(b != null){
            level_id = b.getString("level_id");
        }

        MyListAdapter adapter = new MyListAdapter(this, listItems, ChapterActivity.class);
        ListView listView = findViewById(R.id.list);

        Retrofit retrofit = new Retrofit.Builder().baseUrl(EnvVariable.API).addConverterFactory(GsonConverterFactory.create()).build();

        ApiInterface apiInterface = retrofit.create(ApiInterface.class);

        Call<Subjects> call = apiInterface.getSubjects(level_id);

        call.enqueue(new Callback<Subjects>() {
            @Override
            public void onResponse(Call<Subjects> call, Response<Subjects> response) {
                if(response.isSuccessful()){
                    ArrayList<SubjectItem> item = response.body().getItems();
                    for (int i = 0; i< item.size(); i++){
                        listItems.add(new ListData(item.get(i).getSubject_name(), item.get(i).getSubject_img(), item.get(i).getSubject_id()));
                        listView.setAdapter(adapter);
                    }
                }
            }

            @Override
            public void onFailure(Call<Subjects> call, Throwable t) {

            }
        });

    }
}