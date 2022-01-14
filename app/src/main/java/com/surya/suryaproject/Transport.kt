package com.surya.suryaproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast

class Transport : AppCompatActivity() {
    lateinit var  trasportview:WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transport)
        Toast.makeText(applicationContext,"Transport", Toast.LENGTH_SHORT).show()
        trasportview= findViewById(R.id.TransportView)
        trasportview.settings.javaScriptEnabled
        trasportview.webViewClient= object :WebViewClient(){
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
              if (url != null){
                  view?.loadUrl(url)

                }
                return true
            }
        }
        trasportview.loadUrl("")
    }
}