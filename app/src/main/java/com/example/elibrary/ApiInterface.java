package com.example.elibrary;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("courses/all/levels")
    Call<Levels> getPosts();
}
