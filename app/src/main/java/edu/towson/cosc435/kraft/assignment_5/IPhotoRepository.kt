package edu.towson.cosc435.kraft.assignment_5

import android.graphics.Bitmap

interface IPhotoRepository {
    fun addPhoto(photo: Photo)
    fun getPhotos(): List<Photo>
    fun retreivePhoto(photo: Photo) // todo - return bitmap
    fun togglePhoto(photo: Photo)
}