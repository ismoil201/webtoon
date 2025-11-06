package com.example.webtoon

import android.os.Bundle
import androidx.activity.addCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.webtoon.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var  binding  : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        onBackPressedDispatcher.addCallback(this){
           val currentFragment  =  supportFragmentManager.fragments.firstOrNull()


            if (currentFragment is WebViewFragment) {
                if (currentFragment.canGoBack()) {
                    currentFragment.goBack()
                } else {
                    onBackPressedDispatcher.onBackPressed()
                }
            } else {
                onBackPressedDispatcher.onBackPressed()
            }

        }
        binding.button1.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.container, WebViewFragment())
                commit()
            }
        }

        binding.button2.setOnClickListener {

            supportFragmentManager.beginTransaction().apply {
                replace(R.id.container, BlankFragment())
                commit()
            }
        }


    }

}
