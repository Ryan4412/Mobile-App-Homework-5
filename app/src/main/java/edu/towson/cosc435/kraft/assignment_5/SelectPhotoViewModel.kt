package edu.towson.cosc435.kraft.assignment_5

import android.graphics.Bitmap
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class SelectPhotoViewModel: ViewModel() {
    var _bitmap: MutableState<Bitmap?> = mutableStateOf(null)
    
    fun setSelectPhotoBitmap(bitmap: Bitmap?){
        _bitmap.value = bitmap
    }
}