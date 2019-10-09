package com.example.kotlin.examples.kotlin_examples

import android.app.Application
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        val formatStrategy = PrettyFormatStrategy.newBuilder()
            .tag("angel")
            .build()

        Logger.addLogAdapter(AndroidLogAdapter(formatStrategy))


    }
}