package com.example.newsapp.network

import com.example.newsapp.Constant
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ConfigNetwork {
    companion object {
        fun setupRetrofit() : Retrofit {
            val retrofit = Retrofit.Builder()
                .baseUrl(Constant.Base_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit
        }

        fun request() = setupRetrofit().create(NewsService::class.java)
    }
}