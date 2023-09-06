package com.example.sayitahminetoyun

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonBasla:Button = findViewById(R.id.buttonBasla)
        buttonBasla.setOnClickListener {
            startActivity(Intent(this@MainActivity, TahminActivity::class.java))
        }





    }
}