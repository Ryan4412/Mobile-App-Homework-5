package edu.towson.cosc435.kraft.assignment_5

import android.graphics.Bitmap

interface IPhotoRepository {
    suspend fun addPhoto(photo: Photo) // function used to add a photo to the photo list
    fun getPhotos(): List<Photo> // function used to get the list of photos from the photo repository
    suspend fun getBitmap(photo: Photo): Bitmap? // function used to get the photos bitmap
    fun updatePhoto(photo: Photo) // function used to update a photo
}