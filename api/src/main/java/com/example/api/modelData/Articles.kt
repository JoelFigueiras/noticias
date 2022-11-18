package com.example.api.modelData


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Articles(
    @Json(name = "articles")
    val articles: List<Article>?=null,
    @Json(name = "status")
    val status: String?=null ,
    @Json(name = "totalResults")
    val totalResults: Int?=null
)