package com.example.sidkathuria14.news.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sidkathuria14.news.R;
import com.example.sidkathuria14.news.javaModels.Article;
import com.example.sidkathuria14.news.javaModels.java_model;


import java.util.ArrayList;

/**
 * Created by sidkathuria14 on 14/9/17.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.MyViewHolder> {
   private ArrayList<Article> arrayList;
    private Context context;

    public void updateNews(ArrayList<Article> newUserList) {
        this.arrayList = newUserList;
        notifyDataSetChanged();
    }

    public NewsAdapter(ArrayList<Article> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = li.inflate(R.layout.news_layout,parent,false);


        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
// articles myarticle = arrayList.get(position);
//        articles myArticle = arrayList.get(position);

        Article myModel = arrayList.get(position);
        holder.tv_description.setText(myModel.getDescription());
        holder.tv_title.setText(myModel.getTitle());
        holder.tv_publishedAt.setText(myModel.getPublishedAt());
        holder.tv_author.setText(myModel.getAuthor());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tv_title,tv_author,tv_description,tv_publishedAt;
        public MyViewHolder(View itemView) {
            super(itemView);

            tv_author = (TextView)itemView.findViewById(R.id.tv_author);
            tv_publishedAt = (TextView)itemView.findViewById(R.id.tv_publishedAt);
            tv_title = (TextView)itemView.findViewById(R.id.tv_title);
            tv_description = (TextView)itemView.findViewById(R.id.tv_description);


        }
    }
}
