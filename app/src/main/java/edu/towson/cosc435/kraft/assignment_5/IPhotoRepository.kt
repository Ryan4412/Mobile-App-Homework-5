package edu.towson.cosc435.kraft.assignment_5

import android.graphics.Bitmap

interface IPhotoRepository {
    suspend fun addPhoto(photo: Photo)
    fun getPhotos(): List<Photo>
    suspend fun getBitmap(photo: Photo): Bitmap? // todo - return bitmap
    fun togglePhoto(photo: Photo)

    fun updatePhoto(photo: Photo)
}