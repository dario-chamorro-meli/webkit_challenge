package com.mercadolibre.challenge.render

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mercadolibre.challenge.render.databinding.ActivityRenderBinding

class RenderActivity : AppCompatActivity() {

    private var _binding: ActivityRenderBinding? = null
    private val binding: ActivityRenderBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityRenderBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        setupToolBar()
        setupWebView()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun setupToolBar() = intent.extras?.let {
        val title = it.getString(EXTRA_TITLE, binding.webView.title)
        binding.toolbar.title = title

        val url = it.getString(EXTRA_URL) ?: return@let
        binding.webView.loadUrl(url)
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun setupWebView() = intent.extras?.let {
        binding.webView.settings.run {
            javaScriptEnabled = true
        }

        val url = it.getString(EXTRA_URL) ?: return@let
        binding.webView.loadUrl(url)
    }

    companion object {
        const val EXTRA_TITLE = "title"
        const val EXTRA_URL = "url"
    }
}