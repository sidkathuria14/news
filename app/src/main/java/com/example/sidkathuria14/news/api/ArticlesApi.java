package com.example.sidkathuria14.news.api;

import com.example.sidkathuria14.news.javaModels.java_model;
import com.example.sidkathuria14.news.models.articles;
import com.example.sidkathuria14.news.models.main;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by sidkathuria14 on 14/9/17.
 */

public interface ArticlesApi {
 @GET("articles?source=techcrunch&apiKey=f2ffb894fdcb45b0abda3fd3b51692ad")
   // @GET("articles?source={source}&apiKey=f2ffb894fdcb45b0abda3fd3b51692ad")
    Call<java_model> call_java_model(
    //        @Query("source")String source
    );
}
