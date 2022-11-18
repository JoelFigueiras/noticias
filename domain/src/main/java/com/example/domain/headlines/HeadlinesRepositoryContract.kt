package com.example.domain.headlines

import com.example.api.modelData.Articles

interface HeadlinesRepositoryContract {

    suspend fun getHeadlinesFromRemote(country: String, category: String): Articles
    suspend fun getHeadlinesFromDb(country: String, category: String): Articles

}
