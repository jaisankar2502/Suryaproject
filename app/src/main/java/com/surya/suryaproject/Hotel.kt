package com.surya.suryaproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast

class Hotel : AppCompatActivity() {
    private lateinit var webView:WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hotel)
      webView= findViewById(R.id.HotelView)
        webView.settings.javaScriptEnabled
        webView.webViewClient= object :WebViewClient(){
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                if (view != null) {
                    if (url != null) {
                        view.loadUrl(url)
                    }
                }
                return true
            }
        }
        webView.loadUrl("https://hotels.tripodeal.com/")
    }
}