package com.example.noticiasapp

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.domain.headlines.HeadlinesUseCase

class ArticleViewModelFactory : ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>) =
        articlesViewModel(headlinesUseCase = HeadlinesUseCase()) as T

    companion object {

        // We make sure this is a singleton
        // Design Pattern Theory https://refactoring.guru/design-patterns/singleton
        @Volatile // We need this to be marked as Volatile. Click the annotation to see documentation and try to understand the reason
        private var INSTANCE: ViewModelProvider.NewInstanceFactory? = null

        fun getInstance() =
            INSTANCE ?: synchronized(articlesViewModel::class.java) {
                INSTANCE ?: ArticleViewModelFactory().also { INSTANCE = it }
            }

        @VisibleForTesting
        fun setInstance(factory: ViewModelProvider.NewInstanceFactory?) {
            INSTANCE = factory
        }
    }
}