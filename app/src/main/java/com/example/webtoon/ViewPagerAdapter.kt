package com.example.webtoon

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import kotlin.text.get

class ViewPagerAdapter(private val mainActivity: MainActivity) : FragmentStateAdapter(mainActivity) {
    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 ->{
                return WebViewFragment(position, "https://comic.naver.com/webtoon/list?titleId=832243&tab=mon")
            }
            1 -> {
                return WebViewFragment(position,"https://comic.naver.com/webtoon?tab=tue")

            }
            else -> {
                return WebViewFragment(position,"https://comic.naver.com/webtoon?tab=thu")
            }

        }

    }

    override fun getItemCount(): Int {

        return 3
    }


}