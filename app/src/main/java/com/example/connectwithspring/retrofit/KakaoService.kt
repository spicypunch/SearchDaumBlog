package com.example.connectwithspring.retrofit

import com.example.connectwithspring.data.SearchResultResponse
import com.example.connectwithspring.data.WordCountResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface KakaoService {

    @GET("api/blog")
    suspend fun getSearchResult(
        @Query("query") query: String,
        @Query("sort") sort: String,
        @Query("page") page: Int,
        @Query("size") size: Int
    ): SearchResultResponse

    @GET("api/blog/rank")
    suspend fun getWordCount(): WordCountResponse
}