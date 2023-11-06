package com.example.connectwithspring

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RankingScreen(
    navController: NavController,
    viewModel: ViewModel
) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "가장 많이 검색한 ") })
        },
    ) {
        LazyColumn(modifier = Modifier.padding(it)) {
//            items() {
//
//            }
        }
    }
}