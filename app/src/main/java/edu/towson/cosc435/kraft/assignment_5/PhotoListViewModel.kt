package edu.towson.cosc435.kraft.assignment_5

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class PhotoListViewModel: ViewModel() {

    val _photos: MutableState<List<Photo>> = mutableStateOf(listOf())
    private val _repository: IPhotoRepository = PhotoRepository()

    init{
        _photos.value = _repository.getPhotos()
    }

}