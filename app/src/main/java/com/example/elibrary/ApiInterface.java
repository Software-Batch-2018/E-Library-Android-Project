package com.example.elibrary;

import com.example.elibrary.model.Chapter;
import com.example.elibrary.model.Levels;
import com.example.elibrary.model.Subjects;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface {
    @GET("courses/all/levels")
    Call<Levels> getLevels();

    @GET("courses/all/subjects/{id}")
    Call<Subjects> getSubjects(@Path("id") String id);

    @GET("courses/all/content/{subject_id}")
    Call<Chapter> getChapterAndContent(@Path("subject_id") String id);

}


