package edu.towson.cosc435.kraft.assignment_5

import android.graphics.Bitmap

data class Photo(
    var id: Int, // saves a unique id for each photo
    var url: String, // saves the url the photo json object was retrieved from
    var download_url: String, // saves the url used to download the photos bitmap from
    var bitmap: Bitmap? // saves the photos bitmap so you can reference it instead of making another web api request
)
