package com.example.sidkathuria14.news.models

import java.util.*

/**
 * Created by sidkathuria14 on 14/9/17.
 */
data class main(
        val articles: ArrayList<newArticle>,
        val sortBy:String,
        val source:String
){
    data class newArticle(
            val author:String,
            val title:String,
            val description:String,
            val publishedAt:String,
            val url:String,
            val urlToImage:String
    )
}