package com.example.newsapp.network

import com.example.newsapp.Model.ResponseData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {
    @GET("top-headlines")
    fun getNews(
        @Query("country") country : String,
        @Query("apiKey") apiKey : String
    ) : Call<ResponseData>
}