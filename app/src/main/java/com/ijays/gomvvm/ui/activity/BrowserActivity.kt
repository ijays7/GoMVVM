package com.ijays.gomvvm.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.view.Window
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import com.google.android.material.transition.platform.MaterialContainerTransform
import com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback
import com.ijays.core.base.activity.BaseActivity
import com.ijays.gomvvm.common.EXTRA_DATA
import com.ijays.gomvvm.databinding.ActivityBrowserLayoutBinding
import com.ijays.gomvvm.model.BrowserLoadOptionModel

/**
 * Display web content
 */
class BrowserActivity : BaseActivity() {

    private lateinit var binding: ActivityBrowserLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        window.requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS)
        findViewById<View>(android.R.id.content).transitionName = "shared_element_container"
        // Attach a callback used to receive the shared elements from Activity A to be used by the
        // container transform transition
        setEnterSharedElementCallback(MaterialContainerTransformSharedElementCallback())

        // Set this Activity's enter and return transition to a MaterialContainerTransform
        window.sharedElementEnterTransition = MaterialContainerTransform().apply {
            addTarget(android.R.id.content)
            duration = 300L
        }
        window.sharedElementReturnTransition = MaterialContainerTransform().apply {
            addTarget(android.R.id.content)
            duration = 250L
        }

        super.onCreate(savedInstanceState)
        binding = ActivityBrowserLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val optionModel =
            intent.getParcelableExtra<BrowserLoadOptionModel>(EXTRA_DATA) ?: return

        setSupportActionBar(binding.toolbar)
        supportActionBar?.let {
            it.setDisplayHomeAsUpEnabled(true)
            it.setDisplayShowTitleEnabled(true)
//            it.title = optionModel.title
        }

        setupWebView()
        binding.webView.loadUrl(optionModel.link)
    }


    private fun setupWebView() {
        val settings = binding.webView.settings
        settings.loadWithOverviewMode = true
        settings.useWideViewPort = true
        //允许js代码
        settings.javaScriptEnabled = false
        //允许SessionStorage/LocalStorage存储
        settings.domStorageEnabled = true
        //
        settings.displayZoomControls = false
        settings.builtInZoomControls = false

        settings.loadsImagesAutomatically = true
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            settings.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
        }
        binding.webView.webChromeClient = object : WebChromeClient() {
            override fun onProgressChanged(view: WebView?, newProgress: Int) {
                super.onProgressChanged(view, newProgress)

                binding.progressBar.progress = newProgress

                if (newProgress >= 90) {
                    binding.progressBar.visibility = View.GONE
                } else {
                    binding.progressBar.visibility = View.VISIBLE
                }
            }

        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onDestroy() {
        super.onDestroy()

        binding.webView.removeAllViews()
        binding.webView.clearHistory()
        binding.webView.destroy()
    }

    companion object {

        fun startActivity(context: Context, url: String) {
            startActivity(context, BrowserLoadOptionModel(url))
        }

        fun startActivity(context: Context, model: BrowserLoadOptionModel) {
            val intent = Intent(context, BrowserActivity::class.java)
            intent.putExtra(EXTRA_DATA, model)
            context.startActivity(intent)
        }
    }

}