package com.example.sidkathuria14.news.api;

import com.example.sidkathuria14.news.models.main;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by sidkathuria14 on 15/9/17.
 */

public interface SourceApi {
    @GET("sources")
    // https://newsapi.org/v1/articles?source=the-next-web&sortBy=latest&apiKey=f2ffb894fdcb45b0abda3fd3b51692ad
    Call<main> call_sources(
//            Query("name")String name
    );
}
