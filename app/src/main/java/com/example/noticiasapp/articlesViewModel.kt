package com.example.noticiasapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.api.modelData.Articles
import com.example.domain.headlines.HeadlinesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class articlesViewModel(private val headlinesUseCase: HeadlinesUseCase):ViewModel() {
    val articles = MutableLiveData<Articles>()


    fun getArticles() {
        viewModelScope.launch(Dispatchers.IO) {
            articles.postValue(headlinesUseCase.getHeadlines("pt","business"))
        }

    }
}