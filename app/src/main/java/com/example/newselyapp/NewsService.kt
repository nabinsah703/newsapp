package com.example.newselyapp

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Query

//https://newsapi.org/v2/top-headlines?country=us&apiKey=293963b781ca412dbfad624e1ce370ec

const val BASE_URL = "https://newsapi.org"
const val API_KEY = "293963b781ca412dbfad624e1ce370ec"
interface NewsInterface {
@GET("/v2/top-headlines?apiKey=$API_KEY")
    fun getHeadline(@Query("country")country:String, @Query("page") page:Int) : Call<News>
}

object NewsService{
    val newsInstance:NewsInterface
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
      newsInstance = retrofit.create(NewsInterface::class.java)
    }
}
//https://newsapi.org/v2/top-headlines?apiKey=293963b781ca412dbfad624e1ce370ec&country=in&page=1