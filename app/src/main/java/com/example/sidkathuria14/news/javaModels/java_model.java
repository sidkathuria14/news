package com.example.sidkathuria14.news.javaModels;

/**
 * Created by sidkathuria14 on 15/9/17.
 */

public class java_model {
    String source;
    String sortBy;
    Article articles[];
    String status;

    public String getStatus() {
        return status;
    }

    public String getSource() {
        return source;
    }

    public String getSortBy() {
        return sortBy;
    }

    public Article[] getArticles() {
        return articles;
    }

//    public java_model(String source, String sortBy, Article[] articles) {
//        this.source = source;
//        this.sortBy = sortBy;
//        this.articles = articles;
//    }


}
