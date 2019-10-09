package com.example.kotlin.examples.kotlin_examples.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin.examples.kotlin_examples.R
import com.orhanobut.logger.Logger
import kotlinx.android.synthetic.main.content_main.*

class LoggerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logger)
        Logger.e("onCreate")
        btn_logger.setOnClickListener {
            Logger.e("test")
        }
    }


}
