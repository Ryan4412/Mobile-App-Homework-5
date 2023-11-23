package edu.towson.cosc435.kraft.assignment_5

import android.graphics.Bitmap
import android.util.Log
import com.google.gson.Gson
import kotlinx.coroutines.delay

class PhotoRepository: IPhotoRepository {

    private var _photos = listOf<Photo>() // holds the list of photos
    private val pf = PhotoFetcher() // used to call web api retrieval functions

    // adds a photo to the list that was retrieved as a json object from the web api
    override suspend fun addPhoto(photo: Photo) {
        val json: String = Gson().toJson(photo) // used for testing to see that it does retrieve a json object
        Log.d("myTag", json);
        _photos = listOf(photo) + _photos // adds the photo to the photo list
    }

    // function to return the list of photos held in this photo repository
    override fun getPhotos(): List<Photo> {
        return _photos
    }

    // function used to retrieve a bitmap for a particular photo
    override suspend fun getBitmap(photo: Photo): Bitmap? {
        val bitmap: Bitmap? = pf.fetchIcon(photo.url) // gets bitmap from web api call function
        photo.bitmap = bitmap // sets this photos bitmap to the bitmap returned
        return bitmap // returns bitmap to be used

    }

    // function to update photo based on the id of the photo passed in
    override fun updatePhoto(photo: Photo) {
         _photos = _photos.map{ p -> // maps the list of photos to an updated list of photos
            if(photo.id == p.id) // is the photo ids match
                photo // replace the photo in the list with this new photo
            else
                p// otherwise keep the photo the same
        }
    }
}