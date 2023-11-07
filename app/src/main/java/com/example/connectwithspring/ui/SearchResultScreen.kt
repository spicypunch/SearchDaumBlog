package com.example.connectwithspring.ui

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.connectwithspring.R
import com.example.connectwithspring.data.SearchResultResponse

@Composable
fun LazyItem(item: SearchResultResponse.Document, context: Context) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .padding(bottom = 4.dp)
            .clickable { openBrowser(context, item.url) }
    ) {
        Row() {
            Image(
                modifier = Modifier
                    .width(75.dp)
                    .height(75.dp)
                    .padding(5.dp),
                painter = rememberAsyncImagePainter(model = if (item.thumbnail != null) item.thumbnail else R.drawable.baseline_insert_photo_24),
                contentDescription = "thumbnail"
            )
            Column {
                Text(text = "제목: " + removeBoldTags(item.title))
                Text(text = "내용: " + removeString(removeBoldTags(item.contents)))
            }
        }
    }
}




fun removeBoldTags(input: String): String {
    val regex = Regex("</?b>")
    return regex.replace(input, "")
}

fun removeString(input: String): String {
    return if (input.length < 30) {
        input
    } else {
        input.substring(0, 30) + "..."
    }
}

fun openBrowser(context: Context, url: String) {
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
    context.startActivity(intent)
}