package com.example.newsapp.Model

class ResponseData (
    var status : String,
    var articles : List<News>
)

class News (
    var author : String,
    var title : String,
    var description : String,
    var url : String,
    var urlToImage : String
        )