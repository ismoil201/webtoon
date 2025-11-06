package com.example.webtoon

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import com.example.webtoon.databinding.FragmentWebViewBinding

class WebViewFragment : Fragment() {


    private lateinit var  binding : FragmentWebViewBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentWebViewBinding.inflate(inflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)




        binding.web.apply {
            loadUrl("https://comic.naver.com/webtoon?tab=mon")
            webViewClient = WebtoonWebViewClient(binding.progressBar)
            settings.javaScriptEnabled = true
        }
    }

    fun canGoBack(): Boolean{
        return binding.web.canGoBack()
    }

    fun goBack(){
        return binding.web.goBack()
    }

}