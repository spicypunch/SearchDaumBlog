package com.example.connectwithspring

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.connectwithspring.data.SearchResultResponse
import com.example.connectwithspring.data.WordCountResponse
import com.example.connectwithspring.repository.GetSearchRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModel @Inject constructor(
    private val getSearchRepositoryImpl: GetSearchRepositoryImpl
) : ViewModel() {

    private val _searchResult = mutableStateOf<SearchResultResponse?>(null)
    val searchResult: State<SearchResultResponse?> = _searchResult

    private val _searchResultForDialog = mutableStateOf<SearchResultResponse?>(null)
    val searchResultForDialog: State<SearchResultResponse?> = _searchResultForDialog

    private val _wordCountResult = mutableStateOf<WordCountResponse?>(null)
    val wordCountResult: State<WordCountResponse?> = _wordCountResult

    fun searchBlog(
        query: String,
        sort: String,
        page: Int,
        size: Int
    ) {
        viewModelScope.launch {
            try {
                _searchResult.value = getSearchRepositoryImpl.getSearchRepository(query, sort, page, size)
            } catch (e: Exception) {
                Log.e("SearchBlogErr", e.toString())
            }
        }
    }

    fun searchBlogForDialog(
        query: String,
        sort: String,
        page: Int,
        size: Int
    ) {
        viewModelScope.launch {
            try {
                _searchResultForDialog.value = getSearchRepositoryImpl.getSearchRepository(query, sort, page, size)
            } catch (e: Exception) {
                Log.e("SearchBlogErr", e.toString())
            }
        }
    }

    fun getWordCount() {
        viewModelScope.launch {
            try {
                _wordCountResult.value = getSearchRepositoryImpl.getWordCount()
            } catch (e: Exception) {
                Log.e("GetWordCountErr", e.toString())
            }
        }
    }
}
