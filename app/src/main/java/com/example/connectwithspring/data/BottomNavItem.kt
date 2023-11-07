package com.example.connectwithspring.data

import com.example.connectwithspring.R.*

sealed class BottomNavItem(
    val route: String,
    val title: String,
    val icon: Int
) {
    object Search : BottomNavItem(route = "search", title = "Search", icon = drawable.baseline_search_24)
    object Ranking : BottomNavItem(route = "ranking", title = "Ranking", icon = drawable.baseline_format_list_numbered_24)
}