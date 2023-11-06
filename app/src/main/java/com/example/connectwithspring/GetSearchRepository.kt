package com.example.connectwithspring

interface GetSearchRepository {
    suspend fun getSearchRepository(
        query: String,
        sort: String,
        page: Int,
        size: Int
    ): SearchResultResponse

    suspend fun getWordCount(): WordCountResponse
}