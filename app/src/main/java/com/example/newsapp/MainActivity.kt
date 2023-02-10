package com.example.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.Model.News
import com.example.newsapp.Model.ResponseData
import com.example.newsapp.adapter.CategoryAdapter
import com.example.newsapp.adapter.RecyclerViewAdapter
import com.example.newsapp.databinding.ActivityMainBinding
import com.example.newsapp.network.ConfigNetwork
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var manager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    manager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
    binding.rvCategory.apply {
        adapter = CategoryAdapter()
        layoutManager = manager
    }

        val request = ConfigNetwork.request()

        request.getNews("us","f3d97c51025a4a3aa9492a0503bc7e90")
            .enqueue(object : Callback<ResponseData>{
                override fun onResponse(
                    call: Call<ResponseData>,
                    response: Response<ResponseData>
                ) {
                    if (response.isSuccessful){
                        val dataNews = response.body()?.articles
                        Log.d("data", dataNews.toString())

                        // show to recycler view
                        val recyclerView = binding.recyclerView
                        val adapter = dataNews?.let { RecyclerViewAdapter(it) }
                        recyclerView.adapter = adapter
                    }
                }

                override fun onFailure(call: Call<ResponseData>, t: Throwable) {
                    Log.d("error", t.localizedMessage ?: "")
                }

            })

    }
}