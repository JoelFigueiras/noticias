package com.example.domain.headlines

import androidx.annotation.VisibleForTesting
import com.example.api.modelData.Articles
import com.example.api.remote.headlines.HeadlinesRemoteDataSource


class HeadlinesRepository : HeadlinesRepositoryContract {

    // TODO Refactor this into Dependency Injection when we get to that lesson
    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    var headlinesSource = HeadlinesRemoteDataSource()

    override suspend fun getHeadlinesFromRemote(country: String, category: String): Articles {
        val response = headlinesSource.getHeadlines(country,category)
        val result = response.body()
        if (response.isSuccessful && result != null) {
            return result
        }
        // Basic error Handling. Change to proper sealed class handling when we come back
        else {
            return Articles (status = response.errorBody().toString())
        }
    }

    override suspend fun getHeadlinesFromDb(country: String, category: String): Articles {
        TODO("Not yet implemented")
    }
}