package com.example.connectwithspring.repository

import com.example.connectwithspring.data.SearchResultResponse
import com.example.connectwithspring.data.WordCountResponse

interface GetSearchRepository {
    suspend fun getSearchRepository(
        query: String,
        sort: String,
        page: Int,
        size: Int
    ): SearchResultResponse

    suspend fun getWordCount(): WordCountResponse
}