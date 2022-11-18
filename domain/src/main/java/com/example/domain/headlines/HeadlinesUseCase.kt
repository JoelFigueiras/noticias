package com.example.domain.headlines

import com.example.api.modelData.Articles

class HeadlinesUseCase() {
    var headlinesRepository = HeadlinesRepository()
    suspend fun getHeadlines(country: String, category: String): Articles =
        headlinesRepository.getHeadlinesFromRemote(country, category)
}