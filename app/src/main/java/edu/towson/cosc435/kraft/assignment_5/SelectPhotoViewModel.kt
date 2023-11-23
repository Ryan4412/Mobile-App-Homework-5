package edu.towson.cosc435.kraft.assignment_5

import android.graphics.Bitmap
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

// view model for the SelectPhoto screen
class SelectPhotoViewModel: ViewModel() {
    // stores a bitmap for the image to be displayed
    var _bitmap: MutableState<Bitmap?> = mutableStateOf(null)

    // function to set the bitmap stored in the view model to the bitmap passed in (bitmap passed in when the photo is clicked on the photo list screen)
    fun setSelectPhotoBitmap(bitmap: Bitmap?){
        _bitmap.value = bitmap // sets the bitmap in this view model to the bitmap passed in
    }
}