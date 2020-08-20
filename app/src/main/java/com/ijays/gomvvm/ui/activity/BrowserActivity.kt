package com.ijays.gomvvm.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import com.ijays.gomvvm.R
import com.ijays.gomvvm.base.BaseActivity
import kotlinx.android.synthetic.main.activity_browser_layout.*

/**
 * Display web content
 */
class BrowserActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_browser_layout)
        val requestUrl = intent.getStringExtra(EXTRA_URL)

        setupWebView()
        webView.loadUrl(requestUrl)

    }


    private fun setupWebView() {
        val settings = webView.settings
        settings.loadWithOverviewMode = true
        settings.useWideViewPort = true
        //允许js代码
        settings.javaScriptEnabled = true
        //允许SessionStorage/LocalStorage存储
        settings.domStorageEnabled = true
        //
        settings.displayZoomControls = false
        settings.builtInZoomControls = false

        settings.loadsImagesAutomatically = true
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            settings.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
        }
        webView.webChromeClient = object : WebChromeClient() {
            override fun onProgressChanged(view: WebView?, newProgress: Int) {
                super.onProgressChanged(view, newProgress)

                progressBar.progress = newProgress

                if (newProgress >= 90) {
                    progressBar.visibility = View.GONE
                } else {
                    progressBar.visibility = View.VISIBLE
                }
            }

        }
    }


    override fun onDestroy() {
        super.onDestroy()

        if (webView != null) {
            webView.removeAllViews()
            webView.clearHistory()
            webView.destroy()
        }
    }

    companion object {
        const val EXTRA_URL = "extra_url"
        fun startActivity(context: Context, url: String) {
            val intent = Intent(context, BrowserActivity::class.java)
            intent.putExtra(EXTRA_URL, url)
            context.startActivity(intent)
        }
    }

}