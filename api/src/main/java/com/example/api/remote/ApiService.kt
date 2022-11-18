package com.example.api.remote

import com.example.api.common.RestConstants
import com.example.api.modelData.Articles
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET(RestConstants.HEADLINES)
    suspend fun getHeadlines(
        @Query(RestConstants.COUNTRY) country : String,
        @Query(RestConstants.CATEGORY) category: String,
        @Query(RestConstants.API_KEY) apiKey: String
    ): Response<Articles>
}