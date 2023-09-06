package com.example.sayitahminetoyun

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class TahminActivity : AppCompatActivity() {

    private var rastgeleSayi = 0
    private var sayac = 5

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tahmin)

        rastgeleSayi = Random.nextInt(1, 15)

        Log.e("RastgeleSayi", rastgeleSayi.toString())

        val kalanHak: TextView = findViewById(R.id.kalanHak)
        val yardimciText: TextView = findViewById(R.id.yardimciTextView)
        val girdiText: EditText = findViewById(R.id.girdiText)

        val buttonTahminEt: Button = findViewById(R.id.buttonTahminEt)
        buttonTahminEt.setOnClickListener {
            val tahmin = girdiText.text.toString().toInt()
            if (tahmin > 15) {
                yardimciText.text = "Lutfen Gecerli Bir Deger Giriniz.."
            } else {
                sayac -= 1

                if (tahmin == rastgeleSayi) {
                    val intent = Intent(this@TahminActivity, SonucActivity::class.java)
                    intent.putExtra("sonuc", true)
                    finish()
                    startActivity(intent)
                }
                if (tahmin < rastgeleSayi) {
                    yardimciText.text = "Arttir"
                    kalanHak.text = "Kalan Hak: $sayac"
                }
                if (tahmin > rastgeleSayi) {
                    yardimciText.text = "Azalt"
                    kalanHak.text = "Kalan Hak: $sayac"
                }
                if (tahmin - 3 == rastgeleSayi || tahmin - 2 == rastgeleSayi || tahmin - 1 == rastgeleSayi) {
                    yardimciText.text = "Cok Yakinsin Azalt.. "
                    kalanHak.text = "Kalan Hak: $sayac"
                }
                if (tahmin + 3 == rastgeleSayi || tahmin + 2 == rastgeleSayi || tahmin + 1 == rastgeleSayi) {
                    yardimciText.text = "Cok Yakinsin Arttir.."
                    kalanHak.text = "Kalan Hak: $sayac"
                }
                if (sayac == 0 && tahmin != rastgeleSayi) {
                    val intent = Intent(this@TahminActivity, SonucActivity::class.java)
                    intent.putExtra("sonuc", false)
                    finish()
                    startActivity(intent)
                } else if (sayac == 0 && tahmin == rastgeleSayi) {
                    val intent = Intent(this@TahminActivity, SonucActivity::class.java)
                    intent.putExtra("sonuc", true)
                    finish()
                    startActivity(intent)
                }
                girdiText.setText("")
            }


        }
    }
}