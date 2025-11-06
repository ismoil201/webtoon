package com.example.webtoon

import android.os.Bundle
import android.view.Gravity
import android.widget.TextView
import androidx.activity.addCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.webtoon.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var  binding  : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.viewPager.adapter = ViewPagerAdapter(this)

        TabLayoutMediator(binding.tabLayout, binding.viewPager,){
            tab, position -> run {
//                val textView  = TextView(this@MainActivity)
//                textView.gravity = Gravity.CENTER
//
//                tab.customView = textView  // -> bu biz qilgan text view


                tab.text = "$position"

            }
        }.attach()



        onBackPressedDispatcher.addCallback(this){
           val currentFragment  =  supportFragmentManager.fragments[binding.viewPager.currentItem]
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



    }

}
