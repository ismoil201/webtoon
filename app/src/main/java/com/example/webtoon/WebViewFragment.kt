package com.example.webtoon

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.core.content.edit
import com.example.webtoon.databinding.FragmentWebViewBinding

class WebViewFragment(private val position : Int, private val webviewUrl : String) : Fragment() {


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
            settings.javaScriptEnabled = true

            loadUrl(webviewUrl)
            webViewClient = WebtoonWebViewClient(binding.progressBar,
            {
                activity?.getSharedPreferences("WEB_HISTORY", Context.MODE_PRIVATE)?.edit{
                    putString("tab$position", url)
                }
            })

        }

        binding.btnBackToLast.setOnClickListener {
            val shared = activity?.getSharedPreferences("WEB_HISTORY", Context.MODE_PRIVATE)
            val url = shared?.getString("tab$position", null)

            if (url.isNullOrEmpty()) {
                Toast.makeText(context, "Oxirgi saqlangan sahifa yo‘q", Toast.LENGTH_SHORT).show()
            } else {
                binding.web.loadUrl(url)
            }

        }

    }

    fun canGoBack(): Boolean{
        return binding.web.canGoBack()
    }

    fun goBack(){
        return binding.web.goBack()
    }

}