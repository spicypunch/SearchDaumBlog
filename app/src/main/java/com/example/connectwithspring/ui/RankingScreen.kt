package com.example.connectwithspring.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.connectwithspring.ViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RankingScreen(viewModel: ViewModel) {
    viewModel.getWordCount()
    val rankingList = viewModel.wordCountResult.value
    var showDialog by remember {
        mutableStateOf(false)
    }
    var word by remember {
        mutableStateOf("")
    }
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "검색 횟수") })
        },
    ) {
        LazyColumn(modifier = Modifier.padding(it)) {
            rankingList?.let {
                items(items = rankingList) { item ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.Transparent)
                            .padding(8.dp)
                            .clickable {
                                showDialog = true
                                word = item.word
                            },
                        colors = CardDefaults.cardColors(containerColor = Color.Transparent)
                    ) {
                        Row() {
                            Text(
                                modifier = Modifier.weight(0.7f),
                                text = "검색어: " + item.word,
                                fontSize = 22.sp
                            )
                            Text(
                                modifier = Modifier.weight(0.3f),
                                text = "횟수: " + item.cnt.toString(),
                                fontSize = 22.sp
                            )
                        }
                    }
                    Divider(modifier = Modifier.padding(8.dp))
                }
            }
        }
    }

    if (showDialog) {
        SearchResultDialog(word = word, viewModel = viewModel) {
            if (!it) showDialog = false
        }
    }
}