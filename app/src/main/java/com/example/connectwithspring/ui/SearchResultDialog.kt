package com.example.connectwithspring.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.connectwithspring.ViewModel

@Composable
fun SearchResultDialog(
    word: String,
    viewModel: ViewModel,
    onClicked: (Boolean) -> Unit
) {
    viewModel.searchBlogForDialog(word, "ACCURACY", 1, 10)
    val searchResult = viewModel.searchResultForDialog.value
    val context = LocalContext.current
    Dialog(onDismissRequest = { onClicked(false) }) {
        Surface(
            shape = MaterialTheme.shapes.large,
            color = MaterialTheme.colorScheme.surface,
            contentColor = contentColorFor(MaterialTheme.colorScheme.surface)
        ) {
            Box(modifier = Modifier
                .padding(8.dp)
                .fillMaxHeight(0.9f)
                .fillMaxWidth(1f)) {
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
}