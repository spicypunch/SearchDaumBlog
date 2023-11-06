package com.example.connectwithspring

data class SearchResultResponse(
    val documents: List<Document>,
    val meta: Meta
) {
    data class Document(
        val blogname: String,
        val contents: String,
        val datetime: String,
        val thumbnail: String,
        val title: String,
        val url: String
    )

    data class Meta(
        val is_end: Boolean,
        val pageable_count: Int,
        val total_count: Int
    )
}