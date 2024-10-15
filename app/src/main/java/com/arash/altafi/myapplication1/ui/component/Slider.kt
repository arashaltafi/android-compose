package com.arash.altafi.myapplication1.ui.component

import androidx.compose.foundation.*
import androidx.compose.runtime.*
import kotlinx.coroutines.delay
import androidx.compose.material3.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.*
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.arash.altafi.myapplication1.utils.GlobalUtils
import kotlinx.coroutines.launch
import kotlin.math.abs
import kotlin.math.min

data class ImageData(
    val id: Int,
    val image: String,
    val title: String,
    val link: String
)

@Composable
fun ImageSliderScreen() {
    val imageDataList = listOf(
        ImageData(
            1,
            "https://arashaltafi.ir/Social_Media/story-01.jpg",
            "arash",
            "https://arashaltafi.ir/"
        ),
        ImageData(
            2,
            "https://arashaltafi.ir/Social_Media/story-02.jpg",
            "myChats",
            "https://mychats.ir/"
        ),
        ImageData(
            3,
            "https://arashaltafi.ir/Social_Media/story-03.jpg",
            "myChats",
            "https://mychats.ir/"
        ),
        ImageData(
            4,
            "https://arashaltafi.ir/Social_Media/story-04.jpg",
            "myChats",
            "https://mychats.ir/"
        ),
        ImageData(
            5,
            "https://arashaltafi.ir/Social_Media/story-05.jpg",
            "myChats",
            "https://mychats.ir/"
        ),
    )

    var currentIndex by remember { mutableStateOf(0) }
    val totalImages = imageDataList.size
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    val context = LocalContext.current
}