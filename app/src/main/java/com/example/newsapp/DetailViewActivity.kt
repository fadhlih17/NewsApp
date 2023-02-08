package com.example.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.newsapp.databinding.ActivityDetailViewBinding

class DetailViewActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDetailViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val detailView = binding.detailView

        val detailData = intent.getStringExtra("url")
        detailData.let {
            if (it != null){
                detailView.loadUrl(it)
            }
        }
    }
}