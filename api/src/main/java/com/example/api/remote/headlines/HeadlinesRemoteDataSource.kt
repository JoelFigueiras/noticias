package com.example.api.remote.headlines

import androidx.annotation.VisibleForTesting
import com.example.api.common.RestConstants
import com.example.api.modelData.Articles
import com.example.api.remote.ApiClient
import com.example.api.remote.ApiService
import retrofit2.Response

class HeadlinesRemoteDataSource() : HeadlinesDataSource {

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    var client = ApiClient.getInstance()
    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    var service: ApiService = client.create(ApiService::class.java)

    override suspend fun getHeadlines(country: String, category: String): Response<Articles> {
        return service.getHeadlines(country, category, RestConstants.API_KEY_VALUE)
    }
}