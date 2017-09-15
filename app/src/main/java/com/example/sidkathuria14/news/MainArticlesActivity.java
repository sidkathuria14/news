package com.example.sidkathuria14.news;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.sidkathuria14.news.adapters.NewsAdapter;
import com.example.sidkathuria14.news.api.ArticlesApi;
import com.example.sidkathuria14.news.javaModels.java_model;
import com.example.sidkathuria14.news.models.articles;
import com.example.sidkathuria14.news.models.main;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainArticlesActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
RecyclerView rv;NewsAdapter myAdapter;Spinner sortBy_spinner,source_spinner;String source,sortBy;
    public static final String TAG = "MainArticlesActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_articles);
rv = (RecyclerView)findViewById(R.id.rv);
        myAdapter = new NewsAdapter(new ArrayList<java_model.Article>(),this);
        rv.setAdapter(myAdapter);
        rv.setLayoutManager(new LinearLayoutManager(this));

        String sortBy[] = {"top","latest","popular"};
String source[] = {"al-jazeera-english","ars-technica","associated-press","bbc-news," +
        "bbc-sport","abc-news-au","bild","bloomberg","breitbart-insider","business-insider",
"business-insider-uk","buzzfeed","cnbc","cnn","daily-mail","der-tagesspiegel",
"die-zeit","engadget","entertainment-weekly","espn","fpcus","football-italia","fortune",
"four-four-two","fox-sports","google-news","gruenderszene","hacker-news","handelsblatt"};
        sortBy_spinner= (Spinner)findViewById(R.id.sortBy_spinner);
        source_spinner =  (Spinner)findViewById(R.id.source_spinner);



        sortBy_spinner.setOnItemSelectedListener(this);
        source_spinner.setOnItemSelectedListener(this);

        ArrayAdapter source_array= new ArrayAdapter(this,android.R.layout.simple_spinner_item,source);
        ArrayAdapter sortBy_array= new ArrayAdapter(this,android.R.layout.simple_spinner_item,sortBy);
        sortBy_array.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sortBy_spinner.setAdapter(sortBy_array);
        source_spinner.setAdapter(source_array);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://newsapi.org/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        ArticlesApi articlesApi = retrofit.create(ArticlesApi.class);

     Callback<java_model> callback = new Callback<java_model>() {
         @Override
         public void onResponse(Call<java_model> call, Response<java_model> response) {
             Log.d(TAG, "onResponse: " + response.body().getArticles().toString());
         }

         @Override
         public void onFailure(Call<java_model> call, Throwable t) {
             Log.d(TAG, "onFailure: ");
         }
     };
        articlesApi.call_java_model().enqueue(callback);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if(view == source_spinner) {
         source =  String.valueOf(adapterView.getItemAtPosition(i));
            Log.d(TAG, "onItemSelected: " + source);
        }
        if(view == sortBy_spinner){
            sortBy = String.valueOf(adapterView.getItemAtPosition(i));
            Log.d(TAG, "onItemSelected: " + sortBy);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.modes,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public MenuInflater getMenuInflater() {
        return super.getMenuInflater();

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

    int id = item.getItemId();
        if(id == R.id.menu_source){
            startActivity(new Intent(MainArticlesActivity.this,MainSourceActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }
}
