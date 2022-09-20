package com.example.newselyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getNews()
    }

    private fun getNews() {
        val news = NewsService.newsInstance.getHeadline("in",1)
        news.enqueue(object: Callback<News>{
            override fun onResponse(call: Call<News>, response: Response<News>) {
                Log.d("TAG", "onResponse: success")
                val news  = response.body()
                if (news !=  null ) {
                    Log.d("TAG", news.toString())
                }
            }

            override fun onFailure(call: Call<News>, t: Throwable) {
                Log.d("TAG", "onFailure: failed")
            }

        })

    }
}