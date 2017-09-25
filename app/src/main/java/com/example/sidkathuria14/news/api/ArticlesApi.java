package com.example.sidkathuria14.news.api;

import com.example.sidkathuria14.news.javaModels.java_model;


import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by sidkathuria14 on 14/9/17.
 */

public interface ArticlesApi {
 

    // @GET("articles?source={source}&sortBy={sort}&apiKey=f2ffb894fdcb45b0abda3fd3b51692ad")




         @GET("articles?source=the-next-web&sortBy=latest&apiKey=f2ffb894fdcb45b0abda3fd3b51692ad")
    Call<java_model> call_articles(
            @Query("source")String source,
            @Query("sortBy")String sortBy,
            @Query("api_key")String api_key


         );

}
