package edu.towson.cosc435.kraft.assignment_5

import androidx.compose.ui.graphics.ImageBitmap

data class Photo(
    val index: Int,
    val url: String,
    val bitmap: ImageBitmap?
)
