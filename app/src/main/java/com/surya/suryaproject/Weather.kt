package com.surya.suryaproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast

class Weather : AppCompatActivity() {
    lateinit var weatherview:WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)
        Toast.makeText(applicationContext," Weather", Toast.LENGTH_SHORT).show()
        weatherview= findViewById(R.id.WeatherView)
        weatherview.settings.javaScriptEnabled
        weatherview.webViewClient= object :WebViewClient(){
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                if (url !=null){
                    view?.loadUrl(url)
                }
                return true
            }
        }
        weatherview.loadUrl("")

    }
}