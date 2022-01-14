package com.surya.suryaproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.core.content.withStyledAttributes

class Travel : AppCompatActivity() {
    private lateinit var webview: WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_travel)
        webview = findViewById(R.id.TravelView)
        webview.settings.javaScriptEnabled
        webview.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                if (url != null) {
                    view?.loadUrl(url)

                }

                return true
            }
        }
        webview.loadUrl("https://www.tripodeal.com/travel/advice/")
    }
}