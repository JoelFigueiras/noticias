package com.example.noticiasapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.noticiasapp.databinding.ArticlesFragmentBinding

class articlesFragment: Fragment() {


private  lateinit var viewModel: articlesViewModel
private lateinit var binding: ArticlesFragmentBinding



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = ArticlesFragmentBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(
            this,
            ArticleViewModelFactory.getInstance()
        )[articlesViewModel::class.java]
        viewModel.getArticles()
    }

}