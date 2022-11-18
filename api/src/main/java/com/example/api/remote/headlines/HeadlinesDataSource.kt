package com.example.api.remote.headlines

import com.example.api.modelData.Articles
import retrofit2.Response

interface HeadlinesDataSource {
    suspend fun getHeadlines(country: String, category: String): Response<Articles>
}