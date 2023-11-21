package edu.towson.cosc435.kraft.assignment_5

class PhotoRepository: IPhotoRepository {

    private var _photos = listOf<Photo>()
    private var _currentIndex: Int = 0

    init{
        _photos = (0..21).map {p ->
            Photo(_currentIndex + 1, "url", null)
        }
    }

    override fun addPhoto(photo: Photo) {
        val newPhoto = Photo(_currentIndex + 1, photo.url, photo.bitmap)
    }

    override fun getPhotos(): List<Photo> {
        return _photos
    }

    override fun retreivePhoto(photo: Photo) {
        TODO("Not yet implemented")
    }

    override fun togglePhoto(photo: Photo) {
        TODO("Not yet implemented")
    }
}