package edu.towson.cosc435.kraft.assignment_5

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import com.google.gson.Gson

// interface for photo fetcher
interface IPhotoFetcher {
    suspend fun fetchPhotos(): List<Photo>

    suspend fun fetchIcon(url: String): Bitmap?
}

// photo fetcher class
class PhotoFetcher: IPhotoFetcher {
    // sets the url to use to get the list of photos json objects from
    // limit=20 ensures we only retrieve 20 photo json objects
    private val URL = "https://picsum.photos/v2/list?page=2&limit=20"

    // suspend function that gets called from the context of a coroutine that fetched the list of json objects from the specified url
    override suspend fun fetchPhotos(): List<Photo> {
        // ensure we are not on the main thread
        return withContext(Dispatchers.IO) {// uses Dispatcher.IO to efficiently receive data from a web api
            // use okhttp with a get request to fetch the json
            val httpClient = OkHttpClient()
            val request = Request.Builder() // builds api request
                .get()
                .url(URL)
                .build()
            val response = httpClient.newCall(request).execute() // gets response from the api request
            if (response.isSuccessful) { // checks if the response was successful
                val jsonString = response.body?.string() // stringifies the response
                if (jsonString != null) { // checks if the jsonString returned was null
                    Log.d("myTag", "yes"); // for testing purposes open logcat and search based on the tag "myTag"
                    // use gson to parse the json into a list of photo objects
                    val photoArray: Array<Photo> =
                        Gson().fromJson(jsonString, Array<Photo>::class.java) // parses the returned json into objects of the photo data class
                    photoArray.toList()//returns list of photos
                } else { // if the jsonString WAS null
                    Log.d("myTag", "no 1");
                    listOf()// return empty list
                }
            } else { // is the response was NOT successful
                Log.d("myTag", "no 2");
                listOf()// return empty list
            }
        }
    }

    // suspend function that gets called from the context of a coroutine that retrieves the bitmap of a photo
    override suspend fun fetchIcon(url: String): Bitmap? { // passes in the download_url of a photod
        return withContext(Dispatchers.IO) {// uses Dispatcher.IO to efficiently receive data from a web api
            try {
                val client = OkHttpClient() // uses okHttp to get a response
                val request = Request.Builder() // builds the request
                    .get()
                    .url(url)
                    .build()
                val response = client.newCall(request).execute() // receives the response
                val stream = response.body?.byteStream() // converts the response to a byteStream
                val bitmap = BitmapFactory.decodeStream(stream) // converts the byteStream to a bitmap
                Log.d("myTag", "yes 3");
                bitmap // returns bitmap
            } catch (e: Exception) { // catches exception
                Log.d("myTag", "no 3");
                null// returns null if there is an exception
            }
        }
    }
}