package com.mercadolibre.challenge.client

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mercadolibre.challenge.client.databinding.ActivityClientBinding
import com.mercadolibre.challenge.render.RenderActivity

class ClientActivity : AppCompatActivity() {

    private var _binding: ActivityClientBinding? = null
    private val binding: ActivityClientBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityClientBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setup()
    }

    private fun setup() {
        binding.btnNext.setOnClickListener { goToGoogle() }
    }

    private fun goToGoogle() {
        val intent = Intent(this, RenderActivity::class.java)
        intent.putExtra(RenderActivity.EXTRA_TITLE, getString(R.string.challenge))
        intent.putExtra(RenderActivity.EXTRA_URL, getString(R.string.url_example))
        startActivity(intent)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}