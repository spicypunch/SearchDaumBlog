package com.example.connectwithspring.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.connectwithspring.ViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(viewModel: ViewModel) {
    val context = LocalContext.current
    val (search, setSearch) = rememberSaveable {
        mutableStateOf("")
    }
    val keyboardController = LocalSoftwareKeyboardController.current
    val searchResult = viewModel.searchResult.value
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "다음 블로그 검색") })
        }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                TextField(
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .weight(1f)
                        .height(50.dp),
                    value = search,
                    onValueChange = setSearch,
                    textStyle = TextStyle(fontSize = 15.sp),
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
                    keyboardActions = KeyboardActions(onSearch = {
                        keyboardController?.hide()
                        viewModel.searchBlog(search, "ACCURACY", 1, 10)
                    })
                )
                Button(
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .padding(end = 8.dp)
                        .height(50.dp),
                    onClick = {
                        keyboardController?.hide()
                        viewModel.searchBlog(search, "ACCURACY", 1, 20)
                    }) {
                    Icon(imageVector = Icons.Default.Search, contentDescription = "search")
                }
            }
            LazyColumn(modifier = Modifier.padding(8.dp)) {
                searchResult?.let { result ->
                    items(items = result.documents) { item ->
                        LazyItem(item, context)
                    }
                }
            }
        }
    }
}