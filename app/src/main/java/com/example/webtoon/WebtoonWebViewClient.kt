package com.example.webtoon

import android.graphics.Bitmap
import android.view.View
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import androidx.core.view.isVisible

class WebtoonWebViewClient(
    var progressBar: ProgressBar,
    private val saveData: (String) -> Unit

) : WebViewClient() {


    override fun onPageFinished(view: WebView?, url: String?) {
        super.onPageFinished(view, url)

        progressBar.visibility = View.GONE

        if (!url.isNullOrEmpty()) {
            saveData.invoke(url)
        }

    }

    override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
        super.onPageStarted(view, url, favicon)

        progressBar.isVisible = true
    }

//    override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
//
//        if( request != null && request.url.toString().contains("https://comic.naver.com/webtoon?tab=mon"))
//            return false
//        else return true
//  //TODO naver comic saytidan tawqariga chiqa olmasligi taminlash uchun ya'bi user harakatlarini bloklash uchun
//
//    }


    override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
        //https://comic.naver.com/webtoon?tab=mon


        if(request != null && request.url.toString().contains("comic.naver.com/webtoon/detail?titleId=")){
            saveData.invoke(request.url.toString())
        }

        return super.shouldOverrideUrlLoading(view, request)
    }

    override fun onReceivedError(
        view: WebView?,
        request: WebResourceRequest?,
        error: WebResourceError?
    ) {
        super.onReceivedError(view, request, error)

        progressBar.isVisible  = true
    }
}