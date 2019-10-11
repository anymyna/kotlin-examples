package com.example.kotlin.examples.kotlin_examples

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.example.kotlin.examples.kotlin_examples.ui.LoggerActivity
import com.example.kotlin.examples.kotlin_examples.ui.TabLayoutActivity
import com.example.kotlin.examples.kotlin_examples.util.NetworkActivity

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        btn_logger.setOnClickListener {
            startActivity(Intent(this, LoggerActivity::class.java))
        }

        btn_tab.setOnClickListener {
            startActivity(Intent(this, TabLayoutActivity::class.java))
        }

        btn_network.setOnClickListener {
            startActivity(Intent(this, NetworkActivity::class.java))
        }
        // SharedPreferences
//        var preferences = getSharedPreferences("share",0).edit()
//        preferences.putString("name","angel")
//        preferences.putString("title","name")
//        preferences.commit()
//        val result = preferences.commit()

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when(item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
