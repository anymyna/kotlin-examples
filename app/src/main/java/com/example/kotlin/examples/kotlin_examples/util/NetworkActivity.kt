package com.example.kotlin.examples.kotlin_examples.util

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.orhanobut.logger.Logger
import kotlinx.android.synthetic.main.activity_network.*
import okhttp3.*
import java.io.IOException
import java.util.concurrent.TimeUnit


class NetworkActivity : AppCompatActivity() {

    var client:OkHttpClient = OkHttpClient();




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.kotlin.examples.kotlin_examples.R.layout.activity_network)
        btn_post.setOnClickListener {
            Logger.e("post")
            postData()
        }

        btn_get.setOnClickListener {
            getData()
        }
    }



    private  fun getData(){
        try {
            val client = OkHttpClient()
            val request = Request.Builder().get()
                .url("https://api.github.com/events")
                .build()

            var call = client.newCall(request)

            call.enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    Logger.e("onFailure")
                }

                @Throws(IOException::class)
                override fun onResponse(call: Call, response: Response) {
                    Logger.e("onResponse" + response.body.toString())
                    Logger.e(response.toString())
                    Logger.e("onResponse" + response.body?.string())// get


                }
            })
        }catch (e:Exception) {
            Log.e("UPDATE ERROR:", "", e)
        }
    }




    private fun postData() {

        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .build()
        val formBody = FormBody.Builder()
            .build()

        val request = Request.Builder()
            .post(formBody)
            .url("http://httpbin.org/post")
            .build()

        val call = okHttpClient.newCall(request)
        call.enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Logger.e("onFailure")
            }

            @Throws(IOException::class)
            override fun onResponse(call: Call, response: Response) {

                Logger.e("onResponse" + response.body?.string())

            }
        })

    }


}
