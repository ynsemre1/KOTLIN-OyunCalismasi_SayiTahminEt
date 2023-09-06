package com.example.sayitahminetoyun

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.VideoView
import androidx.core.view.isVisible

class SonucActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sonuc)

        val imageView:ImageView=findViewById(R.id.imageView)
        val sonucText:TextView=findViewById(R.id.sonucText)
        val videoView:VideoView=findViewById(R.id.videoView)

        val sonuc = intent.getBooleanExtra("sonuc",false)

        if (sonuc){
            sonucText.text="Kazandiniz .."
            imageView.setImageResource(R.drawable.kazandiniz)
            videoView.isVisible=false
        }else{
            sonucText.text="Kaybettiniz .."
            imageView.setImageResource(R.drawable.kazandiniz)
            imageView.isVisible=false
            val videoAdresi= Uri.parse("android.resource://"+packageName+"/"+R.raw.kaybettiniz)
            videoView.setVideoURI(videoAdresi)
            videoView.start()
        }

        val buttonBasaDon: Button = findViewById(R.id.buttonBasaDon)
        buttonBasaDon.setOnClickListener {
            val intent = Intent(this@SonucActivity, TahminActivity::class.java)
            finish()
            startActivity(intent)
        }
    }
}