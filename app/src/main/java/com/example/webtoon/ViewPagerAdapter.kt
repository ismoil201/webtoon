package com.example.webtoon

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import kotlin.text.get

class ViewPagerAdapter(private val mainActivity: MainActivity) : FragmentStateAdapter(mainActivity) {
    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 ->{
                return WebViewFragment()
            }
            1 -> {
                return WebViewFragment()

            }
            else -> {
                return BlankFragment()
            }

        }

    }

    override fun getItemCount(): Int {

        return 3
    }


}