package com.example.news_app.ui.fragments

import android.os.Bundle
import android.view.View
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.news_app.R
import com.example.news_app.databinding.FragmentArticleNewsBinding
import com.example.news_app.model.Article
import com.example.news_app.ui.NewsActivity
import com.example.news_app.ui.NewsViewModel
import com.google.android.material.snackbar.Snackbar

class ArticleFragment : Fragment(R.layout.fragment_article_news) {

    lateinit var viewModel: NewsViewModel
    private lateinit var binding: FragmentArticleNewsBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentArticleNewsBinding.bind(view)

        viewModel = (activity as NewsActivity).viewModel

        // Retrieve the article from the bundle
        val article = arguments?.getSerializable("article") as? Article

        binding.webView.apply {
            webViewClient = WebViewClient()
            article?.let { loadUrl(it.url) }
        }

        binding.fab.setOnClickListener {
            article?.let { it1 -> viewModel.saveArtivle(it1) }
            Snackbar.make(view, "Article saved successfully", Snackbar.LENGTH_SHORT)
                .show()
        }




    }

}