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
import android.widget.Toast;

import com.example.sidkathuria14.news.adapters.NewsAdapter;
import com.example.sidkathuria14.news.api.ArticlesApi;
import com.example.sidkathuria14.news.javaModels.Article;
import com.example.sidkathuria14.news.javaModels.java_model;


import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.sidkathuria14.news.R.string.news_api_key;

public class MainArticlesActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
RecyclerView rv;
    public static final String api_key = "f2ffb894fdcb45b0abda3fd3b51692ad";
    NewsAdapter myAdapter;
    Spinner sortBy_spinner,source_spinner;
    String source,sortBy;
    ArrayList<Article> myArrayList = new ArrayList<>();
    public static final String TAG = "MainArticlesActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_articles);
rv = (RecyclerView)findViewById(R.id.rv);
        myAdapter = new NewsAdapter(new ArrayList<Article>(),this);
        rv.setAdapter(myAdapter);
        rv.setLayoutManager(new LinearLayoutManager(this));

        String sortBy_array[] = {"top","latest","popular"};
String source_array[] = {"choose source"  ,  "al-jazeera-english"  ,  "ars-technica","associated-press","bbc-news," +
        "bbc-sport","abc-news-au","bild","bloomberg","breitbart-insider","business-insider",
"business-insider-uk","buzzfeed","cnbc","cnn","daily-mail","der-tagesspiegel",
"die-zeit","engadget","entertainment-weekly","espn","fpcus","football-italia","fortune",
"four-four-two","fox-sports","google-news","gruenderszene","hacker-news","handelsblatt"};

        sortBy_spinner= (Spinner)findViewById(R.id.sortBy_spinner);
        source_spinner =  (Spinner)findViewById(R.id.source_spinner);



        sortBy_spinner.setOnItemSelectedListener(this);
        source_spinner.setOnItemSelectedListener(this);

        ArrayAdapter source_adapter= new ArrayAdapter(this,android.R.layout.simple_spinner_item,source_array);
        ArrayAdapter sortBy_adapter= new ArrayAdapter(this,android.R.layout.simple_spinner_item,sortBy_array);
        sortBy_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        source_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sortBy_spinner.setAdapter(sortBy_adapter);
        source_spinner.setAdapter(source_adapter);

//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://newsapi.org/v1/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//
//        ArticlesApi articlesApi = retrofit.create(ArticlesApi.class);
//
//     Callback<java_model> callback = new Callback<java_model>() {
//         @Override
//         public void onResponse(Call<java_model> call, Response<java_model> response) {
//             for(int i=0;i<1;++i) {
//                 Log.d(TAG, "onResponse: " + response.body().getArticles()[i].getAuthor() + "\n"
//                         + response.body().getArticles()[i].getTitle() + "\n"
//                         + response.body().getArticles()[i].getDescription() + "\n"
//                         + response.body().getArticles()[i].getPublishedAt() + "\n"
//                 );
//             }
//
//
//                 for (int i = 0;i<5; ++i) {
//                     //    java_model.Article myArticle = new java_model();
//                     myArrayList.add(new Article(
//                             String.valueOf(response.body().getArticles()[i].getAuthor()),
//                             String.valueOf(response.body().getArticles()[i].getTitle()),
//                             String.valueOf(response.body().getArticles()[i].getPublishedAt()),
//                             String.valueOf(response.body().getArticles()[i].getDescription())));
//
//                 }
//
//
//             myAdapter.updateNews(myArrayList);
//
//         }
//
//         @Override
//         public void onFailure(Call<java_model> call, Throwable t) {
//             Log.d(TAG, "onFailure: ");
//         }
//     };
//        articlesApi.call_articles(source,sortBy,api_key).enqueue(callback);

    }
   void update (String source,String sortBy){
       myArrayList.clear();
       Retrofit retrofit = new Retrofit.Builder()
               .baseUrl("https://newsapi.org/v1/")
               .addConverterFactory(GsonConverterFactory.create())
               .build();


       ArticlesApi articlesApi = retrofit.create(ArticlesApi.class);

       Callback<java_model> callback = new Callback<java_model>() {
           @Override
           public void onResponse(Call<java_model> call, Response<java_model> response) {
               for(int i=0;i<1;++i) {
                   Log.d(TAG, "onResponse: " + response.body().getArticles()[i].getAuthor() + "\n"
                           + response.body().getArticles()[i].getTitle() + "\n"
                           + response.body().getArticles()[i].getDescription() + "\n"
                           + response.body().getArticles()[i].getPublishedAt() + "\n"
                   );
               }


               for (int i = 0;i<5; ++i) {
                   //    java_model.Article myArticle = new java_model();
                   myArrayList.add(new Article(
                           String.valueOf(response.body().getArticles()[i].getAuthor()),
                           String.valueOf(response.body().getArticles()[i].getTitle()),
                           String.valueOf(response.body().getArticles()[i].getPublishedAt()),
                           String.valueOf(response.body().getArticles()[i].getDescription())));

               }


               myAdapter.updateNews(myArrayList);

           }

           @Override
           public void onFailure(Call<java_model> call, Throwable t) {
               Log.d(TAG, "onFailure: ");
           }
       };
       articlesApi.call_articles(source,sortBy,api_key).enqueue(callback);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//        if(view == source_spinner) {
//         source =  String.valueOf(adapterView.getItemAtPosition(i));
//            Log.d(TAG, "onItemSelected: " + source);
//        }
//        if(view == sortBy_spinner){
//            sortBy = String.valueOf(adapterView.getItemAtPosition(i));
//            Log.d(TAG, "onItemSelected: " + sortBy);
//        }
        switch (adapterView.getId()) {
            case R.id.sortBy_spinner:
                Log.d(TAG, "onItemSelected: " + adapterView.getItemAtPosition(i));
                sortBy = adapterView.toString();
             //   update(source,sortBy);
                // do stuffs with you spinner 1
                break;
            case R.id.source_spinner:
                Log.d(TAG, "onItemSelected: " + adapterView.getItemAtPosition(i));
                // do stuffs with you spinner 2
                source = adapterView.toString();
              //  update(source,sortBy);
                break;
            default:
                break;
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
        if(id == R.id.refresh){
            if(source.equals("choose source")){
                Toast.makeText(this, "Choose a source please.", Toast.LENGTH_SHORT).show();
            }
            else
update(source,sortBy);
        }
        return super.onOptionsItemSelected(item);
    }
}
