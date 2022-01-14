package com.surya.suryaproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast

class Package : AppCompatActivity() {
    private lateinit var webView: WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_package)
        Toast.makeText(applicationContext, "Package", Toast.LENGTH_SHORT).show()
        webView = findViewById(R.id.PackageView)
        webView.settings.javaScriptEnabled
        webView.webViewClient= object :WebViewClient(){
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                if (url != null) {
                    view?.loadUrl(url)
                }
                return true
            }
        }
webView.loadUrl("https://www.tripodeal.com/travel/")

    }

}