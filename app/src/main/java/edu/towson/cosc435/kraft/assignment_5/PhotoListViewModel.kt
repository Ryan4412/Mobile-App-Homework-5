package edu.towson.cosc435.kraft.assignment_5

import android.graphics.Bitmap
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class PhotoListViewModel: ViewModel() {

    var _photos: MutableState<List<Photo>> = mutableStateOf(listOf())
    private val _repository: IPhotoRepository = PhotoRepository()
    private val pf : IPhotoFetcher = PhotoFetcher()

    init{
        viewModelScope.launch {
            // Populate photo repository with photos fetched from web API.
            val photoFetcher = PhotoFetcher()
            val photosFromAPI = photoFetcher.fetchPhotos()
            for (photo in photosFromAPI) {
                _repository.addPhoto(photo)
            }
            _photos.value = _repository.getPhotos()
        }
    }

    suspend fun getBitmap(url: String): Bitmap? {
        return try {
            pf.fetchIcon(url)
        } catch (e: Exception){
            null
        }
    }

    fun updatePhoto(photo: Photo){
        _repository.updatePhoto(photo)
        _photos.value = _repository.getPhotos()
    }
}