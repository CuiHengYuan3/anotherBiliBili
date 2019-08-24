package com.example.anotherbilibili.ui.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebViewClient
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import com.example.anotherbilibili.R

import kotlinx.android.synthetic.main.activity_web.*
import kotlinx.android.synthetic.main.content_web.*

class WebActivity : AppCompatActivity() {

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)
        setSupportActionBar(toolbar)
        wb.settings.javaScriptEnabled = true
        wb.webViewClient = WebViewClient()
        wb.loadUrl(intent.getStringExtra("link"))

    }

}
