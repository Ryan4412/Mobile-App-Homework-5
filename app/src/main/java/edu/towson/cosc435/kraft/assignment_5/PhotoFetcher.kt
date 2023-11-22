package edu.towson.cosc435.kraft.assignment_5

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import com.google.gson.Gson

interface IPhotoFetcher {
    suspend fun fetchPhotos(): List<Photo>

    suspend fun fetchIcon(url: String): Bitmap?
}

class PhotoFetcher: IPhotoFetcher {

    private val URL = "https://picsum.photos/v2/list?page=2&limit=20"
//    private val URL = "https://picsum.photos/200"
    override suspend fun fetchPhotos(): List<Photo> {
        // ensure we are not on the main thread
        return withContext(Dispatchers.IO) {
            // use okhttp with a get request to fetch the json
            val httpClient = OkHttpClient()
            val request = Request.Builder()
                .get()
                .url(URL)
                .build()
            val response = httpClient.newCall(request).execute()
            if (response.isSuccessful) {
                val jsonString = response.body?.string()
                if (jsonString != null) {
                    Log.d("myTag", "yes");
                    // use gson to parse the json into a list of photo objects
                    val photoArray: Array<Photo> =
                        Gson().fromJson(jsonString, Array<Photo>::class.java)
                    photoArray.toList()
                } else {
                    Log.d("myTag", "no 1");
                    listOf()
                }
            } else {
                Log.d("myTag", "no 2");
                listOf()
            }
        }
    }

    override suspend fun fetchIcon(url: String): Bitmap? {
        return withContext(Dispatchers.IO) {
            try {
                val client = OkHttpClient()
                val request = Request.Builder()
                    .get()
                    .url(url)
                    .build()
                val response = client.newCall(request).execute()
                val stream = response.body?.byteStream()
                val bitmap = BitmapFactory.decodeStream(stream)
                Log.d("myTag", "yes 3");
                bitmap
            } catch (e: Exception) {
                Log.d("myTag", "no 3");
                null
            }
        }
    }
}