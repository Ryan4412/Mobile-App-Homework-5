package edu.towson.cosc435.kraft.assignment_5

import android.graphics.Bitmap

data class Photo(
    var id: Int,
    var url: String,
    var download_url: String,
    var bitmap: Bitmap?
)
