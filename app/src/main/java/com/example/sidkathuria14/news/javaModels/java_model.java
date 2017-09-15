package com.example.sidkathuria14.news.javaModels;

/**
 * Created by sidkathuria14 on 15/9/17.
 */

public class java_model {
    String source;
    String sortBy;
    Article articles[];

    public String getSource() {
        return source;
    }

    public String getSortBy() {
        return sortBy;
    }

    public Article[] getArticles() {
        return articles;
    }


    public class Article{
        String author;
        String title;
        String publishedAt;
        String description;

        public String getAuthor() {
            return author;
        }

        public String getTitle() {
            return title;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public String getDescription() {
            return description;
        }

        public Article(String author, String title, String publishedAt, String description) {
            this.author = author;
            this.title = title;
            this.publishedAt = publishedAt;
            this.description = description;
        }
    }
}
