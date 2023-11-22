package edu.towson.cosc435.kraft.assignment_5

import android.graphics.Bitmap
import android.util.Log
import com.google.gson.Gson
import kotlinx.coroutines.delay

class PhotoRepository: IPhotoRepository {

    private var _photos = listOf<Photo>()
    private var _currentIndex: Int = 0
    private val pf = PhotoFetcher()

    override suspend fun addPhoto(photo: Photo) {
        delay(100)
        val json: String = Gson().toJson(photo)
        Log.d("myTag", json);
        _photos = listOf(photo) + _photos
    }

    override fun getPhotos(): List<Photo> {
        return _photos
    }

    override suspend fun getBitmap(photo: Photo): Bitmap? {
        val bitmap: Bitmap? = pf.fetchIcon(photo.url)
        photo.bitmap = bitmap
//        updatePhoto(photo)
        return bitmap

    }

    override fun togglePhoto(photo: Photo) {
        TODO("Not yet implemented")
    }

    override fun updatePhoto(photo: Photo) {
         _photos = _photos.map{ p ->
            if(photo.id == p.id)
                photo
            else
                p
        }
    }
}