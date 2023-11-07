package com.example.connectwithspring.data

class WordCountResponse : ArrayList<WordCountResponse.WordCountResponseItem>() {
    data class WordCountResponseItem(
        val cnt: Int,
        val word: String
    )
}