package com.example.connectwithspring.repository

import com.example.connectwithspring.data.SearchResultResponse
import com.example.connectwithspring.data.WordCountResponse
import com.example.connectwithspring.retrofit.KakaoService
import javax.inject.Inject

class GetSearchRepositoryImpl @Inject constructor(
    private val kakaoService: KakaoService
) : GetSearchRepository {

    override suspend fun getSearchRepository(
        query: String,
        sort: String,
        page: Int,
        size: Int
    ): SearchResultResponse {
        return kakaoService.getSearchResult(query, sort, page, size)
    }

    override suspend fun getWordCount(): WordCountResponse {
        return kakaoService.getWordCount()
    }
}