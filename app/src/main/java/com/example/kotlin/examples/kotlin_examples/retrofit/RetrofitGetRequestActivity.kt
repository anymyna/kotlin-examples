package com.example.kotlin.examples.kotlin_examples.retrofit

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity

import com.example.kotlin.examples.kotlin_examples.R
import com.orhanobut.logger.Logger

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitGetRequestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit)
        request()
    }

    private fun request() {

        //步骤4:创建Retrofit对象
        val retrofit = Retrofit.Builder()
            .baseUrl("http://fy.iciba.com/") // 设置 网络请求 Url
            .addConverterFactory(GsonConverterFactory.create()) //设置使用Gson解析(记得加入依赖)
            .build()

        // 步骤5:创建 网络请求接口 的实例
        val request = retrofit.create(GetRequestInterface::class.java)

        //对 发送请求 进行封装
        val call = request.call

        //步骤6:发送网络请求(异步)
        call.enqueue(object : Callback<Translation> {
            //请求成功时候的回调
            //步骤7：处理返回数据
            override fun onResponse(call: Call<Translation>, response: Response<Translation>) {
                //请求处理,输出结果
                response.body().show()
                response.body().toString()
                Logger.e("response " + response.body().toString())
            }

            //请求失败时候的回调
            override fun onFailure(call: Call<Translation>, throwable: Throwable) {
                println("连接失败")
            }
        })
    }
}

