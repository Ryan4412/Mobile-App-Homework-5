package edu.towson.cosc435.kraft.assignment_5

import android.graphics.Bitmap
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class PhotoListViewModel: ViewModel() {

    var _photos: MutableState<List<Photo>> = mutableStateOf(listOf()) // used to hold the list of photos
    private val _repository: IPhotoRepository = PhotoRepository() // used to reference the photoRepository functions
    private val pf : IPhotoFetcher = PhotoFetcher() // used to reference the the kotlin file that makes the rest api requests to get the photos

    // code that runs when the class is initialized
    init{
        // coroutine that Populates the photo repository with photos fetched from web API.
        viewModelScope.launch {
            val photosFromAPI = pf.fetchPhotos() // gets list of photos from web api
            for (photo in photosFromAPI) { // loop to go through the list of photos
                _repository.addPhoto(photo) // adds each individual photo to the photo repository
            }
            _photos.value = _repository.getPhotos() // sets the list of photos in this view model to the list in the photo repository after it was populated with the photos from the web api
        }
    }

    // function that gets called from the context of a coroutine that gets the bitmap of a photo particular photo
    suspend fun getBitmap(url: String): Bitmap? {
        return try {
            pf.fetchIcon(url) // returns bitmap if there was no exception
        } catch (e: Exception){ // catches exception
            null // returns null if there was an exception
        }
    }

    // function that updates a photo in the photo repository photo list and this view models photo list with the bitmap retrieved from the web api
    fun updatePhoto(photo: Photo){
        _repository.updatePhoto(photo) // updates photo in the photo list that has a new bitmap
        _photos.value = _repository.getPhotos() // sets the list of photos in this view model to the newly updated photo repository list
    }
}